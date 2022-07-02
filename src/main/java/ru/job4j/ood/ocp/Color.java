package ru.job4j.ood.ocp;

import java.util.List;
import java.util.stream.Stream;

enum Color {
    RED, GREEN, BLUE
}

enum Size {
    SMALL, MEDIUM, LARGE, YUGE
}

class Product {
    public String name;
    public Color color;
    public Size size;

    public Product(String name, Color color, Size size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }

    class ProductFilter {
        public Stream<Product> filterByColor(List<Product> products, Color color) {
            return products.stream().filter(p -> p.color == color);
        }

        public Stream<Product> filterBySize(List<Product> products, Size size) {
            return products.stream().filter(p -> p.size == size);
        }

        public Stream<Product> filterByColorAndSize(List<Product> products,
                                                    Color color, Size size) {
            return products.stream().filter(p -> p.color == color
                    && p.size == size);
        }
    }
}


