package com.kriss.spring.DemoApp.model;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


/**
 * @author kriss
 * @concept 
 * 		BeanNameAware - 
 * 				Implement setBeanName method
 * 				To know the name of the beans
 * 				Will be invoked first
 * 
 * 		ApplicationContextAware - 
 * 				Implement setApplicationContext method
 * 				To access application context
 * 				Will be invoked second
 * 
 * 		InitializingBean - 
 * 				Implement afterPropertiesSet method
 * 				This will be executed once the bean is initialized
 * 		One other way is to have custom method like myInit and include it in init-method attribute of Spring configuration file
 * 		First InitializingBean will be called and then the configured one in configuration file
 * 
 * 		DisposableBean - 
 * 				Implements destroy method
 * 				This will be executed just before the bean gets destroyed
 * 				Note: This happens only if shutdown hook is registered
 * 		One other way is to have custom method like myDestroy and include it in destroy-method attribute of Spring configuration file
 * 		First DisposableBean will be called and then the configured one in configuration file
 * 
 * 		@Required - 
 * 				When this annotation is marked on any setter, Spring looks for this property before initializing the bean
 * 				Will fail the process if it does not find this bean in the configuration file
 * 
 * 		@Autowired - 
 * 				Spring first looks for this class (type) in the configuration file. If there are multiple beans of the same type,
 * 					it then checks for the name of the attribute as a clue to autowire the bean from the existing beans of same type.
 * 				@Qualifier - 
 * 					If Spring is still not able to wire a bean to the object, we can also mention a qualifier with the same qualifier
 * 						used in the configuration file.
 * 
 */
public class Triangle implements Shape, ApplicationContextAware, BeanNameAware, InitializingBean, DisposableBean {
	
	private String type;
	private int height;
	
	private Point a;
	private Point b;
	private Point c;
	
	private Line p;
	private Line q;
	private Line r;
	
	private ApplicationContext context = null;
	private String name = null;
	
	//private Point origin;
	
	private List<Point> points;
	
	public Triangle() {}
	
	public Triangle(String type) {
		this.type = type;
	}
	
	public Triangle(String type, int height) {
		this.type = type;
		this.height = height;
	}
	
	public Triangle(String type, int height, List<Point> points) {
		this.type = type;
		this.height = height;
		this.points = points;
	}
	
	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public String getType() {
		return type;
	}
	
	@Required
	public void setType(String type) {
		this.type = type;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Point getA() {
		return a;
	}

	public void setA(Point a) {
		this.a = a;
	}

	public Point getB() {
		return b;
	}

	public void setB(Point b) {
		this.b = b;
	}

	public Point getC() {
		return c;
	}

	public void setC(Point c) {
		this.c = c;
	}

	public Line getP() {
		return p;
	}
	
	@Autowired
	public void setP(Line p) {
		this.p = p;
	}

	public Line getQ() {
		return q;
	}

	public void setQ(Line q) {
		this.q = q;
	}

	public Line getR() {
		return r;
	}

	public void setR(Line r) {
		this.r = r;
	}

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public void draw() {
		System.out.println("Name - " + name);
		System.out.println(getHeight() + " meters high " + type + " Triangle Drawn with : " + a + " " + b + " " + c);
		System.out.println("Lines : " + p + " " + q + " " + r);
		System.out.println("List - " + points);
	}

	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		this.context = context;
		System.out.println("ApplicationContextAware is invoked for the bean... "+this.name);
	}

	public void setBeanName(String name) {
		this.name = name;
		System.out.println("BeanNameAware is invoked for the bean... "+this.name);
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("Initializing Bean invoked after properties are set... "+this.name);
		
	}

	public void destroy() throws Exception {
		System.out.println("Disposable Bean invoked... "+this.name);
		
	}
	
	public void myInit(){
		System.out.println("My Inti invoked... "+this.name);
	}

	public void myDestroy(){
		System.out.println("My Destroy invoked... "+this.name);
	}
	
	public void myGlobalInit(){
		System.out.println("My Global Inti invoked... "+this.name);
	}

	public void myGlobalDestroy(){
		System.out.println("My Global Destroy invoked... "+this.name);
	}
	
}
