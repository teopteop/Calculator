package lv3;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator {

    public enum OperatorType {
        PLUS("+"), MINUS("-"), TIMES("*"), DIVINED("/");

        private final String oper;

        OperatorType(String oper) {
            this.oper = oper;
        }

        public String getOper() {
            return oper;
        }

        public static OperatorType operChoice(String c){
            for(OperatorType oper : OperatorType.values()) {
                if (oper.getOper().equals(c)){
                    return oper;
                }
            }
            throw new IllegalArgumentException("해당하는 연산자가 없습니다.");
        }
    }

    private final List<Number> sumList = new ArrayList<>();

    public void clearSumList() {
        sumList.clear();
    }

    public void setSumList(Number sum) {
        sumList.add(sum);
    }

    public static <T extends Number> void checkNegative(T num1, T num2) throws IllegalArgumentException{
        if(num1.doubleValue() < 0 || num2.doubleValue() < 0){
            throw new IllegalArgumentException("입력값은 음수가 될 수 없습니다. (입력값>=0)");
        }
    }

    public <T extends Number> void calculator (T num1, T num2, String c){
        OperatorType oper = OperatorType.operChoice(c);
        checkNegative(num1, num2);

        switch (oper) {
            case PLUS:
                setSumList(num1.doubleValue() + num2.doubleValue());
                break;

            case MINUS:
                setSumList(num1.doubleValue() - num2.doubleValue());
                break;

            case TIMES:
                setSumList(num1.doubleValue() * num2.doubleValue());
                break;

            case DIVINED:
                if(num2.doubleValue() == 0){
                    throw new IllegalArgumentException("나누기 진행 시 두 번째 값이 0이 될수 없습니다. 다시 시도해주세요.");
                }
                setSumList(num1.doubleValue() / num2.doubleValue());
                break;
        }
    }
}


