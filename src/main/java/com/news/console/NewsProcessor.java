package com.news.console;

import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NewsProcessor {

	private int cacheCapacity = 5;

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

	private NewsHolder newsHolder = new NewsHolder();

	private List<News> newsList;

	public NewsProcessor() throws ParseException {
		newsList = newsHolder.loadNews();
	}

	public void scanConsol() {

		List<News> newsSortedList = new ArrayList<News>();

		System.out.println("Enter the news sorting type:");
		System.out.println("1 - all");
		System.out.println("2 - topic");
		System.out.println("3 - date");
		System.out.println("4 - popularity");
		System.out.println("5 - exit");

		Scanner in = new Scanner(System.in);
		String type = in.nextLine();

		// All news
		if (type.equals("1")) {
			printNewsFromList(newsList, newsList, type);
		}

		// News by topic
		if (type.equals("2")) {

			System.out.println("Enter news topic:");
			System.out.println("a - sport");
			System.out.println("b - media");
			System.out.println("c - social");
			System.out.println("d - politic");

			String typeT = in.nextLine();

			HashMap<String, String> topicType = new HashMap<>();

			topicType.put("a", "sport");
			topicType.put("b", "media");
			topicType.put("c", "social");
			topicType.put("d", "politic");

			newsSortedList = newsList.stream()
					.filter(news -> news.getTopic().equals(" - " + topicType.get(typeT) + " - "))
					.collect(Collectors.toList());

			printNewsFromList(newsList, newsSortedList, typeT);
		}

		// Compare News by date
		if (type.equals("3")) {

			newsSortedList.addAll(newsList);

			newsSortedList = newsList.stream().sorted((News n1, News n2) -> n1.getDate().compareTo(n2.getDate()))
					.collect(Collectors.toList());

			printNewsFromList(newsList, newsSortedList, type);
		}

		// Compare News by popularity
		if (type.equals("4")) {

			System.out.println("Sort by popularity:");

			newsSortedList.addAll(newsList);

			newsSortedList = newsList.stream().sorted((News n1, News n2) -> n2.getDate().compareTo(n1.getDate()))
					.collect(Collectors.toList());

			newsSortedList = newsSortedList.stream()
					.sorted((News n1, News n2) -> n2.getCounter().compareTo(n1.getCounter()))
					.collect(Collectors.toList());

			for (int i = 0; i < cacheCapacity; i++) {

				News news = newsSortedList.get(i);

				System.out.println(news.getDate().format(formatter) + " " + news.getTopic() + " " + news.getText() + " "
						+ news.getCounter());
			}
		}

		if (type.equals("5")) {
			System.out.println("Exit...");
			System.exit(0);
		}

	}

	public void printNewsFromList(List<News> newsList, List<News> newsSortedListForPrint, String type) {

		HashMap<String, String> sortingType = new HashMap<>();

		sortingType.put("1", "all");
		sortingType.put("2", "topic");
		sortingType.put("3", "date");
		sortingType.put("4", "popularity");

		System.out.println("Sort by " + sortingType.get(type) + ":");

		Iterator<News> itr = newsSortedListForPrint.iterator();
		while (itr.hasNext()) {

			News news = new News();
			news = itr.next();

			news.setCounter(news.getCounter() + 1);

			System.out.println(news.getDate().format(formatter) + " " + news.getTopic() + " " + news.getText() + " "
					+ news.getCounter());
		}
	}

}