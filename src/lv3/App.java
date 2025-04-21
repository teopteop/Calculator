package lv3;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        NumberParser np = new NumberParser();
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator<Number> ac = new ArithmeticCalculator();

        while(true) {
            try {
                System.out.println("계산을 진행할 두 숫자를 입력하세요. (입력값 >=0)");
                System.out.print("첫 번째 입력값: ");
                Number num1 = np.parseNumber(sc.nextLine());
                System.out.print("두 번째 입력값: ");
                Number num2 = np.parseNumber(sc.nextLine());
                System.out.println("계산에 맞는 연산기호(+, -, *, /)를 입력하세요!");
                String c = sc.nextLine();
                ac.calculator(num1, num2, c);
                System.out.println("숫자를 입력하면 지금까지의 계산값 중 입력값보다 큰 값을 출력합니다.");
                Number num3 = np.parseNumber(sc.nextLine());

                PrintList printList = () -> {
                    List<Number> f = ac.getOperationResults().stream().filter(num -> num.doubleValue() > num3.doubleValue())
                            .toList();
                    if(f.isEmpty()){
                        System.out.println("입력값보다 큰 값이 없습니다.");
                    } else {
                        System.out.println("입력값보다 큰 값은: " + f);
                    }
                };
                printList.prt();

                System.out.println("계속해서 계산을 진행하시려면 엔터를 입력하세요.('exit' 를 입력시 종료됩니다.)");
                String check = sc.nextLine();
                if(check.equals("exit")){
                    break;
                }

            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }

        sc.close(); //스캐너 종료 위치 수정

    }
}
