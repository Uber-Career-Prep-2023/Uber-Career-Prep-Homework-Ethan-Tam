# Hash the Elements

def kAnagrams(str1, str2, k):
    if len(str1) != len(str2):
        return False
    def make_dict(x):
        x_dict = {}
        for i in x:
            if i in x_dict:
                x_dict[i] += 1
            else:
                x_dict[i] = 1
        return x_dict
    str1_dict = make_dict(str1)
    str2_dict = make_dict(str2)
    count = 0
    for key in str2_dict:
        if key not in str1_dict:
            count += 1
        else:
            count += abs(str2_dict[key] - str1_dict[key])
    for key in str1_dict:
        if key not in str2_dict:
            count += 1
    if count // 2 > k:
            return False
    return True

print(kAnagrams("apple", "peach", 1))
print(kAnagrams("apple", "peach", 2))
print(kAnagrams("cat", "dog", 3))
print(kAnagrams("debit curd", "bad credit", 1))
print(kAnagrams("baseball", "basketball", 2))

# I spent 27 minutes on this problem.