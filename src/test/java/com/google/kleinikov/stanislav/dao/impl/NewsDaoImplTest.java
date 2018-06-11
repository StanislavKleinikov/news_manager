package com.google.kleinikov.stanislav.dao.impl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.kleinikov.stanislav.controller.ApplicationController;
import com.google.kleinikov.stanislav.exception.NoSuchNewsException;

import junit.framework.TestCase;

public class NewsDaoImplTest extends TestCase {

	public void testGetListNewsDTO() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ApplicationController controller = context.getBean(ApplicationController.class, "controller");
		context.close();
		assertNotNull(controller.getService().getListNewsDTO());
	}

	public void testGetNews() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ApplicationController controller = context.getBean(ApplicationController.class, "controller");
		context.close();
		try {
			assertNotNull(controller.getService().getNews(1));
		} catch (NoSuchNewsException e) {
			e.printStackTrace();
		}
	}

}
