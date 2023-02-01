package com.mrtark.controller.api;

import com.mrtark.business.dto.RegisterDTO;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface IRegisterAPI {
    String getProfileRegister(String name);
    void getHeaderInformationRegister(Map<String,String> headers);
    ResponseEntity<?> getAppInformationRegister(HttpServletRequest request, HttpServletResponse response);
    ResponseEntity<?> createApiRegister(RegisterDTO registerDTO);
    ResponseEntity<List<RegisterDTO>> listApiRegister();
    ResponseEntity<RegisterDTO> findApiRegister(Long id, RegisterDTO registerDTO);
    ResponseEntity<?> updateApiRegister(Long id, RegisterDTO registerDTO);
    ResponseEntity<Map<String,String>> deleteApiRegister (Long id);
}
