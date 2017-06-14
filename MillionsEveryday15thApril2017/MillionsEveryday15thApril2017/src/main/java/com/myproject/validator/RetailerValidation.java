package com.myproject.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.myproject.pojo.RegisteredUser;
import com.myproject.pojo.Retailer;

public class RetailerValidation implements Validator{
	
	public boolean supports(Class aClass) {
		return aClass.equals(Retailer.class);
	}
	
	public void validate(Object obj, Errors errors) {
		Retailer user = (Retailer) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.invalid.name", "Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "error.invalid.address", "Address Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error.invalid.userName", "User Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.invalid.email",
				"Email Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "error.invalid.phone", "Phone number Required");
		//validate phone numbers of format "1234567890"
        if (!(user.getPhone().matches("\\d{10}"))&&!(user.getPhone().matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}"))&&!(user.getPhone().matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}"))&&!(user.getPhone().matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")))
        //validating phone number with -, . or spaces
        {
        	errors.rejectValue("phone", "phone-invalid", "phone is not valid!");
        }
        else if (!(user.getName().matches("^[a-zA-Z0-9]*$")))
            //validating phone number with -, . or spaces
            {
            	errors.rejectValue("name", "name-invalid", "Name is not valid!");
            }
        
        else if (!(user.getPassword().matches("^[a-zA-Z0-9]*$")))
            //validating phone number with -, . or spaces
            {
            	errors.rejectValue("password", "lastName-invalid", "lastName is not valid!");
            }
        
        else if (!(user.getUserName().matches("^[a-zA-Z0-9]*$")))
            //validating phone number with -, . or spaces
            {
            	errors.rejectValue("username", "lastName-invalid", "lastName is not valid!");
            }
        
        
        //validating phone number with extension length from 3 to 5
        
        //validating phone number where area code is in braces ()
        
        //return false if nothing matches the input
        
		
		// check if user exists
		
	}


}
