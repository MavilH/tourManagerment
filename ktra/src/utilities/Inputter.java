package utilities;


import java.util.Scanner;

public class Inputter {
    public static Scanner sc = new Scanner(System.in);

    // get an int between min and max
    public static int inputInt(String msg, int min, int max) {
        if (min > max) {
            int t = min;
            min = max;
            max = t;
        }
        int data;
        do {
            System.out.print(msg);
            data = Integer.parseInt(sc.nextLine());
        } while (data < min || data > max);
        return data;
    }
    //nhập int > || >=
    public static int inputInt(String msg, int min, String status) {
        int data = min;
        if(status.equals(">=")){
            do {
                System.out.print(msg);
                data = Integer.parseInt(sc.nextLine());
            } while (data < min);

        }else if(status.equals(">")){
            do {
                System.out.print(msg);
                data = Integer.parseInt(sc.nextLine());
            } while (data <= min);
        }
        return data;
    }
    //nhập double > || >=
    public static double inputDouble(String msg, double min, String status) {
        double data = min;
        if(status.equals(">=")){
            do {
                System.out.print(msg);
                data = Double.parseDouble(sc.nextLine());
            } while (data < min);

        }else if(status.equals(">")){
            do {
                System.out.print(msg);
                data = Double.parseDouble(sc.nextLine());
            } while (data <= min);
        }
        return data;
    }
    //method nhập số nguyên
    public static int inputAnInteger(String inpMsg, String errMsg){
        System.out.println(inpMsg);//hiển thị dòng vừa nhập
        while(true){
            try{
                
                int number = Integer.parseInt(sc.nextLine());
                return number;// ném số vừa nhập ra ngoài sử dụng
            }catch(Exception e){
                System.out.println(errMsg);//hiển thị nếu nhập sai
            }
        }
    }
     //method nhập số thực
    public static double inputADouble(String inpMsg, String errMsg){
        System.out.println(inpMsg);//hiển thị dòng vừa nhập
        while(true){
            try{
                
                double number = Double.parseDouble(sc.nextLine());
                return number;// ném số vừa nhập ra ngoài sử dụng
            }catch(Exception e){
                System.out.println(errMsg);//hiển thị nếu nhập sai
            }
        }
    }

    // get a string with no condition
    public static String inputStr(String msg) {
        System.out.print(msg);
        String data = sc.nextLine().trim();
        return data;
    }

    // get a non-blank string
    public static String inputNonBlankStr(String msg) {
        String data;
        do {
            System.out.print(msg);
            data = sc.nextLine().trim();
        } while (data.length() == 0);
        return data;
    }

    // get a string following a pattern
    public static String inputPattern(String msg, String pattern) {
        String data;
        do {
            System.out.print(msg);
            data = sc.nextLine().trim();
        } while (!data.matches(pattern));
        return data;
    }
    public static String getString(String inpMsg, String errMsg, String regex){
        System.out.printf(inpMsg);//mời nhập
        while(true){
            try{
                String str = sc.nextLine();
                if(str.isEmpty() || !str.trim().matches(regex)){
                    throw new Exception();
                }
                return str;
            }catch(Exception e){
                System.out.printf(errMsg);
            }
        }
    }
    
}

// Inputter class
