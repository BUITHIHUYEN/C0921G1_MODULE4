package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class ProductRepository implements IProductRepository {
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Mi 3 mien chua cay", 3000, "goi", "Viet Nam"));
        products.put(2, new Product(2, "Mi Hao Hao", 3500, "goi", "Viet Nam"));
        products.put(3, new Product(3, "Mi Omachi", 5500, "hop", "Viet Nam"));
        products.put(4, new Product(4, "Mi Gau Đo", 3000, "goi", "Viet Nam"));
        products.put(5, new Product(5, "Mien Phu Huong", 6000, "goi", "Viet Nam"));
        products.put(6, new Product(6, "Pho Ga Phu Huong", 5500, "goi", "Viet Nam"));
        products.put(7, new Product(7, " Mi Omachi ", 5000, "goi", "Viet Nam"));
        products.put(8, new Product(8, "Mien Nhip Song", 5500, "goi", "Viet Nam"));
        products.put(9, new Product(9, "Mi KoKoMi", 3000, "goi", "Viet Nam"));
        products.put(10, new Product(10, "Mi MiLiKet", 3000, "goi", "Viet Nam"));
        products.put(11, new Product(11, "Mi Lau Thai", 4500, "goi", "Viet Nam"));
        products.put(12, new Product(12, "Mi Đe Nhat", 4500, "goi", "Viet Nam"));
        products.put(13, new Product(13, "Mi Cay Han Quoc", 15000, "goi", "Viet Nam"));
        products.put(14, new Product(14, "Mi Nhat Ban", 18000, "goi", "Viet Nam"));
        products.put(15, new Product(15, "Mi Đe Nhat", 5000, "hop", "Viet Nam"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> productList = new ArrayList<>();
        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
            if (entry.getValue().getName().contains(name) ){
                productList.add(entry.getValue());
            }
        }
        return productList;
    }
    }


