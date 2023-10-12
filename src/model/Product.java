package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Product implements Serializable {
    private int id;
    private String name;
    private double price;
    private String brand;
    private String description;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static Scanner sc = new Scanner(System.in);
    public static List<Product> products = new ArrayList<>();

    public void input() {
        id = checkId();
        name = checkName();
        System.out.println("Nhập vào nhãn hàng:");
        brand = sc.nextLine();
        System.out.println("Nhập vào giá:");
        price = Double.parseDouble(sc.nextLine());
        System.out.println("Mô tả Sản phẩm: ");
        description = sc.nextLine();
    }

    int checkId() {
        int id = 0;
        boolean check = true;
        while (check) {
            try {
                System.out.println("Nhập mã sản phẩm: ");
                id = Integer.parseInt(sc.nextLine());
                if (isId(id)) {
                    check = false;
                } else {
                    System.out.println("Mã sản phẩm đã tồn tại, nhập lại");
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Mã sản phẩm phải là số nguyên, vui lòng nhập lại");
            }
        }
        return id;
    }

    String checkName() {
        String name = null;
        boolean check = true;
        while (check) {
            System.out.println("Nhập tên sản phẩm: ");
            name = sc.nextLine();
            if (isName(name)) {
                check = false;
            } else {
                System.out.println("Tên sản phẩm đã tồn tại, nhập lại");
            }
        }
        return name;
    }

    boolean isId(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return false;
            }
        }
        return true;
    }

    boolean isName(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    public void getProduct() {
        System.out.printf("Sản phẩm %d, tên sản phẩm: %s, nhãn hàng: %s, giá: %.2f, mô tả: %s\n",id,name,brand,price,description);
    }

}
