/*
Doug Ciraulo
COMP-271-801RL
Assignment #3.2
 */
package comp271_assignment3.pkg2;

public class Comp271_Assignment3b {

    public static void main(String[] args) {
    }
    
}

abstract class GeometricObject {
    
    private String color = "white";
    private Boolean filled;
    private java.util.Date dateCreated;
    
    public GeometricObject(){
        dateCreated = new java.util.Date();
    }
    
    public GeometricObject(String color, Boolean filled){
        this.color = color;
        this.filled = filled;
        dateCreated = new java.util.Date();
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
    
    public java.util.Date getDateCreated(){
        return dateCreated;
    }
    
    @Override
    public String toString(){
        return "Created on: " + dateCreated + "\nColor: " + color
                + "\nFilled: " + filled;
    }
    
}

abstract class Circle
extends GeometricObject
implements Comparable<Circle>{
    
    private double radius;
    
    public Circle(){
        super();
    }
    
    public Circle(double radius){
        this.radius = radius;
    }
    
    public Circle(double radius, String color, Boolean filled){
        super(color, filled);
        this.radius = radius;
    }
    
    public double getRadius(){
        return radius;
    }
    
    public void setRadius(double radius){
        this.radius = radius;
    }
    
    public double getArea(){
        return radius * radius * Math.PI;
    }
    
    public double getDiameter(){
        return 2 * radius;
    }
    
    public double getPerimeter(){
        return 2 * radius * Math.PI;
    }

    public Boolean equals(Circle myCircle){
        return this.radius == myCircle.radius;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\nRadius: " + radius;
    }

    @Override
    public int compareTo(Circle o){
        if(getArea() > o.getArea())
            return 1;
        else if(getArea() < o.getArea())
            return -1;
        else return 0;
    }
    
}