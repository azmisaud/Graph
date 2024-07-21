class FloodFillAlgorithm
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here 
        int initialColor=image[sr][sc];
        int[][] result=image;
        int[] delRow={-1,0,1,0};
        int[] delCol={0,1,0,-1};
        dfs(sr,sc,result,image,newColor, delRow, delCol, initialColor);
        return result;
    }
    private void dfs(int row,int col, int[][] result,int[][] image, int newColor, int[] delRow, int[] delCol, int initialColor){
        result[row][col]=newColor;
        int n=image.length;
        int m=image[0].length;
        for(int i=0;i<4;i++){
            int nRow=row+delRow[i];
            int nCol=col+delCol[i];
            if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && image[nRow][nCol]==initialColor && result[nRow][nCol]!=newColor){
                dfs(nRow,nCol,result,image,newColor,delRow,delCol,initialColor);
            }
        }
    }
}
