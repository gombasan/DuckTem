package otaku.newducktem.domain.product.api;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import otaku.newducktem.domain.product.dto.request.ProductRequest;
import otaku.newducktem.domain.product.dto.response.ProductResponse;
import otaku.newducktem.domain.product.service.ProductService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/prduct")
public class ProductController {

	private final ProductService productService;

	@PostMapping
	public ResponseEntity<Long> registerProduct(@RequestBody ProductRequest request) {
		Long productId = productService.register(request);
		URI redirect = URI.create("/product/" + productId.toString());
		return ResponseEntity.created(redirect).body(productId);
	}
	@GetMapping("/{productId}")
	public ResponseEntity<ProductResponse> getProductBy(@PathVariable Long productId) {
		ProductResponse response = productService.getProductBy(productId);
		return ResponseEntity.ok().body(response);
	}
}
