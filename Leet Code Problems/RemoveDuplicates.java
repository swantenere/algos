import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Annam on 02-08-2015.
 */
public class RemoveDuplicates {
    public static void main(String args[])throws Exception
    {
        int num;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of integers");
        num=Integer.parseInt(br.readLine());
        int array[]=new int[num];
        for(int i=0;i<num;i++) {
            System.out.println("Enter a number");
            array[i]=Integer.parseInt(br.readLine());
        }
        int after_duplicate_removal=removeDuplicates(array);
        System.out.println("after removing duplicates");
        for(int i=0;i<after_duplicate_removal;i++)
            System.out.println(array[i]);

    }
    public static int removeDuplicates(int[] nums) {
        if(nums.length==0)
            return 0;
        int i=0,j=1;
        while(j<nums.length)
        {
            if(nums[i]==nums[j])
                j++;
            else
            {
                i++;
                nums[i]=nums[j];
                j++;
            }
        }
        return i+1;

    }
}
