import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Annam on 26-07-2015.
 */
public class PalindromeNumber {
    public static void main(String args[])throws Exception
    {
        int num;
        System.out.println("Enter a number");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        num=Integer.parseInt(br.readLine());
        boolean palindrome=isPalindrome(num);
        System.out.println(palindrome);
    }
    public static boolean isPalindrome(int x) {
        boolean negative=false;

        if(x<0)
            return false;
        if(x==0)
            return true;
        int length=(int)(Math.log10(x)+1)-1,l,r;
        while(length>=1) {
             r=x%10;
             l=x/(int)(Math.pow(10,length));
             if(l!=r)
                return false;
            x=x-(l* (int)(Math.pow(10,length)));
            x=x/10; length=length-2;

        }
        return true;
    }
}
