import java.util.*;

class MedianOfTwoSortedArrays {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        List<Integer> list = new ArrayList<Integer>();
        int a = A.length-1;
        int b = B.length-1;
        while(a>=0 && b>=0)
        {
            if(A[a]<=B[b])
            {
                list.add(B[b--]);
            }
            else
            {
                list.add(A[a--]);
            }
        }
        
        while(a>=0)
        {
            list.add(A[a--]);
        }
        while(b>=0)
        {
            list.add(B[b--]);
        }
        if(list.size() >1)
        {
            return (list.get(list.size() >>1) + list.get((list.size()-1) >>1))/2.0;
        }
        else{
            return list.get(0);
        }
    }
}

