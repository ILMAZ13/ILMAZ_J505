import java.util.Iterator;

public class Task4I implements Iterable<Task3I> {
    private Iterator<Task3I> iter = new Iter();
    private Task3I[] o = new Task3I[12];
    public Iterator<Task3I> iterator() {
        return iter;
    }

    public Iterator<Task3I> getIter() {
        return iter;
    }

    public int size(){
        return o.length;
    }

    private class Iter implements Iterator<Task3I>{
        private int i = 0;
        private int count = o.length ;

        @Override
        public boolean hasNext() {
            return i < count;
        }

        @Override
        public Task3I next() {
            i++;
            return o[i-1];
        }
    }
}
