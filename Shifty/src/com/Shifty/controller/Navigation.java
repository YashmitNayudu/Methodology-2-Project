
/**
 * @author yashmit
 *
 */

package com.Shifty.controller;
import javax.xml.stream.XMLStreamException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class Navigation {
	int count;
	@GetMapping("/login")
	
	
	public String LoginPage(Model m) throws XMLStreamException {
		if (count ==1 ) {
		m.addAttribute("user1", new Curruser());
		com.Shifty.database.Database.userLogin(user1.username, user1.password);
		count+=1;
		return "login";
		}
	}
	@GetMapping("/login")
	public String LoginPage(Model m) throws XMLStreamException {
		if (count == 2) {
		m.addAttribute("user2", new Curruser());
		com.Shifty.database.Database.userLogin(user1.username, user1.password);
		count+=1;
		return "login";
		}
	}	
	@GetMapping("/login")
	public String LoginPage(Model m) throws XMLStreamException {
		if (count == 3) {
		m.addAttribute("user3", new Curruser());
		com.Shifty.database.Database.userLogin(user1.username, user1.password);
		count+=1;
		return "login";
		}
	}
	  @PostMapping("/login")
	  public String greetingSubmit(Model model) {
		if(com.Shifty.database.Database.userLogin(user1.username, user1.password);) {
			if (com.Shifty.scheduler.iflate(user1.username)) {
				com.Shifty.email.ShiftyEmail(user1.email);
			}
		} 
	    model.addAttribute("user1", Curruser);
	    return "login";
	  }
	  @PostMapping("/login")
	  public String greetingSubmit(Model model) {
		if(com.Shifty.database.Database.userLogin(user2.username, user2.password);) {
			if (com.Shifty.scheduler.iflate(user2.username)) {
				com.Shifty.email.ShiftyEmail(user2.email);
			}
		} 
	    model.addAttribute("user2", Curruser);
	    return "login";
	  }
	  @PostMapping("/login")
	  public String greetingSubmit(Model model) {
		if(com.Shifty.database.Database.userLogin(user3.username, user3.password);) {
			if (com.Shifty.scheduler.iflate(user3.username)) {
				com.Shifty.email.ShiftyEmail(user3.email);
			}
		} 
	    model.addAttribute("user3", Curruser);
	    return "login";
	  }
}
