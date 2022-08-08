package com.ivan.designing.tables.model.entity.temp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ClientGetDTO {

    private Long clientId;

    private String clientName;

    private List<ContactEmailGetDTO> contactEmails;

}
