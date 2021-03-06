import java.util.*;
import java.io.*;

class Test{
	static InputReader bf=new InputReader(System.in);
	static PrintWriter out=new PrintWriter(System.out);
	static StringBuilder finalprint=new StringBuilder("");
	static Map<Integer,ArrayList<Integer>> levelwiseSorted=new HashMap<>();
	static List<Integer>[] edgelist=new ArrayList[N+1];
	public static void main(String args[])throws Exception{
	int N=bf.nextInt();
	int Q=bf.nextInt();
	int[] val=new int[N+1];
	int strt=0;
	List<Integer>[] edgelist=new ArrayList[N+1];
	for(int i=1;i<=N;i++){
		val[i]=bf.nextInt();
	}
	for(int i=0;i<N-1;i++){
		
		int first=bf.nextInt();
		if(i==0)
			strt=first;
		int second =bf.nextInt();
		if(edgelist[first]==null){
			edgelist[first]=new ArrayList<>();
			edgelist[first].add(second);
		}else{
			edgelist[first].add(second);
		}
	}
	Queue letqueue=new LinkedList<Integer>();
		
	bfsOnTree(letqueue,strt,0);
	
	while(Q-->0){
		int levelq=bf.nextInt();
		int xq=bf.nextInt();
		
	}
	
	out.close();
	}
}


public static void bfsOnTree(Queue<Integer> qu,int strt,int level){
	
	qu.add(strt);
	while(!qu.isEmpty()){
		int nodecount=qu.size();
		ArrayList<Integer> templist=new ArrayList<>();
		while(nodecount>0){
			int popedvalue=(int)qu.remove();
			for(Integer val:edgelist[popedvalue]){
				templist.add(val);
				qu.add(val);
			}
		}
		Collections.sort(templist);
		levelwiseSorted.put(level,templist);
		level++;
	}
}

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

