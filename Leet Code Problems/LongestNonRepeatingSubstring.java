import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by Annam on 19-07-2015.
 */
public class LongestNonRepeatingSubstring {

    public static void main(String args[])throws Exception
    {
        String s;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a string");
        s=br.readLine();
        int x=lengthOfLongestSubstring(s);
        System.out.println("length of maximum possible substring without repeating characters is "+x);
    }
    public static int lengthOfLongestSubstring(String s) {
       if((s==null)||(s.length()==0))
            return 0;
        char string[]=s.toCharArray();
        int num_of_chars=s.length(),substr_start=0;
        int curr_len=1,max_len=1;
        int prev_substr_start=0;
        HashMap<Character,Integer> index_hash=new HashMap<Character,Integer>();
        HashMap<Character,Integer> hm=new HashMap<Character,Integer>();
        hm.put(string[0],1);
        index_hash.put(string[0],0);
        for(int i=1;i<num_of_chars;i++) {
            if((hm.get(string[i])==null)||(hm.get(string[i])!=1)||(index_hash.get(string[i])==null)||(index_hash.get(string[i])<substr_start)) { //visiting character for first time.
                index_hash.put(string[i], i);
                curr_len++;
            }
            else
            {

                if(max_len<curr_len) {
                    prev_substr_start=substr_start;
                    max_len = curr_len;
                }
                substr_start=index_hash.get(string[i])+1;
                curr_len=i-substr_start+1;
                index_hash.put(string[i],i);
            }
            hm.put(string[i], 1);
        }
        if(max_len<curr_len)
        {
            max_len=curr_len;
            prev_substr_start=substr_start;
        }
        System.out.println("the maximum substring without repeating characters is");
        System.out.println(s.substring(prev_substr_start,prev_substr_start+max_len));
        return max_len;


    }
}