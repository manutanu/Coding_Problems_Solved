import java.util.*;
import java.io.*;

class TreePlay{
	static InputReader bf=new InputReader(System.in);
	static PrintWriter out=new PrintWriter(System.out);
	static StringBuilder finalprint=new StringBuilder("");
	static int[] value;
	static int flag;
	public static void main(String args[])throws Exception{
		int N=bf.nextInt();
		int Q=bf.nextInt();
		value=new int[N+1];
		for(int i=1;i<=N;i++){
			value[i]=bf.nextInt();
		}
		HashMap<Integer,ArrayList<Integer>> edgelist=new HashMap<>();
		
		for(int i=0;i<N-1;i++){
			int src=bf.nextInt();
			int des=bf.nextInt();
			if(edgelist.containsKey(src)){
				edgelist.get(src).add(des);
				if(edgelist.containsKey(des)){
					edgelist.get(des).add(src);
				}else{
					ArrayList<Integer> temp1=new ArrayList<>();
					temp1.add(src);
					edgelist.put(des,temp1);
				}
			}else{
				ArrayList<Integer> temp=new ArrayList<>();
				temp.add(des);
				edgelist.put(src,temp);
				if(edgelist.containsKey(des)){
					edgelist.get(des).add(src);
				}else{
					ArrayList<Integer> temp1=new ArrayList<>();
					temp1.add(src);
					edgelist.put(des,temp1);
				}
			}
		}	
		
		for(int i=0;i<Q;i++){
			flag=0;
			int src=bf.nextInt();
			int des=bf.nextInt();
			dfs(src,des,edgelist,value[src],new HashSet<Integer>());
			//System.out.println(flag+" hellow "+" "+ value[src]);
			if(flag==0){
				finalprint.append("Alex").append('\n');
			}else if(flag>0){
				finalprint.append("Bob").append('\n');
			}
		}
		out.println(finalprint.toString());
		out.close();
	}
	
	
	public static int dfs(int src,int des,HashMap<Integer,ArrayList<Integer>> edgelist, int xorvalue,HashSet<Integer> visited){
		visited.add(src);
		if(src==des){
			flag=xorvalue;
			return xorvalue;
		}
		
		int xorvaluecurrent=0;
		for(int i=0;i<edgelist.get(src).size();i++){
			//System.out.println(src+" "+des+" "+edgelist.get(src).get(i)+" "+edgelist+" "+visited+" "+xorvalue );
			if(!visited.contains(edgelist.get(src).get(i))){
				visited.add(edgelist.get(src).get(i));
				xorvaluecurrent=dfs(edgelist.get(src).get(i),des,edgelist,xorvalue^value[edgelist.get(src).get(i)],visited);
			}
		}
		
		return xorvaluecurrent;
		//return xorvaluecurrent;
	}
}

/*
10 5
12 3 4 5 89 77 89 77 3 55
1 2
2 3
1 4
4 5
3 6
6 7
5 8
1 9
9 10
1 4
1 5
4 10
3 10
4 9
*/

//Fast IO

class InputReader{

	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;
	private SpaceCharFilter filter;

	public InputReader(InputStream stream) {
		this.stream = stream;
	}

	public int read() {
		if (numChars == -1) {
			throw new InputMismatchException();
		}

		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}

			if (numChars <= 0) {
				return -1;
			}
		}
		return buf[curChar++];
	}

	public String nextLine() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}

	public int nextInt() {
		int c = read();

		while (isSpaceChar(c)) {
			c = read();
		}

		int sgn = 1;

		if (c == '-') {
			sgn = -1;
			c = read();
		}

		int res = 0;
		do {
			if (c < '0' || c > '9') {
				throw new InputMismatchException();
			}
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));

		return res * sgn;
	}

	public long nextLong() {
		int c = read();
		while (isSpaceChar(c)) {
			c = read();
		}
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		long res = 0;

		do {
			if (c < '0' || c > '9') {
				throw new InputMismatchException();
			}
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

	public double nextDouble() {
		int c = read();
		while (isSpaceChar(c)) {
			c = read();
		}
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		double res = 0;
		while (!isSpaceChar(c) && c != '.') {
			if (c == 'e' || c == 'E') {
				return res * Math.pow(10, nextInt());
			}
			if (c < '0' || c > '9') {
				throw new InputMismatchException();
			}
			res *= 10;
			res += c - '0';
			c = read();
		}
		if (c == '.') {
			c = read();
			double m = 1;
			while (!isSpaceChar(c)) {
				if (c == 'e' || c == 'E') {
					return res * Math.pow(10, nextInt());
				}
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				m /= 10;
				res += (c - '0') * m;
				c = read();
			}
		}
		return res * sgn;
	}

	public String readString() {
		int c = read();
		while (isSpaceChar(c)) {
			c = read();
		}
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isSpaceChar(c));

		return res.toString();
	}

	public boolean isSpaceChar(int c) {
		if (filter != null) {
			return filter.isSpaceChar(c);
		}
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}

	public String next() {
		return readString();
	}

	public interface SpaceCharFilter {

		public boolean isSpaceChar(int ch);
	}
}

