package com.fhc.dao;

import com.alibaba.fastjson.JSONObject;
import com.fhc.model.Product;

import java.util.List;

public interface mapper {
    List<Product> selectByPage(JSONObject json);

    long selectByCount(JSONObject json);

    void deleteById(int pid);

    void update(Product product);

    void insert(Product product);
}