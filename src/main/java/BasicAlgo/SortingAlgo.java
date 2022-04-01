import java.util.Arrays;


/** BUBBLE SORT [STARTING]*/

/** bubble sort-> https://www.programiz.com/dsa/bubble-sort */
//bubble sort is about comparing each item with its adjecent item.
//so the number of loop required is n-1
//and j will go up to n-i-1 (becuse in each loop of i we will get the highest item in the last)
/*public class SortingAlgo {

    void bubbleSort(int arr[]){
        int n = arr.length;
        for (int i =0; i<n-1; i++){
            for (int j=0; j<n-i-1; j++){
                if (arr[j]> arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String args[]){
        SortingAlgo sortingAlgo = new SortingAlgo();
        int arr[] = {64, 34, 25, 12, 22, 11, 90};
        sortingAlgo.bubbleSort(arr);
        System.out.println("output of bubble sort is");
        System.out.println(Arrays.toString(arr));
    }
}*/
//the above algorithm will complete its loop without knowing that is sorting completed before...
//so lets discuss that if the swap doesnt required in a loop, it means sorting done, no need to call the next loop

/*public class SortingAlgo {

    void bubbleSort(int arr[]){
        int n = arr.length;
        for (int i =0; i<n-1; i++){
            boolean swapped = false;
            for (int j=0; j<n-i-1; j++){
                if (arr[j]> arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped){
                break;
            }
        }
    }

    public static void main(String args[]){
        SortingAlgo sortingAlgo = new SortingAlgo();
        int arr[] = {64, 34, 25, 12, 22, 11, 90};
        sortingAlgo.bubbleSort(arr);
        System.out.println("output of bubble sort is");
        System.out.println(Arrays.toString(arr));
    }
}*/

/**
BUBBLE SORT [END]
*/

/** MERGE SORT[STARTING]
 *https://drive.google.com/file/d/1meJu99A8-0O3PRnOqF66vw5lw8wz2MMi/view
 * https://www.interviewbit.com/tutorial/merge-sort-algorithm/
 */
/*public class SortingAlgo {

    void merge(int[] arr, int si, int mid, int ei){
        int[] merged = new int[ei-si+1]; //temporary list
        int i = si;
        int j = mid+1;
        int k = 0;
        System.out.println("si, mid, ei "+si+", "+mid+", "+ei);

        while (i<=mid && j<=ei){
            if (arr[i]<=arr[j]){
                merged[k] = arr[i];
                k++;
                i++;
            }else {
                merged[k] = arr[j];
                k++;
                j++;
            }
        }

        while (i<= mid){
            merged[k]= arr[i];
            k++;
            i++;
        }
        while (j<= ei){
            merged[k] = arr[j];
            k++;
            j++;
        }


        System.out.println("merged array is "+Arrays.toString(merged));
        for (int m = 0, n= si; m<merged.length; m++, n++ ){ //saving the sorted temp list into main list
            arr[n] = merged[m];
        }
        System.out.println(Arrays.toString(merged));
    }


    void mergeSort(int[] arr, int si, int ei){
      if (si>=ei){
          return;
      }
      int mid = (si+ei)/2;
      mergeSort(arr, si, mid);//first half //recursion
      mergeSort(arr, mid+1, ei);//second half //recursion
      merge(arr, si, mid, ei); //merge fun
    }

    private void printArray(int[] arr) {
        System.out.println("final array is "+Arrays.toString(arr));
    }

    public static void main(String args[]){
        SortingAlgo sortingAlgo = new SortingAlgo();
        int[] arr = {6,5,12,18,62, 10,13, 19, 9,1, 15, 34};
        sortingAlgo.mergeSort(arr, 0, arr.length-1);
        sortingAlgo.printArray(arr);
    }
}*/

/**MERGE SORT[END]*/

/**SELECTION SORT[STARTING]*/
//https://www.programiz.com/dsa/selection-sort
/*
selectionSort(array, size)
        repeat (size - 1) times
        set the first unsorted element as the minimum
        for each of the unsorted elements
        if element < currentMinimum
      set element as new minimum
              swap minimum with first unsorted position
              end selectionSort
              */

/*
public class SortingAlgo {
    private void selectionSort(int[] arr) {
        for (int i= 0; i<arr.length-1; i++){//number of loops of iteration
            int minPosition= i;
            for (int j=i; j<arr.length; j++){
               if (arr[j]<arr[minPosition]){
                   minPosition = j;
               }
            }
            //swap the position now
            int temp = arr[i];
            arr[i] = arr[minPosition];
            arr[minPosition] = temp;
        }
    }


    public static void main(String args[]){
        SortingAlgo sortingAlgo = new SortingAlgo();
        int[] arr = {20, 12, 10, 15, 2};
        sortingAlgo.selectionSort(arr);
        System.out.println("sorted array is "+Arrays.toString(arr));
    }


}
*/
/**SELECTION SORT[END]*/

/**
INSERTION SORT[START]
*/


















