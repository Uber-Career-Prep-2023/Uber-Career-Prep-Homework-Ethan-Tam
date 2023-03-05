# initially tried Binary Search, but then used simple math

# Time Complexity: Constant
# Space Complexity: Constant

def missingInteger(array, n):
    return sum(range(1, n+1)) - sum(array)
    
print(missingInteger([1, 2, 3, 4, 6, 7], 7))
print(missingInteger([1], 2))
print(missingInteger([1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12], 12))

# I spent 40 minutes on this problem.