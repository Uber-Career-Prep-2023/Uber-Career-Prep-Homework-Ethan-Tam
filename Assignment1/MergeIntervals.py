# Sort then Solve

# Time Complexity: Linear
# Space Complexity: Linear

# assuming that we can return merged tuples in any order

def mergeIntervals(array):
    # sort array first
    array.sort()

    total = []
    
    for x,y in array:
        if len(total) != 0 and total[-1][1] >= x:
            temp = (total[-1][0], max(y, total[-1][1]))
            total.pop()
            total.append(temp)
        else:
            total.append((x,y))
    return total

print(mergeIntervals([(2, 3), (4, 8), (1, 2), (5, 7), (9, 12)]))
print(mergeIntervals([(5, 8), (6, 10), (2, 4), (3, 6)]))
print(mergeIntervals([(10, 12), (5, 6), (7, 9), (1, 3)]))

# It took me 40 minutes to solve this problem.