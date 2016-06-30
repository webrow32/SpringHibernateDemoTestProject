package com.benjie.project;

public class App {

	public static void main(String[]args){
		App app = new App();
		int addition = app.sum(10,20);
		System.out.println("Addition : "+addition);
	}
	
	public int sum(int a, int b){
		return a+b;
	}
}
