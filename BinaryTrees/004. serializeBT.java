    // serialize means converting a BT into a string.
    private static String serialize(Node node){
        StringBuilder sb = new StringBuilder();

        serializeHelper(node, sb);

        return sb.toString();
    }

    private static void serializeHelper(Node node, StringBuilder sb){
        if(node == null){
            sb.append("null" + " ");
            return ;
        }

        sb.append(node.data + " ");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }



    // ROUGH WORK











