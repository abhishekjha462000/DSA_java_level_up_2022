// problem link -- https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1

/**
 * This function returns the head of the doubly linked list
 **/
private static Node BinaryTreeToDoublyLinkedList(Node root){

        if(root == null)
            return null;

        Node leftAns  = BinaryTreeToDoublyLinkedList(root.left); // make the left tree a doubly linked list
        Node rightAns = BinaryTreeToDoublyLinkedList(root.right); // make the right tree a doubly linked list

        /**
         * "leftAns" and "rightAns" are the heads of the left and the right doubly linked list.
         **/

        // Move to the rightmost node of the doubly linked list
        while(leftAns != null && leftAns.right != null){
            leftAns = leftAns.right
        }

        // connect the "rightmost" node of the "left" doubly linked list to the "root"
        if(leftAns != null)
            leftAns.right = root;

        // connect "root" to the "rightmost" node of the "left" doubly linked list.
        root.left = leftAns;
        root.right = rightAns;

        // connect the "rightAns" to the "root" node
        if(rightAns != null)
            rightAns.left = root;

        // move the "root" to the head of the new linked list
        while(root != null && root.left != null)
            root = root.left;

        return root;

    }




    // ROUGH WORK








