package com.ducktem.web.service;

import com.ducktem.web.dao.MemberDao;
import com.ducktem.web.dao.ProductDao;
import com.ducktem.web.entity.Member;
import com.ducktem.web.form.MemberForm;
import com.ducktem.web.entity.Product;
import com.ducktem.web.entity.ProductPreview;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDao productDao;
    @Autowired
    private MemberDao memberDao;

    /* 상품 등록 서비스 */
    @Override
    public void upload(String memberNickName, Product product) {
        Member member = memberDao.findByName(memberNickName);


        /* product 멤버 아이디 사용.*/
        product.setRegMemberId(member.getUserId());

        productDao.save(product);
    }

    /* 하나의 상품 조회 서비스 */
    @Override
    public Product get(Long productId) {




        /* 상품 시간 n분전으로 표시 준비.*/
        Product product = productDao.findById(productId);
        dateChange(product);



        return product;
    }

    public void dateChange(Product product) {
        Date regDate = product.getRegDate();
        long today = System.currentTimeMillis();

        long sec = (today-regDate.getTime()) / 1000;
        long minute = (today-regDate.getTime()) / 60000;
        long hour = (today-regDate.getTime()) /3600000;
        long days = sec / (24 * 60 * 60);

        if(sec < 60){
            String betweenSec = sec + "초 전";
            product.setNTimeAgo(betweenSec);
        }else if (minute < 60){
            String betweenMinute = minute + "분 전";
            product.setNTimeAgo(betweenMinute);
        }else if(hour < 24) {
            String betweenHour = hour + "시간 전";
            product.setNTimeAgo(betweenHour);
        }else if(days < 30) {
            String betweenDays = days + "일 전";
            product.setNTimeAgo(betweenDays);
        }
    }


    /* 전체 상품 리스트 조회 서비스 (프리뷰료 변경 예정) */
    @Override
    public List<Product> list() {
        return productDao.findAll();
    }


    /* 쿠키와 상품 아이디를 비교 후 다르다면 조휘수 증가.*/
    @Override
    public void upHit(HttpServletResponse response, String hitCookie, Long productId) {
        if(validHit(response,hitCookie,productId)) {
            productDao.updateHit(productId);
        }
    }

    @Override
    public void update(Product product) {
        productDao.update(product);
    }

    @Override
    public void stateChange(Long productId, int salesStatusId) {
        Product product = productDao.findById(productId);
        product.setSalesStatusId(salesStatusId);
        productDao.update(product);
    }


    /* 쿠키값을 비교하여 상품 아이디와 같다면 false , 다르다면 쿠키값 변경 후 true 반환. */
    private static boolean validHit(HttpServletResponse response, String hitCookie, Long productId) {
        if(!hitCookie.equals(String.valueOf(productId))) {
            hitCookie = String.valueOf(productId);
            Cookie cookie = new Cookie("newHit", hitCookie);
            response.addCookie(cookie);
            return true;
        }

        return false;
    }

	@Override
	public List<Product> getByMemberId(String memberId) {
		return productDao.findByMemberId(memberId);
	}

}
