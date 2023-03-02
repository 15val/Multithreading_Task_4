public class Operator {
    private int operatorId;

    public Operator(int operatorId){
        this.operatorId = operatorId;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    public void speakingWithOperator(){
        try {
            Thread.sleep(50);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
