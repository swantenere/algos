import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Annam on 01-08-2015.
 */
public class ThreeSumSolution1 {// sort and parse the array with two pointers for solution

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

        ArrayList<ArrayList<Integer>> list=threeSum(array);


    }
    public static ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
        ArrayList<ArrayList<Integer>> ret=new ArrayList<ArrayList<Integer>>();

        if(nums.length<3)
            return ret;
        Arrays.sort(nums);
        int a,b=0,c=0,left,right;
        for(int i=0;i<=nums.length-3;i++)
        {
            a=nums[i];
            left=i+1;
            right=nums.length-1;
//            System.out.println("a="+a+"visited?"+visited.get(a));
            if(i==0||a>nums[i-1]) {
                while (left < right) {
                    b = nums[left];
                    c = nums[right];
                    if (a + b + c == 0) {


                        System.out.println("Solution :" + a + "," + b + "," + c);
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(a);
                        temp.add(b);
                        temp.add(c);
                        ret.add(temp);
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) {

                            left++;
                        }

                        while (left < right && nums[right] == nums[right+ 1])
                            right--;


                    } else if (a + b + c > 0)
                        right = right - 1;
                    else
                        left = left + 1;
                }
            }

        }
        return ret;
    }
}
