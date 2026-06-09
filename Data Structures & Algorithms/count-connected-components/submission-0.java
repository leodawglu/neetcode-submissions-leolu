class Solution {
    /*
    Undirected path - adj node needs to be added to both nodes

    Adjacency list to hold nodes
    a boolean[] visited to track nodes already seen
    */

    boolean[] visited;
    public int countComponents(int n, int[][] edges) {
        visited = new boolean[n];
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0 ;i<n; i++){
            adjList.add(new ArrayList<>());
        }

        //undirected graph, both nodes need edge associated
        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        int count=0;
        for(int i=0; i<n; i++){
            if(visited[i]) continue;
            dfs(i, adjList);
            count++;
        }

        return count;

    }

    private void dfs(int node, List<List<Integer>> adjList){
        visited[node] = true;
        for(int neighbor: adjList.get(node)){
            if(visited[neighbor])continue;
            dfs(neighbor, adjList);
        }
    }
}
