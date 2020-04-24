/*
Doug Ciraulo
COMP-271-801RL
Assignment #3
 */
package comp271_assignment3;

import java.util.Date;
import java.util.Scanner;

public class Comp271_Assignment3 {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter length of side 1: ");
        double side1 = input.nextDouble();
        System.out.println("Enter length of side 2: ");
        double side2 = input.nextDouble();
        System.out.println("Enter length of side 3: ");
        double side3 = input.nextDouble();
        System.out.println("Enter color of your triangle: ");
        String color = input.nextLine();
        System.out.println("Enter true or false to set fill: ");
        Boolean filled = input.nextBoolean();
        
        Triangle triangle = new Triangle(side1, side2, side3);
        triangle.setColor(color);
        triangle.setFilled(filled);
        triangle.toString();
        
    }
    
}

abstract class GeometricObject{
    
    private String color;
    private Boolean filled;
    private Date dateCreated;
    
    public GeometricObject(){
        dateCreated = new Date();
    }
    
    public GeometricObject(String color, Boolean filled){
        this();
        this.color = color;
        this.filled = filled;
    }
    
    public String getColor(){
        return color;
    }
    
    public void setColor(String color){
        this.color = color;
    }
    
    public Boolean isFilled(){
        return filled;
    }
    
    public void setFilled(Boolean filled){
        this.filled = filled;
    }
    
    public Date getDate(){
        return dateCreated;
    }
    
    @Override
    public abstract String toString();
    
    public abstract double getArea();
    
    public abstract double getPerimeter();
    
}

class Triangle
extends GeometricObject{
    
    private double side1, side2, side3;
    
    public Triangle(){
    }
    
    public Triangle(double side1, double side2, double side3){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    
    @Override
    public double getArea(){
        double s = (side1 + side2 + side3)/2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
    
    @Override
    public double getPerimeter(){
        return side1 + side2 + side3;
    }
    
    @Override
    public String toString(){
        return "Area: " + getArea() + "\nPerimeter: " + getPerimeter() +
                "\nColor: " + getColor() + "\nFilled: " + isFilled();
    }
    
}