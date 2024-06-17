package kr.co.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringConfigClass extends AbstractAnnotationConfigDispatcherServletInitializer{
   // DispatcherServlet�� ������ ��û �ּҸ� �����Ѵ�.
   @Override
   protected String[] getServletMappings() {
      // TODO Auto-generated method stub
      return new String[] {"/"};
   }
   
   // Spring MVC ������Ʈ ������ ���� Ŭ������ �����Ѵ�.
   @Override
   protected Class<?>[] getServletConfigClasses() {
      // TODO Auto-generated method stub
      return new Class[] {ServletAppContext.class};
   }
   
   // ������Ʈ���� ����� Bean���� ���Ǳ� ���� Ŭ������ �����Ѵ�.
   @Override
   protected Class<?>[] getRootConfigClasses() {
      // TODO Auto-generated method stub
      return new Class[] {RootAppContext.class};
   }
   
   // �Ķ���� ���ڵ� ���� ����
   @Override
   protected Filter[] getServletFilters() {
      // TODO Auto-generated method stub
      CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
      encodingFilter.setEncoding("UTF-8");
      return new Filter[] {encodingFilter};
   }
   //Multipart ��������
   //null: ����ڰ� �Է��� ������ �ӽñ���� ����ġ���Ͽ��� �����ϴ� ������ �ӽñ�����
   //52428800 :  ���ε� �������� �뷮 (1024*50) 50M�� ����
   //524288000 : ���ϵ����͸� ������ ��ü�뷮 500M ����
   //0 : ������ �Ӱ谪
   
   @Override
   protected void customizeRegistration(Dynamic registration) {
      // TODO Auto-generated method stub
      super.customizeRegistration(registration);
      
      MultipartConfigElement config1 = new MultipartConfigElement(null, 52428800, 524288000, 0);
      registration.setMultipartConfig(config1);
   }
}











