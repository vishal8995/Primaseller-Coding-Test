package main;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import controller.BooksController;
import controller.SalesController;
import manipulate.SalesOnDate;
import manipulate.TopCustomers;
import manipulate.TopSellingBooks;
import model.Books;
import model.Sales;

public class BookSales {

	/*Main Class*/
	
	public static void main(String[] args) throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		List<Books> books = BooksController.readBooks(args[0].substring(9) + ".csv");

		List<Sales> sales = SalesController.readSales(args[1].substring(9) + ".csv");

		for (int i = 2; i < args.length; i++) {

			if (args[i].contains("top_selling_books")) {

				int count = Integer.parseInt(args[i].substring(20));

				ArrayList<String> topSellingBooksValue = TopSellingBooks.topSellingBooks(books, sales, count);

				System.out.print("\ntop_selling_books\t");
				for (String topNBooks : topSellingBooksValue) {
					System.out.print(topNBooks + "\t");
				}

			}

			else if (args[i].contains("top_customers")) {

				int count = Integer.parseInt(args[i].substring(16));

				ArrayList<String> topCustomersValue = TopCustomers.topCustomers(books, sales, count);

				System.out.print("\ntop_customers\t");
				for (String topNCustomers : topCustomersValue) {
					System.out.print(topNCustomers + "\t");
				}

			}

			else if (args[i].contains("sales_on_date")) {

				Date date = new SimpleDateFormat("yyyy-MM-dd").parse(args[i].substring(16));

				BigDecimal salesOnDateValue = SalesOnDate.salesOnDate(books, sales, date);

				System.out.println("\nsales_on_date\t" + formatter.format(date) + "\t" + salesOnDateValue + "\n");
			}
		}

	}

}
