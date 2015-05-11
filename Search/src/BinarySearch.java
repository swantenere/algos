import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Annam on 11-05-2015.
 */
//assuming input to be sorted and added no condition for checking that.
public class BinarySearch {

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
        int ind=binary_search_iterative(array,val);
        System.out.println("Binary search iterative-search for val in array yielded "+ind);
        ind=binary_search_recursive(array,0,array.length,val);
        System.out.println("Binary search recursive:search for val in array yielded "+ind);
    }

    public static int binary_search_iterative(int array[],int val)
    {
        int low=0,high=array.length,mid;
        for(mid=(low+high)/2;low<high;)
        {
            if(array[mid]==val)
                return mid;
            else if (val<array[mid])
                high=mid;
            else
                low=mid+1;
            mid=(low+high)/2;
        }
        return -1;
    }

    public static int binary_search_recursive(int array[],int low,int high,int val){
        int mid=(low+high)/2;
        if(low>=high)
            return -1;
        if(array[mid]==val)
            return mid;
        else if(array[mid]>val)
            return binary_search_recursive(array,low,mid,val);
        else
            return binary_search_recursive(array,mid+1,high,val);
    }
}
