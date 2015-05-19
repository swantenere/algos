import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by Annam on 19-05-2015.
 */
public class FindElementsHashMap {
    public static void main(String args[]) throws Exception {

        System.out.println("enter the number of elements in the array");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num_elts=Integer.parseInt(br.readLine()),x;
        int array[] = new int[num_elts+1];
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        for(int i=1;i<=num_elts;i++)
        {
            System.out.println("enter a number");
            array[i]=Integer.parseInt(br.readLine());
            hm.put(array[i],0); //initialize hash map to 0 for the elements in array
        }
        System.out.println("Enter the sum to search for");
        x=Integer.parseInt(br.readLine());
        print_array(array);
        int flag=0;
        for(int i=1;i<=num_elts;i++){
            if((hm.containsKey(x-array[i]))&&(hm.get(array[i])!=1))
            {
                flag=1;
                System.out.println("found pair that add to x :"+array[i]+","+(x-array[i]));
                hm.put(array[i],1);
                hm.put(x-array[i],1);
            }
        }
        if(flag==0){
            System.out.println("No such elements found");
        }

    }

    public static void print_array(int array[]){
        for(int i=1;i<=array.length-1;i++)
            System.out.println(array[i]+"\t");
    }

}
