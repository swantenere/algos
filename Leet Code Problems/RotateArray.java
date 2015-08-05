import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Annam on 05-08-2015.
 */
public class RotateArray {

    public static void main(String args[])throws Exception
    {
        int num=0;
        System.out.println("Enter the number of elements");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        num=Integer.parseInt(br.readLine());
        int arr[]=new int[num];
        for(int i=0;i<num;i++)
        {
            System.out.println("Enter the value in array");
            arr[i]=Integer.parseInt(br.readLine());
        }
        int k;
        System.out.println("Enter the rotation factor");
        k=Integer.parseInt(br.readLine());
        rotate(arr,k);
        print_array(arr);
    }
    public static void print_array(int arr[])
    {
        System.out.println();
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }

    public static void rotate(int[] nums, int k) {
        if(nums.length==0||k<0) {
            System.out.println("enter valid arguments");
            return;
        }
        if(k>nums.length)
            k=k%nums.length;

        reverse(nums, 0, nums.length - k-1);
        reverse(nums,nums.length-k,nums.length-1);
        reverse(nums, 0, nums.length-1);
    }

    public static void reverse(int arr[],int left,int right)
    {
        if(arr==null||arr.length==1)
            return;
        while(left<right)
        {
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            right--;
            left++;
        }
    }
}
