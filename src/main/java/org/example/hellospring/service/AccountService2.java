package org.example.hellospring.service;

import org.example.hellospring.entity.Account;
import org.example.hellospring.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService2 {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService2(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveAccount2() {
        Account account3 = new Account("account3", "account3@mail.com", 1000);
        accountRepository.save(account3);
    }
}
