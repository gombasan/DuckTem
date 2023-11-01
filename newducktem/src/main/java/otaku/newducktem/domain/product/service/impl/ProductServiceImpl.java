package otaku.newducktem.domain.product.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import otaku.newducktem.domain.product.dto.request.ProductRequest;
import otaku.newducktem.domain.product.dto.response.ProductResponse;
import otaku.newducktem.domain.product.entity.Product;
import otaku.newducktem.domain.product.repository.ProductRepository;
import otaku.newducktem.domain.product.service.ProductService;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	@Override
	public Long register(ProductRequest request) {
		Product product = Product.builder()
			.name(request.name())
			.price(request.price())
			.condition(request.condition())
			.description(request.description())
			.deliveryType(request.deliveryType())
			.build();
		Product savedProduct = productRepository.save(product);
		return savedProduct.getId();
	}

	@Override
	public ProductResponse getProductBy(Long productId) {
		Product product = productRepository.findById(productId)
			.orElseThrow(NoSuchElementException::new);
		return ProductResponse.from(product);
	}

	@Override
	public List<Product> list() {
		return null;
	}
}
