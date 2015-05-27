import com.sorting.MergeSort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Annam on 26-05-2015.
 */
public class SortAndSearch {


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
            for(int i=1;i<array.length;i++)
            {
                boolean complement_search=binary_search_recursive(array,1,array.length,(x-array[i]));
                if((complement_search)&&(array[i]<(x-array[i])))
                    System.out.println("Found values that add up to x:"+array[i]+","+(x-array[i]));
            }

        }
        public static void print_array(int array[]){
            for(int i=1;i<=array.length-1;i++)
                System.out.println(array[i]+"\t");
        }

        public static boolean binary_search_recursive(int array[],int low,int high,int val){
            int mid=(low+high)/2;
            if(low>=high)
                return false;
            if(array[mid]==val)
                return true;
            else if(array[mid]>val)
                return binary_search_recursive(array,low,mid,val);
            else
                return binary_search_recursive(array,mid+1,high,val);
        }
    }

