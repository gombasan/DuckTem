package otaku.newducktem.domain.product.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import otaku.newducktem.domain.product.dto.response.ProductResponse;
import otaku.newducktem.domain.product.entity.Product;
import otaku.newducktem.domain.product.repository.ProductRepository;
import otaku.newducktem.domain.product.service.ProductService;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	@Override
	public Long register(Product product) {
		Product savedProduct = productRepository.save(product);
		return savedProduct.getId();
	}

	@Override
	public ProductResponse getProductBy(Long productId) {
		return null;
	}

	@Override
	public List<Product> list() {
		return null;
	}
}
