package com.ivan.designing.tables.model.entity.temp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactEmailGetDTO {

    private Long id;

    private String typeEmail;

    private String email;

}
