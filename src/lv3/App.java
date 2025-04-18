package lv3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        NumberParser np = new NumberParser();
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator ac = new ArithmeticCalculator();

        while(true) {
            try {
                System.out.println("숫자를 입력하세요!");
                Number num1 = np.parseNumber(sc.nextLine());
                Number num2 = np.parseNumber(sc.nextLine());
                System.out.println("연산기호를 입력하세요!");
                String c = sc.nextLine();
                ac.calculator(num1, num2, c);
                break;
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


    }
}
