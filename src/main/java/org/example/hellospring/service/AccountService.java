package org.example.hellospring.service;

import org.example.hellospring.entity.Account;
import org.example.hellospring.exception.AccountNotFoundException;
import org.example.hellospring.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountService2 accountService2;

    @Autowired
    public AccountService(AccountRepository accountRepository, AccountService2 accountService2) {
        this.accountRepository = accountRepository;
        this.accountService2 = accountService2;
    }

    @Transactional
    public Long createAccount(String name, String email, Integer bill) {
        Account account = new Account(name, email, bill);
        Account account1 = accountRepository.save(account);
        accountService2.saveAccount2();

        Account account2 = new Account("account2", "account2@mail.com", 1000);
        accountRepository.save(account2);

        return account1.getId();
    }

    public Account getAccountById(Long id) {
        return accountRepository
                .findById(id)
                .orElseThrow(() -> new AccountNotFoundException("account not found id: " + id));
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account deleteAccountById(Long id) {
        Account account = getAccountById(id);
        accountRepository.delete(account);
        return account;
    }

    public void editAccount(Long id, String name, String email, Integer bill) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new AccountNotFoundException("account not found id: " + id));

        account.setName(name);
        account.setEmail(email);
        account.setBill(bill);

        accountRepository.save(account);
    }
}
