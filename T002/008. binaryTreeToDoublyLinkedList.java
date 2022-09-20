private static Node BinaryTreeToDoublyLinkedList(Node root){

        if(root == null)
            return null;

        Node leftAns  = BinaryTreeToDoublyLinkedList(root.left);
        Node rightAns = BinaryTreeToDoublyLinkedList(root.right);

        while(leftAns != null && leftAns.right != null){
            leftAns = leftAns.right
        }

        if(leftAns != null)
            leftAns.right = root;

        root.left = leftAns;
        root.right = rightAns;

        if(rightAns != null)
            rightAns.left = root;

        while(root != null && root.left != null)
            root = root.left;

        return root;

    }




    // ROUGH WORK







    
