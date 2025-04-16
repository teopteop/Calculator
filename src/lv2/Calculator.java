package lv2;

public class Calculator {
    //연산결과 저장 필드
    private double sum = 0;

    public double getSum() {
        return sum;
    }

    //사칙연산 메서드
    public void plusInt(int a, int b){
        this.sum = a + b;
    }

    public void minusInt(int a, int b){
        this.sum = a - b;
    }

    public void timesInt(int a, int b){
        this.sum = a * b;
    }

    public void dividedInt(int a, int b) throws Exception{
        if(b == 0){
            throw new Exception();
        }
        this.sum = (double)a / b;
    }
}
