package com.google.kleinikov.stanislav.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.kleinikov.stanislav.annotation.Logable;
import com.google.kleinikov.stanislav.dao.NewsDao;
import com.google.kleinikov.stanislav.dto.NewsDTO;
import com.google.kleinikov.stanislav.entity.News;
import com.google.kleinikov.stanislav.exception.NoSuchNewsException;
import com.google.kleinikov.stanislav.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	NewsDao newsDao;

	@Override
	public News getNews(int id) throws NoSuchNewsException {
		News news = newsDao.getNews(id);
		return news;
	}

	@Override
	public List<NewsDTO> getListNewsDTO() {
		List<NewsDTO> list = newsDao.getListNewsDTO();
		return list;
	}

	@Override
	@Logable
	public void removeNews(int id) {
		newsDao.removeNews(id);
	}

}
