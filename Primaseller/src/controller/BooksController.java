package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import model.Books;

public class BooksController {

	public static List<Books> readBooks(String bFile) {

		List<Books> books = new ArrayList<>();
		Path path = Paths.get(bFile);

		try {
			BufferedReader br = Files.newBufferedReader(path, StandardCharsets.US_ASCII);

			String line = br.readLine();

			while (line != null) {
				String[] values = line.split(",");

				Books bHolder = createBooks(values);

				books.add(bHolder);

				line = br.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return books;
	}

	private static Books createBooks(String[] values) {

		Books books = new Books();

		books.setBook_id(values[0]);
		books.setBook_title(values[1]);
		books.setBook_author(values[2]);
		books.setBook_price(new BigDecimal(values[3]));

		return books;
	}

}
