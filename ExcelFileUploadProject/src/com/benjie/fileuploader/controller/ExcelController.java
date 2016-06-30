package com.benjie.fileuploader.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "excel")
public class ExcelController {

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "redirect:excel/importexcel.html";
	}
	
	@RequestMapping(value = "importexcel", method = RequestMethod.GET)
	public String importExcel(){
		return "index";
	}
}
