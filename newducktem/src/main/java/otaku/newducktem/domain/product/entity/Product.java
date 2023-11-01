package otaku.newducktem.domain.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import otaku.newducktem.global.base.BaseEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String price;
	private String description;
	@Enumerated(value = EnumType.STRING)
	private String condition;
	private String deliveryType;
	private int hit;

	@Builder
	public Product(String name, String price, String description, String condition, String deliveryType) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.condition = condition;
		this.deliveryType = deliveryType;
	}
}
