package lv2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    //연산결과 저장 필드
    private final List<Double> operationResults = new ArrayList<>();

    public double getOperationResults(){
        return operationResults.get(0);
    }

    public void clearSumList(){
        operationResults.clear();
    }

    public void setOperationResults(double sum){
        operationResults.add(sum);
    }

    //사칙연산 메서드
    public double plusInt(int a, int b){
        return a + b;
    }

    public double minusInt(int a, int b){
        return a - b;
    }

    public double timesInt(int a, int b){
        return a * b;
    }

    public double dividedInt(int a, int b) throws IllegalArgumentException{
        if(b == 0){
            throw new IllegalArgumentException("나누기 진행 시 두 번째 값이 0이 될수 없습니다. 다시 시도해주세요.");
        }
        return (double)a / b;
    }

    public void checkNegative(int a, int b) throws IllegalArgumentException{
        if(a < 0 || b < 0){
            throw new IllegalArgumentException("입력값은 음수가 될 수 없습니다. (입력값>=0)");
        }
    }
}