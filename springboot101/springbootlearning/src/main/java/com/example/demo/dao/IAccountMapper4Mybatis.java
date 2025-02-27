package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Account;

/**
 *  use traditional way to match DAO and sql statement.The MybatisConfig.java is needed.
 * @author anqi.xiong
 *
 */
public interface IAccountMapper4Mybatis {
	
	int add(Account account);
	
	int update(Account account);

	int delete(Integer id);
	
	Account getAccountById(Integer id);

	List<Account> findAccountList();
}
