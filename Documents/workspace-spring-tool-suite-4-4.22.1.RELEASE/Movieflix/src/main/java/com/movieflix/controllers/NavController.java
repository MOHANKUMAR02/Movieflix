package com.movieflix.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.movieflix.entities.Movies;

@Controller
public class NavController {
	
	@GetMapping("register")
	public String  mapRegister()
	{
		return "register";
	}
     
	@GetMapping("login")
	public String mapLogin() {
		return "login";
	}
	
	@GetMapping("addmovies")
	public String addUser()
	{
		return "addmovies";
	}
	
	@GetMapping("addmovie")
	public String addmovie()
	{
		return "addmovies";
	}
	
	@GetMapping("Updatemovies")
	public String updateMovie()
	{
		return "updatemovies";
	}
	
	
	@GetMapping("Change_Password")
	public String changepassword()
	{
		return "oldpassword";
	}
	
	@GetMapping("DeleteUser")
	public String deleteUser()
	{
		return "deleteuser";
	}
	
	@GetMapping("delete-account")
	public String deleteAccount()
	{
		return "deleteaccount";
	}
	
	@GetMapping("Update_Profile")
	public String updateProfile()
	{
		return "updateprofile";
	}

	@GetMapping("guest")
	public String  guestUser()
	{
		return "home";
	}
}

