package manipulate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import model.Books;
import model.Sales;

public class TopSellingBooks {

	public static ArrayList<String> topSellingBooks(List<Books> books, List<Sales> sales, int count) {

		Map<String, BigDecimal> cumulativeSalesMap = new HashMap<>();

		for (Sales s : sales) {

			HashMap<String, Integer> hMap = s.getOnwards();

			for (Map.Entry<String, Integer> entry : hMap.entrySet()) {

				String bookID = entry.getKey();
				int qty = entry.getValue();

				for (Books b : books) {

					if (b.getBook_id().equals(bookID)) {

						BigDecimal pricePerBook = b.getBook_price();

						BigDecimal totalPrice = pricePerBook.multiply(new BigDecimal(qty));

						cumulativeSalesMap.put(b.getBook_id(), totalPrice);

					}

				}
			}

		}

		Map.Entry<String, BigDecimal> maxValue = null;

		Map<String, BigDecimal> topNBooks = new LinkedHashMap<>();

		for (int i = 0; i < count; i++) {

			for (Map.Entry<String, BigDecimal> entry : cumulativeSalesMap.entrySet()) {

				if (maxValue == null || entry.getValue().compareTo(maxValue.getValue()) > 0) {

					maxValue = entry;

				}

			}

			topNBooks.put(maxValue.getKey(), maxValue.getValue());

			cumulativeSalesMap.remove(maxValue.getKey());

			maxValue = null;

		}

		return new ArrayList<>(topNBooks.keySet());

	}

}
