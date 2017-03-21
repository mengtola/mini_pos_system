package com.pos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.pos.dao.CategoryDao;
import com.pos.domain.Categories;

public class IdToCustomerConverter implements Converter<String, Categories>{
    @Autowired CategoryDao categoryDao;
    public Categories convert(String id) {
        return this.categoryDao.findCategoryById(Integer.valueOf(id));
    }
}
