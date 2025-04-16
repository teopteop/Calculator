package lv1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 0;
        int b = 0;
        double sum = 0;
        String c = "";

        while (true) {
            //예외처리
            try {
                System.out.println("---------------------");
                System.out.println("계산할 두 정수를 입력하세요 (입력값>=0)");

                System.out.print("첫 번째 정수: ");
                a = sc.nextInt();
                System.out.print("두 번째 정수: ");
                b = sc.nextInt();

                System.out.println("계산을 진행할 연산 기호를 입력하세요.(+, -, *, /)");
                c = sc.next();

                if(c.equals("+")){
                    sum = plusInt(a, b);
                } else if(c.equals("-")){
                    sum = minusInt(a, b);
                } else if(c.equals("*")){
                    sum = timesInt(a, b);
                } else if(c.equals("/")){
                    try {
                        sum = dividedInt(a, b);
                    } catch (Exception e){
                        System.out.println("나누기 진행 시 두 번째 값이 0이 될수 없습니다. 다시 시도해주세요.");
                        continue;
                    }
                } else {
                    System.out.println("지원하지 않는 형식입니다. 다시 시도해주세요.");
                    continue;
                }

                System.out.println("계산 결과값은: " + sum + " 입니다.");
                sc.nextLine(); //남은 개행문자(\n) 지우기
                System.out.println("엔터를 누르면 다음 계산을 진행합니다. ('exit'를 입력시 종료됩니다.)");
                c = sc.nextLine();

                if(c.equals("exit")) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }

            } catch (InputMismatchException e){
                //InputMismatchException 발생 시 처음부터 계산을 다시 실행
                System.out.println("잘못된 입력입니다. 조건에 맞게 입력해주세요.");
                sc.nextLine(); //버퍼 비우기
                continue;
            }

        }

    }

    //사칙연산 메서드
    public static int plusInt(int a, int b){
        return a + b;
    }

    public static int minusInt(int a, int b){
        return a - b;
    }

    public static int timesInt(int a, int b){
        return a * b;
    }

    public static double dividedInt(int a, int b){
        return (double)a / b;
    }
}
