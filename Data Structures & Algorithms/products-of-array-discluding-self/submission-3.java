class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prd = 1;
        boolean flag = false;
        int[] arr = new int[nums.length];
        for(int i = 0; i<nums.length; i++){

            for(int j = 0; j<nums.length; j++){
                 if(i==j){
                    continue;
                }
                prd *= nums[j];
                flag = true;
            }
            if(flag)
                arr[i] = prd;
            prd = 1;
            flag = false;
        }
        return arr;
    }
}  
