package com.google.kleinikov.stanislav.util;

public final class ConstantValue {

	public final static String SQL_STATEMENT_LIST_NEWS = "SELECT * FROM news";

	public final static String SQL_STATEMENT_NEWS = "SELECT news.id,title,date,category.name AS category,text FROM news JOIN category "
			+ "ON news.category = category.id WHERE news.id = ?";

	public final static String SQL_STATEMENT_AUTHORS = "SELECT name FROM news_author JOIN author ON author_id = author.id WHERE news_id = ?";

	public final static String SQL_STATEMENT_TAGS = "SELECT name FROM news_tag JOIN tag ON tag_id = tag.id WHERE news_id = ?";

	public final static String SQL_STATEMENT_DELETE_NEWS = "DELETE FROM news WHERE id = ?";
}
