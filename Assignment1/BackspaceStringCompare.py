# Two-Pointer with "Catch-Up" Condition

def backspacestringcompare(str1, str2):
    def without_backspace(string):
        new_string = ""
        p1 = len(string) - 1
        p2 = len(string) - 1
        # traverse string backwards
        for i in range(len(string)):
            # once we encounter a #, use p1 pointer to check for more #s  
            if string[p1] == "#":
                count = 1
                p1 -= 1
                # once we encounter a non-#, skip the number of letters equivalent to the number of #s in a row
                while p1 >= 0 and string[p1] == "#":
                    count += 1
                    p1 -= 1
                for i in range(count):
                    p1 -= 1
                p2 = p1
            else:
                # otherwise, add characters to create the new string
                new_string = string[p2] + new_string
                p2 -= 1
                p1 -= 1
            # since the length of the string may be shorter without the #s, check the pointers' values for this scenario
            if p1 < 0 or p2 < 0:
                break
        return new_string
    
    return without_backspace(str1) == without_backspace(str2)

print(backspacestringcompare("abcde", "abcde"))
print(backspacestringcompare("Uber Career Prep", "u#Uber Careee#r Prep"))
print(backspacestringcompare("abcdef###xyz", "abcw#xyz"))
print(backspacestringcompare("abcdef###xyz", "abcdefxyz###"))
print(backspacestringcompare("a###", "a#"))

# I spent 27 minutes on this problem.