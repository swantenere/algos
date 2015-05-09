import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Annam on 05-04-2015.
 */
public class LinearSearch {

    public static void main(String args[]) throws Exception{
        int num,value;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of elements");
        num=Integer.parseInt(br.readLine());
        int array[]=new int[num];
        for(int i=0;i<num;i++)
        {
            System.out.println("Enter a number");
            array[i]=Integer.parseInt(br.readLine());
        }
        System.out.println("Enter the value to search");
        int val=Integer.parseInt(br.readLine());
        int ind=linear_search(array,val);
        System.out.println("search for val in array yielded "+ind);

    }
    public static int linear_search(int array[],int val){

        for(int i=0;i<array.length;i++)
        {
         if(array[i]==val)
             return i;
        }
        return -1;
    }


}
