n-sum问题包括2sum，3sum，4sum。。。等问题，这些问题可以分成两步来解决：

1. 把n-sum转化为n-1 sum问题，直到变成2sum问题
2. 解决2sum问题。

## 1. Two Sum

### 问题

Given an array of integers `nums` and an integer `target`, return *indices of the two numbers such that they add up to `target`*.

You may assume that each input would have **exactly one solution**, and you may not use the *same* element twice.

You can return the answer in any order.

**Example 1:**

```
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
```

**Example 2:**

```
Input: nums = [3,2,4], target = 6
Output: [1,2]
```

**Example 3:**

```
Input: nums = [3,3], target = 6
Output: [0,1]
```

**Constraints:**

- `2 <= nums.length <= 104`
- `-109 <= nums[i] <= 109`
- `-109 <= target <= 109`
- **Only one valid answer exists.**

**Follow-up:** Can you come up with an algorithm that is less than `O(n2) `time complexity?

### 解答

如果两次遍历来解，时间复杂度是O(n^2)。这里用Hash Table来解，时间复杂度是O(n)。

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // map保存遍历到的数和对应的index
        HashMap<Integer, Integer> map = new HashMap<>();
        // 只需要遍历一次数组
        for (int i = 0; i < nums.length; i++) {
            // 如果存在和为target的数，就返回两个数的index
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
```

## 15. 3Sum

### 问题

Given an integer array nums, return all the triplets `[nums[i], nums[j], nums[k]]` such that `i != j`, `i != k`, and `j != k`, and `nums[i] + nums[j] + nums[k] == 0`.

Notice that the solution set must not contain duplicate triplets.

**Example 1:**

```
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
```

**Example 2:**

```
Input: nums = []
Output: []
```

**Example 3:**

```
Input: nums = [0]
Output: []
```

**Constraints:**

- `0 <= nums.length <= 3000`
- `-105 <= nums[i] <= 105`

### 解答

题目需要找出三个数的和为0的所有子数组。这里遍历数组中的数，先定下第一个数，之后就是剩余数的2sum问题。首先要先对数组进行排序，因为数组中存在重复数。同时由于数组是已经排序过的，不需要用hash table来解，直接用双指针来解。

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 首先对数组进行排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 由于数组是排序过的，如果第一个数已经大于0了，后面的数加上的和一定不可能等于0，直接结束循环
            if (nums[i] > 0) break;
            // 跳过重复的数
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 此时的目标值就是-nums[i]
            int target = -nums[i];
            // 用双指针找剩下的两个数
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l > i + 1 && nums[l] == nums[l - 1]) l++;
                    while (r < nums.length - 1 && nums[r] == nums[r + 1]) r--;
                } else {
                    if (nums[l] + nums[r] < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return res;
    }
}
```

## 16. 3Sum Closest

### 问题

Given an array `nums` of *n* integers and an integer `target`, find three integers in `nums` such that the sum is closest to `target`. Return the sum of the three integers. You may assume that each input would have exactly one solution.

**Example 1:**

```
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
```

**Constraints:**

- `3 <= nums.length <= 10^3`
- `-10^3 <= nums[i] <= 10^3`
- `-10^4 <= target <= 10^4`

### 解答

这题需要找到与target值差值最小的三个数子数组。与3sum问题相似，对数组进行排序之后，将3sum问题转化为2sum问题，用双指针方法来解决。

```java
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // 首先排序数组，方便用双指针
        Arrays.sort(nums);
        // 定义最小差值和三个数的和，初值选择前三个数的和
        int min = Integer.MAX_VALUE;
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            // 选择第i个数，用双指针在右边寻找结果
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                // 计算差值
                int diff = nums[left] + nums[right] + nums[i] - target;
                // 如果差值=0，直接break返回
                if (diff == 0) return target;
                // 找到更小的差值，更新差值和结果
                if (Math.abs(diff) < min) {
                    min = Math.abs(diff);
                    res = nums[left] + nums[right] + nums[i];
                }
                // 根据差值移动指针
                if (diff < 0) left++;
                else right--;
            }
        }
        return res;
    }
}
```

## 18. 4Sum

### 问题

Given an array `nums` of `n` integers, return *an array of all the **unique** quadruplets* `[nums[a], nums[b], nums[c], nums[d]]` such that:

- `0 <= a, b, c, d < n`
- `a`, `b`, `c`, and `d` are **distinct**.
- `nums[a] + nums[b] + nums[c] + nums[d] == target`

You may return the answer in **any order**.

**Example 1:**

```
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
```

**Example 2:**

```
Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
```

**Constraints:**

- `1 <= nums.length <= 200`
- `-109 <= nums[i] <= 109`
- `-109 <= target <= 109`

### 解答

这题和3sum问题相似，需要从4sum问题转化为3sum再转化为2sum问题。

```java
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 首先排序数组
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            // 跳过重复的数，数组的第一个数暂定为坐标为i的数，此时的target = target - nums[i]
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int targetThree = target - nums[i];
            for (int j = i + 1; j < nums.length - 2; j++) {
                // 数组的第二个数暂定为坐标为j的数，此时target = target - nums[j]
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int targetTwo = targetThree - nums[j];
                // 用双指针寻找剩下的两个数
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] == targetTwo) {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                        res.add(list);
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    } else if (nums[left] + nums[right] < targetTwo) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
```

## QA

1. 为什么第一个问题选择用哈希表来解，后面的问题都用双指针来解？

    哈希表和双指针的时间复杂度都是O(n)，相对而言哈希表的空间复杂度更高，因此双指针是更好的选择。但是双指针需要数组首先是排序好的，而排序算法需要O(nlogn)的时间复杂度。对于3sum以及更多的数的问题，本身时间复杂度都是最小O(n^2)，排序的时间复杂度是没有影响的，但是2sum问题的O(n)实现就必须用到哈希表

