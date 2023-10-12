package service;

import model.Product;

import static model.Product.products;
import static model.Product.sc;

public class ProductService {
    public void add() {
        Product product = new Product();
        product.input();
        products.add(product);
    }

    public void getAll() {
        for (Product product : products) {
            product.getProduct();
        }
    }

    public void searchName() {
        System.out.println("Nhập vào tên sản phẩm cần tìm:");
        String name = sc.nextLine();
        for (Product product : products) {
            if (product.getName().equals(name)) {
                product.getProduct();
            }
        }
    }
}
