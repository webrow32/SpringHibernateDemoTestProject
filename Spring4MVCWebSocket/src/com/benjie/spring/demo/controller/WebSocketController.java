package com.benjie.spring.demo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.benjie.spring.demo.services.CalcInput;
import com.benjie.spring.demo.services.Result;


@Controller
public class WebSocketController {

	@MessageMapping("/add")
	@SendTo("/topic/showResult")
	public Result addNum(CalcInput input) throws Exception {
		Thread.sleep(2000);
		Result result = new Result(input.getNum1()+"+"+input.getNum1()+"="+(input.getNum1()+input.getNum2()));
		return result;
	}
	
	@RequestMapping("/start")
	public String start(){
		return "start";
	}
}
