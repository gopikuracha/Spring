package com.kriss.spring.DemoApp;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import com.kriss.spring.DemoApp.model.Shape;


/**
 * @author kriss
 * @concept
 * 1. Bean factory types - 
 * 		a. XML Bean factory - Reads an XML file (resource)
 * 		b. Application Context - Class Path XML Application Context
 * 				Reads an XML file (resource)
 * 				Supports AOP and event handling
 * 					Event Handling - 
 * 						Event Publisher
 * 						Event Listener		- 	ApplicationListener (i)
 * 						Event				- 	ApplicationEvent (i)
 * 				Support for messaging and internationalization
 * 				No much deference in performance
 * 		c. AbstractApplicationContext - same as ApplicationContext
 * 				Used only for desktop applications
 * 				To close the Application context and destroy all the beans
 * 				need to invoke registerShutdownHook() initially
 */
public class DrawingApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		//Triangle tr = (Triangle) factory.getBean("triangle");
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		
		Shape shape1 = (Shape) context.getBean("triangle");
		shape1.draw();
		
		Shape shape2 = (Shape) context.getBean("tr-2");
		shape2.draw();
		
		Shape shape3 = (Shape) context.getBean("autowired-1-triangle");
		shape3.draw();
		
		Shape shape4 = (Shape) context.getBean("autowired-3-triangle");
		shape4.draw();
		
		Shape shape5 = (Shape) context.getBean("circle");
		shape5.draw();
		
		Shape shape6 = (Shape) context.getBean("line");
		shape6.draw();
		
		System.out.println(context.getMessage("greetings", null, "Default Hi Gopi", null));
		System.out.println(context.getMessage("def-greetings", null, "Default Hi Gopi", null));
		System.out.println(context.getMessage("other.greetings", null, "Default Hi Gopi", null));
		//System.out.println(context.getMessage("greetings", null, "Default Hi Gopi", null));
		
	}

}
