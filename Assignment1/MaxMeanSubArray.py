# Sliding Window

# Time Complexity: Linear
# Space Complexity: Constant

def maxmeansubarray(array, k):
    highest_mean = 0
    for i in range(len(array) - k + 1):
        curr_mean = 0
        for j in range(k):
            curr_mean += array[i + j]
        curr_mean = curr_mean / k
        if curr_mean > highest_mean:
            highest_mean = curr_mean
    return highest_mean

print(maxmeansubarray([4, 5, -3, 2, 6, 1], 2))
print(maxmeansubarray([4, 5, -3, 2, 6, 1], 3))
print(maxmeansubarray([1, 1, 1, 1, -1, -1, 2, -1, -1], 3))
print(maxmeansubarray([1, 1, 1, 1, -1, -1, 2, -1, -1, 6], 5))

# I spent 15 minutes on this problem.