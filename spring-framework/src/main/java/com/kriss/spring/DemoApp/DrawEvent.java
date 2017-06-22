package com.kriss.spring.DemoApp;

import org.springframework.context.ApplicationEvent;

public class DrawEvent extends ApplicationEvent{

	public DrawEvent(Object source) {
		super(source);
	}
	
	@Override
	public String toString() {
		return "Draw Event occured";
	}

}
