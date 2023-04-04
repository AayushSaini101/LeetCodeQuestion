/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		
		Scanner scan=new Scanner(System.in);
		
		int t=scan.nextInt();
		
		while(t-->0){
		int first=scan.nextInt();
		
		int second=scan.nextInt();
		
		int min=Math.min(first,second);
		
		long answer=1;
		
		for(int i=1;i<=min;++i){
		    
		    answer*=i;
		}
		
		System.out.println(answer);
		}
	}
}