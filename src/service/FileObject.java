package service;

import model.Product;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;

public class FileObject {
    public static final String FILENAME = "demo.txt";

    public static void exportFileObject(List<Product> list) {
        File file = new File(FILENAME);
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
            System.out.println("Ghi thành công");
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File không tồn tại");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file");
        }
    }

    public static List<Product> importFileToList() {
        List<Product> list = new ArrayList<>();
        File file = new File(FILENAME);
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            list = (List<Product>) objectInputStream.readObject();
            System.out.println("Đã nạp");
        } catch (FileNotFoundException e) {
            System.out.println();
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
