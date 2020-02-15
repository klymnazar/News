package com.news_project;

import java.text.ParseException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ParseException {

		Sort sort = new Sort();

		sort.scanConsol();

		for (int i = 0; i < i + 1; i++) {
			Scanner in = new Scanner(System.in);
			String type = in.nextLine();

			if (type.equals("y")) {

				sort.scanConsol();

			}

			if (type.equals("no")) {
				
				

			}
		}
	}
}
