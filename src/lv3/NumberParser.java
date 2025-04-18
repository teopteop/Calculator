package lv3;

public class NumberParser {

    public Number parseNumber(String number){
        if(number.contains(".")){
            return Double.parseDouble(number);
        } else {
            return Integer.parseInt(number);
        }
    }

}
