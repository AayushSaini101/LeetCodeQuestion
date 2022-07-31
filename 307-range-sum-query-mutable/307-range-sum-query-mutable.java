class NumArray {

    int build[];
    
    int length=0;
    
    int nums[];
    
    
    public int build(int start,int end,int nums[],int build[],int index){
        
        if(start==end){
            
            build[index]=nums[start];
            
            return build[index];
        }
        
        int mid=(start+end)>>1;
        
        int left1=build(start,mid,nums,build,2*index+1);
        
        int right1=build(mid+1,end,nums,build,2*index+2);
        
        return build[index]=left1+right1;
    }
    
    public int sum(int start,int end,int left,int right,int build[],int index){
        
       
        if(end<left||right<start){
            
            return 0;
        }
        
        if(start>=left&&end<=right){
            
            return build[index];
        }
        
        int mid=(start+end)>>1;
        
        int answer=0;
        
        int left1=sum(start,mid,left,right,build,2*index+1);
        
        int right1=sum(mid+1,end,left,right,build,2*index+2);
        
        
        return left1+right1;
       
    }
    public NumArray(int[] nums) {
       //Use the segment tree concept to find 
    
        this.length=nums.length;
        
        this.nums=nums;
        
        build=new int[nums.length*4+1];
        
        build(0,nums.length-1,nums,build,0);
    }
    public void update(int start,int end,int build[],int changedIndex,int value,int index){
        
        if(start==end){
            
            if(start==changedIndex){
                
                build[index]=value;
                
                //System.out.println("Sdf");
            }
            
            return;
            
        }
        
        int mid=(start+end)>>1;
        
        
        if(changedIndex<=mid){
            
            update(start,mid,build,changedIndex,value,2*index+1);
        }
        else{
            update(mid+1,end,build,changedIndex,value,2*index+2);
        }
        
        build[index]=build[2*index+1]+build[2*index+2];
        
        
    
        
    }
    public void update(int index, int val) {
    
     
        update(0,length-1,build,index,val,0);
        
        nums[index]=val;
        
       // System.out.println(Arrays.toString(build));
    }
    
    public int sumRange(int left, int right) {
        
     //  System.out.println(Arrays.toString(build));
        
        return sum(0,length-1,left,right,build,0);
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */