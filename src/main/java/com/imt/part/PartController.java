package com.imt.part;


import com.imt.part.dto.PartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service/part")
public class PartController {

    @Autowired
    private PartRepository partRepository;


    @GetMapping
    public List<PartDto> findAll() {
        return PartMapper.entityToDto(partRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<PartDto> save(@RequestBody PartDto partDto) {
        PartEntity partEntity = PartMapper.dtoToEntity(partDto);
        partEntity = partRepository.save(partEntity);
        return ResponseEntity.ok(PartMapper.entityToDto(partEntity));
    }

    @PutMapping
    public ResponseEntity<PartDto> update(@RequestBody PartDto partDto) {
        PartEntity partEntity = PartMapper.dtoToEntity(partDto);
        partEntity = partRepository.save(partEntity);
        return ResponseEntity.ok(PartMapper.entityToDto(partEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        partRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search/{supplierCodeRegex}")
    public List<PartDto> findBySupplierCode(@PathVariable String supplierCodeRegex) {
        supplierCodeRegex = "%" + supplierCodeRegex + "%";
        return PartMapper.entityToDto(partRepository.findBySupplierCodeLike(supplierCodeRegex));
    }
}
