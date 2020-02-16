package com.news.console;

import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NewsProcessor {

	public static final int CACHE_CAPACITY = 5;

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

	private NewsHolder newsHolder = new NewsHolder();

	private List<News> newsList;

	private HashMap<String, String> sortingType = new HashMap<>();

	public NewsProcessor() throws ParseException {
		newsList = newsHolder.loadNews();

		sortingType.put("1", "all");
		sortingType.put("2", "topic");
		sortingType.put("3", "date");
		sortingType.put("4", "popularity");

		sortingType.put("a", "SPORT");
		sortingType.put("b", "MEDIA");
		sortingType.put("c", "SOCIAL");
		sortingType.put("d", "POLITIC");

	}

	public void scanConsol() {

		List<News> newsSortedList = new ArrayList<News>();

		System.out.println("Enter the news sorting type:");
		System.out.println("1 - all");
		System.out.println("2 - topic");
		System.out.println("3 - date");
		System.out.println("4 - popularity");
		System.out.println("5 - exit");

		try (Scanner scaner = new Scanner(System.in)) {
			while (scaner.hasNext()) {

				String type = scaner.nextLine();

				// All news
				if (type.equals("1")) {
					printNewsFromList(newsList, newsList, type);
				}

				// Compare News by topic
				if (type.equals("2")) {

					System.out.println("Enter news topic:");
					System.out.println("a - sport");
					System.out.println("b - media");
					System.out.println("c - social");
					System.out.println("d - politic");

					String typeT = scaner.nextLine();

					newsSortedList = newsList.stream()
							.filter(news -> news.getTopic().equals(" - " + sortingType.get(typeT) + " - "))
							.collect(Collectors.toList());

					printNewsFromList(newsList, newsSortedList, typeT);
				}

				// Compare News by date
				if (type.equals("3")) {

					newsSortedList.addAll(newsList);

					newsSortedList = newsList.stream()
							.sorted((News n1, News n2) -> n1.getDate().compareTo(n2.getDate()))
							.collect(Collectors.toList());

					printNewsFromList(newsList, newsSortedList, type);
				}

				// Compare News by popularity
				if (type.equals("4")) {

					System.out.println("Sort by popularity:");

					newsSortedList.addAll(newsList);

					newsSortedList = newsList.stream()
							.sorted((News n1, News n2) -> n2.getDate().compareTo(n1.getDate()))
							.sorted((News n1, News n2) -> n2.getCounter().compareTo(n1.getCounter()))
							.collect(Collectors.toList());

					for (int i = 0; i < CACHE_CAPACITY; i++) {

						News news = newsSortedList.get(i);

						System.out.println(news.getDate().format(formatter) + " " + news.getTopic() + " "
								+ news.getText() + " " + news.getCounter());
					}
				}

				if (type.equals("5")) {
					System.out.println("Exit...");
					System.exit(0);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void printNewsFromList(List<News> newsList, List<News> newsSortedListForPrint, String type) {

		System.out.println("Sort by " + sortingType.get(type) + ":");

		for (News news : newsSortedListForPrint) {
			news.setCounter(news.getCounter() + 1);

			System.out.println(news.getDate().format(formatter) + " " + news.getTopic() + " " + news.getText() + " "
					+ news.getCounter());
		}

	}

}