package valerko.lgs.domain;

//import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;

public class Bucket {
	private String id;
	private User user;
	private Product product;
	private Date purchaseDate;

	public Bucket(String id, User user, Product product, Date purchaseDate) {
		this.id = id;
		this.user = user;
		this.product = product;
		this.purchaseDate = purchaseDate;
	}

	public Bucket(User user, Product product, Date date) {
		this.user = user;
		this.product = product;
		this.purchaseDate = date;
	}

	public Bucket() {
	}

	public static Bucket map(ResultSet result) throws SQLException {
//		String id = result.getString("id");
//		int userId = result.getInt("user_id");
//		int productId = result.getInt("product_id");
//		Date purchaseDate = result.getDate("purchase_date");
		return new Bucket();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Override
	public String toString() {
		return "Bucket{" + "id=" + id + ", userId=" + user + ", productId=" + product + ", purchaseDate=" + purchaseDate
				+ '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Bucket bucket = (Bucket) o;
		return Objects.equals(id, bucket.id) && Objects.equals(user, bucket.user)
				&& Objects.equals(product, bucket.product) && Objects.equals(purchaseDate, bucket.purchaseDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, user, product, purchaseDate);
	}
}
