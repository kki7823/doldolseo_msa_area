package com.gikim.doldolseo_msa_area.service;

import com.gikim.doldolseo_msa_area.domain.Area;
import com.gikim.doldolseo_msa_area.dto.AreaDTO;
import com.gikim.doldolseo_msa_area.repository.AreaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AreaDTO getArea(String name) {
        Area entity = repository.findFirstByName(name);
        AreaDTO area = modelMapper.map(entity, AreaDTO.class);
        return area;
    }

    @Override
    public Page<AreaDTO> getAreaList(AreaDTO dto, Pageable pageable) {
        Page<Area> entityPage;
        if (dto.getContentType() == null) {
            entityPage = repository.findBySigungu(dto.getSigungu(), pageable);
        } else {
            entityPage = repository.findBySigunguAndContentType(dto.getSigungu(), dto.getContentType(), pageable);
        }

        //Page<Area> to Page<AreaDTO>
        Page<AreaDTO> areaList = modelMapper.map(entityPage, new TypeToken<Page<AreaDTO>>() {
        }.getType());
        return areaList;
    }

    @Override
    public Page<AreaDTO> getAreaListBySearch(AreaDTO dto, Pageable pageable) {
        Page<Area> entityPage = repository.findBySigunguAndNameContaining(dto.getSigungu(), dto.getSearchKeyword(), pageable);

        Page<AreaDTO> areaList = modelMapper.map(entityPage, new TypeToken<Page<AreaDTO>>() {
        }.getType());
        return areaList;
    }
}
