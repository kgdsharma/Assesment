import java.util.Arrays;

/*
	 * This is a demo task.

		Write a function:
		
		class Solution { public int solution(int[] A); }
		
		that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
		
		For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
		
		Given A = [1, 2, 3], the function should return 4.
		
		Given A = [−1, −3], the function should return 1.
		
		Assume that:
		
		N is an integer within the range [1..100,000];
		each element of array A is an integer within the range [−1,000,000..1,000,000].
		Complexity:
		
		expected worst-case time complexity is O(N);
		expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
		Copyright 2009–2018 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
		Solution

	 * */

public class MinimumInteger {	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MinimumInteger MI = new MinimumInteger();
		
		//int[] A = new int[]{1, 3, 6, 4, 1, 2};
		int[] A = new int[]{1, 3, 6, 4, 1, 2};
		
		int result =MI.solution(A);
		
		System.err.println("And  the result is ...>> "+result);

	}
	
	public MinimumInteger() {};
	
	public int solution(int[] A) {
		
		if(1<A.length && A.length>100000) {
			System.out.println("Array Input is beyond the boundry conditions");
			System.exit(0);
		}
		
		int i=0;
		//int min= (-1000000);
		while(i<(A.length-1)){
			if(-1000000>A[i] && A[i]>1000000) {
				System.out.println("Array Input is beyond the boundry conditions");
				System.exit(0);
			}
			i++;			
		}		
		
	     Arrays.sort(A);
	     
	     int temp=0;
	     
	     //System.out.println(Arrays.toString(A));
	     
	     int positiveIndex=0;
	     
	     for(int index=0;index<A.length;index++) {
	    	 if(A[index]<=0)
	    		 positiveIndex++;	    		 
	     }
	     
	    // System.out.println("Position Index >> "+positiveIndex);
	     
	     if(positiveIndex==A.length) {
	    	 temp=1;
	     }else
	    	 
	     
	     if(A.length==1) {
	    	 temp=A[0]+1;
	     }else {
	    	 for(int j=positiveIndex;j<=A.length-2;j++) {
		    	 
		    	 if(A[j]==A[j+1]) {
		    		 temp=A[j]+1;
		    		 continue;
		    	 }else if(A[j]<A[j+1] && (A[j]+1 !=A[j+1])) {
		    		 temp=A[j]+1;
		    	 }
		     }
	     }
	     
	     
	        
	        return temp;
	    }


	}

