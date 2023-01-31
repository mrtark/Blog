package com.mrtark.error;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@CrossOrigin
public class CustomErrorHandleResult implements ErrorController {
    private ErrorAttributes errorAttributes;
    @RequestMapping("/error")
    ApiResult catchErrors(WebRequest rfwebRequest){
        Map<String, Object> errAttributes = errorAttributes.getErrorAttributes(rfwebRequest, ErrorAttributeOptions.of(
                ErrorAttributeOptions.Include.MESSAGE,ErrorAttributeOptions.Include.BINDING_ERRORS)
                                                                                );
        int status = (Integer)errAttributes.get("status");
        String message = (String)errAttributes.get("message");
        String path = (String)errAttributes.get("path");
        ApiResult error = new ApiResult(status,message,path);
        if(errAttributes.containsKey("error")){
            List<FieldError> fieldErrorList =(List<FieldError>)errAttributes.get("errors");
            Map<String,String> validationMistakes = new HashMap<>();
            for (FieldError reffieldError: fieldErrorList) {
                validationMistakes.put(reffieldError.getField(),reffieldError.getDefaultMessage());
            }
            error.setValidationErrorss(validationMistakes);
        }
        return error;
    }
}
