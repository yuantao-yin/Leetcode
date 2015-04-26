public class SearchForRange {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        rst.add(-1);
        rst.add(-1);
        if (A == null || A.size() == 0) {
            return rst;
        }
        int start = 0;
        int end = A.size() - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start)/2;
            if (A.get(mid) > target) {
                end = mid;
            } else if (A.get(mid) < target) {
                start = mid;
            } else {
                end = mid; // run to left
            }
        }
        if (A.get(start) == target) {
            rst.set(0, start);
        } else if (A.get(end) == target) {
            rst.set(0, end);
        } else {
            return rst;
        }
        
        start = 0;
        end = A.size() - 1;
        while (start + 1 < end) {
            mid = start + (end - start)/2;
            if (A.get(mid) > target) {
                end = mid;
            } else if (A.get(mid) < target) {
                start = mid;
            } else {
                start = mid; // run to right
            } 
        }
        if (A.get(end) == target) { // must check right first
            rst.set(1, end);
        } else if (A.get(start) == target) {
            rst.set(1, start);
        } else {
            return rst;
        }
        return rst;
    }
}
