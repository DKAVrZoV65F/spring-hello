package org.example.hellospring.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountRequestDTO {

    private String name;
    private String email;
    private Integer bill;

    public AccountRequestDTO() {}

    public AccountRequestDTO(String name, String email, Integer bill) {
        this.name = name;
        this.email = email;
        this.bill = bill;
    }
}
