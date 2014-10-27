package strategy;

public class Context {
    private Strategy strategy;
 
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }
    public String executeStrategy(int n, int [] arr) {
        return this.strategy.execute(n, arr);
    }
}
