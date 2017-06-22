package com.kriss.spring.DemoApp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;


/**
 * @author kriss
 * @concept
 * 		BeanPostProcessor -
 * 			Classes that tell spring that there are some process that spring needs to do after initializing each bean
 * 			This is used to extend the framework functionalities,
 * 			To do any configuration related work after beans are initialized.
 * 			You need to register this class in configuration file, 
 * 								no use of mentioning id while configuring the bean as it will not be referenced anywhere
 * 			postProcessBeforeInitialization -
 * 				this method is invoked before initialization
 * 			postProcessAfterInitialization
 * 				this method is invoked after initialization
 */
public class DisplayNameBeanPostProcessor implements BeanPostProcessor{

	public Object postProcessAfterInitialization(Object bean,
			String beanName) throws BeansException {
		System.out.println("Post Process After Initialization is invoked for... " + beanName);
		return bean;
	}

	public Object postProcessBeforeInitialization(Object bean,
			String beanName) throws BeansException {
		System.out.println("Post Process Before Initialization is invoked for... " + beanName);
		return bean;
	}

}
