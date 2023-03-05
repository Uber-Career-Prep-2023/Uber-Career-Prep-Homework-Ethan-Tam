# Hash the Elements

# Time Complexity: Linear
# Space Complexity: Linear

def dedupArray(array):
    
    array_dict = {}
    for i in array:
        if i in array_dict:
            array_dict[i] += 1
        else:
            array_dict[i] = 1

    for j in array_dict:
        for k in range(array_dict[j] - 1):
            array.remove(j)
    
a1 = [1, 2, 2, 3, 3, 3, 4, 4, 4, 4]
dedupArray(a1)
print(a1)

a2 = [0, 0, 1, 4, 5, 5, 5, 8, 9, 9, 10, 11, 15, 15]
dedupArray(a2)
print(a2)

a3 = [1, 3, 4, 8, 10, 12]
dedupArray(a3)
print(a3)

# I spent 15 minutes on this problem.