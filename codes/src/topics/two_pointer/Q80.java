package topics.two_pointer;

public class Q80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        // 前两个不看，直接从index=1之后看
        int index = 1;
        int i = 2;
        while (i < nums.length) {
            if (nums[i] > nums[index - 1]) {
                index++;
                nums[index] = nums[i];
            }
            i++;
        }
        return index + 1;
    }
}
