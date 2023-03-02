import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class OperatorPool<Operator> {
    private int amountOfOperators = 5;
    private Semaphore semaphore = new Semaphore(amountOfOperators, true);
    private Queue<Operator> operators = new LinkedList<>();

    public OperatorPool(Queue<Operator> operators){
        this.operators.addAll(operators);
    }

    public Operator getOperator (long timeout) throws InterruptedException {
        try{
            if(semaphore.tryAcquire(timeout, TimeUnit.MILLISECONDS)){
                Operator operator = operators.poll();
                return operator;
            }
        }
        catch (InterruptedException e){
            throw new InterruptedException();
        }
        throw new InterruptedException(" time is out");
    }

    public void returnOperator(Operator operator){
        operators.add(operator);
        semaphore.release();
    }
}
