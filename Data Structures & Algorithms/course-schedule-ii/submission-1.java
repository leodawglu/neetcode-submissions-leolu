class Solution {
    /*
    Cycle Detection in Directed Graph

    - need Adjacency list for each course
    - need a visited/unvisited/visiting array
    - a list for capturing order of courses

    visitStatus: 1 - visiting ; 2 - visited ; 0 not visited
    DFS recursive loop to check for Cycle 
    
    */

    private int[] visitStatus;
    private List<List<Integer>> coursePrereqs;
    private List<Integer> courseOrder;
    private final int[] CANNOTFINISH = {};
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visitStatus = new int[numCourses];
        coursePrereqs = new ArrayList<>();
        courseOrder = new ArrayList<>();

        for(int i=0; i<numCourses; i++){
            coursePrereqs.add(new ArrayList<>());
        }

        for(int[] prereq: prerequisites){
            coursePrereqs.get(prereq[0]).add(prereq[1]);
        }

        for(int course=0; course<numCourses; course++){
            if(visitStatus[course]==2) continue;
            if(visitStatus[course]==1) return CANNOTFINISH;
            List<Integer> currOrder = new ArrayList<>();
            if(visitStatus[course]==0 && hasCycle(course, currOrder)) return CANNOTFINISH;
            courseOrder.addAll(currOrder);
        }

        int[] order = new int[courseOrder.size()];
        for(int i=0; i<courseOrder.size(); i++){
            order[i]=courseOrder.get(i);
        }
        return order;
    }


    private boolean hasCycle(int course, List<Integer> currOrder){
        if(visitStatus[course]==1) return true;
        visitStatus[course]=1;
        List<Integer> adjCourses = coursePrereqs.get(course);
        for(int adj: adjCourses){
            if(visitStatus[adj]==2) continue;
            if(visitStatus[adj]==1) return true;
            if(visitStatus[adj]==0 && hasCycle(adj, currOrder)) return true;
        }

        currOrder.add(course);

        visitStatus[course]=2;
        return false;
    }
}
