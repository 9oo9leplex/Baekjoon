package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class Baekjoon17298 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int inputNum = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		int[] seq = new int[inputNum];
		
		for(int i=0;i<inputNum;i++)
			seq[i] = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<inputNum;i++) {
			while(!stack.isEmpty() && seq[stack.peek()] < seq[i]) {
				seq[stack.pop()] = seq[i];
			}
			stack.push(i);
		}
		
		while(!stack.isEmpty())
			seq[stack.pop()] = -1;
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<seq.length;i++)
			sb.append(seq[i]).append(" ");
		
		System.out.println(sb);
		
		
		/*
		int[] seq = new int[inputNum];
		int[] stack = new int[inputNum];
		int top = -1;
		
		for(int i=0;i<inputNum;i++)
			seq[i] = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<inputNum;i++) {
			while(top != -1 && seq[stack[top]] < seq[i]) {
				seq[stack[top]] = seq[i];
				top--;
			}
			top++;
			stack[top] = i;
		}
	
		for(int i=top;i>=0;i--)
			seq[stack[i]] = -1;
		
		StringBuilder sb = new StringBuilder();
		for(int a : seq)
			sb.append(a).append(" ");
		
		System.out.println(sb);
		*/
	}
}
