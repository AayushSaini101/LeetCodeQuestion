class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        check=set(nums)
       
        if len(nums)-len(check)==0:
            return False
        else:
            return True