package kr.co.beans;


import javax.validation.constraints.NotBlank;

public class ContentBean {
   
   private int content_idx;    //�۹�ȣ
   
   @NotBlank
   private String content_title;   //������
   
   @NotBlank
   private String content_subject;   //�۳���
   
   private String code;     //�۾��� ���̵�
   
   private String name;     //�۾��� �̸�
   
   private String sys_code;   //������ ���̵�
   
   private String add_date;   //�� �� ��¥
   
   private String answer_date;  //�亯 ��¥
   
   private int q_checked;      //�亯����
   private String q_checked_text;      //�亯�����ؽ�Ʈ
   
   private String acontent;     //�亯�ؽ�Ʈ
   
   private int secret=2;

   //--------------------getter & setter ---------------------
   
   
   
   
   public int getContent_idx() {
      return content_idx;
   }

   public int getSecret() {
      return secret;
   }

   public void setSecret(int secret) {
      this.secret = secret;
   }

   public String getAcontent() {
      return acontent;
   }

   public void setAcontent(String acontent) {
      this.acontent = acontent;
   }

   public String getQ_checked_text() {
      return q_checked_text;
   }

   public void setQ_checked_text(String q_checked_text) {
      this.q_checked_text = q_checked_text;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setContent_idx(int content_idx) {
      this.content_idx = content_idx;
   }

   public String getContent_title() {
      return content_title;
   }

   public void setContent_title(String content_title) {
      this.content_title = content_title;
   }

   public String getContent_subject() {
      return content_subject;
   }

   public void setContent_subject(String content_subject) {
      this.content_subject = content_subject;
   }

   public String getCode() {
      return code;
   }

   public void setCode(String code) {
      this.code = code;
   }

   public String getSys_code() {
      return sys_code;
   }

   public void setSys_code(String sys_code) {
      this.sys_code = sys_code;
   }

   public String getAdd_date() {
      return add_date;
   }

   public void setAdd_date(String add_date) {
      this.add_date = add_date;
   }

   public String getAnswer_date() {
      return answer_date;
   }

   public void setAnswer_date(String answer_date) {
      this.answer_date = answer_date;
   }

   public int getQ_checked() {
      return q_checked;
   }

   public void setQ_checked(int q_checked) {
      this.q_checked = q_checked;
   }
   
   
   
   
   
   
   

}