package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Account;

public interface IAccountService {


    int add(Account account);

    int update(Account account);

    int delete(int id);

	List<Account> getAccounts();

	Account getAccountById(Integer id);

}