import java.util.Scanner;

public class MainClass {
    //private String equation;
    //private Scanner scanEqn;
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int choice;

        System.out.println("Enter Equation to be Solved:\n");
        String eqn = scan.nextLine();

        System.out.println("Enter Method \n 1.Bisection Method \t 2.Fixed Point Iteration\n");
        choice = scan.nextInt();

        switch (choice)
        {
            case 1:
            {
                System.out.println("Enter Xl, Xu, Tolerance and Max Iteration");
                double xl,xu,tolerance;
                int maxIteration;
                xl = scan.nextDouble();
                xu = scan.nextDouble();
                tolerance = scan.nextDouble();
                maxIteration = scan.nextInt();

                Bisection b1 = new Bisection(eqn,0,1,10,100);
                b1.solve();



            }

        }




        //Bisection b1 = new Bisection(eqn,0,1,10,100);
        //b1.solve();
    }
    //c24e6eff8e759683a98206a98e29602b9d6d71d6;
}
