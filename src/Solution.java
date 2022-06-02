import java.util.Scanner;

public class Solution {

    private static final String EQUATION_REGEX = "^-?\\d+((\\/|\\*|\\+|-)\\d+)*$";

    public static void main(String[] args) {
        boolean isStatus;



       String s= "123456789101166768=697071727374757677787980";

       char[] ch =s.toCharArray();
                StringBuilder equals= new StringBuilder();
                StringBuilder end= new StringBuilder();
                StringBuilder start= new StringBuilder();
        for (char c : ch) {
            if (c=='='){
                equals.append(c);
             break;
            }
            else {
                start.append(c);
            }
        }

        String numberD = String.valueOf(ch);
        numberD = numberD.substring ( numberD.indexOf ( "=" ) );
        char[]char2=numberD.toCharArray();
        for (char c:char2){
            if (c=='='){
                continue;
            }
            else {
                end.append(c);
            }}

         String concat= start +end.toString();
        char []negative=concat.toCharArray();

       String minus= String.valueOf(negative[0]);



  if (minus.equals("-")) {
           System.out.println("В начале должен быть не отрицательный цифра");
       }

       else {
           // Integer.parseInt(String.valueOf(start.length()+end.length()))<1000
           if (Integer.parseInt(String.valueOf(start.length() + end.length())) >= 1000) {
               System.out.println("превышен");

           } else if (Integer.parseInt(String.valueOf(start.length() + end.length())) < 0) {
               System.out.println("Уменьшен");

           } else {
    if (concat.length()+1<80){
               if (allSignsResult2(end.toString())<1000000000000000000L&&allSignsResult1(start.toString())<1000000000000000000L){
               isStatus = isEquals(start.toString(), end.toString());
               System.out.println(start + "=" + end + " " + isStatus);

               }else {

                   System.out.println("Превышен");

               }}
    else {
        System.out.println("Больше чем 80");

    }
           }
       }}


    public static Long allSignsResult1(String s1){

        long allSignsResult1;
        if (s1.matches(EQUATION_REGEX)) {
            allSignsResult1 = computeWithAllOperations(s1);
           // System.out.println(allSignsResult1);
        } else {
            allSignsResult1=0L;
         //   System.out.println(allSignsResult1);
        }
        return  allSignsResult1;
    }

    public static Long allSignsResult2(String s2){
            long allSignsResult2;
        if (s2.matches(EQUATION_REGEX)) {
            allSignsResult2 = computeWithAllOperations(s2);
        } else {
            allSignsResult2=0L;
        }
return allSignsResult2;
    }

    private static boolean isEquals(String s1,String s2){

        long allSignsResult2;
        if (s2.matches(EQUATION_REGEX)) {
            allSignsResult2 = computeWithAllOperations(s2);

        } else {
            allSignsResult2=0L;
        }



        Long allSignsResult1;
        if (s1.matches(EQUATION_REGEX)) {
            allSignsResult1 = (long) computeWithAllOperations(s1);
        } else {
            allSignsResult1=0L;
        }

        if(allSignsResult1.equals(allSignsResult2)){
            return true;
        }else {
            return false;

        }
    }

    private static int computeWithAllOperations(String input) {
        int result = 0;

        String parts[] = input.replaceAll("(\\d)-", "$1+-").split("\\+");
        for (String part : parts) {
            result += computeMultAndDivision(part);
        }
        return result;
    }


    private static int computeMultAndDivision(String part) {


        String[] parts = part.split("(?=[/*])|(?<=[/*])");
        if (parts[0].isEmpty()) {
            return 0;
        }

        int result = Integer.parseInt(parts[0]);
        for (int i = 1; i < parts.length; i += 2) {
            String op = parts[i];
            int val = Integer.parseInt(parts[i + 1]);
            switch (op) {
                case "*":
                    result *= val;
                    break;
                case "/":
                    result /= val;
                    break;
            }
        }
        return result;
    }

}