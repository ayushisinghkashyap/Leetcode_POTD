class Solution {
    public int maxDistance(String s, int k) {
        // n:  The length of the input string
        int n = s.length();

        // netY:  Keeps track of the overall North-South movement
        // netX:  Keeps track of the overall East-West movement
        int netY = 0, netX = 0;

        // dist:  The maximum Manhattan distance we can achieve
        int dist = 0;

        // Loop through each direction in the string s
        for (int i = 0; i < n; i++) {
            // c:  The current direction character (N, S, E, or W)
            char c = s.charAt(i);

            // Update netY and netX based on the current direction
            switch (c) {
                // If North, increment netY
                case 'N': netY++; break;
                // If South, decrement netY
                case 'S': netY--; break;
                // If East, increment netX
                case 'E': netX++; break;
                // If West, decrement netX
                case 'W': netX--; break;
            }
            /*
Imagine that netY and netX are the coordinates on the map. 
Every time we encounter a direction, we simply move in that
direction, updating the coordinates.
            */

            // d:  Potential max Manhattan distance we can achieve so far
            // If we changed every steps until we reached, the Manhattan distance would be d
            int d = Math.abs(netY) + Math.abs(netX) + 2 * k;

            //  Update dist with the maximum Manhattan distance until we reached the current iteration i
            //  We compare if d or i+1 is larger
            //  Imagine if you have two options, which option would result in max Manhattan distance until we reach step i?
            //  If we changed every steps until we reached, the Manhattan distance would be d
            //  If we didn't change anything until we reached, the Manhattan distance would be i+1
            dist = Math.max(dist, Math.min(d, i + 1));
        }
/*
dist = Math.max(dist, Math.min(d, i + 1));

i + 1 - This is the number of steps we've taken so far. 
This is the maximum distance we could have traveled even 
if we'd gone in the same direction all the time.

Math.min(d, i + 1) - Take the minimum between d 
(the potential maximum distance with changes) 
and i + 1 (the maximum distance without changes). 
Why the minimum? Because we can't take more steps than we've taken.

Math.max(dist, Math.min(d, i + 1)) - Take the maximum between 
the current value of dist (the best distance we've found so far) 
and Math.min(d, i + 1) (the best distance we can achieve 
on the current step). We update dist if we find something better.*/

        // Return the maximum Manhattan distance we can achieve
        return dist;
    }
}