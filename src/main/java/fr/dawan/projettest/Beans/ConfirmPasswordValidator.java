package fr.dawan.projettest.Beans;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.websocket.server.PathParam;

public class ConfirmPasswordValidator implements ConstraintValidator<ConfirmPassword, String>{
	
	@Override
    public void initialize(ConfirmPassword constraint) {
    }
 
    @Override
    public boolean isValid(String a, ConstraintValidatorContext context) {
    	
//    	System.out.println();
    	
    	//StringBuffer aaa = new StringBuffer(a).reverse();
    	//System.out.println(aaa);
    	
//    	StringBuilder aaa = 
        	
    	if(a.equals("null")) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
}
