# Growing/Shrinking Sliding Window

# Time Complexity: Quadratic
# Space Complexity: Linear

def twoSum(array,k):

    if len(array) <= 1:
        return 0
    count = 0
    for i in range(len(array)):
        for j in array[i+1:]:
            if (array[i] + j) == k:
                count += 1
    return count



print(twoSum([1, 10, 8, 3, 2, 5, 7, 2, -2, -1], 10))
print(twoSum([1, 10, 8, 3, 2, 5, 7, 2, -2, -1], 8))
print(twoSum([4, 3, 3, 5, 7, 0, 2, 3, 8, 6], 6))
print(twoSum([4, 3, 3, 5, 7, 0, 2, 3, 8, 6], 1))

# I spent 30 minutes on this problem.