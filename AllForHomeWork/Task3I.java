import java.util.Comparator;

public class Task3I implements Comparable<Task3I>{
    private int number;
    private String name;

    public Task3I(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Task3I o) {
        return Integer.compare(this.number, o.getNumber());
    }

    class Com1 implements Comparator<Task3I>{

        @Override
        public int compare(Task3I o1, Task3I o2) {
            return Integer.compare(o1.getNumber(), o2.getNumber());
        }
    }


}
