package kr.co.beans;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

public class FurnitureBean {
   
   private int furniture_idx;      //�ε���
   
   @NotBlank
   private String furnitureid;    //���� ��ǰ�ڵ�
   private String code;           //�Ǹ����ڵ�
   private String furniture_type;  //����
   
   @NotBlank
   private String furniture_name;      //�̸�
   private Integer furniture_price;    //����
   private Integer furniture_cnt;      //����
   private Integer furniture_width;    //����
   private Integer furniture_length;   //����
   private Integer furniture_height;   //����
   private int furniture_color;    //����
   private String tag;   //�±�
   private String brand; //�귣��
   private String furniture_date;  //��ϳ�¥
   private String furniture_img1;  //��ǥ����(�̸��� �����ͺ��̽��� ����)
   private String furniture_img2;  //�������� ����(�̸��� �����ͺ��̽��� ����)
   private MultipartFile upload_file1; //�������� ���� ��ǥ ���� ������
   private MultipartFile upload_file2; //�������� ���� �������� ���� ������
   
   
   
   //---------------------------------- Getter&Setter -------------------------------------------
   public int getFurniture_idx() {
      return furniture_idx;
   }
   public void setFurniture_idx(int furniture_idx) {
      this.furniture_idx = furniture_idx;
   }
   public String getFurnitureid() {
      return furnitureid;
   }
   public void setFurnitureid(String furnitureid) {
      this.furnitureid = furnitureid;
   }
   public String getCode() {
      return code;
   }
   public void setCode(String code) {
      this.code = code;
   }
   public String getFurniture_type() {
      return furniture_type;
   }
   public void setFurniture_type(String furniture_type) {
      this.furniture_type = furniture_type;
   }
   public String getFurniture_name() {
      return furniture_name;
   }
   public void setFurniture_name(String furniture_name) {
      this.furniture_name = furniture_name;
   }
   public Integer getFurniture_price() {
      return furniture_price;
   }
   public void setFurniture_price(Integer furniture_price) {
      this.furniture_price = furniture_price;
   }
   public Integer getFurniture_cnt() {
      return furniture_cnt;
   }
   public void setFurniture_cnt(Integer furniture_cnt) {
      this.furniture_cnt = furniture_cnt;
   }
   public Integer getFurniture_width() {
      return furniture_width;
   }
   public void setFurniture_width(Integer furniture_width) {
      this.furniture_width = furniture_width;
   }
   public Integer getFurniture_length() {
      return furniture_length;
   }
   public void setFurniture_length(Integer furniture_length) {
      this.furniture_length = furniture_length;
   }
   public Integer getFurniture_height() {
      return furniture_height;
   }
   public void setFurniture_height(Integer furniture_height) {
      this.furniture_height = furniture_height;
   }
   public int getFurniture_color() {
      return furniture_color;
   }
   public void setFurniture_color(int furniture_color) {
      this.furniture_color = furniture_color;
   }
   public String getTag() {
      return tag;
   }
   public void setTag(String tag) {
      this.tag = tag;
   }
   public String getBrand() {
      return brand;
   }
   public void setBrand(String brand) {
      this.brand = brand;
   }
   public String getFurniture_date() {
      return furniture_date;
   }
   public void setFurniture_date(String furniture_date) {
      this.furniture_date = furniture_date;
   }
   public String getFurniture_img1() {
      return furniture_img1;
   }
   public void setFurniture_img1(String furniture_img1) {
      this.furniture_img1 = furniture_img1;
   }
   public String getFurniture_img2() {
      return furniture_img2;
   }
   public void setFurniture_img2(String furniture_img2) {
      this.furniture_img2 = furniture_img2;
   }
   public MultipartFile getUpload_file1() {
      return upload_file1;
   }
   public void setUpload_file1(MultipartFile upload_file1) {
      this.upload_file1 = upload_file1;
   }
   public MultipartFile getUpload_file2() {
      return upload_file2;
   }
   public void setUpload_file2(MultipartFile upload_file2) {
      this.upload_file2 = upload_file2;
   }
   


   
   
   
   
   

   
   
   

}