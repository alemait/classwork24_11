package org.itstep;

import static java.lang.Character.isLowerCase;
import java.util.Scanner;

public class UserExceptions {

    public static void main(String[] args) throws NotEvenException, FromOneToTenException, NotCapitalLetterException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an even number:");
        int a = scanner.nextInt();        
        validateEven(a);
       
        System.out.println("Enter a number from 1 to 10:");
        int b = scanner.nextInt();        
        validateFromOneToTen(b);
        
        Person person = new Person("alex");
    }

    //Проверить число на четность и при необходимости вызвать исключение
    public static void validateEven(int number) throws NotEvenException {
        if (number % 2 != 0) {
            throw new NotEvenException("The number is not even");
        }
    }
    
    //Проверить число на диапазон 1...10 и при необходимости вызвать исключение
    public static void validateFromOneToTen(int number) throws FromOneToTenException {
        if (number<1||number>10) {
            throw new FromOneToTenException("The number must be in range 1..10");
        }
    }
}

class NotEvenException extends Exception {
    NotEvenException(String str) {
        super(str);
    }
}

class FromOneToTenException extends Exception {

    FromOneToTenException(String str) {
        super(str);
    }
}

class Person{
    private String name = "";
    Person(String name) throws NotCapitalLetterException{
    this.name = name;
    validateName();
    }
    
    private void validateName() throws NotCapitalLetterException{
         if (isLowerCase(name.charAt(0))) {  
                 throw new NotCapitalLetterException("The first letter of name "+name+ " must be capital");
        }    
}
}

class NotCapitalLetterException extends Exception {

    NotCapitalLetterException(String str) {
        super(str);
    }
}

