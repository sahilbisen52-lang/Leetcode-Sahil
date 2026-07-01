/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        
        // 1. Find the peak index
        int start = 0, end = n - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        int peak = start;

        // 2. Binary search in the increasing part (0 to peak)
        int res = binarySearch(mountainArr, target, 0, peak, true);
        if (res != -1) return res;

        // 3. Binary search in the decreasing part (peak+1 to n-1)
        return binarySearch(mountainArr, target, peak + 1, n - 1, false);
    }

    private int binarySearch(MountainArray mountainArr, int target, int start, int end, boolean ascending) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int cur = mountainArr.get(mid);
            if (cur == target) return mid;
            
            if (ascending) {
                if (cur < target) start = mid + 1;
                else end = mid - 1;
            } else {
                // In decreasing part, swap logic
                if (cur > target) start = mid + 1;
                else end = mid - 1;
            }
        }
        return -1;
    }
}