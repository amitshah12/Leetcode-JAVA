// Method-1
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int idx = m+n-1;

        while(i>=0 && j>=0){
            if(nums1[i] > nums2[j]){
                nums1[idx--] = nums1[i--];
            } else {
                nums1[idx--] = nums2[j--];
            }
        }

        while(j>=0){
            nums1[idx--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;

        int[] nums2 = {2,5,6};
        int n = 3;

        Solution obj = new  Solution();
        obj.merge(nums1, m, nums2, n);

        System.out.print("Output: {");
        for(int i=0; i<nums1.length; i++){
            System.out.print(nums1[i]);
            if(i<nums1.length-1){
                System.out.print(",");
            }
        }
        System.out.println("}");
    }
}

// Method-2
// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         int c = 0;

//         for(int i=0; i<m; i++){
//             nums1[c] = nums1[i];
//             c++;
//         }
//         for(int j=0; j<n; j++){
//             nums1[c] = nums2[j];
//             c++;
//         }

//         Arrays.sort(nums1);
//     }
// }