package org.example.hellospring.controller;

import org.example.hellospring.controller.dto.AccountRequestDTO;
import org.example.hellospring.controller.dto.AccountResponseDTO;
import org.example.hellospring.entity.Account;
import org.example.hellospring.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @PostMapping("/accounts")
    public Long createAccount(@RequestBody AccountRequestDTO accountRequestDTO) {
        return accountService.createAccount(accountRequestDTO.getName(), accountRequestDTO.getEmail(),
                accountRequestDTO.getBill());
    }

    @GetMapping("/accounts/{id}")
    public AccountResponseDTO getAccount(@PathVariable Long id) {
        Account account = accountService.getAccountById(id);
        return new AccountResponseDTO(account);
    }

    @GetMapping("/accounts")
    public List<AccountResponseDTO> getAllAccount() {
        return accountService.getAllAccounts().stream()
                .map(AccountResponseDTO::new)
                .toList();
    }

    @DeleteMapping(value = "/accounts/{id}")
    public AccountResponseDTO deleteAccount(@PathVariable Long id) {
        return new AccountResponseDTO(accountService.deleteAccountById(id));
    }

    @PutMapping("/accounts/{id}")
    public AccountResponseDTO editAccount(@PathVariable Long id, @RequestBody AccountRequestDTO accountRequestDTO) {
        accountService.editAccount(id,
                accountRequestDTO.getName(),
                accountRequestDTO.getEmail(),
                accountRequestDTO.getBill());
        return new AccountResponseDTO(accountService.getAccountById(id));
    }

    @GetMapping("/string")
    public String getString(@RequestParam(name = "ABC") String text) {
        return text;
    }
}
