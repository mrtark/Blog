package com.mrtark.data.repository;

import com.mrtark.data.entity.RegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRegisterRepository extends JpaRepository<RegisterEntity,Long> {
    RegisterEntity findByEmail(String email);
}
