class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        // Sort the unique positions of all the edges.
        SortedSet<Integer> edgeSet = new TreeSet<Integer>();
        for (int[] building : buildings) {
            int left = building[0], right = building[1];
            edgeSet.add(left);
            edgeSet.add(right);
        }
        List<Integer> edges = new ArrayList<Integer>(edgeSet);
        
        // Hast table 'edgeIndexMap' record every {position : index} pairs in edges.
        Map<Integer, Integer> edgeIndexMap = new HashMap<>();
        for (int i = 0; i < edges.size(); ++i) {
            edgeIndexMap.put(edges.get(i), i);
        }

        // Initialize 'heights' to record maximum height at each index.
        int[] heights = new int[edges.size()];

        // Iterate over all the buildings.
        for (int[] building : buildings) {
            // For each building, find the indexes of its left
            // and right edges.
            int left = building[0], right = building[1], height = building[2];
            int leftIndex = edgeIndexMap.get(left), rightIndex = edgeIndexMap.get(right);
            
            // Update the maximum height within the range [left_idx, right_idx)
            for (int idx = leftIndex; idx < rightIndex; ++idx) {
                heights[idx] = Math.max(heights[idx], height);
            }
        }
        
        List<List<Integer>> answer = new ArrayList<>();

        // Iterate over 'heights'.
        for (int i = 0; i < heights.length; ++i) {
            int currHeight = heights[i], currPos = edges.get(i);

            // Add all the positions where the height changes to 'answer'.
            if (answer.isEmpty() || answer.get(answer.size() - 1).get(1) != currHeight) {
                answer.add(Arrays.asList(currPos, currHeight));
            }
        }
        return answer;
    }
}