package com.mrtark.controller.api;

import com.mrtark.business.dto.RegisterDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IRegisterAPI {
    ResponseEntity<?> createApi(RegisterDTO registerDTO);
    ResponseEntity<List<RegisterDTO>> listApi();
    ResponseEntity<RegisterDTO> findApi(Long id, RegisterDTO registerDTO);
    ResponseEntity<?> updateApi(Long id, RegisterDTO registerDTO);
    ResponseEntity<Map<String,String>> deleteApi (Long id);
}
