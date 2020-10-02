package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class no1544 {

	public static void main(String[] args) {
		no1544 test=new no1544();
		System.out.println(test.makeGood("abBAcC"));

	}
	
    public String makeGood(String s) {
    	
    	if(s.length()<=1)return s;
    	
    	StringBuilder res=new StringBuilder("");
    	Stack<Character> stack=new Stack<Character>();

    	stack.push(s.charAt(0));
    	for(int i=1;i<s.length();i++) {
    		char cur=s.charAt(i);
    		if(!stack.isEmpty()&&(stack.peek()^cur)==32) {
    			stack.pop();
    		}else {
    			stack.push(cur);
    		}
    	}
    	
    	while(!stack.isEmpty())
    		res.append(stack.pop());
    	
    	return res.reverse().toString();
    }
    
    public String makeGood1(String s) {
        int l = 0;
        int r = 1;
        while (true) {
            if (s.length() > 1 && Math.abs(s.charAt(l) - s.charAt(r)) == 32) {
                s = s.substring(0, l) + s.substring(r + 1);
                l = 0;
                r = 1;
                continue;
            } else if (r == s.length() - 1 || s.length() < 2) {
                break;
            } else {
                l++;
                r++;
            }
        }
        return s;
    }

}
