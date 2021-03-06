/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class CodechefFirstQuestion
{
    static BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter out=new PrintWriter(System.out);
	static StringBuilder finalstring=new StringBuilder("");
	public static void main (String[] args) throws java.lang.Exception
	{
		int T=Integer.parseInt(bf.readLine());
    	while(T-->0){
    	    int N=Integer.parseInt(bf.readLine());
    	    HashMap<String,Integer> hm=new HashMap<>();
    	    List<String> namelist=new ArrayList<>(N+1);
    	    for(int i=0;i<N;i++){
    	    StringTokenizer stk=new StringTokenizer(bf.readLine());
    	    String fname=stk.nextToken();
    	    String lname=stk.nextToken();
    	    String fullname=fname+" "+lname;
    	    namelist.add(fullname);
    	    if(hm.containsKey(fname)){
    	        int temp=hm.get(fname);
    	        hm.put(fname,++temp);
    	    }else{
    	        hm.put(fname,1);
    	    }
    	    }
    	    System.out.println(hm);
    	 for(int i=0;i<N;i++){
    	     String name=namelist.get(i);
    	     String firstname=name.substring(0,name.indexOf(" "));
    	     if(hm.containsKey(firstname) && hm.get(firstname)>1){
    	         System.out.println(name);
    	     }else{
    	         System.out.println(firstname);
    	   }
    	 }   
    	}
	}
}

