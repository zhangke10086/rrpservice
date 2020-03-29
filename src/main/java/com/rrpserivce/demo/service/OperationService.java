package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.Operation;
import com.rrpserivce.demo.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationService {
    @Autowired
    private OperationRepository operationRepository;
    public List<Operation> findAll() {
        return operationRepository.findAll();
    }
}
