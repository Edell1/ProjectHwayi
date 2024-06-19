package kr.co.beans;

public class CartBean {

    private int cart_id;
    private String code;
    private String furnitureid;
    private int count;
    private double price;

    // �⺻ ������
    public CartBean() {
    }

    // ��� �ʵ带 �ʱ�ȭ�ϴ� ������
    public CartBean(int cart_id, String code, String furnitureid, int count, double price) {
        this.cart_id = cart_id;
        this.code = code;
        this.furnitureid = furnitureid;
        this.count = count;
        this.price = price;
    }

    // Getter �� Setter �޼����
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // toString �޼��� (����� �� �α��)
    @Override
    public String toString() {
        return "CartBean{" +
                "cart_id=" + cart_id +
                ", code='" + code + '\'' +
                ", furnitureid='" + furnitureid + '\'' +
                ", count=" + count +
                ", price=" + price +
                '}';
    }
}