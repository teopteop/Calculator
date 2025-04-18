package lv2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        Scanner sc = new Scanner(System.in);
        int a = 0;
        int b = 0;
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

                //음수 체크 메서드
                cal.checkNegative(a, b);

                System.out.println("계산을 진행할 연산 기호를 입력하세요.(+, -, *, /)");
                c = sc.next();

                if(c.equals("+")){
                    cal.setSumList(cal.plusInt(a, b));
                } else if(c.equals("-")){
                    cal.setSumList(cal.minusInt(a, b));
                } else if(c.equals("*")){
                    cal.setSumList(cal.timesInt(a, b));
                } else if(c.equals("/")){
                    try {
                        cal.setSumList(cal.dividedInt(a, b));
                    } catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                        continue;
                    }
                } else {
                    System.out.println("지원하지 않는 형식입니다. 다시 시도해주세요.");
                    continue;
                }

                System.out.println("계산 결과값은: " + cal.getSumList() + " 입니다.");
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
                continue; //흐름 명시해주기 없어도 무방
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                continue; //흐름 명시해주기 없어도 무방
            }

        }
    }
}

