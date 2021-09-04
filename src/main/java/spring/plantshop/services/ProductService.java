package spring.plantshop.services;


import spring.plantshop.domain.Product;

public interface ProductService {
    Iterable<Product> listAllProducts();
    Product getProductById(Integer id);
    Product saveProduct(Product product);
}
