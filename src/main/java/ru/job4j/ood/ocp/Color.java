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

    @Override
    public String toString() {
        return "Product{"
                + "name='" + name + '\''
                + ", color=" + color
                + ", size=" + size
                + '}';
    }
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

    interface Specification<T> {
        boolean isSatisfied(T item);
    }

    interface Filter<T> {
        Stream<T> filter(List<T> items, Specification<T> specification);
        }

        class ColorSpecification implements Specification<Product> {

        Color color;

            public ColorSpecification(Color color) {
                this.color = color;
            }

            @Override
            public boolean isSatisfied(Product item) {
                return item.color == color;
            }
        }

        class BetterFilter implements Filter<Product> {

            @Override
            public Stream<Product> filter(List<Product> items, Specification<Product> specification) {
                return items.stream().filter(specification::isSatisfied);
            }
        }

class Test {
    public static void main(String[] args) {
        Product product1 = new Product("samsung", Color.GREEN, Size.SMALL);
        Product product2 = new Product("Toyota", Color.BLUE, Size.LARGE);
        List<Product> lst = List.of(product1, product2);
        BetterFilter bf = new BetterFilter();
        bf.filter(lst, new ColorSpecification(Color.GREEN)).forEach(System.out::println);
    }
}





