class solution{
	private static Node deserealize(String data){
		String[] vals = data.split(" ");

		Node root = deserealizeHelper(vals);

		return root;
	}

	static int idx = 0;

	private static Node deserealizeHelper(String[] vals){
		if(vals[idx].equals("null")){
			return null;
		}

		Node root = new Node(Integer.parseInt(vals[idx]));
		idx++;

		root.left = deserealizeHelper(vals);
		idx++;
		root.right = deserealizeHelper(vals);

		return root;
	}
}



// ROUGH WORK






