package com.movieflix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieflix.entities.User;
import com.movieflix.repositories.UserRepository;

@Service
public class UserServiceImplementation implements UserService{

	@Autowired
	UserRepository usrep;

	private User status;
	public UserServiceImplementation(UserRepository usrep) {
		super();
		this.usrep = usrep;
	}

	@Override
	public void addUsers(User user) {
		usrep.save(user);
		
	}

	@Override
	public boolean valiDateUser(String emailId) {
		status=usrep.findByEmailId(emailId);
		if(status==null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean userLogin(String emailId, String password) {
		status=usrep.findByEmailId(emailId);
		User loginStatus=usrep.findByEmailId(emailId);
		if(status==null)
		{
			return false;
		}
		else if(loginStatus.getPassword().equals(password))
		{
			return true;
		}
		else
		{
			return false;
		}	 
	}

	@Override
	public String adminLogin(String emailId, String password) {
		status=usrep.findByEmailId(emailId);
		if(status==null)
		{
			return "AdminEmailNotPresent";
		}
		else
		{
			String passkey=status.getPassword();
			return passkey;
		}
	}

	@Override
	public List<User> viewUsers() {
		List<User> userList=usrep.findAll();
		return userList;
	}

	@Override
	public User getUser(String emailId) {
		User user=usrep.findByEmailId(emailId);
		return user  ;
	}

	@Override
	public void updateUser(User user) {
		usrep.save(user);	
	}

	@Override
	public boolean deleteuser(String emailId) {
		User user=usrep.findByEmailId(emailId);
		if(user==null)
		{
			return false;
		}
		else
		{
			Integer id=user.getId();
			usrep.deleteById(id);
			return true;
		}
	}

	@Override
	public void deleteuserAdmin(Integer id) {
		usrep.deleteById(id);
	}

	@Override
	public String checkOldPassword(String emailId, String password) {
		status=usrep.findByEmailId(emailId);
		if(password.equals(status.getPassword()))
		{
			return "true";
		}
		else
		{
			return "false";

		}
	}

	@Override
	public void updatePassword(String emailId, String Password) {
		status=usrep.findByEmailId(emailId);
		status.setPassword(Password);
		status.setConfirmpassword(Password);
	}

	@Override
	public void updateProfile(String emailId, String name, String gender, long phoneNo, String address)
	{
		status=usrep.findByEmailId(emailId);
		status.setName(name);
		status.setGender(gender);
		status.setPhoneNo(phoneNo);
		status.setAddress(address);
	    usrep.save(status);
		
	}

}
