import java.io.*;


public class InsertionSort {
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
        insertion_sort(array);
        System.out.println("after sort");
        print_array(array);

    }
    public static void insertion_sort(int array[]){
        for(int j=1;j<array.length;j++){
            int key=array[j],i;
            for(i=j-1;i>=0 && array[i]>key;i--) {
                array[i+1]=array[i];
            }
            array[i+1]=key;
        }
    }
    public static void print_array(int array[]){
        for(int i=0;i<array.length;i++)
            System.out.println(array[i]+"\t");
    }
}