package lv2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    //연산결과 저장 필드
    private final List<Double> sumList = new ArrayList<>();

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
//저장 값이 있을때 명확한 타겟을 수정하는 역할이 세터에 가까운 느낌이지만 인덱스의 값을 바꿔줘...
//오케이이긴 하다...
//계산기 앱은 숫자와 사칙연산 기호만 전달해주는 역할 계산기에서 결정하는게
//리팩토링 > 기존의 코드를 그대로 가져가는 것은 아니다. 끝나가는 과정에서 흐름이 더 잘보인다.