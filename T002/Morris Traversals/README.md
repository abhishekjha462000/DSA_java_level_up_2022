1. preorder   === node left  right<br>
   inorder    === left node  right<br>
   postorder  === left right node<br>

2. We also have reverse traversals. Just do `left <=> right`

   reverse preorder  === node right left<br>
   reverse inorder   === right node left<br>
   reverse postorder === right left node<br>

3. We have written the Morris traversals codes for preorder and inorder.<br>
   If we want to write the Morris traversal codes for reverse preorder and reverse inorder then just filp left and right.


4. We cannot write postorder using Morris Traversal. However we can write reverse preorder
   (NRL) using the Morris Traversal and then reverse it (LRN), but this would defeat the purpose of Morris Traversal as we would have to use an array to store the values which would take O(#{nodes}).

   <br>
   <br>
   Though I have written the code for that as well in `003. postorder.java`.

5. What is the time complexity of Morris Traversal algorithm. It's time complexity is 
   somewhat complicated as we do not know how many times we are going to visit each node.
   <br>

   Then how do we determine its time complexity?
   <br>
   We determine it's time complexity using the number of edges.
   <br>

   In a binary tree with `n` nodes we have `(n-1)` edges.
   <br>
   We can traverse an array atmost 3 times
   <br>
      - Once while connecting it to the rightmost node of the left subtree.
      - Once while disconnecting it from the rightmost node of the left subtree.
      - Once while moving down the edge.

   <br>
   so the time complexity is `O(3 * (n-1)) ~ O(3 _n_)`


       




