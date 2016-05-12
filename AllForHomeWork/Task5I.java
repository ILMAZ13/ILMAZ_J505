import java.util.AbstractCollection;
import java.util.Iterator;

public class Task5I extends AbstractCollection<Task3I> {
    private Task4I task4I = new Task4I();

    @Override
    public Iterator<Task3I> iterator() {
        return task4I.getIter();
    }

    @Override
    public int size() {
        return task4I.size();
    }
}
