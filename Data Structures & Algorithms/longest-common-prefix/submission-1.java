class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Arrays.sort(strs, (a,b) -> {
        //     int aLen = a.length();
        //     int bLen = b.length();

        //     return aLen - bLen;
        // });

        String target = strs[0];
        String max = "";

        StringBuilder sb = new StringBuilder();
        
        for(int i = 0 ; i < target.length(); i++){
            sb.append(target.charAt(i));
            boolean isPrefix = true;

            for(int j = 1; j < strs.length; j++){
                String tmp = sb.toString();

                if(!strs[j].startsWith(tmp)){
                    isPrefix = false;
                }
            }

            if(isPrefix){
                max = sb.toString();
            }
        }
        return max;
    }
}