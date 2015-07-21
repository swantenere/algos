import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Annam on 21-07-2015.
 */
public class ZigZagConversion {
    public static void main(String args[])throws Exception{
        String s;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a string");
        s=br.readLine();
        System.out.println("Enter the number of rows");
        int rows=Integer.parseInt(br.readLine());
        String zigzag=convert(s,rows);
        System.out.println("Zig zag conversion results in "+zigzag);
    }
    public static String convert(String s, int numRows) {
        if(s.length()==0)
            return "";
        if(numRows<2)
            return s;
        char arr[]=new char[s.length()];
        char str[]=s.toCharArray();
        int nol=0;

        int noc=0,i=0,j=0,step=1;
        arr[0]=str[0];
        int flag=0;
        while(i<s.length())
        {
            j=noc;
            flag=0;

            while((j<s.length())&&(i<s.length()))
            {
                step=numRows*2-2;
                if((noc==0)||(noc==numRows-1)) //first or last row => no outliers
                {
                    arr[i] = str[j];
                    j = j + step;
                    i++;
                }
                else
                {
                    int step1=(numRows-noc-1)*2;
                    int step2=step-step1;
                    if(flag==0)
                    {
                        arr[i]=str[j];
                        flag=1;
                        j=j+step1;
                        i++;
                    }
                    else
                    {
                        arr[i]=str[j];
                        flag=0;
                        j=j+step2;
                        i++;
                    }
                }
            }
            noc++;
        }
        String zigzag=new String(arr);
        return zigzag;
    }

}
