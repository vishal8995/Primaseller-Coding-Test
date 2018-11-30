package model;

import java.math.BigDecimal;

public class Books {

	private String book_id;

	private String book_title;

	private String book_author;

	private BigDecimal book_price;

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public String getBook_title() {
		return book_title;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}

	public String getBook_author() {
		return book_author;
	}

	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}

	public BigDecimal getBook_price() {
		return book_price;
	}

	public void setBook_price(BigDecimal book_price) {
		this.book_price = book_price;
	}

	@Override
	public String toString() {
		return "Books [book_id=" + book_id + ", book_title=" + book_title + ", book_author=" + book_author
				+ ", book_price=" + book_price + "]";
	}

}
