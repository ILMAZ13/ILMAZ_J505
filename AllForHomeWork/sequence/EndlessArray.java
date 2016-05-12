///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package sequence;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Iterator;
//import javax.annotation.Generated;
//
//
//
///**
// *
// * @author ILMAZ
// * @param <T>
// */
//public class EndlessArray<T> implements Iterable<Object>{
//    private T[] obj;
//            
//    public EndlessArray() {
//        obj = (T[]) new Object[0];
//
//    }
//    
//    public void add(T ob){
//        T[] obj2 = (T[]) new Object[obj.length + 1];
//        obj2[obj.length] = ob;
//        System.arraycopy(obj, 0, obj2, 0, obj.length);
//        obj = obj2;
//    }
//    
//    public T[] getArray(){
//        return obj;
//    }
//    
//    public static void main(String[] args){
//        EndlessArray<Integer> ea = new EndlessArray<>();
//        for (int i = 0; i < 20; i++){
//            ea.add(Math.abs((int) Math.round(Math.random()*100)));
//        }
//        for(Integer n : ea){
//            
//        }
//    }
//
//    @Override
//    public Iterator<T> iterator() {
//        return new EndlessArrayIterator<T>(obj);
//    }
//    
//    static class EndlessArrayIterator<T> implements Iterator<T>{
//
//        private T[] obj;
//        private int n = -1;
//        
//        public EndlessArrayIterator(T[] obj1){
//            this.obj = obj1;
//        }
//        
//        @Override
//        public boolean hasNext() {
//            if(obj.length >= n+1){
//                return true;
//            } 
//            else {
//                return false;
//            }
//        }
//
//        @Override
//        public T next() {
//            return obj[n++];
//        }
//        
//    }
//    
//}
