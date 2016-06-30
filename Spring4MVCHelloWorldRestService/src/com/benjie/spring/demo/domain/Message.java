package com.benjie.spring.demo.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="pizza")
public class Message {

	String name;
	String text;

	public Message() {

	}

	public Message(String name, String text) {
		this.name = name;
		this.text = text;
	}
	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@XmlElement
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
