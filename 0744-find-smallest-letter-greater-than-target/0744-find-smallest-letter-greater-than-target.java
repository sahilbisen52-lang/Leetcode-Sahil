class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char res = binarySearch(letters,target);
        return res;

    }

    static char binarySearch(char arr[],char target){
        char ans = '$';
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]<=target){
                start=mid+1;
            }
            else{
                end=mid-1;
                ans=arr[mid];
            }

        }
              return(ans=='$')?arr[0]:ans;
        
        }
}
    