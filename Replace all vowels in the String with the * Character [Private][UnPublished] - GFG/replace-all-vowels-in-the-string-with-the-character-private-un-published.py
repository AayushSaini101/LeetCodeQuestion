#User function Template for python3

def replaceVowels(s):
     vowels = ['a', 'e', 'i', 'o', 'u','A', 'E', 'I', 'O', 'U']
     for i in range(len(s)):
        if s[i] in vowels:
            s = s[:i] + '*' + s[i+1:]
     return s


#{ 
#  Driver Code Starts
#Initial Template for Python 3

if __name__ == "__main__":
    t = int(input())
    while(t>0):
        s = input()
        print(replaceVowels(s))
        t = t-1


# } Driver Code Ends