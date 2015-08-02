import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

/**
 * Created by Annam on 02-08-2015.
 */
public class FourSum {

    public static void main(String args[]) throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=0;
        System.out.println("Enter the number of integers");
        num=Integer.parseInt(br.readLine());
        int arr[]=new int[num];
        for(int i=0;i<num;i++)
        {
            System.out.println("Enter a number");
            arr[i]=Integer.parseInt(br.readLine());
        }
        System.out.println("Enter the targer");
        int target=Integer.parseInt(br.readLine());
        List<ArrayList<Integer>> solution=fourSum(arr, target);
        Iterator iterator=solution.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());

    }
    public static List<ArrayList<Integer>> fourSum(int[] nums, int target) {
        List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        HashMap<ArrayList<Integer>,Integer> map=new HashMap<>();
        if (nums.length < 4)
            return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++)
        {
            for(int j=i+1;j<nums.length-2;j++)
            {
                int left=j+1;
                int right=nums.length-1;
                while(left<right)
                {
                    if(nums[i]+nums[j]+nums[left]+nums[right]==target)
                    {
                        ArrayList<Integer> temp=new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        if(map.get(temp)==null) {
                            result.add(temp);
                            map.put(temp,1);
                        }
                        left++;
                        right--;
                    }
                    else if(nums[i]+nums[j]+nums[left]+nums[right]<target)
                    {
                        left++;

                    }
                    else
                        right--;
                }
            }
        }
        return result;
    }
}
