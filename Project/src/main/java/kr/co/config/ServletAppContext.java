package kr.co.config;

import javax.annotation.Resource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.beans.UserBean;
import kr.co.interceptor.CartInterceptor;
import kr.co.interceptor.CheckLoginInterceptor;
import kr.co.interceptor.CheckWriterInterceptor;
import kr.co.interceptor.TopMenuInterceptor;
import kr.co.mapper.AddressMapper;
import kr.co.mapper.AdminMapper;
import kr.co.mapper.BoardMapper;
import kr.co.mapper.BuyerMapper;
import kr.co.mapper.CartMapper;
import kr.co.mapper.FurnitureMapper;
import kr.co.mapper.OrderMapper;
import kr.co.mapper.OrdetailMapper;
import kr.co.mapper.SellerMapper;
import kr.co.mapper.TopMenuMapper;
import kr.co.service.BoardService;
import kr.co.service.CartService;
import kr.co.service.TopMenuService;

@Configuration // Spring MVC 프로젝트 설정
@EnableWebMvc // 어노테이션 셋팅 선언
@ComponentScan(basePackages = "kr.co")
@ComponentScan("kr.co.dao")
@ComponentScan("kr.co.service")
@ComponentScan("kr.co.controller")
@PropertySource("/WEB-INF/properties/db.properties")
@PropertySource("/WEB-INF/properties/application.properties")
public class ServletAppContext implements WebMvcConfigurer {

	@Value("${db.classname}")
	private String db_classname;

	@Value("${db.url}")
	private String db_url;

	@Value("${db.username}")
	private String db_username;

	@Value("${db.password}")
	private String db_password;

	@Value("${openai.api.key}")
	private String apiKey;

	@Autowired
	private BoardService boardService;

	@Autowired
	private TopMenuService topMenuService;

	@Autowired
	private CartService cartService;

	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;

	// jsp /html /css /js /jq
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/views/", ".jsp");
	}

	// 정적 컨텐츠 파일의 경로 설정
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/**").addResourceLocations("/resources/");
	}

	// 데이터베이스 접속 정보를 관리하는 Bean
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource source = new BasicDataSource();
		source.setDriverClassName(db_classname);
		source.setUrl(db_url);
		source.setUsername(db_username);
		source.setPassword(db_password);

		return source;
	}

	// 쿼리문과 접속 정보를 관리하는 객체
	@Bean
	public SqlSessionFactory factory(BasicDataSource source) throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(source);
		SqlSessionFactory factory = factoryBean.getObject();
		return factory;
	}

	// 쿼리문 실행을 위한 객체(Mapper 관리)
	@Bean
	public MapperFactoryBean<BoardMapper> getBoardMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<BoardMapper> factoryBean = new MapperFactoryBean<BoardMapper>(BoardMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}

	@Bean
	public MapperFactoryBean<TopMenuMapper> getTopMenuMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<TopMenuMapper> factoryBean = new MapperFactoryBean<TopMenuMapper>(TopMenuMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}

	@Bean
	public MapperFactoryBean<AdminMapper> getAdminMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<AdminMapper> factoryBean = new MapperFactoryBean<AdminMapper>(AdminMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}

	@Bean
	public MapperFactoryBean<SellerMapper> getSellerMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<SellerMapper> factoryBean = new MapperFactoryBean<SellerMapper>(SellerMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}

	@Bean
	public MapperFactoryBean<BuyerMapper> getBuyerMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<BuyerMapper> factoryBean = new MapperFactoryBean<BuyerMapper>(BuyerMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}

	@Bean
	public MapperFactoryBean<FurnitureMapper> getFurnitureMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<FurnitureMapper> factoryBean = new MapperFactoryBean<FurnitureMapper>(FurnitureMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}

	@Bean
	public MapperFactoryBean<CartMapper> getCartMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<CartMapper> factoryBean = new MapperFactoryBean<CartMapper>(CartMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}

	@Bean
	public MapperFactoryBean<OrderMapper> getOrderMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<OrderMapper> factoryBean = new MapperFactoryBean<OrderMapper>(OrderMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}

	// Ordetail
	@Bean
	public MapperFactoryBean<OrdetailMapper> getOrdetailMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<OrdetailMapper> factoryBean = new MapperFactoryBean<OrdetailMapper>(OrdetailMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}

	// Address
	@Bean
	public MapperFactoryBean<AddressMapper> getAddressMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<AddressMapper> factoryBean = new MapperFactoryBean<AddressMapper>(AddressMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}


	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		WebMvcConfigurer.super.addInterceptors(registry);

		TopMenuInterceptor topMenuInterceptor = new TopMenuInterceptor(topMenuService, loginUserBean);
		InterceptorRegistration reg1 = registry.addInterceptor(topMenuInterceptor);
		reg1.addPathPatterns("/**");// 모든 요청주소에 동작

		CheckLoginInterceptor checkLoginInterceptor = new CheckLoginInterceptor(loginUserBean);
		InterceptorRegistration reg2 = registry.addInterceptor(checkLoginInterceptor);

		reg2.addPathPatterns("/user/modify", "/user/logout", "/board/*");
		reg2.excludePathPatterns("/board/main");

		CheckWriterInterceptor checkWriterInterceptor = new CheckWriterInterceptor(loginUserBean, boardService);
		InterceptorRegistration reg3 = registry.addInterceptor(checkWriterInterceptor);
		reg3.addPathPatterns("/board/modify", "/board/delete");

		CartInterceptor cartInterceptor = new CartInterceptor(loginUserBean, cartService);
		InterceptorRegistration cartReg = registry.addInterceptor(cartInterceptor);
		cartReg.addPathPatterns("/cart/*");
	}

	// Properties파일을 Bean으로 등록
	@Bean
	public static PropertySourcesPlaceholderConfigurer PropertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	// Properties Message위치 지정하여 유효성 검사 소스는 모두 이곳을 읽고 가도록
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource res = new ReloadableResourceBundleMessageSource();
		res.setBasenames("/WEB-INF/properties/error_message");
		return res;
	}

	// enctype="multipart/form-data" 사용하기 위한 클래스 객체 생성
	@Bean
	public StandardServletMultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver(); // 객체 생성하여 반환
	}

}