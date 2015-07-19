import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;

/**
 * Created by Annam on 19-07-2015.
 */
public class MaximumSubArrayKadane {
        public static void main(String args[])throws Exception {
            int num_elts;
            System.out.println("Enter the number of elements in the array");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            num_elts = Integer.parseInt(br.readLine());
            int array[] = new int[num_elts];
            for (int i = 0; i < num_elts; i++)
            {
                System.out.println("Enter a value");
                array[i]=Integer.parseInt(br.readLine());
            }
            int max=maxSubArray(array);
            System.out.println("max sum="+max);
        }
        public static int maxSubArray(int[] nums) {
            if(nums.length==0)
                return 0;
            int curr_max=0,max_sum=nums[0];
            for(int i=0;i<nums.length;i++)
            {
                curr_max=nums[i]+curr_max;
                if(curr_max<0)
                    curr_max=0;
                if((max_sum<curr_max)&&(curr_max!=0))
                    max_sum=curr_max;
            }
            if(max_sum<0)
                max_sum=find_max(nums);
            return max_sum;

        }
        public static int find_max(int array[])
        {
            int max=array[0];
            for(int i=1;i<array.length;i++)
            {
                if(array[i]>max)
                    max=array[i];
            }
            return max;
        }



}
