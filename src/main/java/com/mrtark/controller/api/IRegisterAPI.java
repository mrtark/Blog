package com.mrtark.controller.api;

import com.mrtark.business.dto.RegisterDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

public interface IRegisterAPI {

    String getProfileRegister(String name);
    void getHeaderInformationRegister(Map<String, String> headers);
    ResponseEntity<?> getAppInformationRegister(HttpServletRequest request, HttpServletResponse response);
    ResponseEntity<?> createApiRegister(RegisterDTO registerDTO);
    ResponseEntity<List<RegisterDTO>> listApiRegister();
    ResponseEntity<?> findApiRegister(Long id);
    ResponseEntity<Map<String, Boolean>> deleteApiRegister(Long id);
    ResponseEntity<RegisterDTO> updateApiRegister(Long id, RegisterDTO registerDTO);
}
