# Growing/Shrinking Sliding Window

# assumption: if multiple substrings are the shortest substrings containing the required characters, 
# return the substring that occurs earliest

"""
Input Strings: "abracadabra", "abc"
Output: 4
(Shortest Substring: "brac")

Input Strings: "zxycbaabcdwxyzzxwdcbxyzabccbazyx", "zzyzx" (Fun fact: "Zzyzx" is a town in the Mojave Desert in California!)
Output: 10
(Shortest Substring: "zzxwdcbxyz")

Input Strings: "dog", "god"
Output: 3
(Shortest Substring: "dog")
"""
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