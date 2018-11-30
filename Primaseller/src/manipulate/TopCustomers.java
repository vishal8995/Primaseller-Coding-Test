package manipulate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import model.Books;
import model.Sales;

public class TopCustomers {

	public static ArrayList<String> topCustomers(List<Books> books, List<Sales> sales, int count) {

		Map<String, BigDecimal> cumulativeSalesPerCustomerMap = new HashMap<>();

		String eMail;
		BigDecimal pricePerBook;
		BigDecimal bookPricePerSale;
		BigDecimal totalPricePerSale;

		for (Sales s : sales) {

			totalPricePerSale = new BigDecimal(0);
			bookPricePerSale = new BigDecimal(0);

			HashMap<String, Integer> hMap = s.getOnwards();

			for (Map.Entry<String, Integer> entry : hMap.entrySet()) {

				String bookID = entry.getKey();
				int qty = entry.getValue();

				for (Books b : books) {

					if (b.getBook_id().equals(bookID)) {

						pricePerBook = b.getBook_price();
						bookPricePerSale = bookPricePerSale.add(pricePerBook.multiply(new BigDecimal(qty)));
					}

				}
			}

			eMail = s.getSale_email();

			if (cumulativeSalesPerCustomerMap.isEmpty()) {

				totalPricePerSale = totalPricePerSale.add(bookPricePerSale);
				cumulativeSalesPerCustomerMap.put(eMail, totalPricePerSale);
			}

			else {

				if (cumulativeSalesPerCustomerMap.containsKey(eMail)) {

					cumulativeSalesPerCustomerMap.put(eMail,
							((cumulativeSalesPerCustomerMap.get(eMail)).add(bookPricePerSale)));

				}

				else {

					totalPricePerSale = totalPricePerSale.add(bookPricePerSale);
					cumulativeSalesPerCustomerMap.put(eMail, totalPricePerSale);
				}
			}

		}

		Map.Entry<String, BigDecimal> maxValue = null;

		Map<String, BigDecimal> topNCustomers = new LinkedHashMap<>();

		for (int i = 0; i < count; i++) {

			for (Map.Entry<String, BigDecimal> entry : cumulativeSalesPerCustomerMap.entrySet()) {

				if (maxValue == null || entry.getValue().compareTo(maxValue.getValue()) > 0) {

					maxValue = entry;

				}

			}

			topNCustomers.put(maxValue.getKey(), maxValue.getValue());

			cumulativeSalesPerCustomerMap.remove(maxValue.getKey());

			maxValue = null;

		}

		return new ArrayList<>(topNCustomers.keySet());
	}

}
