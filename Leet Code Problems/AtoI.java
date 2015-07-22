import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Annam on 22-07-2015.
 */
public class AtoI {

    public static void main(String args[])throws Exception
    {
        String str;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a string");
        str=br.readLine();
        int x=myAtoi(str);
        System.out.println("x="+x);
    }

    public static int myAtoi(String str) {
        if(str==null)
            return 0;
        boolean negative=false,flag=false;
        long result=0;

        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='+') {
                int num=str.charAt(i+1)-'0';

                if(!((num>=0)&&(num<=9)))
                    return 0;
                else
                    continue;
            }
            if(str.charAt(i)=='-') {
                int num=str.charAt(i+1)-'0';
                if(!((num>=0)&&(num<=9)))
                    return 0;
                else {
                    negative=true;
                    continue;
                }
            }


            if((str.charAt(i)==' ')&&(!flag))
                continue;

            int num=str.charAt(i)-'0';
            if((!flag)&&!((num>=0)&&(num<=9))&&(num!=-16))
                return 0;
            if((num>=0)&&(num<=9)) {

                long val=(long)(result*10);
                System.out.println(val);
                if((long)((result*10)+num)>Integer.MAX_VALUE) {
                    if(!negative)return Integer.MAX_VALUE;
                    else return Integer.MIN_VALUE;
                }
                else
                result = result * 10 + num;
                flag=true;
            }
            else
            {

                if((flag)&&(!negative))
                    return (int)result;
                else if((flag)&&(negative))
                    return (int)(result*-1);
            }


        }
        if(negative)
            result=result*-1;

        return (int)result;
    }

}
