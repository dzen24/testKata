import java.util.Scanner;

public class Main {
    public static void main (String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        //System.out.print("Enter an expression in format 'a+b': ");  //Вводим выражение
        String expression = in.nextLine();
        System.out.print(calc(expression));
    }
    public static String calc (String input) throws Exception{
        char[] a = new char[11]; //выражение должно занимать не болеее 11 символов
        char operation = 0; //переменная для знака
        int index = 0; //переменная для индекса знака
        for (int i=0; i<input.length(); i++){  // достаем знак и записываем его в переменную
            a[i] = input.charAt(i);
            if (a[i]=='+'){
                operation = '+';
                index = i;
            }
            if (a[i]=='-'){
                operation = '-';
                index = i;
            }
            if (a[i]=='*'){
                operation = '*';
                index = i;
            }
            if (a[i]=='/'){
                operation = '/';
                index = i;
            }
        }  //Цикл для определения знака
        if (operation!='+'&operation!='-'&operation!='*'&operation!='/') throw new Exception("Incorrect operation");
        char[] num1 = new char[4];  //Первая переменная
        char[] num2 = new char[4];  //Вторая переменная
        int num1Int = 0;
        int num2Int = 0;
        input.getChars(0, index, num1, 0);  //Достаем первую переменную и кладем её в num1
        input.getChars(index+1, input.length(), num2, 0);  //Достаем вторую переменную -> num2
        String num1_str = String.valueOf(num1).trim(); //Преобразуем переменную в String
        String num2_str = String.valueOf(num2).trim(); //Преобразуем переменную в String
        int flag1 = 0; //Флаг, чтоб узнать римкое ли число было введено
        int flag2 = 0;
        switch (num1_str){
            case "I":
                num1_str = "1";
                flag1 = 1;
                break;
            case "II":
                num1_str = "2";
                flag1 = 1;
                break;
            case "III":
                num1_str = "3";
                flag1 = 1;
                break;
            case "IV":
                num1_str = "4";
                flag1 = 1;
                break;
            case "V":
                num1_str = "5";
                flag1 = 1;
                break;
            case "VI":
                num1_str = "6";
                flag1 = 1;
                break;
            case "VII":
                num1_str = "7";
                flag1 = 1;
                break;
            case "VIII":
                num1_str = "8";
                flag1 = 1;
                break;
            case "IX":
                num1_str = "9";
                flag1 = 1;
                break;
            case "X":
                num1_str = "10";
                flag1 = 1;
                break;
        }
        switch (num2_str){
            case "I":
                num2_str = "1";
                flag2 = 1;
                break;
            case "II":
                num2_str = "2";
                flag2 = 1;
                break;
            case "III":
                num2_str = "3";
                flag2 = 1;
                break;
            case "IV":
                num2_str = "4";
                flag2 = 1;
                break;
            case "V":
                num2_str = "5";
                flag2 = 1;
                break;
            case "VI":
                num2_str = "6";
                flag2 = 1;
                break;
            case "VII":
                num2_str = "7";
                flag2 = 1;
                break;
            case "VIII":
                num2_str = "8";
                flag2 = 1;
                break;
            case "IX":
                num2_str = "9";
                flag2 = 1;
                break;
            case "X":
                num2_str = "10";
                flag2 = 1;
                break;
        }
        if (flag1!=flag2 ) throw new Exception("Type of 'a' != type of 'b'");
        /*Тут начинается "Калькулятор"*/
        num1Int = Integer.parseInt(num1_str);
        num2Int = Integer.parseInt(num2_str);
        if (num1Int>10 | num1Int<1) throw new Exception("a < 0 or a > 10");
        if (num2Int>10 | num2Int<1) throw new Exception("b < 0 or b > 10");
        String answer = null;
        switch (operation) {
            case '+' -> answer = String.valueOf(num1Int + num2Int);
            case '-' -> answer = String.valueOf(num1Int - num2Int);
            case '*' -> answer = String.valueOf(num1Int * num2Int);
            case '/' -> {
                answer = String.valueOf(num1Int / num2Int);
                if (num1Int < num2Int) throw new Exception("a < b");
            }
        }
        if (flag1 == 1 | flag2 == 1) {
            answer = toRome(answer);
        }
        return answer;
    }
    static String toRome(String answer) throws Exception {
        int s = Integer.parseInt(answer);
        String dec = null;
        String ed = null;
        switch (s%10){
            case 1 -> ed = "I";
            case 2 -> ed = "II";
            case 3 -> ed = "III";
            case 4 -> ed = "IV";
            case 5 -> ed = "V";
            case 6 -> ed = "VI";
            case 7 -> ed = "VII";
            case 8 -> ed = "VIII";
            case 9 -> ed = "IX";
        }
        switch (s%100-s%10){
            case 10 -> dec = "X";
            case 20 -> dec = "XX";
            case 30 -> dec = "XXX";
            case 40 -> dec = "XL";
            case 50 -> dec = "L";
            case 60 -> dec = "LX";
            case 70 -> dec = "LXX";
            case 80 -> dec = "LXXX";
            case 90 -> dec = "XC";
        }
        answer = dec+ed;
        if (dec == null) answer = ed;
        if (ed == null) answer = dec;
        if (s < 1) throw new Exception("Rome-num always > 0");
        if (s == 100) answer="C";
        return answer;
    }
}