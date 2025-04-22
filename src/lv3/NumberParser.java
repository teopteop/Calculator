package lv3;

public class NumberParser {
    //입력 문자열 숫자로 파싱
    public Number parseNumber(String number){
        if(number.contains(".")){
            return Double.parseDouble(number);
        } else {
            return Integer.parseInt(number);
        }
    }

}
