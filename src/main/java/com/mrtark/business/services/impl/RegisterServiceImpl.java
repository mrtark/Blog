package com.mrtark.business.services.impl;

import com.mrtark.business.dto.RegisterDTO;
import com.mrtark.business.services.IRegisterService;
import com.mrtark.data.entity.RegisterEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Log4j2
@Service
public class RegisterServiceImpl implements IRegisterService {
    @Override
    public RegisterDTO EntityToDto(RegisterEntity registerEntity) {
        return null;
    }

    @Override
    public RegisterEntity DtoToEntity(RegisterDTO registerDTO) {
        return null;
    }

    @Override
    public RegisterDTO registerCreate(RegisterDTO registerDTO) {
        return null;
    }

    @Override
    public List<RegisterDTO> registerList() {
        return null;
    }

    @Override
    public RegisterDTO registerFind(Long id) {
        return null;
    }

    @Override
    public RegisterDTO registerUpdate(Long id, RegisterDTO registerDTO) {
        return null;
    }

    @Override
    public Map<String, Boolean> registerDelete(Long id) {
        return null;
    }
}
