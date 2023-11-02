package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.dao.AppDAO;
import com.model.User;

@Service
public class UserDAOImpl implements UserDAO {
	@Autowired
	AppDAO appdao;
	ArrayList<User> al=new ArrayList<User>();
	@Override
	
	public boolean loginValidated(User users){
		for(User user:al) {
			if(user.getUname().equals(users.getUname())&& user.getPwd().equals(users.getPwd())) {
				return true;
			}
		}
		return false;

	
}
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		//al.add(user);
		appdao.save(user);
		
	}
	@Override
	public List<User> loadAll() {
		// TODO Auto-generated method stub
		//return al;
		return (List<User>)appdao.findAll();
	}
	@Override
	public boolean findUser(int uid) {
		// TODO Auto-generated method stub
//		for(User user:al) {
//			if(user.getUname().equals(uname)) {
//				return true;
//			}
//		}
//		return false;
		Optional<User>op=appdao.findById(uid);
		if(op.isPresent()) {
			return true;
		}
		return false;
	}
	@Override
	public boolean deleteUser(String uname) {
	
		int id=-1;
		for(int i=0;i<al.size();i++) {
			if(al.get(i).getUname().equalsIgnoreCase(uname)) {
				id=i;
			}
		}
		
		if(id == -1)return false;
		al.remove(id);
		return true;
	}
	@Override
	public boolean updateUser(String name, User user) {
		// TODO Auto-generated method stub
		
		for(User users:al) {
			if(users.getUname().equalsIgnoreCase(name)) {
			users.setUname(user.getUname());
			users.setPwd(user.getPwd());
			users.setEmail(user.getEmail());
			users.setCity(user.getCity());
			return true;
			}
		}
		return false;
	}}




/*
@Override
public boolean updateUser(String userName, User user) {
	// TODO Auto-generated method stub
	int idx = -1;
	for(int i=0;i<al.size();i++) {
		if(al.get(i).getUserName().equals(userName)) {
			idx = i;
			break;
		}
	}
	
	if(idx==-1)return false;
	
	al.set(idx, user);
	return true;
}
*/