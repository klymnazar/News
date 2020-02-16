package com.news.console;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NewsHolder {

	public static final String SPORT = "SPORT";
	public static final String MEDIA = "MEDIA";
	public static final String SOCIAL = "SOCIAL";
	public static final String POLITIC = "POLITIC";

	public List<News> loadNews() throws ParseException {

		List<News> newsList = new ArrayList<News>();

		newsList.add(createNews(LocalDate.of(2019, 1, 12), SPORT, "1 - Sport is good", 0));
		newsList.add(createNews(LocalDate.of(2018, 2, 14), SPORT, "2 - Sport is very good", 0));
		newsList.add(createNews(LocalDate.of(2018, 8, 14), SOCIAL, "3 - Social news", 0));
		newsList.add(createNews(LocalDate.of(2018, 9, 18), MEDIA, "4 - Media are cool", 0));
		newsList.add(createNews(LocalDate.of(2018, 7, 14), SPORT, "5 - Sport is cool", 0));
		newsList.add(createNews(LocalDate.of(2019, 5, 14), SOCIAL, "6 - Social is ...", 0));
		newsList.add(createNews(LocalDate.of(2019, 12, 12), POLITIC, "7 - Politics is very important", 0));
		newsList.add(createNews(LocalDate.of(2020, 1, 31), SPORT, "8 - Sport is my life", 0));
		newsList.add(createNews(LocalDate.of(2019, 11, 11), MEDIA, "9 - Media are the communication", 0));
		newsList.add(createNews(LocalDate.of(2017, 12, 12), POLITIC, "10 - Politics is for people", 0));

		return newsList;
	}

	public News createNews(LocalDate localDate, String topic, String text, int counter) {
		News news = new News();

		news.setDate(localDate);
		news.setTopic(" - " + topic + " - ");
		news.setText(text);
		news.setCounter(counter);

		return news;
	}

}
