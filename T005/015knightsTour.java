    /**
     * This is not a graph problem though.
     * problem -- https://www.pepcoding.com/resources/online-java-foundation/recursion-backtracking/knights-tour-official/ojquestion
     **/

    public static void printKnightsTour(int[][] chess, int r, int c, int upcomingMove) {
        if(r < 0 || c < 0 || r >= chess.length || c >= chess.length || chess[r][c] != 0)
            return;
        
        chess[r][c] = upcomingMove;

        if(upcomingMove == chess.length * chess.length){
            displayBoard(chess);
            chess[r][c] = 0; // backtrack
            return;
        }

        int[][] dir = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1},
                       {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};

        for(int i = 0;i < dir.length ;i++){
            int dr = dir[i][0];
            int dc = dir[i][1];

            printKnightsTour(chess, r + dr, c + dc, upcomingMove + 1);
        }
        
        chess[r][c] = 0; // backtrack
    }

    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }


    // ROUGH WORK






