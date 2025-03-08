package com.bank.management.service;

import com.bank.management.model.BankAccount;
import com.bank.management.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankAccountService {


    private final BankAccountRepository repository;

    public BankAccountService(BankAccountRepository repository) {
        this.repository = repository;
    }

    public List<BankAccount> getAllAccounts() {
        return repository.findAll();
    }

    public Optional<BankAccount> getAccountById(Long id) {
        return repository.findById(id);
    }

    public BankAccount createAccount(BankAccount account) {
        return repository.save(account);
    }

    public BankAccount updateAccount(Long id, BankAccount updatedAccount) {
        return repository.findById(id)
                .map(account -> {
                    account.setAccountHolder(updatedAccount.getAccountHolder());
                    account.setAccountType(updatedAccount.getAccountType());
                    account.setBalance(updatedAccount.getBalance());
                    return repository.save(account);
                }).orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public void deleteAccount(Long id) {
        repository.deleteById(id);
    }
}
