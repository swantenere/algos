import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Annam on 07-05-2015.
 */
public class MergeSort {

    public static void main(String args[]) throws Exception {

        System.out.println("enter the number of elements in the array");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num_elts=Integer.parseInt(br.readLine());
        int array[] = new int[num_elts+1];
        for(int i=1;i<=num_elts;i++)
        {
            System.out.println("enter a number");
            array[i]=Integer.parseInt(br.readLine());
        }
        System.out.println("before sort");
        print_array(array);
        merge_sort(array,1,num_elts);
        System.out.println("after sort");
        print_array(array);

    }
    public static void print_array(int array[]){
        for(int i=1;i<=array.length-1;i++)
            System.out.println(array[i]+"\t");
    }

    public static void merge_sort(int array[],int p, int r){

        if(p<r){
          int  q=(p+r)/2;
          merge_sort(array, p, q);
          merge_sort(array,q+1,r);
          merge(array,p,q,r);
        }
    }
    public static void merge(int array[],int p,int q,int r){

        int n1=q-p+1;
        int n2=r-q,i,j;
        int left[]=new int[n1+1],right[]=new int[n2+1];
        for( i=1;i<=n1;i++){
            left[i]=array[p+i-1];
        }
        for(j=1;j<=n2;j++){
            right[j]=array[q+j];
        }
        System.out.print("left array");
        print_array(left);
        System.out.print("right array");
        print_array(right);
        i=1;j=1;
        for(int k=p;k<=r;k++){
            if(j>n2||i<=n1&&left[i]<=right[j])
            {
                array[k]=left[i];
                i++;

            }
            else
            {
                array[k]=right[j];
                j++;

            }
        }
    }
}

