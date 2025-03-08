package com.bank.management.controller;


import com.bank.management.model.BankAccount;
import com.bank.management.service.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")
public class BankAccountController {

    private final BankAccountService service;

    public BankAccountController(BankAccountService service) {
        this.service = service;
    }

    @GetMapping
    public List<BankAccount> getAllAccounts() {
        return service.getAllAccounts();
    }

    @GetMapping("/{id}")
    public Optional<BankAccount> getAccountById(@PathVariable Long id) {
        return service.getAccountById(id);
    }

    @PostMapping
    public BankAccount createAccount(@RequestBody BankAccount account) {
        return service.createAccount(account);
    }

    @PutMapping("/{id}")
    public BankAccount updateAccount(@PathVariable Long id, @RequestBody BankAccount account) {
        return service.updateAccount(id, account);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        service.deleteAccount(id);
    }
}
