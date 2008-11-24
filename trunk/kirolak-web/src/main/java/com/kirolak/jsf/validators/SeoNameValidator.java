package com.kirolak.jsf.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.kirolak.util.FacesUtil;
import com.kirolak.util.KirolakValidator;

public class SeoNameValidator implements Validator
{

	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException
	{

		if (!KirolakValidator.validateSeoName((String) value))
		{
			FacesMessage message = FacesUtil.getMessage("messages", "seo_name_error");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
	}

}
