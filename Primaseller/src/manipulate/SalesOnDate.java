package manipulate;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Books;
import model.Sales;

public class SalesOnDate {

	public static BigDecimal salesOnDate(List<Books> books, List<Sales> sales, Date date) {

		Map<String, BigDecimal> totalPriceMap = new HashMap<>();

		BigDecimal finalValue;

		BigDecimal totalPrice = new BigDecimal(0);

		int flag = 0;

		for (Sales s : sales) {

			if (s.getSale_date().compareTo(date) == 0) {

				flag++;

				HashMap<String, Integer> hMap = s.getOnwards();

				for (Map.Entry<String, Integer> entry : hMap.entrySet()) {

					String bookID = entry.getKey();
					int qty = entry.getValue();

					for (Books b : books) {

						if (b.getBook_id().equals(bookID)) {

							BigDecimal pricePerBook = b.getBook_price();

							totalPrice = totalPrice.add(pricePerBook.multiply(new BigDecimal(qty)));

							totalPriceMap.put(b.getBook_id(), totalPrice);

						}

					}

				}
			}

		}

		if (flag == 1) {

			Map.Entry<String, BigDecimal> maxTotalPrice = null;

			for (Map.Entry<String, BigDecimal> entry : totalPriceMap.entrySet()) {

				if (maxTotalPrice == null || entry.getValue().compareTo(maxTotalPrice.getValue()) > 0) {

					maxTotalPrice = entry;
				}

			}

			finalValue = maxTotalPrice.getValue();

		}

		else {

			BigDecimal b = new BigDecimal(0);
			finalValue = b;
		}

		return finalValue;
	}

}
