package com.revature.service;

import java.util.List;

import com.revature.dao.ManagerDAO;
import com.revature.daoimpl.ManagerDAOImpl;
import com.revature.model.Manager;

public class ManagerService {
	ManagerDAO mdao = new ManagerDAOImpl();
	
	public boolean loginVerify(String username, String password){
		List<Manager> mList= mdao.getManager();
		boolean verify = false;
		for(Manager man: mList) {
			if(man.getUsername().equals(username)&& man.getPassword().equals(password)) {
				verify = true;
			}
		}
		System.out.println(verify);
		return verify;
		
	}
	
	public Manager loginGetManager(String username, String password){
		
		if(loginVerify(username,password)) {
			return mdao.getManagerByUsername(username);
		}
		return null;
	}
	

}
