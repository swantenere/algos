import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.sorting.*;

/**
 * Created by Annam on 12-05-2015.
 */

//problem definition: Find two elements in an array that add up to x
public class SortAndFind {

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
            search_sum(array,x);//step 2: Search the array for the sum , using two pointers. Time Complexity O(n)

        }
        public static void print_array(int array[]){
            for(int i=1;i<=array.length-1;i++)
                System.out.println(array[i]+"\t");
        }

        public static void search_sum(int array[],int x)
        {
            int left=1,right=array.length-1;
            while(left<right){
                if(array[left]+array[right]==x) {
                    System.out.println("Found numbers that add up to " +x+" they are: "+ array[left] + "," + array[right]);
                    return;
                }
                else if(array[left]+array[right]>x)
                    right=right-1;

                else
                    left=left+1;

            }
            System.out.println("no such values found");

        }




}
