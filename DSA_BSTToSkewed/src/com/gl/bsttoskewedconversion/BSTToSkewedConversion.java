package com.gl.bsttoskewedconversion;


class Node
{
    int val;
    Node left, right;
    
    Node(int item)
    {
        val = item;
        left = right = null;
    }
}


public class BSTToSkewedConversion {
	
	public static Node node;
    static Node prevNode = null;
    static Node headNode = null;
   
    // Function to flatten the binary
    // search tree into a skewed tree in
    // increasing / decreasing order
    static void convertBSTToSkewed(Node root,int order)
    {
       
        // Base Case
        if(root == null)
        {
            return;
        }
       
        // Condition to check the order
        // in which the skewed tree to be
        // maintained
        if(order > 0)
        {
        	convertBSTToSkewed(root.right, order);
        }
        else
        {
        	convertBSTToSkewed(root.left, order);
        }
        Node rightNode = root.right;
        Node leftNode = root.left;
       
        // Condition to check if the root Node
        // of the skewed tree is not defined
        if(headNode == null)
        {
            headNode = root;
            root.left = null;
            prevNode = root;
        }
        else
        {
            prevNode.right = root;
            root.left = null;
            prevNode = root;
        }
       
        // Similarly recurse for the left / right
        // subtree on the basis of the order required
        if (order > 0)
        {
        	convertBSTToSkewed(leftNode, order);
        }
        else
        {
        	convertBSTToSkewed(rightNode, order);
        }
    }
   
    // Function to traverse the right
    // skewed tree using recursion
    static void traverseRightSkewed(Node root)
    {
        if(root == null)
        {
            return;
        }
        System.out.print(root.val + " ");
        traverseRightSkewed(root.right);       
    }
   
    
}
