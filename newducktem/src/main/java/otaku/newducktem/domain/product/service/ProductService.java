package otaku.newducktem.domain.product.service;

import java.util.List;

import otaku.newducktem.domain.product.dto.response.ProductResponse;
import otaku.newducktem.domain.product.entity.Product;

public interface ProductService {

	/* 상품 등록 서비스 */
	Long register(Product product);

	/* 하나의 상품 조회 서비스*/
	ProductResponse getProductBy(Long productId);

	/* 전체 상품 리스트 조회 서비스 */
	List<Product> list();
}
