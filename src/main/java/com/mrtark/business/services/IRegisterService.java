package com.mrtark.business.services;

import com.mrtark.business.dto.RegisterDTO;
import com.mrtark.data.entity.RegisterEntity;

import java.util.List;
import java.util.Map;

public interface IRegisterService {
    public RegisterDTO EntityToDto(RegisterEntity registerEntity);
    public RegisterEntity DtoToEntity(RegisterDTO registerDTO);

    public RegisterDTO registerCreate(RegisterDTO registerDTO);
    public List<RegisterDTO> registerList();
    public RegisterDTO registerFind(Long id);
    public RegisterDTO registerUpdate(Long id, RegisterDTO registerDTO);
    public Map<String,Boolean> registerDelete(Long id);
}
