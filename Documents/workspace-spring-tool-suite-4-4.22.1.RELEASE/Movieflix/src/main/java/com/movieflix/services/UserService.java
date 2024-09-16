package com.movieflix.services;

import java.util.List;

import com.movieflix.entities.User;

public interface UserService {
	public void addUsers(User user) ;
	public boolean valiDateUser(String emilId);	
	public boolean userLogin(String emailId,String password); 
	public String adminLogin(String emailId,String password);
	public User getUser(String emailId);
	public List<User> viewUsers() ;
	public void updateUser(User user);
	public boolean deleteuser(String emailId);
	public void deleteuserAdmin(Integer id);
	public String checkOldPassword(String emailId,String password);
	public void updatePassword(String emailId,String Password);	
	public void updateProfile(String emailId,String name,String gender,long phoneNo,String address);	
	
	
	

}
