package strategy;

public class Context {
    private StrategySort strategy;
 
    public Context(StrategySort strategy) {
        this.strategy = strategy;
    }
    public String executeStrategy(int n, int [] arr) {
        return this.strategy.sorter(n, arr);
    }
}
