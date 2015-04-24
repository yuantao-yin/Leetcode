public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: The recovered sorted array
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
    /** The key to the problem is to reverse the list in three steps. 
     *  Take the example of [4, 5, 1, 2, 3]. 
     *  Step 1: [4, 5]  -> [5, 4]
     *  Step 2: [1, 2, 3] -> [3, 2, 1]
     *  Step 3: [5, 4, 3, 2, 1] -> [1, 2, 3, 4, 5]
     */  
        if (nums == null || nums.size() == 0) {
            return;
        }
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                reverse(nums, 0, i);
                reverse(nums, i+1, nums.size() - 1);
                reverse(nums, 0, nums.size() - 1);
            }
        }
    }
    
    private void reverse(ArrayList<Integer> nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int tmp = nums.get(i);
            nums.set(i,nums.get(j));
            nums.set(j, tmp);
        }
    }
}
