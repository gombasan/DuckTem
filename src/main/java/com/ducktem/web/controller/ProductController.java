package com.ducktem.web.controller;

import com.ducktem.web.entity.Member;
import com.ducktem.web.entity.Product;
import com.ducktem.web.entity.ProductImg;
import com.ducktem.web.entity.ProductPreview;
import com.ducktem.web.service.CategoryService;
import com.ducktem.web.service.ImgService;
import com.ducktem.web.service.MemberService;
import com.ducktem.web.service.ProductService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
        imgService.upload(file,product.getId());

        return "redirect:/";
    }




    // ===================================================================상품 조회 ==========================================================

    /* 마이 상품 페이지 요청 */
    @GetMapping("/mylist")
    public String myProductList(Model model, HttpSession session) {

//        List<Product> list = productService.myList((String) session.getAttribute("id"));

//        model.addAttribute("list",list);


        return "mylist";
    }

    /* 상품 리스트 보기 (변경 예정.)*/
    @GetMapping("/list")
    public String productList(Model model) {
        model.addAttribute("list", productService.list());

        return "ProdcutList";
    }

    /* 상품 리스트 보기 (상품 미리보기 형태로 변경)*/

    @GetMapping("/product/{id}")
    public String productDetail(Model model, HttpServletResponse response, @CookieValue(name = "newHit") String newCookie, @PathVariable("id") Long productId) {

        /* 새로 고침 조회수 막기 위해 추가. */
        if(validHit(response,newCookie,productId)) {
            productService.upHit(productId);
        }

        Product product = productService.get(productId);
        List<ProductImg> productImgs = imgService.getList(productId);
        String regMemberId = product.getRegMemberId();
        Member member = memberService.getMember(regMemberId);
        List<ProductPreview> memberProducts = productService.myList(member.getUserId());

        model.addAttribute("productImgs", productImgs);
        model.addAttribute("product", product);
        model.addAttribute("member", member);
        model.addAttribute("memberProducts", memberProducts);


        return "detail";
    }


    /* 쿠키값을 비교하여 상품 아이디와 같다면 false , 다르다면 쿠키값 변경 후 true 반환. */
    private boolean validHit(HttpServletResponse response,String newCookie, Long productId) {
        if(!newCookie.equals(String.valueOf(productId))) {
            newCookie = String.valueOf(productId);
            Cookie cookie = new Cookie("newHit", newCookie);
            response.addCookie(cookie);
            return true;
        }

        return false;
    }


}
