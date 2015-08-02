import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Annam on 02-08-2015.
 */
public class RemoveElement {
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
        System.out.println("Enter the number to be deleted");
        int delete=Integer.parseInt(br.readLine());
        int index=removeElement(array,delete);
        System.out.println("after deleting");
        for(int i=0;i<index;i++)
            System.out.println(array[i]);

    }
    public static int removeElement(int[] nums, int val) {
        if(nums.length==0)
            return 0;

        int i=-1,j=0;
        while(j<nums.length)
        {

            if(nums[j]==val)
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
