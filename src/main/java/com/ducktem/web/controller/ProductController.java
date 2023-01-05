package com.ducktem.web.controller;

import com.ducktem.web.entity.*;
import com.ducktem.web.service.*;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ImgService imgService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductPreviewService productPreviewService;

// ===================================================================상품 등록 ==========================================================

    /* 상품 등록 폼파일 요청 */
    @GetMapping("/product")
    public String regProductForm() {

        return "/member/sell/index";
    }

    /* 상품 등록 요청 */
    @PostMapping("/product")
    public String regProduct(Product product ,MultipartFile[] files, @AuthenticationPrincipal DucktemUserDetails user , HttpServletRequest request) {

    	productService.upload(user.getNickName(),product);

    	imgService.upload(files,product.getId(),request);

    	return "redirect:/";
    }




    // ===================================================================상품 조회 ==========================================================

    /* 내 상품 수정 페이지 요청 */
    @GetMapping("/product/myproduct/{memberNickName}/{id}")
    public String myProduct(Model model,@PathVariable("memberNickName") String memberNickName,@PathVariable(value = "id", required = false) Long productId, @AuthenticationPrincipal DucktemUserDetails user) {
        if(memberNickName.equals(user.getNickName())) {
            model.addAttribute("img", imgService.getList(productId));
            model.addAttribute("product", productService.get(productId));
            

            return "member/update-product/index";
        }
        return "redirect:/product/{id}";
    }

    /* 내 상품 정보 수정*/
    @PostMapping("/product/myproduct/{memberNickName}/{id}")
    public String myProductUpdate(Product product) {

        productService.update(product);
        return "redirect:/product/{id}";
    }

    @PostMapping("/product/{id}")
    public String productStateUpdate() {
        return "";
    }



    /* 상품 리스트 보기 (변경 예정.)*/
    @GetMapping("/list")

    public String productList(Model model, @RequestParam(defaultValue="1", name="super") Integer superCategoryId, @RequestParam(defaultValue="-1", name="cate") Integer categoryId) {


    	List<SuperCategory> supercategory = categoryService.getList();
    	List<Category> category = categoryService.getSubList(superCategoryId);
    	List<ProductPreview> preview = productPreviewService.previewByCategory(superCategoryId, categoryId);


    	model.addAttribute("superCategoryList", supercategory);
    	model.addAttribute("categoryList", category);
    	model.addAttribute("preview", preview);


        return "list";
    }










    /* 상품 상세 화면 보기*/
    @GetMapping("/product/{id}")
    public String productDetail(Model model,
                                HttpServletResponse response,
                                @CookieValue(name = "newHit", required=false, defaultValue = "default") String hitCookie,
                                @PathVariable("id") Long productId, @AuthenticationPrincipal DucktemUserDetails ducktemUserDetails) {

        /* 새로 고침 조회수 막기 위해 추가. */
        productService.upHit(response,hitCookie,productId);

        Product product = productService.get(productId);
        List<ProductImg> productImgs = imgService.getList(productId);
        String regMemberId = product.getRegMemberId();
        Member member = memberService.getMember(regMemberId);
        List<ProductPreview> memberProducts = productPreviewService.myList(member.getUserId());
        Category category = categoryService.getCategoryName(productId);

        model.addAttribute("productImgs", productImgs);
        model.addAttribute("product", product);
        model.addAttribute("member", member);
        model.addAttribute("memberProducts", memberProducts);
        model.addAttribute("category",category);
        model.addAttribute("user", ducktemUserDetails);

        
        return "detail";
    }



}
