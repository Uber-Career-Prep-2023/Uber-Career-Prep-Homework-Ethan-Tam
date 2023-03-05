# Forward-Backward Two-Pointer

# Time Complexity: Linear
# Space Complexity: Linear

def reverseVowels(string):
    front = ""
    end = ""
    vowels = ["a", "e", "i", "o", "u", "A", "E", "I", "O", "U"]
    p1 = 0
    p2 = len(string) - 1
    while p1 != p2 and p2 > p1:
        if string[p1] not in vowels and string[p2] not in vowels:
            front += string[p1]
            end = string[p2] + end
            p1 += 1
            p2 -= 1
        else:
            if string[p1] in vowels and string[p2] in vowels:
                front += string[p2]
                end = string[p1] + end
                p1 += 1
                p2 -= 1
            elif string[p1] in vowels:
                end = string[p2] + end
                p2 -= 1
            elif string[p2] in vowels:
                front += string[p1]
                p1 += 1
    if p1 == p2:
        front += string[p1]
    return front + end

print(reverseVowels("Uber Career Prep"))
print(reverseVowels("xyz"))
print(reverseVowels("flamingo"))
print(reverseVowels(""))
print(reverseVowels("oe"))
print(reverseVowels("ota"))

#I finished this problem in 35 minutes.