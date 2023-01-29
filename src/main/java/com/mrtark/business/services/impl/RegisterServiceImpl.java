package com.mrtark.business.services.impl;

import com.mrtark.bean.ModelMapperBean;
import com.mrtark.bean.PasswordEncoderBean;
import com.mrtark.business.dto.RegisterDTO;
import com.mrtark.business.services.IRegisterService;
import com.mrtark.data.entity.RegisterEntity;
import com.mrtark.data.repository.IRegisterRepository;
import com.mrtark.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Log4j2
@Service
public class RegisterServiceImpl implements IRegisterService {
    private final IRegisterRepository IRegisterRepository;
    private final ModelMapperBean modelMapperBean;
    private final PasswordEncoderBean passwordEncoderBean;
    @Override
    public RegisterDTO EntityToDto(RegisterEntity registerEntity) {
        modelMapperBean.modelMapperMethod().map(registerEntity,RegisterDTO.class);
        return null;
    }

    @Override
    public RegisterEntity DtoToEntity(RegisterDTO registerDTO) {
        modelMapperBean.modelMapperMethod().map(registerDTO,RegisterEntity.class);
        return null;
    }

    @Override
    public RegisterDTO registerCreate(RegisterDTO registerDTO) {
        registerDTO.setPassword(passwordEncoderBean.passwordEncoderMethod().encode(registerDTO.getPassword()));
        RegisterEntity registerEntity = IRegisterRepository.save(DtoToEntity(registerDTO));
        registerDTO.setId(registerEntity.getId());
        return registerDTO;
    }

    @Override
    public List<RegisterDTO> registerList() {
        List<RegisterDTO> registerDTOList = new ArrayList<>();
        List<RegisterEntity> registerEntityList = IRegisterRepository.findAll();
        for (RegisterEntity go : registerEntityList) {
            RegisterDTO dto = EntityToDto(go);
            registerDTOList.add(dto);
        }
        return registerDTOList;
    }

    @Override
    public RegisterDTO registerFind(Long id) {
        RegisterEntity findById = IRegisterRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException(id + ": Id Not Found!"));
        RegisterDTO dto = EntityToDto(findById);
        return dto;
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
