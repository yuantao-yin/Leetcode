package com.lc.ladder.us.binarysearch;

public class SearchInsertPosition {
	
	// standard template
	public int searchInsert(int[] A, int target) {
        int l = 0;
        int r = A.length-1;
        while(l<=r)
        {
            int mid = (l+r)/2;
            if(A[mid]==target)
                return mid;
            if(A[mid]<target)
                l = mid+1;
            else
                r = mid-1;
        }
        return l;
    }


}
