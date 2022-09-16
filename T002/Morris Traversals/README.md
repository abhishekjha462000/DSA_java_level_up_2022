1. <p style = "color : blue"> Normal Traversals </p>
   preorder   === node left  right<br>
   inorder    === left node  right<br>
   postorder  === left right node<br>

2. We also have reverse traversals. Just do `left <=> right`

   reverse preorder  === node right left<br>
   reverse inorder   === right node left<br>
   reverse postorder === right left node<br>

3. We have written the Morris traversals codes for preorder and inorder.<br>
   If we want to write the Morris traversal codes for reverse preorder and reverse inorder then just filp left and right.