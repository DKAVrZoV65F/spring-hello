package org.example.hellospring.controller.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.hellospring.entity.Account;

@Setter
@Getter
public class AccountResponseDTO {

    private Long accountId;
    private String name;
    private String email;
    private Integer bill;

    public AccountResponseDTO(Long accountId, String name, String email, Integer bill) {
        this.accountId = accountId;
        this.name = name;
        this.email = email;
        this.bill = bill;
    }

    public AccountResponseDTO(Account account) {
        this.accountId = account.getId();
        this.name = account.getName();
        this.email = account.getEmail();
        this.bill = account.getBill();
    }
}
