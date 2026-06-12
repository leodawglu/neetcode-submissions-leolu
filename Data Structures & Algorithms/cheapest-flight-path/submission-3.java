class Solution {
    /*
    
    Basic Understanding:
    - Directed graph
    - May be cyclic - meaning there's flights from A to B to A
    - also may be multiple flights from A to B at different prices
    - Cost is a concern, so we want to know the cheapest way 
    to get from SRC to all connected airports, including DST
    - limited by K stops, meaning K+1 flights are allowed

    Intuition:
    - build adjacency list for each airport and flights available - quick look up
    - Level order BFS : why? 1. limited by stops 2. avoid visiting unnecessary nodes
    - each level order search updates a min cost[] array for each airport

    */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);

        List<List<int[]>> flightsFromAirport = new ArrayList<>();
        for(int i=0; i<n; i++){
            flightsFromAirport.add(new ArrayList<>());
        }

        //build adj list

        for(int[] flight: flights){
            int dept = flight[0],dest = flight[1], price = flight[2];
            flightsFromAirport.get(dept).add(new int[]{dest, price});
        }

        //Level order search, load starting airport 

        Queue<int[]> airportsToVisit = new LinkedList<>();
        airportsToVisit.offer(new int[]{src,0});
        cost[src]=0; // starting airport is 0 cost 
        int stops=0;

        while(!airportsToVisit.isEmpty() && stops<=k){
            int numAirports = airportsToVisit.size();
            int[] tempCost = Arrays.copyOf(cost,n);
            while(numAirports>0){
                int[] pathCostToAirport = airportsToVisit.poll();
                int airport = pathCostToAirport[0], paid = pathCostToAirport[1];

                for(int[] flt: flightsFromAirport.get(airport)){
                    int dest = flt[0], tix = flt[1];
                    if(tempCost[dest]>paid+tix){
                        tempCost[dest] = paid+tix;
                        airportsToVisit.offer(new int[]{dest, tempCost[dest]});
                    }
                }
                numAirports--;
            }
            cost = tempCost;
            stops++;//end loop
        }

        return cost[dst]==Integer.MAX_VALUE? -1: cost[dst];
    }
}
