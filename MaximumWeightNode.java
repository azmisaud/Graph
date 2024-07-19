class MaximumWeightNode{
    public int maxWeightCell(int N, int Edge[]){
       int[] weight=new int[N];
       for(int i=0;i<N;i++){
           if(Edge[i]!=-1)
            weight[Edge[i]]+=i;
       }
       int max=Integer.MIN_VALUE;
       
       for(int i=0;i<N;i++){
           max=Math.max(max,weight[i]);
       }
       
       int k=0;
       for(int i=0;i<N;i++){
           if(weight[i]==max){
               k=i;
           }
       }
       return k;
    }
}
