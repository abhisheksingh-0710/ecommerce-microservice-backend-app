package com.selimhorri.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.selimhorri.app.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query("SELECT p FROM Product p WHERE LOWER(p.productTitle) LIKE LOWER(CONCAT('%', :title, '%'))")
	List<Product> findByProductTitleContainingIgnoreCase(@Param("title") String title);

	List<Product> findByDiscountPercentGreaterThan(Double discountPercent);

}
