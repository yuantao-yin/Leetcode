public class RemoveElement {
    /** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int i = 0;
        int pointer = A.length - 1;
        while (i <= pointer) {
            if (A[i] == elem) {
                // if find the occurance, we know A[i] need to be removed. Here we override the A[i] with pointer's value. 
                // And we will continue check until it doesn't equal to elem
                A[i] = A[pointer];
                pointer--;
            } else {
                i++;
            }
        }
        return pointer+1;
    }
}
