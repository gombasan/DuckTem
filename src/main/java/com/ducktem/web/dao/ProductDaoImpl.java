package com.ducktem.web.dao;

import com.ducktem.web.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ProductDaoImpl implements ProductDao{
    private static Map<String, Product> store = new HashMap<>();




    @Override
    public void save(Product product) {

        // store.put(memberId, product);
    }

    @Override
    public List<Product> findAll() {

        return new ArrayList<>(store.values());
    }

    @Override
    public List<Product> findMemberProductList(String memberName) {
        List<Product> list = new ArrayList<>();

        for (String memberNames  : store.keySet()) {
            if (memberNames == memberName) {
                list.add(store.get(memberName));
            }
        }

        return list;
    }

    @Override
    public Product find() {
        return null;
    }

    @Override
    public Long findId() {
        return null;
    }
}
