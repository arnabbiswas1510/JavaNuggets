package dsaPrateek.lecture6ArraysII;

public class MaxOfNeighbor {
    public int findPeakElement(int[] a) {
        int low = 0,high = a.length-1;
        if(a.length == 1) return 0; // if there is single element
        if(a.length == 2){ //2 elements
            if(a[0] > a[1]){
                return 0;
            }else{
                return 1;
            }
        }
        while(low<high){
            int  mid = (low+high)/2;
            if(mid == 0) return 0;
            if((a[mid] > a[mid+1]) && ( a[mid] > a[mid-1])) // if the middle element value is more than neighbour
                return mid;
            if(a[mid] > a[mid+1]){
                high = mid;

            }else{
                low = mid+1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        MaxOfNeighbor max = new MaxOfNeighbor();
        int[] a = {3,1,2};
        System.out.println ("Max Element Index is :"+max.findPeakElement(a));
    }
}