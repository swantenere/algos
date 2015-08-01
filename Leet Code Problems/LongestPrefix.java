import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Annam on 01-08-2015.
 */
public class LongestPrefix {

    public static void main(String args[])throws Exception
    {
        int num=0;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of Strings");
        num=Integer.parseInt(br.readLine());
        String arr[]=new String[num];
        for(int i=0;i<num;i++)
        {
            System.out.println("Enter a string");
            arr[i]=br.readLine();
        }
        String longestprefix=longestCommonPrefix(arr);
        System.out.println("Longest common prefix is "+longestprefix);

    }

        public static String longestCommonPrefix(String[] strs) {

            if(strs.length==0)
                return "";
            String longestprefix=strs[0];
            for(int i=1;i<strs.length;i++)
            {
                if(longestprefix.length()>strs[i].length()) {
                    longestprefix = longestprefix.substring(0, strs[i].length());

                }
                for(int j=0;j<longestprefix.length();j++)
                {
                  if(longestprefix.charAt(j)!=strs[i].charAt(j))
                  {
                      longestprefix=longestprefix.substring(0,j);

                      break;
                  }

                }
            }
            return longestprefix;
        }

}
