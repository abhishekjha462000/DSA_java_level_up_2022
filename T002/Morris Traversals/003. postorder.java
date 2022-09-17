/**
 * But this method is useless as Morris Traversal is supposed to reduce the space complexity to O(1), but here no matter how hard we try we get space complexity of O(#{nodes})
 **/
private static List<Integer> postorder(Node node){
	List<Integer> ans = new ArrayList<>();

	// This loop fills "ans" in reverse preorder manner
	while(node != null){

		if(node.right == null){
			ans.add(node.data);
			node = node.left;
		}else{

			Node nodep1 = node.right;

			while(nodep1.left != null && nodep1.left != node){
				nodep1 = nodep1.left;
			}

			if(nodep1.left == null){
				ans.add(node.data);
				nodep1.left = node;
				node = node.right;
			}else if(nodep1.left == node){
				nodep1.left = null;
				node = node.left;
			}
		}
	}

	// "ans" has elements in the order NRL, but we want postorder(LRN) so we reverse it.

	int i = 0;
	int j = ans.size()-1;

	while(i <= j){
		int temp = ans.get(i);
		ans.set(i, ans.get(j));
		ans.set(j, temp);
		i++;
		j--;
	}
	return ans;
}


// ROUGH WORK













