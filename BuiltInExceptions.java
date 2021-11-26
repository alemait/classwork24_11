package org.itstep;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BuiltInExceptions {

    public static void main(String[] args) throws NoSuchFieldException {
        
            //processInputException();
            //processIOException();
            //processDivideByZeroException();
            //processIndexOutOfBoundsException();
            processClassNotFoundException();
            //processNoSuchFieldException();
            //processNoSuchMethodException(testClass,"print1");
            //processNullPointerException();
            //processNumberFormatException();
    }

    //Обработка исключения ввода
    public static void processInputException() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите a: ");
        //Введем не число
        int a = 0;
        try {
            a = scanner.nextInt();
            System.out.printf("a=%d\n", a);
        } catch (InputMismatchException e) {
            System.err.println("Неверный формат введенного числа");
            //e.printStackTrace();
        }
    }

    //Обработка исключения чтения из файла
    public static void processIOException() {
        try {
            InputStream input = new FileInputStream("src\\data\\words.txt");
            System.out.println("File opened...");

        } catch (IOException e) {
            System.err.println("File opening failed:");
            //e.printStackTrace();
        }
    }

    //Обработка исключения деления на ноль
    public static void processDivideByZeroException() {
        int a=1, b;
        try {
            b = 1/0;
        } catch (ArithmeticException e) {
            System.err.println("Деление на ноль");
            //e.printStackTrace();
        }
    }
    
    //Обработка исключения выхода за пределы массива
    public static void processIndexOutOfBoundsException() {
        int [] a={1,2,3};
        try {
            int b = a[3];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Выход за пределы массива");
            e.printStackTrace();
        }
    }
    
     //Обработка исключения проверки существования класса
    public static void processClassNotFoundException() {
        try {            
            Class.forName("org.itstep.Person");
        } catch (ClassNotFoundException e) {
            System.err.println("Класс не существует");
            //e.printStackTrace();
        }
    }
    
    public static void processNoSuchFieldException() {
         TestClass testClass = new TestClass();
        Class<?> klass = testClass.getClass();
    try {
        Field field = klass.getDeclaredField("i");
    } catch (NoSuchFieldException e) {        
            System.err.println("Нет такого поля");    
            e.printStackTrace();
        }
    }


public static void processNoSuchMethodException(Object instance, String member) {
    TestClass testClass = new TestClass();
        Class<?> klass = testClass.getClass();
    try {
        Method method = klass.getDeclaredMethod("print");
    } catch (NoSuchMethodException e) {        
            System.err.println("Нет такого метода");    
            e.printStackTrace();
        }
    }

public static void processNullPointerException() {
        TestClass testClass = null;
    try {
        testClass.print();
    } catch (NullPointerException e) {        
            System.err.println("Обращение к несуществующему экземпляру класса");
            e.printStackTrace();
        }
    }

//NumberFormatException
public static void processNumberFormatException() {        
    try {
        int a = Integer.parseInt("1.2");
    } catch (NumberFormatException e) {        
            System.err.println("Неверный формат целого числа");    
            e.printStackTrace();
        }
    }
}

class TestClass{
    private int i = 0;
    public void print(){        
    }
}
