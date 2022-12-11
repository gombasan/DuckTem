package com.ducktem.web.dao;

import com.ducktem.web.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class ProductDaoImpl implements ProductDao{
    private static Map<String, Product> store = new HashMap<>();




    @Override
    public void upload(String memberName,Product product) {

        store.put(memberName, product);
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
}
