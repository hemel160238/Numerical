import javaluator.DoubleEvaluator;
import javaluator.StaticVariableSet;

public class Bisection implements FunctionEvaluator {
    private String equation;
    private double xl,xu,tolerance;
    private int maxIteration;

    public Bisection(String equation, double xl, double xu, double tolerance, int maxIteration) {
        this.equation = equation;
        this.xl = xl;
        this.xu = xu;
        this.tolerance = tolerance;
        this.maxIteration = maxIteration;
    }

    public void solve()
    {
        double ea = 999,xr_previous = 100;
        int iter =1;
        double xr = 2.5;

        System.out.println("Iteration\t\tXl\t\tXu\t\tXr\t\t\tEa");


        while (iter <= maxIteration)
        {
            xr = (xl + xu)/2 ;

            if(iter>1)
            {
                ea = (xr - xr_previous)/xr*100;
            }

            //System.out.println(iter+"\t\t\t"+xl+"\t"+xu+"\t"+xr+"\t"+ea);

            if (ea < 0)
            {
                ea *= -1;
            }

            if( f(xr) == 0)
            {
                break;
            }

            if(iter > 1)
            {
                if ( ea <= tolerance )
                {
                    System.out.println(iter+"\t\t\t"+xl+"\t"+xu+"\t"+xr+"\t\t"+ea);
                    System.out.println("Found root of equation : "+xr);
                    //System.out.println("Iteration\t\tXl\t\tXu\t\tXr\t\t\tEa");
                    break;
                }
            }
            System.out.println(iter+"\t\t\t"+xl+"\t"+xu+"\t"+xr+"\t\t"+ea);

            if ( f(xl)*f(xr) < 0)
            {
                xu = xr;
            }

            else if (f(xl)*f(xr) > 0)
            {
                xl = xr;
            }

            xr_previous = xr;

            iter +=1;

        }

    }

    @Override
    public double f(double c) {

        //return (667.38 / c)*(1- Math.pow(Math.E,-0.146843*c)) - 40;
        //return -2+7*c-5*c*c+6*c*c*c;
        //return Math.pow(Math.E,-(c));
        //-2+7*x-5*x^2+6*x^3


        final DoubleEvaluator eval = new DoubleEvaluator();
        final StaticVariableSet<Double> variables = new StaticVariableSet<Double>();
        variables.set("x",c);
        Double result = eval.evaluate(equation,variables);
        return result;

    }
}
