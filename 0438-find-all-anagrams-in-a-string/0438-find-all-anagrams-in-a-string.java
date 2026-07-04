class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result=new ArrayList<>();
        if(s.length()<p.length()){
            return result;
        }
            int[] pcount=new int[26];
            int[] windowcount=new int[26];
            for(int i=0;i<p.length();i++){
                pcount[p.charAt(i)-'a']++;
                }

                int left=0;
                for(int right=0;right<s.length();right++){
                   char currentletter=s.charAt(right);
                   windowcount[currentletter-'a']++;

                   if(right-left+1==p.length()){
                    if(Arrays.equals(pcount,windowcount)){
                        result.add(left);
                    }
                    char leftletter=s.charAt(left);
                    windowcount[leftletter-'a']--;
                    left++;
                   }
                }
        return result;
    }
}