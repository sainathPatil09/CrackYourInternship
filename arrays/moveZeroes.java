class Solution {
    public void moveZeroes(int[] nums) {
        
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] == 0){
                int k = i+1;
                while(k<nums.length && nums[k]==0){
                    k++;
                }
                if(k < nums.length){
                    swap(i, k, nums);
                }
            }
        }
    }

    public void swap(int a, int b, int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
