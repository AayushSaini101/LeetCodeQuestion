import random
# import heapq

class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        def get_dist(p):
            return p[0] ** 2 + p[1] ** 2
        # quickselect algorithm
        # Time Complexity: avg O(n), WC: O(n^2)
        # Space Complexity: O(1)
        def quickselect(l, r):
            # random index selection            
            rand_index = random.randrange(l, r + 1)
            
            # switch rand_index element to the end
            points[r], points[rand_index] = points[rand_index], points[r]
            
            # calc pivot distance
            pivot_dist = get_dist(points[r])
            
            # init p to the left boundary
            p = l
            
            for i in range(l, r):
                # if curr should be to the left of pivot
                if get_dist(points[i]) > pivot_dist:
                    # swap
                    points[i], points[p] = points[p], points[i]
                    
                    # increase p
                    p += 1
            
            # move pivot to its correct position
            points[r], points[p] = points[p], points[r]
            
            # check if there are exactly k elements to the right of p including p
            partition_size = len(points) - p
            if partition_size == k:
                return points[p:]
            
            elif partition_size < k:
                return quickselect(l, p - 1)
            else:
                return quickselect(p + 1, r)
                
        return quickselect(0, len(points) - 1)
            
            
        
        
        
        # we can use a k-sized heap to keep track of the k closest
        # Complexity Analysis:
        # Time Complexity: O(nlogk)
        # Space Complexity: O(k)
        
        # init heap
        min_heap = []
        
        # iterate points
        for x, y in points:            
            # calc distance and push (-dist, x, y) to the heap
            curr_dist = x**2 + y**2
            heapq.heappush(min_heap, (-curr_dist, x, y))
            
            # if len of heap > k: pop
            if len(min_heap) > k:
                heapq.heappop(min_heap)
            
        # return only the points without the dist
        return [[x,y] for d,x,y in min_heap]
        
        