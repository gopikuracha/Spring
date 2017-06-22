package com.kriss.spring.DemoApp.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.kriss.spring.DemoApp.DrawEvent;

@Component
public class Square implements Shape {
	
	@Autowired
	@Qualifier("origin")
	private Point point1;
	
	@Autowired
	private MessageSource messageSource;

	public Point getPoint1() {
		return point1;
	}

	public void setPoint1(Point point1) {
		this.point1 = point1;
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public void draw() {
		System.out.println(this.messageSource.getMessage("draw.square", null, "Not Found", null));
		System.out.println(this.messageSource.getMessage("draw.square.drawing", new Object[] {this.point1}, "Not Found", null));
	}

}
