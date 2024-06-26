package kr.co.beans;

public class CartBean {

    private int cart_id;
    private String code;
    private String interiorid;
    private String furnitureid;
    private int count;
    private double price;

    // 기본 생성자
    public CartBean() {
    }

    // 모든 필드를 초기화하는 생성자
    public CartBean(int cart_id, String code, String interiorid, String furnitureid, int count, double price) {
        this.cart_id = cart_id;
        this.code = code;
        this.interiorid = interiorid;
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

    public String getInteriorid() {
        return interiorid;
    }

    public void setInteriorid(String interiorid) {
        this.interiorid = interiorid;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // toString 메서드 (디버깅 및 로깅용)
    @Override
    public String toString() {
        return "CartBean{" +
                "cart_id=" + cart_id +
                ", code='" + code + '\'' +
                ", interiorid='" + interiorid + '\'' +
                ", furnitureid='" + furnitureid + '\'' +
                ", count=" + count +
                ", price=" + price +
                '}';
    }
}