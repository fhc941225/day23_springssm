package com.fhc.service;

import com.alibaba.fastjson.JSONObject;
import com.fhc.model.Product;
import com.fhc.dao.mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService implements IProductService{
    @Autowired
    private mapper mapper;


    @Override
    @Transactional
    public void removeById(int pid) {
        mapper.deleteById(pid);

    }

    @Override
    @Transactional
    public void modify(Product product) {
        mapper.update(product);

    }

    @Override
    @Transactional
    public void save(Product product) {
        mapper.insert(product);

    }

    @Override
    public JSONObject findByPage(JSONObject json) {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("total", mapper.selectByCount(json));
        jsonObject.put("rows", mapper.selectByPage(json));
        return jsonObject;
    }
}