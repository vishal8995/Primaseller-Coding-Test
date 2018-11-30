package model;

import java.util.Date;
import java.util.HashMap;

public class Sales {

	private Date sale_date;

	private String sale_email;

	private String sale_payment_method;

	private int sale_item_count;

	HashMap<String, Integer> onwards = new HashMap<>();

	public Date getSale_date() {
		return sale_date;
	}

	public void setSale_date(Date sale_date) {
		this.sale_date = sale_date;
	}

	public String getSale_email() {
		return sale_email;
	}

	public void setSale_email(String sale_email) {
		this.sale_email = sale_email;
	}

	public String getSale_payment_method() {
		return sale_payment_method;
	}

	public void setSale_payment_method(String sale_payment_method) {
		this.sale_payment_method = sale_payment_method;
	}

	public int getSale_item_count() {
		return sale_item_count;
	}

	public void setSale_item_count(int sale_item_count) {
		this.sale_item_count = sale_item_count;
	}

	public HashMap<String, Integer> getOnwards() {
		return onwards;
	}

	public void setOnwards(HashMap<String, Integer> onwards) {
		this.onwards = onwards;
	}

	@Override
	public String toString() {
		return "Sales [sale_date=" + sale_date + ", sale_email=" + sale_email + ", sale_payment_method="
				+ sale_payment_method + ", sale_item_count=" + sale_item_count + ", onwards=" + onwards + "]";
	}

}
