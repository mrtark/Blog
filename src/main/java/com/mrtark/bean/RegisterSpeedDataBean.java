package com.mrtark.bean;

import com.mrtark.business.dto.RegisterDTO;
import com.mrtark.data.entity.RegisterEntity;
import com.mrtark.data.repository.IRegisterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;
import java.util.UUID;

@RequiredArgsConstructor
@Configuration
public class RegisterSpeedDataBean {
    private final ModelMapperBean modelMapperBean;
    private final IRegisterRepository iRegisterRepository;
    @Value("${data.surname}")
    private String  MessagesProperties;
    private final PasswordEncoderBean passwordEncoderBean;
    private final ServletContext servletContext;
    @Bean
    CommandLineRunner createXRegister(){
        String applicationProperties = servletContext.getInitParameter("my_special.name");
        return (args)->{
            for (int i = 0; i <=3; i++) {
                RegisterDTO registerDTO = RegisterDTO
                        .builder()
                        .username(applicationProperties)
                        .surname(MessagesProperties)
                        .email(UUID.randomUUID().toString().concat("@mrtark.com"))
                        .password(passwordEncoderBean.passwordEncoderMethod().encode("123mrtark"))
                        .telephone("123 456 7890")
                        .build();
                RegisterEntity registerEntity =  modelMapperBean.modelMapperMethod().map(registerDTO,RegisterEntity.class);
                iRegisterRepository.save(registerEntity);
            }
        };
    }
}
