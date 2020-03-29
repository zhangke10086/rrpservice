package com.rrpserivce.demo.service;

import com.rrpserivce.demo.entity.Menu;
import com.rrpserivce.demo.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

//    public Set<Menu> getAllByMenu_Id(Integer menu_id){
//        return menuRepository.getAllByMenu_id(menu_id);
//    }

    //虽然多半不会用到全部，但是先加上以防万一
    public List<Menu> findAll() {
        return menuRepository.findAll();
    }

    public Menu findById(Integer id){
        return menuRepository.findById(id).get();
    }

    public void add(Menu menu){
        menuRepository.save(menu);
    }

    public void update(Menu menu){
        menuRepository.save(menu);
    }

    public void deleteById(Integer id){
        menuRepository.deleteById(id);
    }

}
