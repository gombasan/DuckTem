package com.ducktem.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ducktem.web.dao.MemberDao;
import com.ducktem.web.dao.ProductDao;
import com.ducktem.web.entity.Member;
import com.ducktem.web.entity.Product;
import com.ducktem.web.entity.ProductPreview;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Service
// @Transactional 트랜잭션도 고려해야 합니다!!
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	@Autowired
	private MemberDao memberDao;

	/* 쿠키값을 비교하여 상품 아이디와 같다면 false , 다르다면 쿠키값 변경 후 true 반환. */
	private static boolean validHit(HttpServletResponse response, String hitCookie, Long productId) {
		if (!hitCookie.equals(String.valueOf(productId))) {
			hitCookie = String.valueOf(productId);
			Cookie cookie = new Cookie("newHit", hitCookie);
			response.addCookie(cookie);
			return true;
		}

		return false;
	}

	/* 상품 등록 서비스 */
	@Override
	public void upload(String memberName, Product product) {
		Member member = memberDao.findByName(memberName);

		/* product 멤버 아이디 사용.*/
		product.setRegMemberId(member.getUserId());

		productDao.save(product);
	}

	/* 하나의 상품 조회 서비스 */
	@Override
	public Product get(Long productId) {
		return productDao.findById(productId);
	}

	/* 내 상품 리스트 조회 후 상품타입 리스트를 반환한다. */
	@Override
	public List<ProductPreview> myList(String memberId) {
		return productDao.findMemberProductList(memberId);
	}

	/* 전체 상품 리스트 조회 서비스 (프리뷰료 변경 예정) */
	@Override
	public List<Product> list() {
		return productDao.findAll();
	}

	/* 상품의 아이디를 조회 후 LONG 반환 */
	@Override
	public Long getProductId() {
		return productDao.findId();
	}

	/* 전체 상품을 조회 후 프리뷰타입 리스트를 반환한다. */
	@Override
	public List<ProductPreview> preview() {
		return productDao.getPreviewAll();
	}

	@Override
	public void upHit(HttpServletResponse response, String hitCookie, Long productId) {
		if (validHit(response, hitCookie, productId)) {
			productDao.plusHit(productId);
		}
	}

}
