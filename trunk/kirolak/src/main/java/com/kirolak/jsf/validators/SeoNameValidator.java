package com.kirolak.jsf.validators;

import com.kirolak.util.KirolakValidator;
import com.sun.faces.util.MessageFactory;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class SeoNameValidator implements Validator
{

	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException
	{

		if (!KirolakValidator.validateSeoName((String) value))
		{
			FacesMessage message = MessageFactory.getMessage(context, "seo_name_error", FacesMessage.SEVERITY_ERROR, new Object[] {});
			throw new ValidatorException(message);
		}
	}

}
