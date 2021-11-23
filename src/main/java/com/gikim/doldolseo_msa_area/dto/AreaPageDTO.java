package com.gikim.doldolseo_msa_area.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class AreaPageDTO {
        private List<AreaDTO> areaList;
        private Integer startBlockPage;
        private Integer endBlockPage;
        private Integer totalPages;
}
