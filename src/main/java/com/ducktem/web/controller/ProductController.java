package com.ducktem.web.controller;

import com.ducktem.web.entity.Product;
import com.ducktem.web.entity.ProductPreview;
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

// ===================================================================상품 등록 ==========================================================

    /* 상품 등록 폼파일 요청 */
    @GetMapping("/product")
    public String regProductForm() {

        return "/member/sell/index";
    }

    /* 상품 등록 요청 */
    @PostMapping("/product")
    public String regProduct(Product product , MultipartFile file, HttpSession session) {
        productService.upload((String) session.getAttribute("id"),product);
        Long productId = productService.getProductId();
        imgService.upload(file,productId);

        return "redirect:/";
    }




    // ===================================================================상품 조회 ==========================================================

    /* 마이 상품 페이지 요청 */
    @GetMapping("/mylist")
    public String myProductList(Model model, HttpSession session) {

        List<Product> list = productService.myList((String) session.getAttribute("id"));

        model.addAttribute("list",list);


        return "mylist";
    }

    /* 상품 리스트 보기 (변경 예정.)*/
    @GetMapping("/list")
    public String productList(Model model) {
        model.addAttribute("list", productService.list());

        return "ProdcutList";
    }

    /* 상품 리스트 보기 (상품 미리보기 형태로 변경)*/
    @GetMapping("test")
    public String Test() {
    	List<ProductPreview> list = productService.preview();
    	
    	System.out.println(list.size());
    	return "test";
    }

}
