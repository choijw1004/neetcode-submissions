class Solution {
    public int[] productExceptSelf(int[] nums) {
        //0이 두개 이상인 경우
        int[] ans = new int[nums.length];
        int mul = 1;

        //0 위치를 저장하는 인덱스 
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0 ; i < nums.length; i++){
            int num = nums[i];
            if(num == 0) {
                list.add(i);
                continue;
            }
            mul *= num;
        }

        if(list.size() >= 2) return ans;

        //0이 하나인 경우
        if(list.size() == 1){
            ans[list.get(0)] = mul;
            return ans;
        }

        for(int i = 0; i < nums.length; i++){
            ans[i] = mul / nums[i];
        }

        return ans;
        
    }
}  
