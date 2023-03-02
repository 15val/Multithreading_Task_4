import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Operator> list = new LinkedList<>();
        list.add(new Operator(1));
        list.add(new Operator(2));
        list.add(new Operator(3));
        list.add(new Operator(4));
        list.add(new Operator(5));

        OperatorPool<Operator> pool = new OperatorPool<>(list);
        for (int i = 0; i < 30; i++){
            new Client(pool).start();
        }
    }
}
