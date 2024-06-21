package com.example.ecommerce.service.impl;

import com.example.ecommerce.entity.category.Category;
import com.example.ecommerce.entity.category.SubCategory;
import com.example.ecommerce.entity.dto.request.ProductRequest;
import com.example.ecommerce.entity.dto.response.ProductResponse;
import com.example.ecommerce.entity.dto.response.ReviewResponse;
import com.example.ecommerce.entity.product.FilterCriteriaDTO;
import com.example.ecommerce.entity.product.Product;
import com.example.ecommerce.entity.product.ProductSpecifications;
import com.example.ecommerce.entity.product.filter.*;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.service.ProductService;
import com.example.ecommerce.service.generic.GenericServiceImpl;
import com.example.ecommerce.util.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl extends GenericServiceImpl<Product, ProductRequest, ProductResponse, Long> implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ListMapper listMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, ListMapper listMapper){
        super(productRepository, modelMapper, listMapper);
    }

    @Override
    public List<ProductResponse> findAll(){
        return productRepository.findAll()
                .stream()
                .filter(product -> product.getUser().getEnable())
                .map(product -> modelMapper.map(product,ProductResponse.class))
                .toList();
    }

    @Override
    public List<ReviewResponse> getProductReviews(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            return product.getReview().stream().map(review -> modelMapper.map(review,ReviewResponse.class))
                    .toList();
        }
        return List.of();
    }

    @Override
    public List<ProductResponse> getFilteredProducts(
            List<Category> categories,
            List<SubCategory> subCategories,
            BigDecimal minPrice,
            BigDecimal maxPrice,
            List<Brand> brands,
            List<Rating> ratings,
            List<Color> colors,
            List<Size> sizes,
            List<Material> materials,
            Boolean inStock,
            Boolean onSale,
            Boolean newArrival
    ) {
        Specification<Product> spec = Specification.where(null);

        if (categories != null && !categories.isEmpty()) {
            spec = spec.and(ProductSpecifications.hasCategoryIn(categories));
        }
        if (subCategories != null && !subCategories.isEmpty()) {
            spec = spec.and(ProductSpecifications.hasSubCategoryIn(subCategories));
        }
        if (minPrice != null) {
            spec = spec.and(ProductSpecifications.hasMinPrice(minPrice));
        }
        if (maxPrice != null) {
            spec = spec.and(ProductSpecifications.hasMaxPrice(maxPrice));
        }
        if (brands != null && !brands.isEmpty()) {
            spec = spec.and(ProductSpecifications.hasBrandIn(brands));
        }
        if (ratings != null && !ratings.isEmpty()) {
            spec = spec.and(ProductSpecifications.hasRatingIn(ratings));
        }
        if (colors != null && !colors.isEmpty()) {
            spec = spec.and(ProductSpecifications.hasColorIn(colors));
        }
        if (sizes != null && !sizes.isEmpty()) {
            spec = spec.and(ProductSpecifications.hasSizeIn(sizes));
        }
        if (materials != null && !materials.isEmpty()) {
            spec = spec.and(ProductSpecifications.hasMaterialIn(materials));
        }
        if (inStock != null) {
            spec = spec.and(ProductSpecifications.isInStock(inStock));
        }
        if (onSale != null) {
            spec = spec.and(ProductSpecifications.isOnSale(onSale));
        }
        if (newArrival != null) {
            spec = spec.and(ProductSpecifications.isNewArrival(newArrival));
        }

        return productRepository.findAll(spec).stream().map(product -> modelMapper.map(product,ProductResponse.class)).toList();
    }

    @Override
    public FilterCriteriaDTO getFilterCriteria() {
        FilterCriteriaDTO filterCriteria = new FilterCriteriaDTO();

        filterCriteria.setBrands(Arrays.stream(Brand.values()).map(Enum::name).collect(Collectors.toList()));
        filterCriteria.setCategories(Arrays.stream(com.example.ecommerce.entity.product.filter.Category.values()).map(Enum::name).collect(Collectors.toList()));
        filterCriteria.setSubCategories(Arrays.stream(com.example.ecommerce.entity.product.filter.SubCategory.values()).map(Enum::name).collect(Collectors.toList()));
        filterCriteria.setRatings(Arrays.stream(Rating.values()).map(Enum::name).collect(Collectors.toList()));
        filterCriteria.setColors(Arrays.stream(Color.values()).map(Enum::name).collect(Collectors.toList()));
        filterCriteria.setSizes(Arrays.stream(Size.values()).map(Enum::name).collect(Collectors.toList()));
        filterCriteria.setMaterials(Arrays.stream(Material.values()).map(Enum::name).collect(Collectors.toList()));

        return filterCriteria;
    }

}
