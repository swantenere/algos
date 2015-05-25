import com.sorting.MergeSort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Annam on 24-05-2015.
 */
public class ModifiedMergeSortToFindElements {
    public static int array_end;
    public static void main(String args[]) throws Exception {

        System.out.println("enter the number of elements in the array");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num_elts=Integer.parseInt(br.readLine()),x;
        int array[] = new int[num_elts+1];


        for(int i=1;i<=num_elts;i++)
        {
            System.out.println("enter a number");
            array[i]=Integer.parseInt(br.readLine());
        }
        System.out.println("Enter the sum to search for");
        x=Integer.parseInt(br.readLine());
        MergeSort.merge_sort(array, 1, num_elts); //step 1: sort the given array. Time complexity O(nlogn)
        System.out.println("after sort");
        print_array(array);

        System.out.println("after removing duplicates");
        find_and_remove_duplicates(array);
        print_array(array);
        int array_complement[]=new int[array_end+1];
        for(int i=1;i<=array_end;i++){
            array_complement[i]=x-array[i];
        }

        System.out.println("Calculated complement array");
        print_array(array_complement);
        MergeSort.merge_sort(array_complement,1,array_end);
        print_array(array_complement);
        merge_and_print(array,array_complement,x);

    }
    public static void print_array(int array[]){
        for(int i=1;i<=array.length-1;i++)
            System.out.println(array[i]+"\t");
    }

    public static void find_and_remove_duplicates(int array[]){

        System.out.println(array.length);
        int i=1,j=2;
        while(j<=array.length-1){
            if(array[i]==array[j]) {
                System.out.println("found duplicates"+array[i]);
                j++;
            }
            else
            {
                i++;
                array[i]=array[j];
                j++;
            }

        }
        array_end=i;
        System.out.println("array end="+array_end);

    }

    public static void merge_and_print(int left[],int right[],int x)
    {
        int p=1,q=1,flag=0;
        while((p<array_end)&&(q<=array_end/2))
        {
            if(left[p]==right[q])
            {
                if(!(left[p]==(x-left[p])))
                System.out.println("found pairs that add up to "+x+": "+left[p]+" , "+(x-left[p]));
                p++;
                q++;
                flag=1;
            }
            else if(left[p]<right[q])
                p++;
            else
                q++;
        }
        if(flag==0)
            System.out.println("No such pairs found");


    }

}
