package com.generation.ProductsAPI.service;

import com.generation.ProductsAPI.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public abstract List<Product> getAllProducts();
    public abstract List<Product> sortAllProductsByPriceAscend();
    public abstract List<Product> sortAllProductsByPriceDescend();
    public abstract Optional<Product> getProduct(Integer id);
    public abstract List<Product> getProductsWithName(String productName);
    public abstract List<Product> getProductsWithBrand(String productBrand);
//  public abstract List<Product> searchProducts(String productName, String productBrand);

    public abstract Product createNewProduct(Product product);
//  public abstract Product createNewProduct(Product product, String imageName);

    public abstract Optional<Product> updateProduct(Integer id, Product product);
    public abstract void deleteProduct(Integer id);

}
