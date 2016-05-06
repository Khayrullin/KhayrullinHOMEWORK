package ru.kpfu.itis.group11506.semestr;


public class Mrx {
    public static void main(String[] args) {

        String num = "888888888888888888888888888";
        String num2 = "9999";

        LongArithmetic longArithmetic = new LongArithmetic();
        System.out.println("+: " + longArithmetic.addition(num, num2));
        System.out.println("-: " + longArithmetic.subtraction(num, num2));
        System.out.println("*: " + longArithmetic.multiplication(num, num2));
        System.out.println("^: " + longArithmetic.degree(20, num2));
        System.out.println("<<: " + longArithmetic.leftLogicalShift(5, num2));
        System.out.print("/: ");
        longArithmetic.showArray(longArithmetic.division(longArithmetic.convertToArray(num),
                longArithmetic.convertToArray(num2)));
        System.out.println();
        System.out.print(">>: "  );
        longArithmetic.rightLogicalShift(5, num2);


    }
}
