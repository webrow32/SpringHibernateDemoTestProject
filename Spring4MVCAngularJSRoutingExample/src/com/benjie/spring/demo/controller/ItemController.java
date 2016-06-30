package com.benjie.spring.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benjie.spring.demo.model.Computer;
import com.benjie.spring.demo.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	ItemService itemService;

	@RequestMapping(value = "/computers")
	public ResponseEntity<List<Computer>> listAllComputers() {
		System.out.println("*************************************ListAllComputers");
		List<Computer> items = itemService.findItemsByCategory("computers");
		if (items.isEmpty()) {
			return new ResponseEntity<List<Computer>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Computer>>(items, HttpStatus.OK);
	}

	@RequestMapping(value = "/computers/{id}")
	public ResponseEntity<Computer> findSpecificComputer(
			@PathVariable("id") long id) {
		System.out
				.println("*************************************findSpecificComputer");
		Computer item = (Computer) itemService.findItemById(id, "computers");

		if (item == null) {
			return new ResponseEntity<Computer>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Computer>(item, HttpStatus.OK);
	}

	@RequestMapping(value = "/phones")
	public ResponseEntity<List> listAllPhones() {
		System.out
				.println("*************************************ListAllPhones");
		List items = itemService.findItemsByCategory("phones");
		if (items.isEmpty()) {
			return new ResponseEntity<List>(HttpStatus.NO_CONTENT);// You many
	
		}
		return new ResponseEntity<List>(items, HttpStatus.OK);
	}

	@RequestMapping(value = "/phones/{id}")
	public ResponseEntity<Object> findSpecificPhone(@PathVariable("id") long id) {
		System.out.println("*************************************findSpecificPhone");
		Object item = itemService.findItemById(id, "phones");
		if (item == null) {
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);// You many
	
		}
		return new ResponseEntity<Object>(item, HttpStatus.OK);
	}

	@RequestMapping(value = "/printers")
	public ResponseEntity<List> listAllPrinters() {
		System.out.println("*************************************ListAllPrinters");
		List items = itemService.findItemsByCategory("printers");
		if (items.isEmpty()) {
			return new ResponseEntity<List>(HttpStatus.NO_CONTENT);// You many
																	// HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List>(items, HttpStatus.OK);
	}

	@RequestMapping(value = "/printers/{id}")
	public ResponseEntity<Object> findSpecificPrinter(
			@PathVariable("id") long id) {
		System.out
				.println("*************************************findSpecificPrinter");
		Object item = itemService.findItemById(id, "printers");
		if (item == null) {
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);// You many
																		// decide
		}
		return new ResponseEntity<Object>(item, HttpStatus.OK);
	}

}
