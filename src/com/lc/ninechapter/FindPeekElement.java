class FindPeekElement {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        int mid = 0;
        int start = 1;
        int end = A.length - 1;
        while (start <= end) {
            mid = start + (end - start)/2;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                return mid;
            } else if(A[mid] > A[mid - 1]) {
                start = mid + 1;    
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
