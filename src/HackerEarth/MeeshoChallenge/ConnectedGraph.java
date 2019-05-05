import java.util.*;
import java.io.*;

class ConnectedGraph{
	static BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter out=new PrintWriter(System.out);
	static StringBuilder finalstring=new StringBuilder("");
	static List<Integer>[] edgelist;
	static int[][] arr;
	static long min;
	public static void main(String args[])throws Exception{
		int T=Integer.parseInt(bf.readLine());
		while(T-->0){
			int N=Integer.parseInt(bf.readLine());
			edgelist=new List[N+1];
			for(int i=1;i<=N;i++){
				edgelist[i]=new ArrayList<>();
			}
			
			arr=new int[N+1][N+1];
			StringTokenizer stk;
			for(int i=1;i<=N;i++){
				stk=new StringTokenizer(bf.readLine());
				for(int j=1;j<=N;j++){
					arr[i][j]=Integer.parseInt(stk.nextToken());
				}
			}
			
			for(int i=1;i<=N;i++){
				for(int j=1;j<=i;j++){
					if(i!=j){
						edgelist[i].add(j);
						edgelist[j].add(i);
					}
				}
			}
			
			boolean flag=false;
			for(int i=1;i<=N;i++){
				for(int j=1;j<=i;j++){
					if(i==j && ( arr[i][j]!=0 || arr[j][i]!=0 ) ){
						flag=true;
						break;
					}else if(i!=j && ((arr[i][j]!=arr[j][i]) || (arr[i][j]==0 || arr[j][i]==0))){
						flag=true;
						break;
					}else if(i!=j){
						min=arr[i][j];
						HashSet<Integer> visited=new HashSet<>();
						visited.add(i);
						dfsForShortestPath(i,j, visited,0);
						if(min<arr[i][j]){
							flag=true;
							break;
						}
					}
				}
			}
			
			if(flag==true)
				out.println("NO");
			else
				out.println("YES");
		}
		out.close();
	}
	
	public static void dfsForShortestPath(int src,int des,HashSet<Integer> visited,int distance){
		//System.out.println(src+" "+des+" "+distance+" "+visited);
		if(src==des){
			if(distance<min)
				min=distance;
			//System.out.println(distance+" new distance bw"+src +" and "+des);
			return ;
		}
		
		for(int i=0;i<edgelist[src].size();i++){
			if(!visited.contains(edgelist[src].get(i))){
				visited.add(edgelist[src].get(i));
				dfsForShortestPath(edgelist[src].get(i),des,visited,distance+arr[src][edgelist[src].get(i)]);
				visited.remove(edgelist[src].get(i));
			}
		}
	}

}
