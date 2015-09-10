package com.elitecorelib.andsf.validation;

import com.elitecorelib.andsf.pojo.Policy;
import com.elitecorelib.andsf.utility.CustomConstant;

public class WiMaxLocationValidator implements IValidationHandler {

	@Override
	public void setNextValidator(IValidationHandler nextValidationHandler) {
		// TODO Auto-generated method stub

	}

	@Override
	public int validate(Policy policy) {
		// TODO Auto-generated method stub
		return CustomConstant.NOT_PROVIDED;
	}

}
