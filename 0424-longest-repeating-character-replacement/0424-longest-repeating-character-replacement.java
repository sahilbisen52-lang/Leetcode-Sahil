class Solution {
    public int characterReplacement(String s, int k) {
        int [] charCounts=new int[26];
        int maxfreq=0;
        int maxlength=0;
        int left=0;
        for(int right=0;right<s.length();right++){
            char currentletter=s.charAt(right);
            charCounts[currentletter-'A']++;

            maxfreq=Math.max(maxfreq,charCounts[currentletter-'A']);

            while((right-left+1)-maxfreq>k){
                char leftletter=s.charAt(left);
                charCounts[leftletter-'A']--;
                left++;

            }       
            maxlength=Math.max(maxlength,right-left+1); 
        }
        return maxlength;
        
    }
}