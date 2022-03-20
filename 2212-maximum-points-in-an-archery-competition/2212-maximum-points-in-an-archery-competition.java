class Solution {
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
     int score=0;
for(int i=0;i<aliceArrows.length;++i){
	if(aliceArrows[i]!=0){
		score+=i;
	}
}
int max1=0;
int nums=numArrows;
int max=0;
for(int i=0;i<(1<<13);++i){

	int score1=0;
	int temp=nums;
	int mask=0;
	for(int j=0;j<aliceArrows.length;++j){
        if(temp<=0){
            break;
        }
		if((i&(1<<j))!=0){

       if(temp>aliceArrows[j]){
       	mask|=(1<<j);
       	score1+=j;
       	if(aliceArrows[j]==0){
       		--temp;
		}
       	else
       	temp-=(aliceArrows[j]+1);

	   }
       else{
       	break;
	   }


		}

	}
//System.out.println(score1+" "+score);
{
 if(score1>max1){
 	max1=score1;
 	max=mask;
 }

	}


}
int answaer[]=new int[12];
      //  System.out.println(Integer.toBinaryString(max));
int total=0;
for(int i=0;i<12;++i){
	if((max&(1<<i))!=0){
		answaer[i]=aliceArrows[i]+1;
        total+=answaer[i];
	}
}
        answaer[11]+=(numArrows-total);
return answaer;
        
    }
}