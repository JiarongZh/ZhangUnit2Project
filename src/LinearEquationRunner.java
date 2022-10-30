import java.util.Scanner;
public class LinearEquationRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Linear Equation Program");
        System.out.print("Coordinate 1: ");
        String cord1 = scan.nextLine();
        int index1 = cord1.indexOf(",");
        int len1 = cord1.length();
        int x1 = Integer.parseInt(cord1.substring(1,index1));
        int y1 = Integer.parseInt(cord1.substring(index1+2,len1-1));
        System.out.print("Coordinate 2: ");
        String cord2 = scan.nextLine();
        int index2 = cord2.indexOf(",");
        int len2 = cord2.length();
        int x2 = Integer.parseInt(cord2.substring(1,index2));
        int y2 = Integer.parseInt(cord2.substring(index2+2,len2-1));
        LinearEquation equation = new LinearEquation(x1, y1, x2, y2);
        if (equation.verticalLineTest()){
            System.out.println("\n" + equation.lineInfo());
        } else {
            System.out.println("Equation: " + equation.equation());
            System.out.println("Slope: " + equation.slope());
            System.out.println("y-intercept: " + equation.yIntercept());
            System.out.println("Distance: " + equation.distance());
            System.out.println();
            System.out.println("----- Line info -----");
            System.out.println(equation.lineInfo());
            System.out.println();
            System.out.println("Enter a coordinate for X:");
            double cord = scan.nextInt();
            System.out.println(equation.coordinateForX(cord));

        }
    }
}