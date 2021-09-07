package solution;
import resources.classes.TextIO;
public class LargerQuadraticRootFinder {

    public static void main(String[]args) {
        System.out.println("Let's solve some quadratic equations. As a reminder, a quadratic equation is one that can");
        System.out.println("be displayed with the form Ax^2 + Bx + C = 0.");

        boolean userWantsToContinue = true;
        do{
            getUserInputToFindQuadraticRoot();

            System.out.println("Do you want to put in another quadratic equation? (Type \"Yes\" or \"No\")");
            String tempInput = TextIO.getlnString();
            if(tempInput.equals("no")||tempInput.equals("No")){
                userWantsToContinue = false;
                continue;
            }
            if (tempInput.equals("Yes")||tempInput.equals("yes")){
                continue;
            }

            while (true){
                tempInput = TextIO.getlnString();
                if(tempInput.equals("no")||tempInput.equals("No")){
                    userWantsToContinue = false;
                    break;
                }else if (tempInput.equals("Yes")||tempInput.equals("yes")){
                    break;
                }
            }
        }while (userWantsToContinue);
        System.out.println("Alright. Thanks for using this program!");
    }

    public static void getUserInputToFindQuadraticRoot(){
        System.out.println("Please type a value for \"A\"");
        double A = TextIO.getlnDouble();
        System.out.println("Please type a value for \"B\"");
        double B = TextIO.getlnDouble();
        System.out.println("Please type a value for \"C\"");
        double C = TextIO.getlnDouble();

        try{
            System.out.println("The larger quadratic root of " + A + "x^2 + " + B + "x + "+ C + " = 0 is "
            + findLargerQuadraticRoot(A,B,C));
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }
    }


    //------------------Provided in the textbook----------------------
    /**
     * Returns the larger of the two roots of the quadratic equation A*x*x + B*x + C = 0, provided it has any roots.
     * If A == 0 or if the discriminant, B*B - 4*A*C, is negative, then an exception of
     * type IllegalArgumentException is thrown.
     * @param A input "A" of the equation.
     * @param B input "B" of the equation.
     * @param C input "C" of the equation.
     * @return larger of the two roots of the equation, of type double.
     */
    public static double findLargerQuadraticRoot(double A, double B, double C) throws IllegalArgumentException{
        if (A == 0) {
            throw new IllegalArgumentException("A can’t be zero.");
        }
        else {
            double disc = B*B - 4*A*C;
            if (disc < 0)
                throw new IllegalArgumentException("Discriminant < zero.");
            return (-B + Math.sqrt(disc)) / (2*A);
        }
    }
}
