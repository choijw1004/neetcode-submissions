class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int left = 0;
        int right = n - 1;
        int cnt = 0;


        while(left <= right){
            int l = people[left];
            int r = people[right];

            if(l + r <= limit){
                left++;
                right--;
                cnt++;
            }
            else{
                right--;
                cnt++;
            }
        }

        return cnt;
    }
}