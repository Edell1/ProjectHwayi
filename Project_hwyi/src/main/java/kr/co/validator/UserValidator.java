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
		UserBean userBean = (UserBean) target; 
		if (userBean.getPw().equals(userBean.getPw2()) == false) {
			errors.rejectValue("pw", "NotEquals");
			errors.rejectValue("pw2", "NotEquals");
		}

		if (userBean.isUserIdExist() == false) {
			errors.rejectValue("id", "DontCheckUserIdExist");
		}
	}

}