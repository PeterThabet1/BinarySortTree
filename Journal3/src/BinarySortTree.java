
/*************************************
*    Title: Binary Sort Trees
*    Author: Eck, David j.
*    Date: 2019
*    Code version: 8.1, July 2019
*    Availability: http://math.hws.edu/javanotes
 ************************************/
/**
 * This class represents the Binary sorted tree concept, and illustrates an
 * almost balanced binary sort tree. 
 * 
 * @author Peter Thabet
 *
 */
public class BinarySortTree { // BinarySortTree begin

	public static TreeNode root; //the root of the tree

	private static class TreeNode{ // TreeNode begin

		int item; // the data
		TreeNode left;  // left branch, initially null
		TreeNode right; // right branch, initially null

		TreeNode(int number){ // Constructor begin
			
			item = number;
			
		} //constructor end
		
	} // TreeNode end
	
	
	
	/*******************************************
	 *    Title: Binary Sort Trees
	 *    Author: Eck, David j.
	 *    Date: 2019
	 *    Code version: 8.1, July 2019
	 *    Availability: http://math.hws.edu/javanotes
	 * 
	 ******************************************/
	
	/**
	 * The method takes an item and places it in left node, if item is
	 * less than current node, else to the right if it's greater or equal.
	 * If an occupied node is found, it moves further.
	 * 
	 * @param newItem of type int to be inserted
	 */
	private static void treeInsert(int newItem) { // treeInsert() begin
		
		if(root == null) { // tree is empty
			root = new TreeNode(newItem); //creates a root and returns
			return;
		}

		TreeNode runner; // pointer to traverse the tree
		runner = root;

		while(true) { // Loop begin
			
			// 1st if. should proceed left further. newItem < item
			if(newItem < runner.item) { 

				if(runner.left == null) { // 2nd if. unoccupied node
					runner.left = new TreeNode(newItem);
					return;	
				} // end of 2nd if
				
				else { // else case. the node is still occupied
					runner = runner.left;
				} // end of else case
			} // end of 1st if.
			
			else { // 1st else case. Should proceed right further. newItem >= item
				if(runner.right == null) { // if case. unoccupied node
					runner.right = new TreeNode(newItem);
					return;
				} // end of if case
				
				else { // 2nd else case. The node is still occupied
					runner = runner.right;
				} // end of 2nd else case
			} // end of 1st else case
		} // Loop end
	} // treeInsert() end
	

	/**
	 * this method counts the sum of leaves of the tree
	 * 
	 * @param root begin of the tree
	 * @return int count of leaves
	 */
	public static int countLeaves(TreeNode root) { // countLeaves() begin
		
		TreeNode runner = root; // pointer to traverse

		if(runner == null) { // tree is empty
			return 0;
		}
		
		else {
			if(runner.left == null & runner.right == null) { // a leaf was found
				return 1;
			}
		}
		
		// sum of left and right leaves
		return countLeaves(runner.left) + countLeaves(runner.right); 
	} // countLeaves() end
	
	
	/**
	 * this method begins from depth zero and returns the sum of depths together.
	 * depth starts from 0 till the leaf
	 * 
	 * @param root begin of the tree
	 * @param depth the start of the tree = 0
	 * @return // the sum of all depths.
	 */
	public static int countDepths(TreeNode root, int depth) { //countDepths() begin
		
		TreeNode runner = root; //pointer to traverse the tree
		
		if(runner == null) { // tree is empty
			return 0;
		}
		
		else if (runner.left == null && runner.right == null) { // reached the end
			return depth;
		}
		
		else { // counts recursively the depths
			return countDepths(runner.left, depth + 1) + 
					countDepths(runner.right, depth + 1);
		}
	} // countDepths() end
	
	
	
	/**
	 * The method compares the two depths of the main two branches and returns
	 * the greater of them both.
	 * 
	 * @param root the begin of the tree
	 * @param depth should be 0 to begin from the root
	 * @return the great of left or right Depths.
	 */
	public static int getMaxDepth(TreeNode root, int depth) { // getMaxDepth() begin
		
		TreeNode runner = root; // pointer to traverse.
		
		int leftDepth = 0; // the left branch depth
		int rightDepth = 0; // the right branch depth
		
		if(runner == null) { // tree is empty
			return 0;
		}
		
		else if (runner.left == null && runner.right == null) { //end reached
			return depth;	
		}
		
		else {
			leftDepth = countDepths(runner.left, depth + 1);
			rightDepth = countDepths(runner.right, depth + 1);

		}
		return leftDepth > rightDepth ? leftDepth : rightDepth; //returns the greater depth
	}


	public static void main(String[] args) { // main() begin

		for(int i = 0; i < 1023; i++) {
			treeInsert((int)(1024 * Math.random()));
		}

		int leavesSum = countLeaves(root);
		int depthsSum = countDepths(root, 0);
		int maxDepth = getMaxDepth(root, 0);
		int avgDepth = depthsSum / leavesSum;
		
		System.out.println("Sum of leaves = " + leavesSum);
		System.out.println("Sum of depts = " + depthsSum);
		System.out.println("Maximum depth = "+ maxDepth);
		System.out.println("Average depth " + avgDepth);

	} // main() end
} // BinarySortTree end
