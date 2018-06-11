package com.google.kleinikov.stanislav.dao;

import java.util.List;

import com.google.kleinikov.stanislav.dto.NewsDTO;
import com.google.kleinikov.stanislav.entity.News;
import com.google.kleinikov.stanislav.exception.NoSuchNewsException;

public interface NewsDao {

	List<NewsDTO> getListNewsDTO();

	News getNews(int id) throws NoSuchNewsException;

	void removeNews(int id);
}
