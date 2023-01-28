package com.mrtark.business.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
public class RegisterDTO {
    private Long id;
    @NotNull(message = "{register.username.validation.constraints.NotNull.message}")
    private String username;
    @NotNull(message = "{register.surname.validation.constraints.NotNull.message}")
    private String surname;
    @NotNull(message = "{register.email.validation.constraints.NotNull.message}")
    @Email(message = "{register.email.validation.constraints.property.message}")
    @Size(max = 150,message = "{register.email.validation.constraints.max.message}")
    //@RegisterUniqueEmail
    private String email;
    @NotNull(message = "{register.telephone.validation.constraints.NotNull.message}")
    @Pattern(regexp = "",message = "{register.telephone.validation.constraints.pattern.regex.message}")
    private String telephone;
    @NotNull(message = "{register.password.validation.constraints.NotNull.message}")
    @Pattern(regexp = "",message = "{register.password.validation.constraints.pattern.regex.message}")
    private String password;
    private Date createdDate;
}
