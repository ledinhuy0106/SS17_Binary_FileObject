package run;

import service.ProductService;

import static model.Product.products;
import static model.Product.sc;
import static service.FileObject.exportFileObject;
import static service.FileObject.importFileToList;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        products = importFileToList();
        int choice;
        do {
            System.out.println("1. Thêm mới sản phẩm");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Tìm kiếm sản phẩm sản phẩm");
            System.out.println("4. Thoát và In ra file");
            System.out.println("Nhập vào lựa chọn(1-4)");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    productService.add();
                    break;
                case 2:
                    productService.getAll();
                    break;
                case 3:
                    productService.searchName();
                    break;
                case 4:
                    exportFileObject(products);
                    System.exit(0);
                    System.out.println("Đã thoát");
                    break;
            }

        } while (true);
    }
}
