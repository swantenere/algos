import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.*;

/**
 * Created by Annam on 22-07-2015.
 */
public class AnagramsList {
    public static void main(String args[])throws Exception {
        int num=0;
        System.out.println("Enter the number of strings");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num=Integer.parseInt(br.readLine());
        String arr[] = new String[num];
        for (int i = 0; i < num; i++) {
            System.out.println("Enter the string");
            arr[i] = br.readLine();
        }
        List<String> anagrams_list = anagrams(arr);
        Iterator<String> iterator = anagrams_list.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }

    }
    public static List<String> anagrams(String[] strs) {

        HashMap<String,LinkedList<String>>anagrams_list=new HashMap<>();
        for(int i=0;i<strs.length;i++) {
            String str = strs[i];
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sorted_string = String.valueOf(arr);
            if (anagrams_list.containsKey(sorted_string)) {
                anagrams_list.get(sorted_string).add(str);
            } else {
                LinkedList<String> l = new LinkedList<>();
                l.add(str);
                anagrams_list.put(sorted_string, l);
            }
        }
            List<String> ret=new LinkedList<>();
            for(LinkedList<String>list:anagrams_list.values())
            {
                if(list.size()>1)
                    ret.addAll(list);
            }
            return ret;

        }

}
