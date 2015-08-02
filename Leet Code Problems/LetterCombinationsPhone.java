import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


/**
 * Created by Annam on 02-08-2015.
 */
public class LetterCombinationsPhone {

    public static void main(String args[])throws Exception
    {
        String digits;
        System.out.println("Enter the digits");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        digits=br.readLine();
        List<String> list= letterCombinations(digits);
        Iterator<String> i=list.iterator();
        while(i.hasNext())
            System.out.println(i.next());
    }

    public static List<String> letterCombinations(String digits) {
        HashMap<Integer,String> combn=new HashMap<Integer,String>();
        combn.put(2,"abc");
        combn.put(3,"def");
        combn.put(4,"ghi");
        combn.put(5,"jkl");
        combn.put(6,"mno");
        combn.put(7,"pqrs");
        combn.put(8,"tuv");
        combn.put(9,"wxyz");
        combn.put(0,"");
        ArrayList <Character> temp=new ArrayList<>();
        ArrayList <String> result=new ArrayList<>();
        if(digits==null||digits.length()==0)
            return result;
        getString(digits,result,temp,combn);
        return result;
    }

    public static void getString(String digits,ArrayList<String> result,ArrayList<Character> temp, HashMap map) {
        if (digits.length() == 0)
        {
            char arr[]=new char[temp.size()];
            for(int i=0;i<temp.size();i++)
                arr[i]=temp.get(i);
            result.add(String.valueOf(arr));
            return;
        }
        Integer number=Integer.valueOf(digits.substring(0,1));
        String letters=(String)map.get(number);
        for(int i=0;i<letters.length();i++){
            temp.add(letters.charAt(i));
            getString(digits.substring(1), result, temp, map);
            temp.remove(temp.size()-1);
        }
    }

}
