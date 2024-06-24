package kr.co.beans;

public class CartBean {

	private int cart_id;
	private String code;
	private String furnitureid;
	private int count;
	private int price;

	private String furnitureName;

	// 기본 생성자
	public CartBean() {
	}

	// 모든 필드를 초기화하는 생성자
	public CartBean(int cart_id, String code, String furnitureid, int count, int price) {
		this.cart_id = cart_id;
		this.code = code;
		this.furnitureid = furnitureid;
		this.count = count;
		this.price = price;
	}

	// Getter 및 Setter 메서드들
	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFurnitureid() {
		return furnitureid;
	}

	public void setFurnitureid(String furnitureid) {
		this.furnitureid = furnitureid;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getFurnitureName() {
		return furnitureName;
	}

	public void setFurnitureName(String furnitureName) {
		this.furnitureName = furnitureName;
	}

	// toString 메서드 (디버깅 및 로깅용)
	@Override
	public String toString() {
		return "CartBean{" + "cart_id=" + cart_id + ", code='" + code + '\'' + ", furnitureid='" + furnitureid + '\''
				+ ", count=" + count + ", price=" + price + '}';
	}
}