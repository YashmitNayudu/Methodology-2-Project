
/**
 * @author yashmit
 *
 */

package com.Shifty.controller;
import com.Shifty.database.Database;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.SAXException;

@Controller
public class Navigation {
	@RequestMapping("/login")
	public ModelAndView LoginPage() {
		return new ModelAndView("login");
	}
	
}
