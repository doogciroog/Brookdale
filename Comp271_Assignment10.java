/*
Doug Ciraulo
COMP-271-801RL
Assignment #10
 */
package comp271_assignment10;

import java.io.*;

public class Comp271_Assignment10 {

    public static void main(String[] args) throws IOException {
        
        int sum = 0;
        int count = 0;
        
        try(
           DataOutputStream output = new DataOutputStream(new FileOutputStream("Exercise17_02", true));
        ) {
            for(int i = 1; i <= 100; i++){
                output.writeInt((int)(Math.random()*100));
            }
        }
        
        try(
           DataInputStream input = new DataInputStream(new FileInputStream("Exercise17_02"));
        ) {
            int value;
            
            while((value = input.readInt()) != -1){
                if(count%10 != 0 || count == 0) {
                    System.out.printf("%5d", value);
                }
                else{
                    System.out.printf("\n%5d", value);
                }
                sum += value;
                count++;
            }
            
        }
        
        catch(EOFException ex){
            System.out.println("\nSum: " + sum + "\nCount: " + count);
        }
        
    }
    
}
