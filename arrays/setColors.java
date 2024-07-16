    class Solution {
        public void sortColors(int[] nums) {
            
            int z = 0;
            int i = 0;
            int j = nums.length-1;

            while(i <= j){
                if(nums[i] == 0){
                    swap(nums, i, z);
                    i++;
                    z++;
                }
                else if(nums[i] == 1){
                    i++;
                }
                else{
                    swap(nums, i, j);
                    j--;
                }
            }
        }

        public void swap(int[] nums, int a, int b){
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }


