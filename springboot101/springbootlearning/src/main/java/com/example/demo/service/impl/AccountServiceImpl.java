package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.IAccountMapper4Mybatis;
import com.example.demo.entity.Account;
import com.example.demo.service.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private IAccountMapper4Mybatis accountDAO;

	@Transactional
	@Override
	public int add(Account account) {
		return accountDAO.add(account);
	}

	/**
	 * Use annotation (@Transactional) to turn on transaction
	 */
	@Transactional
	@Override
	public int update(Account account) {
		return accountDAO.update(account);
	}

	@Transactional
	@Override
	public int delete(int id) {
		return accountDAO.delete(id);
	}

	@Override
	public Account getAccountById(Integer id) {
		return accountDAO.getAccountById(id);
	}

	@Override
	public List<Account> getAccounts() {
		return accountDAO.findAccountList();
	}

}
