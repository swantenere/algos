import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Annam on 20-07-2015.
 */
public class LongestPalindrome {
    public static void main(String args[])throws Exception
    {
        String s;
        System.out.println("Enter a string");
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        s=br.readLine();
        String longest_palindrome_substring=longestPalindrome(s);
        System.out.println("Longest palindrome substring is "+longest_palindrome_substring);
    }
    public static String longestPalindrome(String s) {
        int n=s.length();
        if(n==0)
            return "";
        String longest=s.substring(0,1);
        for(int i=0;i<n-1;i++)
        {
            String p1=expandAroundCenter(s,i,i);
            if(p1.length()>longest.length())
                longest=p1;
            String p2=expandAroundCenter(s,i,i+1);
            if(p2.length()>longest.length())
                longest=p2;
        }
        return longest;
    }
    public static String expandAroundCenter(String s,int l,int r)
    {
        char arr[]=s.toCharArray();
        int flag=0;
        while(l>=0&&r<s.length()&&arr[l]==arr[r]) {
            l--;
            r++;
            flag=1;
        }
        if(flag==1)
            return s.substring(l+1,r);
        return "";
    }
}
