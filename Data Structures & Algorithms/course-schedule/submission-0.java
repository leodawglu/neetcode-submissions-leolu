class Solution {

    /*
    Cycle detection problem in Directed Graph 
    - need to check if cycles / Catch 22 exists
    
    1. Build Adjacency list for each node to know which nodes are connected to it
    2. Add a list for each node
    3. Loop through prereqs to populate adjacency list
    4. Have a status[] array that tracks if the node is in
        1: visiting ; 2: visited ; 0: not visited
        - If a node is in "visiting" status and the loop sees it again, a cycle is detected
        - only visit if not visited


    HELPER RECURSIVE LOOP
    
    */
    private int[] status;
    private List<List<Integer>> prereqList;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        status = new int[numCourses];
        prereqList = new ArrayList<>();

        for(int n=0; n<numCourses; n++){
             prereqList.add(new ArrayList<>());
        }

        for(int[] prereq: prerequisites){
            prereqList.get(prereq[0]).add(prereq[1]);
        }

        //1. check if course is not visited
        for(int course=0; course<numCourses; course++){
            if(status[course]==0 && hasCycleDFS(course))return false;
        }

        return true;
        
    }


    private boolean hasCycleDFS(int course){
        if(status[course]==1) return true;
        status[course]=1;
        List<Integer> prereqs = prereqList.get(course);
        for(int pre: prereqs){
            if(status[pre]==1) return true;
            if(status[pre]==0 && hasCycleDFS(pre)) return true;
        }

        status[course]=2;
        return false;
    }
}
