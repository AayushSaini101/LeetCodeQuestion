import math

def isArmstrong(n):
    sum = 0
    temp = n
    digits = math.floor(math.log10(n)) + 1  # count number of digits
    while temp > 0:
        digit = temp % 10
        sum += digit ** digits
        temp //= 10
    if sum == n:
        return 1
    return 0

def countArmstrongNumbers(nums):
    count = 0
    for n in nums:
        if isArmstrong(n) == 1:
            count += 1
    return count

t = int(input())

for _ in range(t):
    n = int(input())
    for i in range(1, 11):
        print(n * i, end=' ')
    print()
