import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * Created by Annam on 19-07-2015.
 */
public class MedianTwoSortedArrayUsingMerge {
    public static void main(String args[])throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of elements in array 1");
        int num_array1=Integer.parseInt(br.readLine());
        int array1[]=new int[num_array1];
        for(int i=0;i<num_array1;i++) {
            System.out.println("Enter a value ");
            array1[i]=Integer.parseInt(br.readLine());
        }

        System.out.println("Enter the number of elements in array 2");
        int num_array2=Integer.parseInt(br.readLine());
        int array2[]=new int[num_array2];
        for(int i=0;i<num_array2;i++) {
            System.out.println("Enter a value ");
            array2[i]=Integer.parseInt(br.readLine());
        }

        double median=findMedianSortedArrays(array1,array2);
        System.out.println("median ="+median);

    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        if((n1==0)&&(n2==0))
            return 0;
        int median_pos,flag=0;
        if((n1+n2-1)%2==0)
         median_pos=(n1+n2-1)/2;//odd number of elements
        else {
            median_pos = (n1 + n2) / 2; //even number of elements take average of two
            flag=1;
        }

        int start=0,array_left=0,array_right=0,prev_val=0;
        double median=0;
        while(start<=median_pos)
        {
            if(array_left>=n1)
            {
                if(start==median_pos){
                    if (flag != 1) {
                        median = nums2[array_right];
                         break;
                    }
                    else {
                        median = (double)((nums2[array_right]) + prev_val) / 2;

                        break;
                    }
                }
                prev_val=nums2[array_right];
                array_right++;
                start++;
                continue;

            }
            if(array_right>=n2)
            {
                if(start==median_pos){
                   if (flag != 1) {
                       median = nums1[array_left];
                       break;
                    }
                   else {
                        median =(double) ((nums1[array_left]) + prev_val) / 2;
                        break;
                   }
                }
                prev_val=nums1[array_left];
                array_left++;
                start++;
                continue;
            }
            if(nums1[array_left]<nums2[array_right])
            {
                if(start==median_pos) {
                    if (flag != 1) {
                        median = nums1[array_left];
                        break;
                    } else {
                        median=(double)(nums1[array_left]+prev_val)/2;
                        break;
                    }
                }
                prev_val=nums1[array_left];
                array_left++;
                start++;
            }
            else
            {
                if(start==median_pos){
                if (flag != 1) {
                    median = nums2[array_right];
                    break;
                } else {
                    median=(double)(prev_val+nums2[array_right])/2;
                    break;
                }
            }
                prev_val=nums2[array_right];
                array_right++;
                start++;

            }
        }

        return median;
    }
}
