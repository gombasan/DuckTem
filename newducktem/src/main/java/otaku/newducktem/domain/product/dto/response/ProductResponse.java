package otaku.newducktem.domain.product.dto.response;

import otaku.newducktem.domain.product.entity.Product;

public record ProductResponse(
	String name,
	String price
) {
	public static ProductResponse from(Product product) {
		return new ProductResponse(product.getName(), product.getPrice());
	}
}
