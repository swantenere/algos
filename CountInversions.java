/**
 * Created by Annam on 28-05-2015.
 */

import java.io.*;

public class CountInversions {
    public static int inversion_count=0;
    public static void main(String args[]) throws Exception{

        System.out.println("enter the number of elements in the array");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num_elts=Integer.parseInt(br.readLine());
        int array[] = new int[num_elts];

        for(int i=0;i<num_elts;i++)
        {
            System.out.println("enter a number");
            array[i]=Integer.parseInt(br.readLine());
        }
        System.out.println("Input array");
        print_array(array);
        int inv_count=count_inversions(array, 0, array.length-1);
        System.out.println("inversion count= "+inv_count);

    }

    public static void print_array(int array[]){
        for(int i=0;i<array.length;i++)
            System.out.println(array[i]+"\t");
    }

    public static int count_inversions(int array[],int left,int right){

        int mid=(left+right)/2;
        if(left>=right)
            return 0;

        count_inversions(array,left,mid);
        count_inversions(array,mid+1,right);
        inversion_count+=merge(array,left,mid,right);
        return inversion_count;
    }

    public static int merge(int array[],int left,int mid,int right){
        int count=0;
        int n1=mid-left+1;
        int n2=right-mid;
        int left_array[]=new int[n1];
        int right_array[]=new int[n2];
        for(int i=0;i<n1;i++)
            left_array[i]=array[left+i];
        for(int j=0;j<n2;j++)
            right_array[j]=array[mid+1+j];
        int i=0,j=0;
        for(int k=left;k<=right;k++){
            if (j>=n2)
            {
                while(i<n1)
                    array[k++]=left_array[i++];
                return count;
            }
            if (i>=n1)
            {
                while(j<n2)
                    array[k++]=right_array[j++];
                return count;
            }

            if((j<n2)&&(left_array[i]>right_array[j])){
                count+=n1-i;
                array[k]=right_array[j];
                j++;
            }
            else {
                array[k]=left_array[i];
                i++;
            }

        }
        return count;
    }


}
