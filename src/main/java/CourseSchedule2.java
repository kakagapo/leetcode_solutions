import java.util.Arrays;
import java.util.*;

public class CourseSchedule2 {
	public static HashMap<Integer, List<Integer>> constructAdjacency(int nodeCount, int[][] prerequisites){
		HashMap<Integer, List<Integer>> adjacency = new HashMap<>(nodeCount);
		for(int i=0 ; i < prerequisites.length; i++){
			int src = prerequisites[i][1], dst = prerequisites[i][0];
					
			List<Integer> adjNodes = adjacency.get(src);
			if(adjNodes == null){
				adjNodes = new ArrayList<>();
				adjacency.put(src, adjNodes);
			}
			adjNodes.add(dst);
		}
		return adjacency;
	}
	
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		if(numCourses == 0){
	        return null; 
	    }else if(numCourses == 1){
	        return new int[]{0};
	    }
		//do topological sort
		
		//1) Create adjacency list using HashMap + create a visited map(used to find loops)
		//2) Do a DFS(only this way you can find loops) 
		
		HashMap<Integer, List<Integer>> adjacency = constructAdjacency(numCourses, prerequisites);
		
		Set<Integer> visited = new HashSet<>(numCourses);
		Set<Integer> onStack = new HashSet<>(numCourses);
		//List<Integer> result = new ArrayList<>(numCourses);
		Stack<Integer> result = new Stack<>();
		for(Map.Entry<Integer, List<Integer>> adjEntry :  adjacency.entrySet()){
			//used to detect cycles
			if(!dfs(adjacency, adjEntry.getKey(), onStack , visited, result)){
				System.out.println("cycle detected");
				return new int[0];
			}
		}
		
		for(int i=0;i<numCourses;i++){
			if(!visited.contains(i)){
				result.add(i);
			}
		}
		
		int[] output = new int[numCourses];
		int i= 0;
		while (!result.isEmpty()) {
            output[i++] = result.pop();
        }
		
		return output;
    }
	
	public static int[] convertToArray(List<Integer> list){
		int[] out = new int[list.size()];
		int i = 0;
		for(int val: list){
			out[i++] = val;
		}
		return out;
	}
	
	boolean dfs(HashMap<Integer, List<Integer>> adjacency, 
			Integer node, 
			Set<Integer> onstack,
			Set<Integer> visited,
			Stack<Integer> result){
		System.out.println(node + " --> checking");
			if(onstack.contains(node)){
				System.out.println(node + " part of cycle");
				//cycle detected, so topo sort not possible
				return false; 
			}
			if(visited.contains(node)){
				//early termination
				return true;
			}
			
			visited.add(node);
			onstack.add(node);
			
			
			List<Integer> children = adjacency.get(node);
			if(children != null){
				for(Integer child: children){
					System.out.println("Going to call dfs on child");
					if(!dfs(adjacency, child, onstack, visited, result)){
						return false;
					}
				}
			}
			
			onstack.remove(node);
			
			//add to result
			result.add(node);
			return true;
	}
	

	public static void main(String[] args) {
		CourseSchedule2 solution = new CourseSchedule2();
		
		int[][] prereq1 = {{1,0},{2,0},{3,1},{3,2}};
		int[] answer1 = solution.findOrder(4, prereq1);
		System.out.println(Arrays.toString(answer1));
		
		int[][] prereq2 = {{1,0}};
		int[] answer2 = solution.findOrder(2, prereq2);
		System.out.println(Arrays.toString(answer2));
	}

}
