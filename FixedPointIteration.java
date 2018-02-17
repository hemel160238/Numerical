public class FixedPointIteration implements FunctionEvaluator {
double xo,tolerance;
int maxIteration;

    public FixedPointIteration(double xo, double tolerance, int maxIteration) {
        this.xo = xo;
        this.tolerance = tolerance;
        this.maxIteration = maxIteration;
    }


    public void solve()
    {

    }

    @Override
    public double f(double c) {
        //return (667.38 / c)*(1- Math.pow(Math.E,-0.146843*c)) - 40;
        return -2+7*c-5*c*c+6*c*c*c;
        //return Math.pow(Math.E,-(c));

        /*
        final DoubleEvaluator eval = new DoubleEvaluator();
        final StaticVariableSet<Double> variables = new StaticVariableSet<Double>();
        variables.set("x",c);
        Double result = eval.evaluate(equation,variables);
        return result;
        */
    }
}
