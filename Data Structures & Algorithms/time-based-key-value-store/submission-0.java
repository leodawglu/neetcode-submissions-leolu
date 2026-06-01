class TimeMap {

    /*
    Since this question looks to store the state of the key's value at any given time
    and that the state is updated with a later timestamp
    Data structure:
    - Key - Value pair, where key is key, 
    and value is another k-v pair where k is timestamp and value is the actual state value
    */

    private class State{
        int time;
        String val;

        public State(int time, String val){
            this.time = time;
            this.val = val;
        }
    }

    private Map<String, List<State>> logs;

    public TimeMap() {
        logs = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!logs.containsKey(key)){
            logs.put(key, new ArrayList<>());
        }

        logs.get(key).add(new State(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!logs.containsKey(key))return "";

        List<State> currLog = logs.get(key);

        int l=0, r=currLog.size()-1;

        String res="";
        while(l<=r){
            int mid = l + (r-l)/2;
            if(currLog.get(mid).time<=timestamp){
                res = currLog.get(mid).val;

                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return res;
    }
}
