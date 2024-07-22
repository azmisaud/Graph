class DisjointSet {

  ArrayList<Integer> rank=new ArrayList<>();
  ArrayList<Integer> size=new ArrayList<>();
  ArrayList<Integer> parent=new ArrayList<>();

// From rank and size, one can be chosen, I choose size because it is more intuitive, but since I am
// writing the code, I am writing both.

  public DisjointSet(int n) {
    for(int i=0;i<=V;i++) {
      rank.add(0);
      size.add(1);
      parent.add(i);
    }
  }

  public int findUltimateParent(int u) {
    if(u==parent.get(u))
      return u;

    int ulp=findUltimateParent(parent.get(u));
    parent.set(u,ulp);

    return parent.get(u);
  }

  public void unionByRank(int u,int v) {
    int pu=findUltimateParent(u);
    int pv=findUltimateParent(v);

    if(pu==pv)
        return;

    if(rank.get(pu)<rank.get(pv)) 
        parent.set(pu,pv);

    else if(rank.get(pu)>rank.get(pv))
        parent.set(pv,pu);

    else {
      parent.set(pv,pu);
      rank.set(pu,rank.get(pu)+1);
    }
  }

  public void unionBySize(int u,int v) {
    int pu=findUltimateParent(u);
    int pv=findUltimateParent(v);

    if(pu==pv)
        return;

    if(size.get(pu)<size.get(pv)){
          parent.set(pu,pv);
          size.set(pv,size.get(pu)+size.get(pv));
    }
    else {
          parent.set(pv,pu);
          size.set(pu,size.get(pu)+size.get(pv));
    }
  }

class DisjointSetApproach {

  static int numProvinces(ArrayList<ArrayList<Integer>> adj,int V) {

    DisjointSet ds=new DisjointSet(V);

    for(int i=0;i<V;i++) {
      for(int j=0;j<V;j++) {
        if(adj.get(i).get(j)==1)
          ds.unionBySize(i,j);
      }
    }

    int count=0;

    for(int i=0;i<V;i++){
      if(i==ds.parent.get(i))
        count++;
    }

    return count;
  }

}
