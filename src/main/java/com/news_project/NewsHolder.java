package com.news_project;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

public class NewsHolder {

	private String sport = "sport";
	private String media = "media";
	private String social = "social";
	private String politic = "politic";

	public List<News> loadNews(List<News> newsList) throws ParseException {

		setNews(1, newsList, 2019, 1, 12, sport, "1 - Sport is good", 0);
		setNews(2, newsList, 2018, 2, 14, sport, "2 - Sport is very good", 0);
		setNews(3, newsList, 2018, 8, 14, social, "3 - Social news", 0);
		setNews(4, newsList, 2018, 9, 18, media, "4 - Media are cool", 0);
		setNews(5, newsList, 2018, 7, 14, sport, "5 - Sport is cool", 0);
		setNews(6, newsList, 2019, 5, 14, social, "6 - Social is ...", 0);
		setNews(7, newsList, 2019, 12, 12, politic, "7 - Politic is very important", 0);

		return newsList;
	}

	public void setNews(int number, List<News> newsList, int year, int month, int day, String topic, String text, int counter) {
		News news = new News();
		news.setNumber(number);
		LocalDate localDate = LocalDate.of(year, month, day);
		news.setDate(localDate);
		news.setTopic(" - " + topic + " - ");
		news.setText(text);
		news.setCounter(counter);
		newsList.add(news);

	}

}
