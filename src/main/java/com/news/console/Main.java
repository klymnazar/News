package com.news.console;

import java.text.ParseException;

public class Main {

	public static void main(String[] args) throws ParseException {

		NewsProcessor newsProcessor = new NewsProcessor();

		for (;;) {
			newsProcessor.scanConsol();
		}
	}
}
