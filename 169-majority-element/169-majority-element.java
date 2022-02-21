class Solution {
    public int majorityElement(int[] a) {
        // We will use the boyrr moure algo
        int count=1;
        int maj=0;
        for(int i=1;i<a.length;++i){
            if(a[maj]==a[i]){
                ++count;
            }
            else
                --count;
            if(count==0){
                maj=i;
                count=1;
            }
        }
        
        return a[maj];
    }
}