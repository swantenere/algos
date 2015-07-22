import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Annam on 22-07-2015.
 */
public class ReverseInteger {

    public static void main(String args[])throws Exception
    {
        int num;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a number");
        num=Integer.parseInt(br.readLine());
        int rev=reverse(num);
        System.out.println("reverse="+rev);
    }


    public static int reverse(int x) {

        long rev=0,flag=0;

        if(x<0){
            x=x*-1;
            flag=1;
        }
       while(x>0)
        {
            rev =rev*10+ x%10;
            x = x / 10;
         }
        if (rev > Integer.MAX_VALUE)
            return 0;
        if(flag==1)
            return (int)(rev*-1);
        return (int)rev;
    }
}
