package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.entity.Account;

/**
 * use annotations to match DAO and sql statement
 * @author anqi.xiong
 *
 */
@Mapper
public interface IAccountMapper4Mybatis2 {
	
	@Insert("insert into account(name,money) values(#{name},#{money})")
	int add(Account account);
	
	@Update("update account set name = #{name}, money = #{money} where id = #{id}")
	int update(Account account);

	@Delete("delete from account where id = #{id}")
	int delete(Integer id);
	
	@Select("select id, name as name, money as money from account where id = #{id}")
	Account getAccountById(Integer id);

	@Select("select id, name as name, money as money from account")
	List<Account> findAccountList();
}
