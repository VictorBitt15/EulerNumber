package utils;

public class fatorial {

    public static int calcFatorial(int number) {
        if(number == 1){
            return 1;
        }else{
            return number * calcFatorial(number-1);
        }
    }
}
