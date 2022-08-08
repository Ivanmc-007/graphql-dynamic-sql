drop table if exists debtor CASCADE;
drop table if exists debtor_group CASCADE;
drop table if exists relationship_debtor_group_debtor CASCADE;
drop sequence if exists hibernate_sequence;

create sequence hibernate_sequence start with 1 increment by 1

create table debtor (
    id bigint not null,
    client_id bigint,
    client_type varchar(255),
    date_close DATE,
    date_open DATE,
    primary key (id));

create table debtor_group (
    id bigint not null,
    date_change DATE,
    date_close DATE,
    date_open DATE,
    group_name varchar(255),
    primary key (id));

create table relationship_debtor_group_debtor (
    id bigint not null,
    date_close date,
    date_open DATE,
    note varchar(255),
    percent_rel decimal(19,2),
    type_rel_code varchar(255),
    debtor_child_id bigint,
    debtor_group_id bigint,
    debtor_parent_id bigint,
    primary key (id));

alter table relationship_debtor_group_debtor add constraint FKf7h3t9n3rq4cvwh06du5iel7d foreign key (debtor_child_id) references debtor;
alter table relationship_debtor_group_debtor add constraint FKraytlca4ytiuns1r4giqp3kqw foreign key (debtor_group_id) references debtor_group;
alter table relationship_debtor_group_debtor add constraint FKrvh4ylosefjstntdk2pqclfs3 foreign key (debtor_parent_id) references debtor;