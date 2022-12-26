package com.ducktem.web.api;

import com.ducktem.web.entity.Product;
import com.ducktem.web.entity.ProductPreview;
import com.ducktem.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductPageApi {

    @Autowired
    ProductService productService;


    @GetMapping("/{page}")
    public List<ProductPreview> homeProductList(@PathVariable(name = "page") int page) {
        List<ProductPreview> preview = productService.preview(page);

        return preview;
    }

    @PostMapping("/product/myproduct/sellStatesChange/{productId}/{selectState}")
    public void productSellStatesChange(@PathVariable("productId") Long productId ,@PathVariable("selectState") int salesStatusId) {
        productService.stateChange(productId,salesStatusId);

    }

}
