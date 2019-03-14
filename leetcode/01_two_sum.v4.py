from typing import List 

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        i, j, length = 0, 1, len(nums)
        while i < length and j < length:
            if nums[i] + nums[j] == target:
                return [i, j]
            j += 1
            if j == length:
                j = 0
                i += 1

sol = Solution()
print(sol.twoSum([2,7,11,15], 9))
