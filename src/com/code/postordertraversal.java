package com.code;
import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
public TreeNode(int data ) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

// Question: Do post-order traversal without using recursion. 

// enter numbers to insert and build BST
// enter -1 to stop building the tree (-1 will not be included in BST)
// 
// test case: 16 1 0 15 2 14 3 13 4 30 17 31 29 18 28 19 27 
//    result: 0->4->13->3->14->2->15->1->27->19->28->18->29->17->31->30->16->

public class postordertraversal {
	 		

	public static LinkedList <Integer> soln( TreeNode root ) {
		
		
		LinkedList <Integer> list = new LinkedList <Integer> ();
        TreeNode x = root;
        Stack <TreeNode> stk1 = new Stack <TreeNode>();   //built-in stack method for java
        Stack <TreeNode> stk2 = new Stack <TreeNode>();   //built-in stack method for java

        
        if (root.left == null && root.right == null ) {
        	list.add(root.data);
        	return list; 
     
        }

        
        while ( x!=null || !stk1.empty() ) { 

        	stk2.push(x); 
        	if ( x!=null) {
	        	if ( x.left != null ) {
	        		stk1.push(x.left);
	        	}
	        	
	        	if ( x.right != null ) {
	        		stk1.push(x.right);
	        	}
	        	
        	}	
        	
        	if ( !stk1.empty() ) {
        		x = stk1.pop(); 
        	} else {
        		x = null; 
        	}
        	
        
        }
        TreeNode y = null; 
		
        while(!stk2.empty()) {
        	y = stk2.pop(); 
        	list.add(y.data);
        }
        return list;   

		 
	}
	
	public static void checklist ( LinkedList <Integer> list) {
		
		for ( int i : list) { 
			System.out.print( i + "->");
		}	
		
	}

	public static void main(String[] args) {
		
		 // Use the Scanner class
	      Scanner sc = new Scanner(System.in);  
	      /*
	      int n      = sc.nextInt();        // read input as integer
	      long k     = sc.nextLong();       // read input as long
	      double d   = sc.nextDouble();     // read input as double
	      String str = sc.next();           // read input as String
	      String s   = sc.nextLine();       // read whole line as String
	      */
	    	TreeNode root = null ; 

	     while (true) {
	    	 
	    	 System.out.println("Type a number to insert a node to BST");
	    	 System.out.println("Or type '-1' to finish");
	    	 
	    	 int str = sc.nextInt();
	    	 
	    	 if ( str == -1 ) {
	    		 
	    		 break; 
	    		 
	    		 
	    	 } else {
	    		 
	    		 root = insert ( str, root ) ;
	    		 
	    	 }
	    	  
	     }
	     System.out.println( "Inorder print: " );
	     printtree ( root ); 
	     
	     LinkedList <Integer> list = soln( root );

	     
	     System.out.print("Final list: ");
	     checklist ( list ); 
	    

	}
	public static void printtree ( TreeNode root ) {
		if ( root== null ) return ;
		printtree (root.left);
		System.out.print( " " + root.data + " ");
		printtree (root.right) ;
		
		
	}
	
	public static TreeNode insert ( int a, TreeNode root ) {
		
		TreeNode x = root; TreeNode p = null ; 
		TreeNode temp = new TreeNode ( a ); 

		if ( root == null ) { root = temp; return root; }
			x = root; 
		while ( x != null ) {
				
			if ( x.data > a ) { 
				p = x; 
				x = x.left; 
			} else {
				p = x; 
				x = x.right; 
			}
			
		}
		if ( a < p.data ) {
			p.left = temp; 
		} else {
			p.right = temp; 
		}
		
		return root; 
	}

}

