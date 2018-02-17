import javaluator.DoubleEvaluator;
import javaluator.StaticVariableSet;

public class FixedPointIteration implements FunctionEvaluator {
double xo,tolerance;
int maxIteration;
String equation;

    public FixedPointIteration(String equation,double xo, double tolerance, int maxIteration) {
        this.equation = equation;
        this.xo = xo;
        this.tolerance = tolerance;
        this.maxIteration = maxIteration;
    }


    public void solve()
    {
        double xr = xo,xr_previous,ea = 999;
        int iter =1;


        System.out.println("Iteration\tXi\t\tEa");
        while (iter <= maxIteration) {

            xr_previous = xr;
            xr = f(xr_previous);
            //System.out.println(iter+"\t\t\t"+xl+"\t"+xu+"\t"+xr+"\t"+ea);
            if (xr != 0) {
                if (iter > 1) {
                    ea = (xr - xr_previous) / xr * 100;
                }
            }

            if (ea < 0) {
                ea *= -1;
            }
            System.out.println(iter+"\t\t"+xr+"\t"+ea);
            if (iter > 1) {
                if (ea <= tolerance) {
                    System.out.println("Xr is : " + xr + " at error :" + ea + " %");
                    //System.out.println("Found root of equation : " + xr);

                    break;
                }
            }



            iter +=1;
        }


        System.out.println(iter+"\t\t\t"+xo+"\t"+xr+"\t\t"+ea);


    }


    @Override
    public double f(double c) {
        //return (667.38 / c)*(1- Math.pow(Math.E,-0.146843*c)) - 40;
        //return -2+7*c-5*c*c+6*c*c*c;
        return Math.pow(Math.E,-(c));

/*
        final DoubleEvaluator eval = new DoubleEvaluator();
        final StaticVariableSet<Double> variables = new StaticVariableSet<Double>();
        variables.set("x",c);
        Double result = eval.evaluate(equation,variables);
        return result;
        //return -2+7*c-5*c*c+6*c*c*c;
*/
    }
}
