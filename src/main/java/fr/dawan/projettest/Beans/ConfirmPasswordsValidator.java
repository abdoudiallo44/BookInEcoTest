package fr.dawan.projettest.Beans;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ConfirmPasswordsValidator implements ConstraintValidator<ConfirmPassword, RegisterForm>{

	@Override
    public void initialize(ConfirmPassword constraint) {
    }
 
    @Override
    public boolean isValid(RegisterForm form, ConstraintValidatorContext context) {
        return form.getMdp().equals(form.getMdp2());
    }
}
