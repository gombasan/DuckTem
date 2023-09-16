package otaku.newducktem.domain.product.dto.request;

public record ProductRequest(
	String name,
	String price,
	String description,
	String condition,
	String deliveryType
) {

}
