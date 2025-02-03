package com.abbou.marjane.service.product;


import com.abbou.marjane.model.Product;
import com.abbou.marjane.request.AddProductRequest;
import com.abbou.marjane.request.ProductUpdateRequest;

import java.util.List;

public interface IProductService {
    Product addProduct(AddProductRequest product);
    Product updateProduct(ProductUpdateRequest product, Long productId);
    Product getProductById(Long productId);
    void deleteProductById(Long productId);

    List<Product> getAllProducts();
    List<Product> getProductsByCategoryAndBrand(String category, String brand);
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByBrandAndName(String brand, String name);
    List<Product> getProductsByBrand(String brand);
    List<Product> getProductsByName(String name);

}
