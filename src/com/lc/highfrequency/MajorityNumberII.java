package com.lc.highfrequency;
import java.util.*;

public class MajorityNumberII {

	public int majorityNumberII(ArrayList<Integer> nums) {
        int candidate1 = 0;
        int count1 = 0;
        int candidate2 = 0;
        int count2 = 0;
        
        for (int i = 0; i < nums.size(); i++) {
        	if (count1 == 0) {
        		candidate1 = nums.get(i);
        		count1++;
        	} else if (candidate1 == nums.get(i)) {
        		count1++;
        	} else if (count2 == 0){
        		candidate2 = nums.get(i);
        		count2++;
        	} else if (candidate2 == nums.get(i)) {
        		count2++;
        	}  else {
        		count1--;
        		count2--;
        	}
        }
        
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.size(); i++) {
        	if (candidate1 == nums.get(i)) {
        		count1++;
        	}
        	if (candidate2 == nums.get(i)) {
        		count2++;
        	}
        }
        return count1 > count2 ? candidate1 : candidate2;
    }
	
}
