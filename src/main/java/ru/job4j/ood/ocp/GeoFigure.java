package ru.job4j.ood.ocp;

public interface GeoFigure {
}

class SquareArea implements GeoFigure {
    private int side;

    public SquareArea(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }
}

     class RectangleArea implements GeoFigure {

        private int a;
        private int b;

        public RectangleArea(int a, int b) {
            this.a = a;
            this.b = b;
        }

         public int getA() {
             return a;
         }

         public int getB() {
             return b;
         }
     }
      class AnotherTest {
         public static void main(String[] args) {
             int a = 5;
             int b = 10;
             GeoFigure geoFigure1 = new SquareArea(a);
             GeoFigure geoFigure2 = new RectangleArea(a, b);
             if (geoFigure1 instanceof SquareArea) {
                 squareArea(a);
             }
             if (geoFigure2 instanceof RectangleArea) {
                 rectangleArea(a, b);
             }
         }

         public static void squareArea(int a) {
             System.out.println(a * a);
         }

         public static void rectangleArea(int a, int b) {
             System.out.println(a * b);
         }
     }

