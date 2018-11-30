package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import model.Sales;

public class SalesController {

	public static List<Sales> readSales(String sFile) {

		List<Sales> sales = new ArrayList<>();
		Path path = Paths.get(sFile);

		try {
			BufferedReader br = Files.newBufferedReader(path, StandardCharsets.US_ASCII);

			String line = br.readLine();

			while (line != null) {
				String[] values = line.split(",");

				Sales sHolder = createSales(values);

				sales.add(sHolder);

				line = br.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return sales;
	}

	private static Sales createSales(String[] values) {

		Sales sales = new Sales();
		HashMap<String, Integer> hash = new HashMap<>();

		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(values[0]);
			sales.setSale_date(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		sales.setSale_email(values[1]);
		sales.setSale_payment_method(values[2]);
		sales.setSale_item_count(Integer.parseInt(values[3]));

		for (int i = 4; i < sales.getSale_item_count() + 4; i++) {

			String[] x = values[i].split(";");
			hash.put(x[0], Integer.parseInt(x[1]));
		}

		sales.setOnwards(hash);

		return sales;
	}

}
