package com.ivan.designing.tables.model.garbage;

// TODO: может быть использовать вместо RelationshipDebtorDebtor.code
//  подумать!!

public enum TypeCode {
     GUARANTOR("12"),LENDER("13"),RELATIVES("31");

     TypeCode(String code) {
         this.code = code;
     }

     private final String code;

     public String getCode() {
        return code;
     }

}
