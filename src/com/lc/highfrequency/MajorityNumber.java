package com.lc.highfrequency;
import java.util.*;

public class MajorityNumber {

	public int majorityNumber(ArrayList<Integer> nums) {
        int candidate = 0;
        int count = 0;
        
        for (int i = 0; i < nums.size(); i++) {
        	if (count == 0) {
        		candidate = nums.get(i);
        		count++;
        	} else if(candidate == nums.get(i)) {
        		count++;
        	} else {
        		count--;
        	}
        }
        return candidate;
    }
	
}
