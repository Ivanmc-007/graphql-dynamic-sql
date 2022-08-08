drop table if exists debtor CASCADE;
drop table if exists group_obligor CASCADE;
drop table if exists group_debtor_clients CASCADE;
drop sequence if exists hibernate_sequence;

create sequence hibernate_sequence start with 1 increment by 1;

create table debtor (
    id bigint not null,
    debtor_type varchar(255),
    primary key (id));

create table group_debtor_clients (
    id bigint not null,
    data_change DATE,
    data_open DATE,
    date_close DATE,
    group_name varchar(255),
    primary key (id));

create table relationship_debtor_debtor (
    id bigint not null,
    debtor_parent_id bigint,
    debtor_child_id bigint,
    code varchar(255),
    primary key (id));

create table relationship_group_debtor_clients_debtor (
    group_debtor_clients_id bigint not null,
    debtor_id bigint not null,
    primary key (group_debtor_clients_id, debtor_id));

alter table relationship_debtor_debtor add constraint FK6biyjh7agoj0fqlc5d3jqwq32 foreign key (debtor_child_id) references debtor
alter table relationship_debtor_debtor add constraint FKqn122cw7lmhpkh0gp9vv2k6pn foreign key (debtor_parent_id) references debtor
alter table relationship_group_debtor_clients_debtor add constraint FKe6acpjhxdyf7vhfdeb614tor foreign key (debtor_id) references debtor;
alter table relationship_group_debtor_clients_debtor add constraint FKiuni6i0fsu2knksavaq643grn foreign key (group_debtor_clients_id) references group_debtor_clients;