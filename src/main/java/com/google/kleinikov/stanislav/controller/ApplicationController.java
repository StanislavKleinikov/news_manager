package com.google.kleinikov.stanislav.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.google.kleinikov.stanislav.exception.InvalidCommandException;
import com.google.kleinikov.stanislav.exception.NoSuchNewsException;
import com.google.kleinikov.stanislav.service.NewsService;
import com.google.kleinikov.stanislav.view.Menu;

@Controller
public class ApplicationController {

	@Autowired
	private Menu menu;

	@Autowired
	private NewsService service;

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ApplicationController controller = context.getBean(ApplicationController.class, "controller");

		while (true) {
			try {
				int newsId = controller.menu.showMenu(controller.service.getListNewsDTO());

				if (newsId == 0) {
					System.err.println("Bye");
					context.close();
					System.exit(0);

				} else if (newsId > 0) {
					int command = controller.menu.getNews(controller.service.getNews(newsId));
					switch (command) {
					case 1:
						break;
					case 2:
						if (controller.menu.removeNews()) {
							controller.service.removeNews(newsId);
						}
						break;
					case 0:
						System.err.println("Bye");
						context.close();
						System.exit(0);
						break;
					default:
						throw new InvalidCommandException("Invalid command. Please, try again");
					}
				} else if (newsId < 0) {
					throw new InvalidCommandException("Invalid command. Please, try again");
				}
			} catch (NumberFormatException e) {
				System.err.println("Invalid command. Please, try again");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InvalidCommandException e) {
				System.err.println(e.getMessage());
			} catch (NoSuchNewsException e) {
				System.err.println(e.getMessage());
			}
		}

	}
}
