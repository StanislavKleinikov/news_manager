package com.google.kleinikov.stanislav.service;

import java.util.List;

import com.google.kleinikov.stanislav.dto.NewsDTO;
import com.google.kleinikov.stanislav.entity.News;
import com.google.kleinikov.stanislav.exception.NoSuchNewsException;

public interface NewsService {

	News getNews(int id) throws NoSuchNewsException;

	List<NewsDTO> getListNewsDTO();

	void removeNews(int id);
}
