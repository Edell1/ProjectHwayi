package kr.co.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.co.beans.UserBean;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return UserBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
<<<<<<< HEAD
		UserBean userBean = (UserBean) target; // ����ȯ
		if (userBean.getPW().equals(userBean.getPW2()) == false) {
			errors.rejectValue("PW", "NotEquals");
			errors.rejectValue("PW2", "NotEquals");
		}
=======
		UserBean userBean = (UserBean) target; // 형변환
		// 어떤 객체가 사용하는 유호성 검사인지 반환해주는 메소드
		String beanName = errors.getObjectName();
		System.out.println(beanName); // joinUserBean
>>>>>>> refs/remotes/origin/heumE

<<<<<<< HEAD
		if (userBean.isUserIdExist() == false) {
			errors.rejectValue("ID", "DontCheckUserIdExist");
=======
		if (beanName.equals("joinUserBean") || beanName.equals("modifyUserBean")) {
			if (userBean.getPw().equals(userBean.getPw2()) == false) {
				errors.rejectValue("pw", "NotEquals");
				errors.rejectValue("pw2", "NotEquals");
			}
			// 중복성 체크
			if (beanName.equals("joinUserBean")) {
				if (userBean.isUserIdExist() == false) {
					errors.rejectValue("id", "DontCheckUserIdExist");
				}
			}
>>>>>>> refs/remotes/origin/heumE
		}
	}
}