package com.kriss.spring.DemoApp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;


/**
 * @author kriss
 * @concept
 * 		BeanFactoryPostProcessor
 * 			Execute the code when a bean factory is initialized
 * 			This applies to Application context as well
 *			You need to register this class in configuration file, 
 * 								no use of mentioning id while configuring the bean as it will not be referenced anywhere
 * 			Other example - PropertyPlaceholderConfigurer supplied by Spring
 * 			postProcessBeanFactory -
 * 				Before the bean factory is initialized
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor{

	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory paramConfigurableListableBeanFactory)
			throws BeansException {
		System.out.println("Bean Factory Post Processor is invoked...");
		
	}

}
