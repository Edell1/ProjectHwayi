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
		UserBean userBean = (UserBean) target; // Çüº¯È¯
		if (userBean.getPW().equals(userBean.getPW2()) == false) {
			errors.rejectValue("PW", "NotEquals");
			errors.rejectValue("PW2", "NotEquals");
		}

		if (userBean.isUserIdExist() == false) {
			errors.rejectValue("ID", "DontCheckUserIdExist");
		}
	}

}
