
//https://leetcode.com/problems/find-target-indices-after-sorting-array/

/*
/*   left <= right, is proper to minimise the range of sorted data
 */

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {

        Arrays.sort(nums);
        int l = 0; int h = nums.length -1;

        //lower bound, upper bound basic writing

        // l is the first element equal or bigger than target
        while( l <= h){

            int mid = l  + ( h -l )/2;


            // moving left position , get closer to target, so left is lowerbound
            if (nums[mid] < target){
                l = mid + 1;
            }else{
                h = mid -1;
            }
        }

        int l1 = 0; int h1 = nums.length -1;

        while( l1 <= h1){

            int mid = l1 + (h1 - l1)/2;

            //moving right position. get closer to target, so righth is the upper bound
            if (nums[mid] > target){
                h1 = mid  -1;
            }else{
                l1 = mid + 1;
            }
        }


        List<Integer> ret = new ArrayList<>();


        for( int i = l; i <=h1; i++){
            if (nums[i] == target) ret.add(i);
        }
        return ret;
    }
}

