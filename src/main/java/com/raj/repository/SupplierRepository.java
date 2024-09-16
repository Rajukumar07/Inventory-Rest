package com.raj.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.raj.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
