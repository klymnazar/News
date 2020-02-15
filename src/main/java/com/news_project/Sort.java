package com.news_project;

import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Sort {

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

	NewsHolder newsHolder = new NewsHolder();

	List<News> newsList = new ArrayList<News>();

	public Sort() throws ParseException {
		newsList = newsHolder.loadNews(newsList);
	}

	public void scanConsol() {

		List<News> newsSortedList = new ArrayList<News>();

		System.out.println("Enter the news sorting type (1 - all, 2 - topic, 3 - date, 4 - popularity):");

		Scanner in = new Scanner(System.in);
		String type = in.nextLine();

		// All news
		if (type.equals("1")) {
			printNewsFromList(newsList, newsList, type);
		}

		// News by topic
		if (type.equals("2")) {

			System.out.println("Enter news topic (21 - sport, 22 - media, 23 - social, 24 - politic):");

			String typeT = in.nextLine();

			if (typeT.equals("21")) {
				typeT = "sport";
			}
			if (typeT.equals("22")) {
				typeT = "media";
			}
			if (typeT.equals("23")) {
				typeT = "social";
			}
			if (typeT.equals("24")) {
				typeT = "politic";
			}

			Iterator<News> itr0 = newsList.iterator();
			while (itr0.hasNext()) {
				News news = new News();
				news = itr0.next();

				if (news.getTopic().equals(" - " + typeT + " - ")) {
					newsSortedList.add(news);
				}
			}
			printNewsFromList(newsList, newsSortedList, typeT);
		}

		// Compare News by date
		if (type.equals("3")) {

			newsSortedList = createNewsSortedList();

			Collections.sort(newsSortedList, (News n1, News n2) -> (n1.getDate()).compareTo(n2.getDate()));

			printNewsFromList(newsList, newsSortedList, type);
		}

		// Compare News by popularity
		if (type.equals("4")) {

			System.out.println("Enter cache capacity:");

			String typeC = in.nextLine();

			newsSortedList = createNewsSortedList();

			Collections.sort(newsSortedList, (News n1, News n2) -> n2.getNumber().compareTo(n1.getNumber()));

			Collections.sort(newsSortedList, (News n1, News n2) -> n2.getCounter().compareTo(n1.getCounter()));

			int cacheCapacity = Integer.parseInt(typeC);

			for (int i = 0; i < cacheCapacity; i++) {

				News news = new News();
				news = newsSortedList.get(i);

				System.out.println(news.getDate().format(formatter) + " " + news.getTopic() + " " + news.getText() + " "
						+ news.getCounter());
			}
		}
		System.out.println("Continue? (y - yes or n - no)");
	}

	public void printNewsFromList(List<News> newsList, List<News> newsSortedListForPrint, String type) {

		if (type.equals("1")) {
			type = "all";
		}
		if (type.equals("2")) {
			type = "topic";
		}
		if (type.equals("3")) {
			type = "date";
		}
		if (type.equals("4")) {
			type = "popularity";
		}

		System.out.println("Sort by " + type + ":");

		Iterator<News> itr = newsSortedListForPrint.iterator();
		while (itr.hasNext()) {

			News news = new News();
			news = itr.next();

			int counter = news.getCounter();
			news.setCounter(counter + 1);

			newsList.set(news.getNumber() - 1, news);

			System.out.println(news.getDate().format(formatter) + " " + news.getTopic() + " " + news.getText() + " "
					+ news.getCounter());
		}
	}

	public List<News> createNewsSortedList() {
		List<News> newsSortedList = new ArrayList<News>();

		Iterator<News> itr0 = newsList.iterator();
		while (itr0.hasNext()) {
			News news = new News();
			news = itr0.next();
			newsSortedList.add(news);
		}

		return newsSortedList;
	}
}