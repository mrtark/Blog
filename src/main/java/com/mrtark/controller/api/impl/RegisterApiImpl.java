package com.mrtark.controller.api.impl;

import com.mrtark.business.dto.RegisterDTO;
import com.mrtark.business.services.IRegisterService;
import com.mrtark.controller.api.IRegisterAPI;
import com.mrtark.error.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
@RequiredArgsConstructor
@Log4j2

@RestController
@RequestMapping("register")
@CrossOrigin(origins = "http://localhost:3000")
public class RegisterApiImpl implements IRegisterAPI {
    private final IRegisterService IRegisterService;
    @Override
    public String getProfileRegister(String name) {
        return null;
    }

    @Override
    public void getHeaderInformationRegister(Map<String, String> headers) {

    }

    @Override
    public ResponseEntity<?> getAppInformationRegister(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    @Override
    @PostMapping("create")
    public ResponseEntity<?> createApiRegister(@Valid @RequestBody RegisterDTO registerDTO) {
        IRegisterService.registerCreate(registerDTO);
        return ResponseEntity.ok(registerDTO);
    }

    @Override
    @GetMapping(value = "/list")
    public ResponseEntity<List<RegisterDTO>> listApiRegister() {
        return ResponseEntity.ok(IRegisterService.registerList());
    }

    @Override
    @GetMapping({"","/{id}"})
    public ResponseEntity<?> findApiRegister(@PathVariable(name = "id",required = false) Long id) {
        if (id==null){
            log.error("404 Not Found");
            return ResponseEntity.notFound().build();
        } else if (id==0){
            log.error("400 Bad Request");
            return ResponseEntity.badRequest().body("Bad Request!");
        } else if (id<0) {
            ApiResult apiResult = ApiResult.builder()
                    .path("/register/")
                    .message("Bad Request")
                    .status(400)
                    .build();
            return ResponseEntity.status(400).body(apiResult);
        }
        log.info("Data: " + IRegisterService.registerFind(id));
        return ResponseEntity.ok(IRegisterService.registerFind(id));
    }

    @Override
    @DeleteMapping({"","/{id}"})
    public ResponseEntity<Map<String, Boolean>> deleteApiRegister(@PathVariable(name = "id",required = false) Long id) {
        if (id==null){
            log.error("404 Not Found");
            return ResponseEntity.notFound().build();
        } else if (id==0){
            log.error("400 Bad Request");
            return ResponseEntity.badRequest().build();
        }
        IRegisterService.registerDelete(id);
        Map<String,Boolean> response = new LinkedHashMap<>();
        response.put("Deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @Override
    @PutMapping({"","/{id}"})
    public ResponseEntity<RegisterDTO> updateApiRegister(@PathVariable(name = "id", required = false)
                                                         @Valid @RequestBody Long id, RegisterDTO registerDTO) {
        if (id==null){
            log.error("404 Not Found");
            return ResponseEntity.notFound().build();
        } else if (id==0){
            log.error("400 Bad Request");
            return ResponseEntity.badRequest().build();
        }
        log.info("Data: " + IRegisterService.registerUpdate(id,registerDTO));
        return ResponseEntity.ok(IRegisterService.registerUpdate(id,registerDTO));
    }


}

