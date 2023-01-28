package com.mrtark.annotation;

import com.mrtark.data.entity.RegisterEntity;
import com.mrtark.data.repository.IRegisterRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
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
