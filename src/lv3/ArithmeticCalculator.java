package lv3;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator<T extends Number> {
    private enum OperatorType {
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

    private final List<Number> operationResults = new ArrayList<>();

/*  요구사항 구현 목적(실행x)
    public void clearOperationResults() {
        operationResults.clear();
    }

    public void removeOperationResult(int i) {
        operationResults.remove(i);
    }
 */

    public void setOperationResults(Number sum) {
        operationResults.add(sum);
    }

    public Number getOperationResult() {
        return operationResults.get(operationResults.size()-1);
    }

    public List<Number> getOperationResults() {
        return operationResults;
    }

    //음수값이 매개변수로 들어올 때 예외 던지기
    public void checkNegative(T num1, T num2) throws IllegalArgumentException{
        if(num1.doubleValue() < 0 || num2.doubleValue() < 0){
            throw new IllegalArgumentException("입력값은 음수가 될 수 없습니다. (입력값>=0)");
        }
    }

    public void calculator (T num1, T num2, String c){
        //String c에 해당하는 상수값을 저장(연산자)
        OperatorType oper = OperatorType.operChoice(c);
        //음수인지 확인
        checkNegative(num1, num2);

        switch (oper) {
            case PLUS:
                setOperationResults(num1.doubleValue() + num2.doubleValue());
                break;

            case MINUS:
                setOperationResults(num1.doubleValue() - num2.doubleValue());
                break;

            case TIMES:
                setOperationResults(num1.doubleValue() * num2.doubleValue());
                break;

            case DIVINED:
                if(num2.doubleValue() == 0){
                    throw new IllegalArgumentException("나누기 진행 시 두 번째 값이 0이 될수 없습니다. 다시 시도해주세요.");
                }
                setOperationResults(num1.doubleValue() / num2.doubleValue());
                break;
        }

        System.out.println("계산 결과는: " + getOperationResult() + " 입니다.");

    }
}


