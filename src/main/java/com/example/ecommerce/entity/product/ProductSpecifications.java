package com.example.ecommerce.entity.product;

import com.example.ecommerce.entity.category.Category;
import com.example.ecommerce.entity.category.SubCategory;
import com.example.ecommerce.entity.product.filter.*;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.util.List;

public class ProductSpecifications {

    public static Specification<Product> hasCategoryIn(List<Category> categories) {
        return (root, query, criteriaBuilder) -> root.get("category").in(categories);
    }

    public static Specification<Product> hasSubCategoryIn(List<SubCategory> subCategories) {
        return (root, query, criteriaBuilder) -> root.get("subCategory").in(subCategories);
    }

    public static Specification<Product> hasMinPrice(BigDecimal minPrice) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    public static Specification<Product> hasMaxPrice(BigDecimal maxPrice) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
    }

    public static Specification<Product> hasBrandIn(List<Brand> brands) {
        return (root, query, criteriaBuilder) -> root.get("brand").in(brands);
    }

    public static Specification<Product> hasRatingIn(List<Rating> ratings) {
        return (root, query, criteriaBuilder) -> root.get("rating").in(ratings);
    }

    public static Specification<Product> hasColorIn(List<Color> colors) {
        return (root, query, criteriaBuilder) -> root.join("colors").in(colors);
    }

    public static Specification<Product> hasSizeIn(List<Size> sizes) {
        return (root, query, criteriaBuilder) -> root.get("size").in(sizes);
    }

    public static Specification<Product> hasMaterialIn(List<Material> materials) {
        return (root, query, criteriaBuilder) -> root.get("material").in(materials);
    }

    public static Specification<Product> isInStock(Boolean inStock) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("inStock"), inStock);
    }

    public static Specification<Product> isOnSale(Boolean onSale) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("onSale"), onSale);
    }

    public static Specification<Product> isNewArrival(Boolean newArrival) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("newArrival"), newArrival);
    }

}

