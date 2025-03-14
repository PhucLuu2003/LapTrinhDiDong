package com.example.baitap_02;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Category> categories;
    private ArrayList<Product> products;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        // Khởi tạo dữ liệu
        initializeData();

        // Gọi các API để hiển thị dữ liệu
        displayAllCategories();
        displayProductsByCategory("Laptop");
        displayTop10SoldProducts();
        displayRecentProducts();
    }

    private void initializeData() {
        categories = new ArrayList<>();
        products = new ArrayList<>();

        // Thêm danh mục
        categories.add(new Category("Điện thoại"));
        categories.add(new Category("Laptop"));
        categories.add(new Category("Phụ kiện"));

        // Thêm sản phẩm
        Calendar calendar = Calendar.getInstance();
        products.add(new Product("iPhone 15", "Điện thoại", 100, calendar.getTime()));

        calendar.add(Calendar.DAY_OF_MONTH, -5); // Ngày tạo trước 5 ngày
        products.add(new Product("Samsung S23", "Điện thoại", 80, calendar.getTime()));

        calendar.add(Calendar.DAY_OF_MONTH, -10); // Ngày tạo trước 10 ngày
        products.add(new Product("MacBook Pro", "Laptop", 50, calendar.getTime()));

        products.add(new Product("Asus ROG", "Laptop", 30, new Date()));
        products.add(new Product("Tai nghe AirPods", "Phụ kiện", 60, new Date()));
    }

    private void displayAllCategories() {
        StringBuilder result = new StringBuilder("Danh mục sản phẩm:\n");
        for (Category category : categories) {
            result.append("- ").append(category.getName()).append("\n");
        }
        textView.append(result.toString() + "\n");
    }

    private void displayProductsByCategory(String categoryName) {
        StringBuilder result = new StringBuilder("Sản phẩm thuộc danh mục " + categoryName + ":\n");
        for (Product product : products) {
            if (product.getCategory().equalsIgnoreCase(categoryName)) {
                result.append("- ").append(product.getName()).append("\n");
            }
        }
        textView.append(result.toString() + "\n");
    }

    private void displayTop10SoldProducts() {
        List<Product> sortedProducts = new ArrayList<>(products);
        sortedProducts.sort((p1, p2) -> Integer.compare(p2.getSoldQuantity(), p1.getSoldQuantity()));

        StringBuilder result = new StringBuilder("Top 10 sản phẩm bán chạy nhất:\n");
        int count = Math.min(sortedProducts.size(), 10);
        for (int i = 0; i < count; i++) {
            result.append("- ").append(sortedProducts.get(i).getName())
                    .append(" (").append(sortedProducts.get(i).getSoldQuantity()).append(" lượt bán)\n");
        }
        textView.append(result.toString() + "\n");
    }

    private void displayRecentProducts() {
        Calendar sevenDaysAgo = Calendar.getInstance();
        sevenDaysAgo.add(Calendar.DAY_OF_MONTH, -7);

        StringBuilder result = new StringBuilder("Sản phẩm mới trong 7 ngày qua:\n");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        for (Product product : products) {
            if (product.getCreatedAt().after(sevenDaysAgo.getTime())) {
                result.append("- ").append(product.getName())
                        .append(" (Ngày tạo: ").append(sdf.format(product.getCreatedAt())).append(")\n");
            }
        }
        textView.append(result.toString() + "\n");
    }

}