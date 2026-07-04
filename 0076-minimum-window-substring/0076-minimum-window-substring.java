class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        
        // 1. The Setup
        int[] targetCount = new int[128];
        int need = 0;
        for (char c : t.toCharArray()) {
            if (targetCount[c] == 0) need++; // Count unique characters needed
            targetCount[c]++;
        }
        
        int[] windowCount = new int[128];
        int have = 0;
        
        int minLength = Integer.MAX_VALUE;
        int minLeft = 0; // To reconstruct the string at the end
        int left = 0;
        
        // 2. The Engine
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            windowCount[rightChar]++;
            
            // If this character is on the checklist and we hit the exact quota
            if (targetCount[rightChar] > 0 && windowCount[rightChar] == targetCount[rightChar]) {
                have++;
            }
            
            // 3. THE ALARM RINGS! The window has everything we need.
            while (have == need) {
                // Record the new low score
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minLeft = left;
                }
                
                // The Bulldozer kicks the back character out
                char leftChar = s.charAt(left);
                windowCount[leftChar]--;
                
                // If we dropped a required character below its quota, we lose a 'have'
                if (targetCount[leftChar] > 0 && windowCount[leftChar] < targetCount[leftChar]) {
                    have--;
                }
                
                left++; // Bulldozer steps forward
            }
        }
        
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }
}