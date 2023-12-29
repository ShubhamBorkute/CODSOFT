package com.codsoft.Counting_words;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class CountingWords {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inputText = "";

		System.out.println("**********Welcome to Words Counter Game***********");
		System.out.println();

		System.out.println("Enter String");
		inputText = sc.nextLine();

		if (args.length > 0) {
			String fileName = args[0];

			inputText = readFile(fileName);
		}

		String[] words = inputText.split("[\\s\\p{Punct}]+");
		int count = words.length;
		System.out.println("--------------------------------------------------");
		System.out.println("The total words In String : " + count);
		System.out.println();
		System.out.println("--------------------------------------------------");
		System.out.println();
		System.out.println(
				"Common Words Are :[the " + "and " + "is " + "in " + "to " + "it " + "of " + "a " + "for " + "on]");
		System.out.println("Do You Want To Count Common Words");
		System.out.println("1. Yes \n2. No");
		int ch = sc.nextInt();
		switch (ch) {

		case 1: // define common words
			Set<String> commonwords = new HashSet<>(
					Arrays.asList("the", "and", "is", "in", "to", "it", "of", "a", "for", "on"));

			// filter out
			List<String> filterwords = new ArrayList<>();

			for (String word : words) {
				if (!commonwords.contains(word.toLowerCase())) {

					filterwords.add(word.toLowerCase());

				}
			}

			int filtercount = filterwords.size();

			// display total words after filtering common words

			// display common words

			System.out.println("-------------------Common Words-------------------");

			System.out.println("Common words are : ");
			int cocount = 0;
			for (String word : words) {
				if (commonwords.contains(word.toLowerCase())) {
					cocount++;
					System.out.print(" " + word + " ");

				}

			} // common words end
			System.out.println();
			System.out.println("Total Common words : " + cocount);
			System.out.println("--------------------------------------------------");
			System.out.println();

			System.out.println("-------------------Normal Words-------------------");

			System.out.println("Total Words After Filtering Common Words : " + filtercount);
			System.out.println("Normal Words are : " + filterwords);
			System.out.println();
			System.out.println("--------------------------------------------------");

			break;
		case 2:
			System.out.println("Thank You !!!!!! ");
			break;
		default:
			System.out.println("Invalid Choice \tTry Again");

		}

		// total word after remove
		sc.close();
	}

	// Method to read from file
	private static String readFile(String fileName) {

		StringBuilder text = new StringBuilder();

		try {
			File file = new File(fileName);

			FileReader reader = new FileReader(file);
			BufferedReader br = new BufferedReader(reader);
			String line;

			while ((line = br.readLine()) != null) {
				text.append(line).append("\n");
			}
			br.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return text.toString();
	}

}
