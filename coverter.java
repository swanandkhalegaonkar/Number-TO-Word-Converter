import java.util.Scanner;
import java.io.*;
public class Main {
    static String one[] = { "", "one ", "two ", "three ", "four ",
                            "five ", "six ", "seven ", "eight ",
                            "nine ", "ten ", "eleven ", "twelve ",
                            "thirteen ", "fourteen ", "fifteen ",
                            "sixteen ", "seventeen ", "eighteen ",
                            "nineteen " };
    static String ten[] = { "", "", "twenty ", "thirty ", "forty ",
                            "fifty ", "sixty ", "seventy ", "eighty ",
                            "ninety " };
 
    static String numToWords(int n, String s)
    {
        String str = "";
        if (n > 19) {
            str += ten[n / 10] + one[n % 10];
        }
        else {
            str += one[n];
        }
        if (n != 0) {
            str += s;
        }
        return str;
    }
 
    static String convertToWords(double n1)
    {
        int n=(int)n1,c=0,d=0,flag=0;
        double temp=n1;
        String out = "Rs.";
        out += numToWords((int)(n / 10000000), "crore ");
        out += numToWords((int)((n / 100000) % 100), "lakh ");
        out += numToWords((int)((n / 1000) % 100), "thousand ");
        out += numToWords((int)((n / 100) % 10), "hundred ");
 
        if (n > 100 && n % 100 > 0) {
            out += "and ";
        }
        out += numToWords((int)(n % 100), "");
         while (temp - (int)temp > 0.0)  
        {  
          c++;
          d=d*10;
          int temp1=0;
          temp *= 10; 
          int temp2=(int)temp;
          temp1=temp2%10;
          d=d+temp1;
          flag=1;
        // System.out.printf("\n"+d);
        }
       
        if(flag==1)
        { 
            out+=d;
            out+="/";
            int e=10;
            c--;
            while(c!=0){
              
              e=e*10;
              c--;
            }
            out+=e;
        }out+=" only ";
        return out;
    }
 
    public static void main(String[] args)
    {
        
        double n ;
        Scanner scan = new Scanner( System.in );
        System.out.print("Enter a double:");
    n = scan.nextDouble();
        System.out.printf(convertToWords(n));
    }
}