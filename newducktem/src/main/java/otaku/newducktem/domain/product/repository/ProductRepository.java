package otaku.newducktem.domain.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import otaku.newducktem.domain.product.entity.Product;

public interface ProductRepository extends JpaRepository <Product, Long> {
}
