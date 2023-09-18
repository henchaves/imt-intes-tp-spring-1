package com.imt.part;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartRepository extends CrudRepository<PartEntity, Long> {

    List<PartEntity> findAll();

    List<PartEntity> findBySupplierCodeLike(String regex);
}
