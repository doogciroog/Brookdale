/*
Doug Ciraulo
COMP-271-801RL
Assignment #2.1
*/
package comp271_assignment2;

import java.util.Scanner;

class GeometricObject {
    
    private String color = "white";
    private boolean filled;
    
    public String getColor(){
        return color;
    }
    
    public void setColor(String color){
        this.color = color;
    }
    
    public boolean isFilled(){
        return filled;
    }
    
    public void setFilled(boolean filled){
        this.filled = filled;
    }
}

class Triangle 
extends GeometricObject{
    
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    public Triangle(){
    }

    public Triangle(double side1, double side2, double side3){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    
    public double getSide1(){
        return side1;
    }
    
    public double getSide2(){
        return side2;
    }
    
    public double getSide3(){
        return side3;
    }
    
    public double getArea(){
        double s = (side1 + side2 + side3)/2;
        double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
        return area;
    }
    
    public double getPerimeter(){
        double perimeter = side1 + side2 + side3;
        return perimeter;
    }
    
    @Override
    public String toString(){
        return "Triange: Side 1 = " + side1 + ", Side 2 = " + side2 +
                ", Side 3 = " + side3;
    }
    
    public static void main(String [] args){
        
        Scanner input = new Scanner(System.in);
        
        double side1;
        double side2;
        double side3;
        String color;
        boolean filled;
        
        System.out.println("Enter length of side 1: ");
        side1 = input.nextDouble();
        System.out.println("Enter length of side 2: ");
        side2 = input.nextDouble();
        System.out.println("Enter length of side 3: ");
        side3 = input.nextDouble();
        
        Triangle triangle = new Triangle(side1, side2, side3);
        
        System.out.println("Set color: ");
        color = input.nextLine();
        triangle.setColor(color);
        
        System.out.println("Is it filled: ");
        filled = input.nextBoolean();
        triangle.setFilled(filled);
    }
    
}