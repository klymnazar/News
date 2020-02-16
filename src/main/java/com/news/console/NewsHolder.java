package com.news.console;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NewsHolder {

	final String Sport = "sport";
	final String Media = "media";
	final String Social = "social";
	final String Politic = "politic";

	public List<News> loadNews() throws ParseException {

		List<News> newsList = new ArrayList<News>();

		newsList.add(addNews(LocalDate.of(2019, 1, 12), Sport, "1 - Sport is good", 0));
		newsList.add(addNews(LocalDate.of(2018, 2, 14), Sport, "2 - Sport is very good", 0));
		newsList.add(addNews(LocalDate.of(2018, 8, 14), Social, "3 - Social news", 0));
		newsList.add(addNews(LocalDate.of(2018, 9, 18), Media, "4 - Media are cool", 0));
		newsList.add(addNews(LocalDate.of(2018, 7, 14), Sport, "5 - Sport is cool", 0));
		newsList.add(addNews(LocalDate.of(2019, 5, 14), Social, "6 - Social is ...", 0));
		newsList.add(addNews(LocalDate.of(2019, 12, 12), Politic, "7 - Politics is very important", 0));
		newsList.add(addNews(LocalDate.of(2020, 1, 31), Sport, "8 - Sport is my life", 0));
		newsList.add(addNews(LocalDate.of(2019, 11, 11), Media, "9 - Media are the communication", 0));
		newsList.add(addNews(LocalDate.of(2017, 12, 12), Politic, "10 - Politics is for people", 0));

		return newsList;
	}

	public News addNews(LocalDate localDate, String topic, String text, int counter) {
		News news = new News();

		news.setDate(localDate);
		news.setTopic(" - " + topic + " - ");
		news.setText(text);
		news.setCounter(counter);

		return news;
	}

}
