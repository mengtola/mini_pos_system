package com.pos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.pos.dao.BrandDao;
import com.pos.domain.Brands;

public class IdToBrandConverter implements Converter<String, Brands>{
    @Autowired BrandDao brandDao;
    public Brands convert(String id) {
        return this.brandDao.findBrandById(Integer.valueOf(id));
    }
}
