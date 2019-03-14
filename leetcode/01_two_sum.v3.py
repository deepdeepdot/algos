from typing import List 

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        i = 0
        length = len(nums)
        while i < length:
            j = i+1
            while j < length:
                if nums[i] + nums[j] == target:
                    return [i, j]
                j += 1
            i += 1

sol = Solution()
print(sol.twoSum([2,7,11,15], 9))
