# Growing/Shrinking Sliding Window

# assumption: if multiple substrings are the shortest substrings containing the required characters, 
# return the substring that occurs earliest

# Time Complexity: Quadratic
# Space Complexity: Linear

def shortestsubstring(str1, str2):
    shortest = ""
    str2_dict = {}
    for char in str2:
        if char in str2_dict:
            str2_dict[char] += 1
        else:
            str2_dict[char] = 1
    for i in range(len(str1)):
        for j in range(1, len(str1)+1):
            contains_str2 = True
            substring = str1[i:j]
            substring_dict = {}
            for char in substring:
                if char in substring_dict:
                    substring_dict[char] += 1
                else:
                    substring_dict[char] = 1
            for k in str2_dict:
                if k not in substring_dict or substring_dict[k] < str2_dict[k]:
                    contains_str2 = False
                    break
            if contains_str2:
                if shortest == "":
                    shortest = substring
                else:
                    if len(shortest) > len(substring):
                        shortest = substring
                break
    return shortest

print(shortestsubstring("abracadabra", "abc"))
print(shortestsubstring("zxycbaabcdwxyzzxwdcbxyzabccbazyx", "zzyzx"))
print(shortestsubstring("dog", "god"))

# I spent 30 minutes on this problem.