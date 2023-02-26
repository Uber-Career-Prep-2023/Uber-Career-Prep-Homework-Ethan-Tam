# initially tried Binary Search, but then used simple math

def missingInteger(array, n):
    return sum(range(1, n+1)) - sum(array)
    
    # while len(array) > 1:
    #     middle = (n - 1) // 2
    #     isEven = (n - 1) % 2 == 0
    #     left = array[:middle]
    #     if isEven:
    #         right = array[middle+1:]
    #     else:
    #         right = array[middle:]
    #     if (left[len(left) - 1] - left[0]) > (right[len(right) - 1] - right[0]):
    #         array = left
    #     elif (left[len(left) - 1] - left[0]) < (right[len(right) - 1] - right[0]):
    #         array = right
    #     elif (left[len(left) - 1] - left[0]) == (right[len(right) - 1] - right[0]):
    #         if array[middle] - array[middle - 1] != 1:
    #             array = left
    #         elif array[middle + 1] - array[middle] != 1:
    #             array = right
    
print(missingInteger([1, 2, 3, 4, 6, 7], 7))
print(missingInteger([1], 2))
print(missingInteger([1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12], 12))

# I spent 40 minutes on this problem.