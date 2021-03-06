import java.util.*;
import java.io.*;
import java.lang.*;

class MergeSort{
	
	static BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter out=new PrintWriter(System.out);
	public static void main(String args[])throws Exception{
		int T=Integer.parseInt(bf.readLine());
		while(T-->0){
			int N=Integer.parseInt(bf.readLine());
			int[] arr=new int[N];
			StringTokenizer stk=new StringTokenizer(bf.readLine());
			for(int i=0;i<N;i++)
				arr[i]=Integer.parseInt(stk.nextToken());
				
			breakArray(0,arr.length-1,arr);
			print(arr);
		}
	}
	
	public static void print(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
	}
	
	public static void merge(int lstrt,int lend,int rstrt,int rend,int[] arr){
		int leftsize=lend-lstrt+1;
		int rightsize=rend-rstrt+1;
		int[] La=new int[leftsize];
		int[] Ra=new int[rightsize];
		int index=lstrt;
		//form two auxiliary arrays to store these two arrays for mergeing
		for(int i=0;i<leftsize;i++){
			La[i]=arr[index];
			index++;
		}
		for(int i=0;i<rightsize;i++){
			Ra[i]=arr[index];
			index++;
		}
		index=lstrt;
		int size=leftsize+rightsize;
		int i=0;
		int j=0;
		int mainindex=lstrt;
		while(size-->0){
			if((i<leftsize && j<rightsize)  &&  La[i]<=Ra[j]){
				arr[mainindex]=La[i];
				i++;
				mainindex++;
			}else if((i<leftsize && j<rightsize)  && La[i]>Ra[j] ){
				arr[mainindex]=Ra[j];
				j++;
				mainindex++;
			}else if(i>=leftsize && j<rightsize){
				arr[mainindex]=Ra[j];
				j++;
				mainindex++;
			}else if(j>=rightsize && i<leftsize){
				arr[mainindex]=La[i];
				i++;
				mainindex++;
			}
		}
	}
	
	public static void breakArray(int strt,int end,int[] arr){
		if(strt==end)
			return ;
		
		if(end<strt)
			return ;
		
		int mid=(strt+end)/2;
		
		breakArray(strt,mid,arr);
		breakArray(mid+1,end,arr);
		merge(strt,mid,mid+1,end,arr);
	}
	
}
