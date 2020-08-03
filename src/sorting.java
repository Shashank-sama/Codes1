import java.util.*;


public class sorting {

    public static void main(String[] args) {


        Scanner sc=new Scanner(System.in);

        int arr[]={10,9,8,7,6,5,4,3,2,1};

        QuickSort(arr,0,arr.length-1);
        System.out.println("\nQuick sort :");
        print_array(arr);

        MergeSort(arr,0,arr.length-1);
        System.out.println("\nMerge sort :");
        print_array(arr);

        BubbleSort(arr);
        System.out.println("\nBubble sort :");
        print_array(arr);

        SelectionSort(arr);
        System.out.println("\nSelection sort :");
        print_array(arr);

        InsertionSort(arr);
        System.out.println("\nInsertion sort :");
        print_array(arr);
    }

    //___________________________________________________________________________________________________
    //Printing array

    static  void print_array(int[] arr){
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+", ");
    }

    //_____________________________________________________________________________________________________
    //Quick Sort

    static void QuickSort(int[] arr,int low, int high) {

        if(low<high) {
            int pivot = partition(arr, low, high);

            QuickSort(arr, low, pivot - 1);
            QuickSort(arr, pivot + 1, high);

        }

    }

    //Partition for QuickSort
    static int partition(int[] arr, int low, int high) {

        int pivot=arr[high];        //pivot as last element
        int ind=low-1;
        for(int i=low;i<high;i++)
        {
            if(arr[i]<pivot)
            {
                ++ind;
                int temp=arr[ind];
                arr[ind]=arr[i];
                arr[i]=temp;
            }
        }

        int temp = arr[ind+1];
        arr[ind+1] = arr[high];
        arr[high] = temp;

        return ind+1;
    }

    //_____________________________________________________________________________________________________-

    //Merge Sort

    static void MergeSort(int[] arr,int left, int right) {


        if(left<right) {
            int mid = left + (right - left) / 2;


            MergeSort(arr, left, mid);
            MergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    //merge for MergeSort

    static void merge(int[] arr, int l, int m, int r) {
        int n1=m-l+1;
        int n2=r-m;
        int[] L=new int[n1];
        int[] R=new int[n2];

        for(int i=0;i<n1;i++)
            L[i]=arr[l+i];
        for(int i=0;i<n2;i++)
            R[i]=arr[m+1+i];

        int i=0,j=0,k=l;
        while(i<n1&&j<n2)
        {
            if(L[i]<=R[j])
            {
                arr[k]=L[i];
                ++i;
            }
            else
            {
                arr[k]=R[j];
                ++j;
            }
            ++k;
        }

        while(i<n1)
        {
            arr[k]=L[i];
            ++i;
            ++k;
        }
        while(j<n2)
        {
            arr[k]=R[j];
            ++j;
            ++k;
        }
    }

    //___________________________________________________________________________________________________
    //Bubble Sort

    static void BubbleSort(int[] arr) {
        int n=arr.length;
        for(int i=0;i<n-1;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int t=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=t;
                }
            }
        }
    }

    //__________________________________________________________________________________________________

    //Selection Sort

    static void SelectionSort(int[] arr) {
        int n=arr.length;
        for(int i=0;i<n-1;i++)
        {
            int min_ind=i;
            for(int j=i+1;j<n;j++)
            {
                if(arr[j]<arr[min_ind])
                    min_ind=j;

            }
            int t=arr[i];
            arr[i]=arr[min_ind];
            arr[min_ind]=t;
        }
    }

    //________________________________________________________________________________________________________
    //Insertion Sort

    static  void  InsertionSort(int[] arr) {
        int n=arr.length;
        for(int i=1;i<n;i++)
        {
            int j=i-1;
            int x=arr[i];
            while(j>=0&&arr[j]>x)
            {
                arr[j+1]=arr[j];
                --j;
            }
            arr[j+1]=x;
        }
    }

    //____________________________________________________________________________________________________________

}
