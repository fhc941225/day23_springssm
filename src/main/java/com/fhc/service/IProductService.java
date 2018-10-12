package com.fhc.service;

import com.alibaba.fastjson.JSONObject;
import com.fhc.model.Product;

public interface IProductService {
    JSONObject findByPage(JSONObject json);
    void removeById(int pid);
    void modify(Product product);
    void save(Product product);
}