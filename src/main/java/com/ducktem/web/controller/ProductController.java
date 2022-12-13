package com.ducktem.web.controller;

import com.ducktem.web.entity.Product;
import com.ducktem.web.service.ImgService;
import com.ducktem.web.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ImgService imgService;


    @GetMapping("/product")
    public String regProductForm() {

        return "/product";
    }
    @PostMapping("/product")
    public String regProduct(Product product , MultipartFile file, HttpSession session) throws Exception{
        productService.upload((String) session.getAttribute("id"), file ,product);
        Long productId = productService.getProductId();
        imgService.upload(file,productId);


        return "redirect:/";
    }

    @GetMapping("/mylist")
    public String myProductList(Model model, HttpSession session) {

        List<Product> list = productService.myList((String) session.getAttribute("id"));

        model.addAttribute("list",list);


        return "mylist";
    }

    @GetMapping("/list")
    public String productList(Model model) {
        model.addAttribute("list", productService.list());

        return "list";
    }

}
