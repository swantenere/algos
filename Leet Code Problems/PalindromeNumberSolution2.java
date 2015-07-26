import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Annam on 26-07-2015.
 */
public class PalindromeNumberSolution2 {
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
        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }
        while (x != 0) {
            int l = x / div;
            int r = x % 10;
            if (l != r) return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }
}
