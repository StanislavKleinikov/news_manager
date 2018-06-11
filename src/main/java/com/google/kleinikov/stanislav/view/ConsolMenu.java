package com.google.kleinikov.stanislav.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.stereotype.Component;

import com.google.kleinikov.stanislav.dto.NewsDTO;
import com.google.kleinikov.stanislav.entity.News;

@Component
public class ConsolMenu implements Menu {

	@Override
	public int showMenu(List<NewsDTO> list) throws NumberFormatException, IOException {
		int point = -1;
		for (NewsDTO newsDTO : list) {
			System.out.printf("%d %s %tF%n%s%n", newsDTO.getId(), newsDTO.getTitle(), newsDTO.getDate(),
					newsDTO.getPreview());
			System.out.println("----------------------------------------------------------------------");
		}
		System.out.println("Please ,enter the id of the news or '0' to Quit");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		point = Integer.parseInt(reader.readLine());
		return point;
	}

	@Override
	public int getNews(News news) throws NumberFormatException, IOException {
		int point = -1;
		System.out.println("-----------------------------------------------------------------------");
		System.out.printf("%d %s: %s %tF %n%n %s %n%n", news.getId(), news.getCategory(), news.getTitle(),
				news.getDate(), news.getText());

		System.out.println("Authors: " + news.getAuthors());
		for (String tag : news.getTags()) {
			System.out.print("#" + tag);
		}

		System.out.println("\n\nPlease, choose the action \n1)Return" + "\n" + "2)Delete news" + "\n" + "0)Quit");

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		point = Integer.parseInt(reader.readLine());

		return point;
	}

	@Override
	public boolean removeNews() {
		boolean result = false;
		System.err.println("Please, confirm the deletion of the news \nEnter 'yes'");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			result = "yes".equalsIgnoreCase(reader.readLine().trim());
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (!result) {
			System.err.println("The deletion has been cancelled");
		}
		return result;
	}

}
