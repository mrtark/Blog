package com.mrtark.data.entity;


import lombok.*;
import lombok.extern.log4j.Log4j2;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "register_1")
public class RegisterEntity extends BaseEntity implements Serializable {
    public static final Long serialVersionUID=1L;
    @Column(name = "username",columnDefinition = "varchar(255) default 'username not input!!'")
    private String username;
    private String surname;
    @Column(name = "email")
    private String email;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "password")
    private String password;

}
