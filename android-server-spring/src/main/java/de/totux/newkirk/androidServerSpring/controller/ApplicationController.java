package de.totux.newkirk.androidServerSpring.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.totux.newkirk.androidServerSpring.json.JSONLoginDetails;
import de.totux.newkirk.androidServerSpring.json.JSONUserDetails;
import de.totux.newkirk.androidServerSpring.model.User;
import de.totux.newkirk.androidServerSpring.model.UserDAO;

@Controller
@Transactional
public class ApplicationController {
	
	@Autowired
	private UserDAO userDao;
	
	@RequestMapping(value="/login", produces={MediaType.APPLICATION_JSON_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	private JSONUserDetails login(@RequestBody JSONLoginDetails login) {
		JSONUserDetails users = new JSONUserDetails();
		List<User> userList = userDao.list();
		if (userList != null && !userList.isEmpty()) {
			for (User user : userList) {
				users.getUsernames().add(user.getUsername());
			}
		}
		return users;
	}
}
