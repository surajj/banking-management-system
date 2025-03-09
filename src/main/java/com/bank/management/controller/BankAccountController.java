package com.bank.management.controller;


import com.bank.management.model.BankAccount;
import com.bank.management.service.BankAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")
@Tag(name = "Bank Account API", description = "API for managing bank accounts")
public class BankAccountController {

    private final BankAccountService service;

    public BankAccountController(BankAccountService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Get all bank accounts")
    public List<BankAccount> getAllAccounts() {
        return service.getAllAccounts();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get bank account by ID")
    public Optional<BankAccount> getAccountById(@PathVariable Long id) {
        return service.getAccountById(id);
    }

    @PostMapping
    @Operation(summary = "Create a new bank account")
    public BankAccount createAccount(@RequestBody BankAccount account) {
        return service.createAccount(account);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing bank account")
    public BankAccount updateAccount(@PathVariable Long id, @RequestBody BankAccount account) {
        return service.updateAccount(id, account);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a bank account")
    public void deleteAccount(@PathVariable Long id) {
        service.deleteAccount(id);
    }
}
