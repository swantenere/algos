import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Annam on 01-08-2015.
 */
public class ThreeSumClosest {

    public static void main(String args[])throws Exception{
        int num;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of integers");
        num=Integer.parseInt(br.readLine());
        int array[]=new int[num];
        for(int i=0;i<num;i++) {
            System.out.println("Enter a number");
            array[i]=Integer.parseInt(br.readLine());
        }
        int target;
        System.out.println("Enter the target");
        target=Integer.parseInt(br.readLine());
        int closest_sum=threeSumClosest(array,target);
        System.out.println("closest sum="+closest_sum);
    }

    public static int threeSumClosest(int[] nums, int target) {
        if(nums.length<3)
            return 0;
        int closest_sum_so_far=0,min_diff=Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++)
        {
            int a=nums[i];
            int left=i+1;
            int right=nums.length-1;

            while(left<right)
            {
                int b=nums[left];
                int c=nums[right];
                int diff=target-(a+b+c);

                if(diff<0)
                    diff=diff*-1;

                if(diff<min_diff) {
                    min_diff=diff;
                    closest_sum_so_far = a+b+c;
                }

                if(a+b+c<target) {
                    left++;

                }
                else {
                    right--;

                }
            }

        }
        return closest_sum_so_far;
    }
}
