package com.ducktem.web.service;

import com.ducktem.web.dao.MemberDao;
import com.ducktem.web.dao.ProductDao;
import com.ducktem.web.entity.Member;
import com.ducktem.web.form.MemberForm;
import com.ducktem.web.entity.Product;
import com.ducktem.web.entity.ProductPreview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDao productDao;
    @Autowired
    private MemberDao memberDao;

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
    public void upHit(Long productId) {
        productDao.plusHit(productId);
    }


}
