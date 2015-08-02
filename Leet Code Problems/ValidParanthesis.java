import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Annam on 02-08-2015.
 */
public class ValidParanthesis {

    public static void main(String args[])throws Exception
    {
        String s;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the string");
        s=br.readLine();
        boolean valid=isValid(s);
        System.out.println("paranthesis match?"+valid);
    }


    public static boolean isValid(String s) {
        HashMap<Character,Character> map=new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        if(s.length()==0||s.length()==1)
            return false;
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            Character c=s.charAt(i);
            if(map.values().contains(c))
                stack.push(c);
            else
                if(map.keySet().contains(c)&&(!stack.empty())&&(stack.peek()==map.get(c)))
                    stack.pop();
                else
                    return false;
        }
        if(stack.empty())
            return true;
        else
            return false;
    }
}
