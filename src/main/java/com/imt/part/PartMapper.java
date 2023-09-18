package com.imt.part;

import com.imt.part.dto.PartDto;

public class PartMapper {

    public static PartEntity dtoToEntity(PartDto dto) {
        PartEntity entity = new PartEntity();
        entity.setId(dto.id());
        entity.setName(dto.name());
        entity.setSupplierCode(dto.supplierCode());
        entity.setDescription(dto.description());
        return entity;
    }

    public static PartDto entityToDto(PartEntity entity) {
        return new PartDto(entity.getId(), entity.getName(), entity.getSupplierCode(), entity.getDescription());
    }
}
