package com.movieflix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.movieflix.entities.Movies;
import com.movieflix.entities.User;
import com.movieflix.services.MoviesServices;
import com.movieflix.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	UserService usserv;

	@Autowired
	MoviesServices movser;

	@PostMapping("map_register")
	public String addUser(@ModelAttribute User user,HttpSession session) {

		if(session==null)
		{
			return "login";
		}
		else
		{
			if(user.getPassword().equals(user.getConfirmpassword()))
			{

				boolean validStatus=usserv.valiDateUser(user.getEmailId());
				if(validStatus==true){
					usserv.addUsers(user);
					return "registersuccess";
				}
				else{
					return "registerfail";
				}
			}
			else
			{
				return "registerpasswordfail";
			}
		}
	}

	@GetMapping("map_login")
	public String login(@RequestParam String emailId, String password, HttpSession session)
	{
		if(session==null)
		{
			return "login";
		}
		else
		{
			boolean loginStatus=usserv.userLogin(emailId, password);
			String passkey=usserv.adminLogin(emailId, password);
			if(passkey=="AdminEmailNotPresent")
			{
				return "loginfail";
			}
			else if(emailId.equals("admin@gmail.com") && password.equals(passkey))
			{
				session.setAttribute("emailId", emailId);
				return "admin";
			}
			else if(loginStatus==true)
			{
				session.setAttribute("emailId", emailId);
				return "home";
			}
			else {
				return "loginfail";
			}
		}
	}

	@GetMapping("viewusers")
	public String viewUser(Model model,HttpSession session) {
		if(session==null)
		{
			return "login";
		}
		else
		{
			List<User> users=usserv.viewUsers();
			model.addAttribute("appUsers", users);
			return "userlist";
		}
	}

	@GetMapping("explore_movies")
	public String viewmovies(HttpSession session, Model model) {

		if(session==null)
		{
			return "login";
		}
		else
		{
			String email=(String)session.getAttribute("emailId");
			User user=usserv.getUser(email);
			boolean status=user.isPremium();
			if(status==true)
			{
				List<Movies> moviesList=movser.viewMovies();
				model.addAttribute("viewAllMovies", moviesList);
				return "viewusermovies";
			}
			else
			{
				return "payment";
			}
		}

	}

	@GetMapping("map_deleteAccount")
	public String deleteAccount(String emailId,HttpSession session)
	{
		if(session==null)
		{
			return "login";
		}
		else
		{
			boolean status =usserv.deleteuser(emailId);
			if(status==true)
			{
				return "deleteusersuccess";
			}
			else
			{
				return "deleteuserfail";
			}
		}
	}

	@GetMapping("map_deleteUserAdmin")
	public String deleteUserAdmin(@RequestParam Integer id,HttpSession session)
	{
		if(session==null)
		{
			return "login";
		}
		else
		{
			usserv.deleteuserAdmin(id);
			return"deleteusersuccess";
		}
	}

	@GetMapping("log_out")
	public String logout(HttpSession session) {
		if(session==null)
		{
			return "login";
		}
		else
		{
			session.invalidate();
			return "login";
		}
	}

	@PostMapping("update_user")
	public String updateuser(User user,HttpSession session)
	{
		if(session==null)
		{
			return "login";
		}
		else
		{
			usserv.updateUser(user);
			return "updateusersuccess";
		}
	}

	@GetMapping("map-Logout")
	public String logourAdmin(HttpSession session)
	{
		if(session==null)
		{
			return "login";
		}
		else
		{
			session.invalidate();
			return "login";
		}
	}

	@GetMapping("map-checkpassword")
	public String checkoldpassword(HttpSession session, @RequestParam String password)
	{
		String email=(String) session.getAttribute("emailId");
		String status=usserv.checkOldPassword(email, password);
		if(status.equals("true"))
		{
			return"changepassword";
		}
		else if(status.equals("false"))
		{
			return"oldpasswordmismatch";
		}
		else
		{
			return "i am in check";
		}
	}

	@PostMapping("newPassword-validation")
	public String newPasswordvalidation(HttpSession session, @RequestParam String password,String confirmpassword)
	{
		if(session==null)
		{
			return "login";
		}
		else
		{
			String emailId=(String) session.getAttribute("emailId");
			if(password.equals(confirmpassword))
			{
				usserv.updatePassword(emailId, password);
				return "passwordupdationsuccess";
			}
			else
			{
				return "passwordupdationfail";
			}
		}
	}

	@PostMapping("map-updateprofile")
	public String updateProfle(HttpSession session,@RequestParam String name,String gender,long phoneNo,String address )
	{
		if(session==null)
		{
			return "login";
		}
		else
		{
			String emailId=(String) session.getAttribute("emailId");
			usserv.updateProfile(emailId, name, gender, phoneNo, address);
			return "updateprofilesuccess";
		}
	}

}	

