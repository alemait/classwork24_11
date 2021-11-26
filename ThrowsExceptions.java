package org.itstep;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
Реализовать метод возвращающий время года (зима|весна|лето|осень) по номеру месяца.
Месяца номеруются с 1 до 12. Январь - 1, Декабрь - 12.
В случае если в аргументе monthNumber будет недопустимое число,
метод должен кидать исключение IllegalArgumentException с сообщение вида
"monthNumber=-5 is invalid, the number of a month should be in a range of 1..12"
 */
public class ThrowsExceptions {
    public static void main(String[] args) throws FileNotFoundException {
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of a month: ");
        int monthNumber = scanner.nextInt();
        System.out.println(getSeason(monthNumber));
         */
        //throwCheckedException();
        getMethodCaller();
    }

    static String getSeason(int monthNumber){
        if (monthNumber<1 || monthNumber>12)
            throw new IllegalArgumentException(String.format(
                    "monthNumber=%d is invalid, the number of a month should be in a range of 1..12",monthNumber));
        if (monthNumber<3) return "winter";
        else if (monthNumber<6) return "spring";
        else if (monthNumber<9) return "summer";
        else if (monthNumber<12) return "autumn";
        else return "winter";
    }

    //Напишите метод `static void throwCheckedException()` который будет кидать `checked` исключение.
    static void throwCheckedException() throws FileNotFoundException {
        FileInputStream fis =  new FileInputStream("B:/myfile.txt");
    }

    //Вывести в консоль имя вызывающего его класса и метода (раскручивание стека вызовов).
    static void getMethodCaller() {
        String className = new Exception().getStackTrace()[1].getClassName();
        System.out.println(className);
        String methodName = new Exception().getStackTrace()[1].getMethodName();
        System.out.println(methodName);
        int line = new Exception().getStackTrace()[0].getLineNumber();
        System.out.println(line);

        StackTraceElement ste = Thread.currentThread().getStackTrace()[2];
        System.out.printf("%s.%s()", ste.getClassName(), ste.getMethodName());

    }
}
