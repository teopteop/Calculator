package lv2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    //연산결과 저장 필드
    private List<Double> sumList = new ArrayList<>();

    public double getSumList(){
        return sumList.get(sumList.size()-1);
    }

    public void setSumList(double sum){
        sumList.add(sum);
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
}
