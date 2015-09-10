package com.elitecorelib.andsf.validation;

import com.elitecorelib.andsf.exception.InvalidDataException;
import com.elitecorelib.andsf.pojo.Policy;

public interface IValidationHandler {
	
	public void setNextValidator(IValidationHandler nextValidationHandler);
	
	public int validate(Policy policy) throws InvalidDataException;
	
}
