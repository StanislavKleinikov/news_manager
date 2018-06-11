package com.google.kleinikov.stanislav.view;

import java.io.IOException;
import java.util.List;

import com.google.kleinikov.stanislav.dto.NewsDTO;
import com.google.kleinikov.stanislav.entity.News;

public interface Menu {

	int showMenu(List<NewsDTO> list) throws NumberFormatException, IOException;

	int getNews(News news) throws NumberFormatException, IOException;

	boolean removeNews();
}
