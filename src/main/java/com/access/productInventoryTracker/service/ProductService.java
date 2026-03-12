package com.access.productInventoryTracker.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.access.productInventoryTracker.dto.ProductDTO;
import com.access.productInventoryTracker.model.Product;
import com.access.productInventoryTracker.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	// Helper method to convert Product to ProductDTO
	private ProductDTO convertToDTO(Product product) {
		return new ProductDTO(product.getId(), product.getName(), product.getPrice(),
				Optional.ofNullable(product.getCategory()).orElse("").toLowerCase(), product.isAvailable());
	}

	// Get all products as DTOs
	public List<ProductDTO> getAllProducts() {
		return productRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	// Your filtering methods here...

	// AI Generated
	// get products by category
	public List<ProductDTO> getProductsByCategory(String category) {
		return Optional.ofNullable(category)
				.map(cat -> productRepository.findAll().stream()
						.filter(product -> product.getCategory().equalsIgnoreCase(cat)).map(this::convertToDTO)
						.collect(Collectors.toList()))
				.orElseGet(List::of);
	}

	// get products within a price range
	public List<ProductDTO> getProductsByPriceRange(double minPrice, double maxPrice) {
		if (minPrice < 0 || maxPrice < 0) {
			throw new IllegalArgumentException("Prices must not be negative.");
		}
		if (minPrice > maxPrice) {
			throw new IllegalArgumentException("minPrice cannot be greater than maxPrice");
		}
		return productRepository.findAll().stream()
				.filter(product -> product.getPrice() >= minPrice && product.getPrice() <= maxPrice)
				.map(this::convertToDTO).collect(Collectors.toList());
	}

	// get products by availability
	public List<ProductDTO> getProductsByAvailability(boolean available) {
		return productRepository.findAll().stream().filter(product -> product.isAvailable() == available)
				.map(this::convertToDTO).collect(Collectors.toList());
	}

}
