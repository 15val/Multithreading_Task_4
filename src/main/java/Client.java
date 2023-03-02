public class Client extends Thread {
    private OperatorPool<Operator> pool;

    public Client(OperatorPool<Operator> pool){
        this.pool = pool;
    }

    public void run(){
        Operator operator = null;
        try {
            operator = pool.getOperator(500);
            System.out.println("Client " + this.getId() + " is speaking with operator " + operator.getOperatorId());
            operator.speakingWithOperator();
        }
        catch (InterruptedException e) {
            System.out.println("Client " + this.getId() + " escaped: " + e.getMessage());
        }
        finally {
            if(operator != null){
                System.out.println("Client " + this.getId() + " stopped speaking with operator " + operator.getOperatorId());
                pool.returnOperator(operator);
            }
        }
    }
}
