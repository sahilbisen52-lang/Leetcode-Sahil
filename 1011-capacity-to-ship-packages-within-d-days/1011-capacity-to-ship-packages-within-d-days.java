class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = 0;
        int sumWeights = 0;
        
        // 1. Correctly identify the search bounds
        for (int w : weights) {
            maxWeight = Math.max(maxWeight, w);
            sumWeights += w;
        }
        
        int low = maxWeight;
        int high = sumWeights;
        int ans = high;
        
        // 2. Perform Binary Search
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isShipmentPossible(weights, mid, days)) {
                ans = mid;    // Record valid capacity
                high = mid - 1; // Try to find a smaller capacity
            } else {
                low = mid + 1;  // Need a larger capacity
            }
        }
        return ans;
    }
    
    private boolean isShipmentPossible(int[] weights, int capacity, int days) {
        int requiredDays = 1;
        int currentLoad = 0;
        
        for (int w : weights) {
            currentLoad += w;
            // If current load exceeds capacity, start a new day
            if (currentLoad > capacity) {
                requiredDays++;
                currentLoad = w;
            }
        }
        return requiredDays <= days;
    }
}
