/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo;
/**
 *
 * @author ILMAZ
 */
public class Ford {
    private boolean[] visited;
    private Queue q = new Queue();
    private int s;
    private int t;
    private int n;
    private int[][] ps;
    public int  DoFord(int n, int[][] ps, int s, int t){
        visited = new boolean[n];
        this.n = n;
        this.s = s;
        this.t = t;
        this.ps = ps;
        int summ = 0;
        
        return summ;
    }
    
    private boolean find(int startVer){
        boolean stat = false;
        int[] pred = new int[n];
        
        
        int min = Integer.MAX_VALUE;
        visited[startVer] = true;
        for(int i = 0; i < n; i++){
            if(ps[startVer][i] > 0 && visited[i] == false){
                find(i);
            }
        }
        
        return stat;
    }
    
    private class Met{
        public int pred;
        public int pot;
        public Met(int pred, int pot)
    }
    
}
