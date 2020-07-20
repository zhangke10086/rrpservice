package com.rrpserivce.demo.repository;

import com.rrpserivce.demo.entity.MenuCorrespondingOperation;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuCorrespondingOperationRepository
        extends JpaRepository<MenuCorrespondingOperation, Integer> {
    List<MenuCorrespondingOperation> findAll(Specification<MenuCorrespondingOperation> spec);
}
