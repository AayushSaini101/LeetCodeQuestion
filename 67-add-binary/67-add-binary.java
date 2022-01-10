import java.math.BigInteger;
class Solution {
    public String addBinary(String a, String b) {
       BigInteger first=new BigInteger(a,2);
       BigInteger second=new BigInteger(b,2);
        first=first.add(second);
        return first.toString(2);
    }
}