package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;
import com.service.UserDAO;

import io.swagger.annotations.ApiOperation;



//@Controller
@RestController
@RequestMapping("/mainapp1")
public class AppController {
	ArrayList<User> al=new ArrayList<User>();
	
	//@RequestMapping(value="/login",method=RequestMethod.POST)
	//@ResponseBody
	//@PostMapping("/login")
	//public String loginValid(@RequestParam("uname")String uname,@RequestParam("pwd")String pwd){
//	if(uname.equals("admin")&& pwd.equals("manager"))	{
//		return "login success";
//	}
	
//	public String loginValid(@ModelAttribute User users){
//		for(User user:al) {
//			if(user.getUname().equals(users.getUname())&& user.getPwd().equals(users.getPwd())) {
//				return "Login Success";
//			}
//		}
//		return "login failure";
	//}
	
	
	@Autowired
	private UserDAO userdao;
	
	@PostMapping("/login")
	public String loginvalid(@RequestBody User user) {
		if(userdao.loginValidated(user)) {
			return "Login success";
		}
		return "Login failure";
	}
	
	
	//@RequestMapping(value="/register",method=RequestMethod.POST)
	//@ResponseBody

	//public String RegisterValid(@RequestParam("uname")String uname,@RequestParam("pwd")String pwd,@RequestParam("email")String email,@RequestParam("city")String city){
	
//	public String RegisterValid(@ModelAttribute User users){
//	
//		al.add(new User(users.getUname(),users.getPwd(),users.getEmail(),users.getCity()));
//		System.out.println(al);
//		//System.out.println("the User name is :"+ al.get(0).getUsername()+"The Password is"+al.get(1).getPassword()+"The email id is "+al.get(2).getEmail()+"The city is :"+al.get(3).getCity());
//		return "Registration successfull";
//		
//		
//	}
	@PostMapping("/register")
	public String RegisterValid(@RequestBody User users){
		
		userdao.addUser(users);
		//System.out.println("the User name is :"+ al.get(0).getUsername()+"The Password is"+al.get(1).getPassword()+"The email id is "+al.get(2).getEmail()+"The city is :"+al.get(3).getCity());
		return "user added";
		
		
	}
	
	@GetMapping("/loadAll")
	
	public List<User> loadAll() {
		
		return userdao.loadAll()  ;
	}
	
	@GetMapping("/finduser/{uid}")
	@ApiOperation(value="find details by id",
	notes="provide id for the data",response=User.class)

	public String findUser(@PathVariable int uid) {
		
		if(userdao.findUser(uid)) {
			return uid+" found";
		}
		return "username not found";
		
	}
	
	
	@GetMapping("/deleteuser/{uname}")
	public String deleteUser(@PathVariable() String uname) {
		
		if(userdao.deleteUser(uname)) {
			return uname+" deleted successfully";
		}
		return "username not deleted";
		
	}
	@PutMapping("/updateUser/{uname}")
	public String updateUser(@PathVariable() String uname,@RequestBody User user) {
		
		if(userdao.updateUser(uname,user)) {
			return uname+" found and updated";
		}
		return "uname";
		
	}
	
	
}
