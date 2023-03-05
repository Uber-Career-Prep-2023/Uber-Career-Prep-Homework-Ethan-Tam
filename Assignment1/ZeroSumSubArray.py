# Growing/Shrinking Sliding Window 

# Time Complexity: Quadratic
# Space Complexity: Constant

def zerosumsubarray(array):
    count = 0
    for i in range(len(array)):
        for j in range(i+1, len(array) + 1):
            if sum(array[i:j]) == 0:
                count += 1
    return count

print(zerosumsubarray([4, 5, 2, -1, -3, -3, 4, 6, -7]))
print(zerosumsubarray([1, 8, 7, 3, 11, 9]))
print(zerosumsubarray([8, -5, 0, -2, 3, -4]))
print(zerosumsubarray([]))

# I spent 30 minutes on this problem.
