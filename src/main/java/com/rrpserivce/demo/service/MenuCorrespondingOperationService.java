package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.MenuCorrespondingOperation;
import com.rrpserivce.demo.repository.MenuCorrespondingOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuCorrespondingOperationService {
    @Autowired
    private MenuCorrespondingOperationRepository menuCorrespondingOperationRepository;

    public List<MenuCorrespondingOperation> findAll() {
        return menuCorrespondingOperationRepository.findAll();
    }
}
