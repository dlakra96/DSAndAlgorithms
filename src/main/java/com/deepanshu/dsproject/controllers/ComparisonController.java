package com.deepanshu.dsproject.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.deepanshu.dsproject.services.ComparisonService;

@Controller
public class ComparisonController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	private ComparisonService comparisonService;

	@GetMapping("getComparisons/{number}")
	@ResponseBody
	public Object getComparisons(@PathVariable int number) {
		log.info("Called getComparisons() using the getComparisons mapping");
		log.info("number recieved is "+ number);
		return null;
	}
	
}
