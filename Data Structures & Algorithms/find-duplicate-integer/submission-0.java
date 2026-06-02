class Solution {

    /*
    think of the value of each index as the "next" node
    */
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do{
            slow = nums[slow]; //slow = slow.next
            fast = nums[nums[fast]]; //fast = fast.next.next
        } while(slow !=fast);

        int ptr1 = nums[0];
        int ptr2 = slow;
        
        while(ptr1 != ptr2){
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;
    }
}
