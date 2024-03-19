class Solution {
    public int leastInterval(char[] tasks, int n) {
         Map<Character, Integer> count = new HashMap<>();
        for(char t: tasks) {
            count.put(t, count.getOrDefault(t, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue(count.size(), Collections.reverseOrder());
        pq.addAll(count.values());

        int ans = 0;

        while(!pq.isEmpty()) {
            int time = 0;
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < n+1; i++) {
                if(!pq.isEmpty()) {
                    temp.add(pq.remove() - 1);
                    time++;
                }
            }
            for(int t : temp) {
                if(t > 0) pq.add(t);
            }
            ans += pq.isEmpty() ? time : n+1;
        }
        return ans;
    }
}