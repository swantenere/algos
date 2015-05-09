import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Annam on 05-04-2015.
 */
public class SelectionSort {
    public static void main(String args[]) throws Exception {

        System.out.println("enter the number of elements in the array");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num_elts=Integer.parseInt(br.readLine());
        int array[] = new int[num_elts];
        for(int i=0;i<num_elts;i++)
        {
            System.out.println("enter a number");
            array[i]=Integer.parseInt(br.readLine());
        }
        System.out.println("before sort");
        print_array(array);
        selection_sort(array);
        System.out.println("after sort");
        print_array(array);

    }

    public static void selection_sort(int array[]){
        for(int i=0;i<array.length-1;i++){
            int index=i;
            for(int j=i+1;j<array.length;j++){
                if(array[index]>array[j]){
                    index=j;
                }
            }
            array[i]=array[index];
        }

    }

    public static void print_array(int array[]){
        for(int i=0;i<array.length;i++)
            System.out.println(array[i]+"\t");
    }

}
