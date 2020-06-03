package com.code;

public class fourpowersortedarray {
	
	//4th power of a given array and sort it in non-increasing order

		    public  static int[] solution(int[] A) {
		        
		        
		        for ( int i = 0; i <  A.length; i ++ ) {

		            A [i] = A[i] * A[i] * A[i] * A[i]; 

		        }
		    // heapsort 
		        for ( int i = (A.length -2 )/2 ; i >=0 ; i -- ) { // make a min heap by sifting down 

		            A = siftdown ( i , A.length, A ) ; 

		       } 
		        

		        for ( int n = A.length ; n >1 ; n -- ) {
		            // swap first and second last number 
		            int temp = A [ 0 ] ; 
		            A [ 0 ] = A [ n -1 ] ;
		            A [ n - 1] = temp; 
		            
		            // sift down from 0, in sub arra of length n-1. this also excludes the last number from
		            // being included in the siftdown 
		            A = siftdown ( 0, n - 1 , A ) ; 
		            
		        }

		       return A ; 


		        
		    }

		    private static int [] siftdown ( int k , int n , int [] A) {


		        while ( 2*k +1 < n ) { // make sure left child is with in the range
		            
		            int minIndex = 2*k +1 ; 

		            
		            int rightIndex = minIndex + 1; 
		        

		            if ( (rightIndex < n) && (A [ rightIndex ] < A[minIndex]) ) {
		                                                // make sure right child is within the range 
		                                                // and compare left and right children 

		                minIndex = rightIndex; 

		            }

		            if ( A [ k ] > A[minIndex] ) { // this is smaller than, not greater than 

		                int temp = A [k];       // make sure the swapping is correct 
		                A [k] = A[minIndex] ; 
		                A [minIndex] = temp ; 
		                k = minIndex ; 
		            } else {
		                break ; 
		            }

		        }


		        return A; 



		    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a []= { -5, -4, -3, -2, 0 , 1, 1, 2, 3, 4 } ;
		
		int [] soln = solution (a);
		
		
		for ( int i : soln ) {
			if ( i == soln [soln.length -1]) {
				System.out.print( i );
			} else {
				System.out.print( i + "->" );
			}
		}
		
		//note: heapsort is the best way to sort a bunch of random numbers 
		// in an array. Compare to mergesort which creates too many extra arrays
		// by using recursions for array, it save tons of memory space. 
		// As compared to quicksort (Worst case O(n^2), 
		//it has better worst case run which is O(nlogn) 
		
		// in short, heapsort is best to sort a random array. 
		

	}

}
