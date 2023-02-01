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
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@RequiredArgsConstructor
@Log4j2
@Service
public class RegisterServiceImpl implements IRegisterService {
    private final IRegisterRepository iRegisterRepository;
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
    @Transactional
    public RegisterDTO registerCreate(RegisterDTO registerDTO) {
        registerDTO.setPassword(passwordEncoderBean.passwordEncoderMethod().encode(registerDTO.getPassword()));
        RegisterEntity registerEntity = iRegisterRepository.save(DtoToEntity(registerDTO));
        registerDTO.setId(registerEntity.getId());
        return registerDTO;
    }

    @Override
    public List<RegisterDTO> registerList() {
        List<RegisterDTO> registerDTOList = new ArrayList<>();
        List<RegisterEntity> registerEntityList = iRegisterRepository.findAll();
        for (RegisterEntity go : registerEntityList) {
            RegisterDTO dto = EntityToDto(go);
            registerDTOList.add(dto);
        }
        return registerDTOList;
    }

    @Override
    public RegisterDTO registerFind(Long id) {
        RegisterEntity findById = iRegisterRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(id + ": ID Not Found!"));
        RegisterDTO dto = EntityToDto(findById);
        return dto;
    }

    @Override
    @Transactional
    public RegisterDTO registerUpdate(Long id, RegisterDTO registerDTO) {
        RegisterDTO dto = registerFind(id);
        if (dto!=null){
            dto.setUsername(registerDTO.getUsername());
            dto.setSurname(registerDTO.getSurname());
            dto.setEmail(registerDTO.getEmail());
            dto.setTelephone(registerDTO.getTelephone());
            dto.setPassword(passwordEncoderBean.passwordEncoderMethod().encode(registerDTO.getPassword()));
            RegisterEntity entity = iRegisterRepository.save(DtoToEntity(dto));
            iRegisterRepository.save(entity);
            dto.setId(entity.getId());
            return dto;
        }
        return null;
    }

    @Override
    @Transactional
    public Map<String, Boolean> registerDelete(Long id) {
        RegisterDTO dto = registerFind(id);
        Map<String,Boolean> registerDelete = new LinkedHashMap<>();
        if (dto!=null){
            iRegisterRepository.delete(DtoToEntity(dto));
            registerDelete.put(dto + ": Data Deleted.",Boolean.TRUE);
        }
        return registerDelete;
    }
}
