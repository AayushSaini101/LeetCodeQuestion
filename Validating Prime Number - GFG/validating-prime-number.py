class Solution: 
    def isPrime(self,N):
        if(N==1):
          return 0
        i=2
        while(i*i<=N):
            if(N%i==0):
              return 0
            i=i+1
        return 1
            

if __name__ == '__main__': 
    t = int (input ())
    for _ in range (t):
        N = int(input())
       

        ob = Solution()
        print(ob.isPrime(N))
