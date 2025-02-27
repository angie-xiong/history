package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Account;
import com.example.demo.service.IAccountService;

@RestController
@RequestMapping(value = "/account")
public class AccountController {

	@Autowired
	IAccountService accountService;

	@RequestMapping(value = "/getAccounts", method = { RequestMethod.POST, RequestMethod.GET })
	public List<Account> getAccounts() {
		return accountService.getAccounts();
	}

	@RequestMapping(value = "/getAccountById", method = { RequestMethod.POST, RequestMethod.GET })
	public Account getAccountById(Integer id) {
		return accountService.getAccountById(id);
	}

	@RequestMapping(value = "/addAccount", method = { RequestMethod.POST, RequestMethod.GET })
	public int addAccount(Account account) {
		return accountService.add(account);
	}

	@RequestMapping(value = "/updateAccount/{id}", method = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT })
	public String updateAccount(@PathVariable("id") int id, @RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "money", required = true) double money) {
		Account account = new Account();
		account.setMoney(money);
		account.setName(name);
		account.setId(id);
		int t = accountService.update(account);
		if (t == 1) {
			return account.toString();
		} else {
			return "fail";
		}
	}

	@RequestMapping(value = "/deleteAccountById", method = { RequestMethod.POST, RequestMethod.GET })
	public int updateAccount(Integer id) {
		return accountService.delete(id);
	}
}
