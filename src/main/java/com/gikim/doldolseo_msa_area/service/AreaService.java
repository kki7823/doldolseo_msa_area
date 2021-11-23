package com.gikim.doldolseo_msa_area.service;

import com.gikim.doldolseo_msa_area.dto.AreaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AreaService {
    public AreaDTO getArea(String name);

    public Page<AreaDTO> getAreaList(AreaDTO dto, Pageable pageable);

    public Page<AreaDTO> getAreaListBySearch(AreaDTO dto, Pageable pageable);
}
