import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Annam on 28-05-2015.
 */
public class BubbleSort {
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
        bubble_sort(array);
        System.out.println("after sort");
        print_array(array);

    }
    public static void bubble_sort(int array[]){
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++) {
                if(array[i]>array[j]){
                    int tmp=array[i];
                    array[i]=array[j];
                    array[j]=tmp;
                }
            }
        }
    }
    public static void print_array(int array[]){
        for(int i=0;i<array.length;i++)
            System.out.println(array[i]+"\t");
    }
}
