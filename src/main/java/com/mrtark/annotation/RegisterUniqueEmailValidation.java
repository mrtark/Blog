package com.mrtark.annotation;

import com.mrtark.data.entity.RegisterEntity;
import com.mrtark.data.repository.IRegisterRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class RegisterUniqueEmailValidation implements ConstraintValidator<RegisterUniqueEmail,String> {
    private final IRegisterRepository iRegisterRepository;
    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        RegisterEntity registerEntity = iRegisterRepository.findByEmail(email);
        if(registerEntity!=null){
            return false;
        }
        return true;
    }
}
