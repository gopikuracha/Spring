package com.kriss.spring.DemoApp.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.kriss.spring.DemoApp.DrawEvent;


/**
 * @author kriss
 * @concept
 * 		@Resource 
 * 			Is a JSR annotation used for injecting dependencies
 * 			when given a name, it looks for the bean with that name/id in the config file anf injects it
 * 			if not give, it uses the name of the attribute as the name/id and injects it
 * 		@PostConstruct
 * 			Will be invoked after a bean is initialized
 * 			This is invoked before the init methods that are declared in the configuration file
 * 		@PreDestroy
 * 			Will be invoked before destroying the bean
 * 			This is invoked before the destroy methods that are declared in the configuration file
 * 
 * 		ApplicationEventPublisherAware
 * 			Implement setApplicationEventPublisher
 * 			to access the application event publisher that spring provides
 * 			Application context is also an application event publisher and thats the one Spring is going to provide here
 * 			When will it be invoked?
 */

@Component
public class Circle implements Shape, ApplicationEventPublisherAware {

	private Point center;
	
	private Point origin;
	
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private MessageSource messageSource;
	
	public Point getCenter() {
		return center;
	}

	@Resource(name="origin")
	public void setCenter(Point center) {
		this.center = center;
	}

	public Point getOrigin() {
		return origin;
	}

	@Resource
	public void setOrigin(Point origin) {
		this.origin = origin;
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public void draw() {
		System.out.println(messageSource.getMessage("circle.instruction", null, "Property Not Read...", null));
		System.out.println(messageSource.getMessage("circle.points", new Object[] {center, origin}, "Property Not Read...", null));
		DrawEvent event = new DrawEvent(this);
		publisher.publishEvent(event);
	}
	
	public void myGlobalInit(){
		System.out.println("My Global Inti invoked... "+this);
	}

	public void myGlobalDestroy(){
		System.out.println("My Global Destroy invoked... "+this);
	}
	
	@PostConstruct
	public void initializeCircle() {
		System.out.println("JSR 250 annotation to invoke init after initialiation of Circle...");
	}

	@PreDestroy
	public void destroyCircle() {
		System.out.println("JSR 250 annotation to invoke destroy before distruction of circle...");
	}

	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.publisher = applicationEventPublisher;
		
	}
}
