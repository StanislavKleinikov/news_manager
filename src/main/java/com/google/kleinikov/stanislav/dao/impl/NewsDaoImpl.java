package com.google.kleinikov.stanislav.dao.impl;

import static com.google.kleinikov.stanislav.util.ConstantValue.SQL_STATEMENT_AUTHORS;
import static com.google.kleinikov.stanislav.util.ConstantValue.SQL_STATEMENT_DELETE_NEWS;
import static com.google.kleinikov.stanislav.util.ConstantValue.SQL_STATEMENT_LIST_NEWS;
import static com.google.kleinikov.stanislav.util.ConstantValue.SQL_STATEMENT_NEWS;
import static com.google.kleinikov.stanislav.util.ConstantValue.SQL_STATEMENT_TAGS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.kleinikov.stanislav.dao.ConnectionPool;
import com.google.kleinikov.stanislav.dao.NewsDao;
import com.google.kleinikov.stanislav.dto.NewsDTO;
import com.google.kleinikov.stanislav.entity.News;
import com.google.kleinikov.stanislav.exception.NoSuchNewsException;

@Repository
public class NewsDaoImpl implements NewsDao {

	@Autowired
	private ConnectionPool pool;

	@Override
	public List<NewsDTO> getListNewsDTO() {
		List<NewsDTO> list = new ArrayList<>();
		try (Connection connection = pool.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(SQL_STATEMENT_LIST_NEWS);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				NewsDTO news = new NewsDTO();
				news.setId(rs.getInt("id"));
				news.setTitle(rs.getString("title"));
				Calendar calendar = new GregorianCalendar();
				calendar.setTimeInMillis(rs.getTimestamp("date").getTime());
				news.setDate(calendar);
				news.setPreview(rs.getString("text").substring(0, 80));
				list.add(news);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public News getNews(int id) throws NoSuchNewsException {

		News news = new News();

		try (Connection conn = pool.getConnection()) {

			try (PreparedStatement statement = conn.prepareStatement(SQL_STATEMENT_NEWS);) {
				statement.setInt(1, id);
				ResultSet rs = statement.executeQuery();
				if (!rs.first()) {
					throw new NoSuchNewsException("invalid id");
				}
				rs.previous();
				while (rs.next()) {
					news.setId(rs.getInt("id"));
					news.setTitle(rs.getString("title"));
					news.setText(rs.getString("text"));
					news.setCategory(rs.getString("category"));
					Calendar calendar = new GregorianCalendar();
					calendar.setTimeInMillis(rs.getTimestamp("date").getTime());
					news.setDate(calendar);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try (PreparedStatement statement = conn.prepareStatement(SQL_STATEMENT_AUTHORS)) {
				statement.setInt(1, id);
				ResultSet rs = statement.executeQuery();
				List<String> authors = new ArrayList<>();
				while (rs.next()) {
					authors.add(rs.getString("name"));
				}
				news.setAuthors(authors);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try (PreparedStatement statement = conn.prepareStatement(SQL_STATEMENT_TAGS)) {
				statement.setInt(1, id);
				ResultSet rs = statement.executeQuery();
				List<String> tags = new ArrayList<>();
				while (rs.next()) {
					tags.add(rs.getString("name"));
				}
				news.setTags(tags);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return news;
	}

	@Override
	public void removeNews(int id) {
		try (Connection connection = pool.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(SQL_STATEMENT_DELETE_NEWS);
			statement.setInt(1, id);
			statement.executeUpdate();
			System.err.println("The news id=" + id + " has been deleted");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Failed to delete");
		}
	}

}
