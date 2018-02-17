import java.util.Scanner;

public class MainClass {
    //private String equation;
    //private Scanner scanEqn;
    public static void main(String args[])
    {
        Scanner scanEqn = new Scanner(System.in);

        System.out.println("Enter Equation to be Solved:\n");
        String eqn = scanEqn.nextLine();

        System.out.println("Enter Method \n");

        //Bisection b1 = new Bisection(eqn,0,1,10,100);
        //b1.solve();

        FixedPointIteration b2 = new FixedPointIteration(eqn,0,10,100);
        b2.solve();
    }
    //c24e6eff8e759683a98206a98e29602b9d6d71d6;
}
