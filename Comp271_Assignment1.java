/* 
Doug Ciraulo
COMP-271-801RL
Assignment #1
*/
package comp271_hw2;

class MyInteger {
    int value = 0;
    
    public MyInteger(int value){
        this.value = value;
    }
    
    public int getInteger(){
        return value;
    }
    
    public boolean isEven(){
        return value % 2 == 0;
    }
    
    public boolean isOdd(){
        return !isEven(value);
    }
    
    public boolean isPrime(){
        double max = Math.sqrt(value);
        
        for (int i = 2; i < max; i++) {
            if (value % i == 0){
                return false;
            }
        }
        return true;
    }
    
    public static boolean isEven(int value){
        return value % 2 == 0;
    }
    
    public static boolean isOdd(int value){
        return !isEven(value);
    }
    
    public static boolean isPrime(int value){
        double max = Math.sqrt(value);
        
        for (int i = 2; i < max; i++){
            if(value % i == 0){
                return false;
            }
        }
        return true;
    }
    
    public static boolean isEven(MyInteger myInteger){
        return myInteger.isEven();
    }
    
    public static boolean isOdd(MyInteger myInteger){
        return myInteger.isOdd();
    }
    
    public static boolean isPrime(MyInteger myInteger){
        return myInteger.isPrime();
    }
    
    public boolean equals(int value){
        return this.value == value;
    }
    
    public boolean equals(MyInteger myInteger){
        return this.value == myInteger.value;
    }
    
    public static int parseInt(char[] value){
        String string = new String(value);
        int result = Integer.parseInt(string);
        return result;
    }
    
    public static int parseInt(String number){
        int result = Integer.parseInt(number);
        return result;
    }
    
    public static void main(String[] args){
        
        /* Declarations */
        
        MyInteger integer = new MyInteger(5);
        MyInteger integer2 = new MyInteger(3);
        char[] value = {'1', '2', '3', '4'};
        String number = "1234";
        
        /* Testing methods */
        
        integer.getInteger();
        integer.isEven();
        integer.isOdd();
        integer.isPrime();
        
        /* Testing methods w/ parameters */
        
        MyInteger.isEven(4);
        MyInteger.isOdd(4);
        MyInteger.isEven(7);
        MyInteger.isOdd(7);
        MyInteger.isPrime(4);
        MyInteger.isPrime(3);
        integer.equals(3);
        integer.equals(5);
        integer.equals(integer2);
        
        /* Testing parse methods */
        
        MyInteger.parseInt(value);
        MyInteger.parseInt(number);
    }
    
}
