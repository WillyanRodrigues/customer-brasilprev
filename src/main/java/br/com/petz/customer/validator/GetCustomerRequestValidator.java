package br.com.petz.customer.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

import br.com.petz.customer.annotation.CombinedNotNull;
import br.com.petz.customer.dto.GetCustomerRequestDTO;

@Component
public class GetCustomerRequestValidator implements ConstraintValidator<CombinedNotNull, GetCustomerRequestDTO> {

	String[] fields;
	
	@Override
	public void initialize(CombinedNotNull constraintAnnotation) {
		fields = constraintAnnotation.fields();
	}
	
	@Override
	public boolean isValid(GetCustomerRequestDTO value, ConstraintValidatorContext context) {
		 final BeanWrapperImpl beanWrapper = new BeanWrapperImpl(value);
		    
		    for (final String f : fields) {
		       final Object fieldValue = beanWrapper.getPropertyValue(f);
		       
		       if (fieldValue == null) {
		          return false;
		       }
		    }

		    return true;
	}

}
