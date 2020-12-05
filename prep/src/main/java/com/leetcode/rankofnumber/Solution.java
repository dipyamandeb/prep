package com.leetcode.rankofnumber;

import java.lang.*;
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
    Scanner s=new Scanner(System.in);
    int n=s.nextInt();
    int m=s.nextInt();
    ArrayList<Integer> adj[]=new ArrayList[n+1];
    for(int i=0; i<=n; i++)
    {
        adj[i]=new ArrayList<>();
    }
    for(int i=0; i<m; i++)
    {
        int a=s.nextInt();
        int b=s.nextInt();
        adj[a].add(b);
        adj[b].add(a);
    }
    long sum=0;
    for(int i=1; i<=n; i++)
    {
        sum+=adj[i].size()*(n-1-adj[i].size());
    }
    sum=sum/2;
    long ans=(long)n*(n-1)*(n-2)/6-sum;
    System.out.println(ans);
    }

	}


