package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.Command;
import com.rrpserivce.demo.repository.CommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandService {
    @Autowired
    private CommandRepository commandRepository;

    //查询全部
    public List<Command> findAll() {
        return commandRepository.findAll();
    }

    //根据id查找
    public Command findById(int id) {
        return commandRepository.findById(id).get();
    }

    //增加
    public void add(Command command) {
        commandRepository.save(command);
    }

    //修改
    public void update(Command command) {
        commandRepository.save(command);
    }

    //根据id删除
    public void deleteById(int id) {
        commandRepository.deleteById(id);
    }

}
