package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

abstract class Shape {
    private Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public abstract double getArea();
    public abstract double getPerimeter();

    public String getColorDescription(){
        return "Red: " + color.red() +
                ", Green: " + color.green() +
                ", Blue: " + color.blue() +
                ", Alpha: " + color.alpha();
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle (double width, double height, Color color) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * width + 2 * height;
    }
}

class Triangle extends Shape {
    private double a, b, c;

    public Triangle (double a, double b, double c, Color color){
        super(color);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }
}

class ShapeDescriber {

    private static final Logger logger = LoggerFactory.getLogger(ShapeDescriber.class);

    public void describe (Shape shape){
        logger.info("Kolor kształtu: " + shape.getColorDescription());
        logger.info("Pole kształtu: " + shape.getArea());
        logger.info("Obwód kształtu: " + shape.getPerimeter());
    }
}
