import java.text.DecimalFormat;
public class LinearEquation {
    DecimalFormat df = new DecimalFormat(".00");
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public LinearEquation(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }


    public double distance(){
        int xD = x2 - x1;
        int yD = y2 - y1;
        double distance = Math.pow(Math.pow(xD,2)+Math.pow(yD,2),0.5);
        distance = Math.round(distance*100);
        return distance/100;
    }
    public String slope(){
        String slope = "";
        double xD = x2 - x1;
        double yD = y2 - y1;
        if (xD == 0.0){
            return null;
        }
        return slope += (Math.round(yD/xD*100.0))/100.0;
    }
    public boolean verticalLineTest(){
        return x1==x2;
    }
    public double yIntercept(){

        double xSlope = x1 * Double.parseDouble(slope());
        double yIntercept = y1-xSlope;
        yIntercept = Math.round(yIntercept*100.0);
        return yIntercept/100.0;
    }
    public String equation(){
        double yInt = yIntercept();
        System.out.println(fracSlope());
        String equation = "y = ";
        if (fracSlope().equals("1")){
            equation += "x ";
        } else if(fracSlope().equals("-1")){
            equation += "-x ";
        } else if(y2-y1==0.0) {

        }
        else {
            equation+= fracSlope() + "x " ;
        }
        if(yInt>0){
            if(fracSlope().equals("")){
                equation += yInt;
            } else {
                equation += "+ " + yInt;
            }
        } else if (yInt<0){
            equation += "- " + Math.abs(yInt);
        } else if (yInt==0.0){

        }
        else {
            return equation;
        }
        return equation;
    }
    public boolean positive(){
        double xD = x2 - x1;
        double yD = y2 - y1;
        return (xD<0 && yD<0) || (xD>=0 && yD>=0);
    }
    // method used to help make the slope in the simplest form//
    public int greatestCommonFactor(){
        String factorList = "";
        double xD = Math.abs(x2 - x1);
        double yD = Math.abs(y2 - y1);
        double max = Math.max(xD, yD);
        if (xD == yD){
            factorList += (int)yD;
            return Integer.parseInt(factorList);
        } else {
            for (int i = 1; i<max; i++){
                if(yD%i==0 && xD%i==0){
                    factorList += i;
                }
            }
        }
        int len = factorList.length();
        String sub = factorList.substring(len-1);
        int gcf = Integer.parseInt(sub);
        return gcf;
    }
// method used to print the slope in the simplest form//
    public String fracSlope(){
        String slope = "";
        double xD = Math.abs(x2 - x1);
        double yD = Math.abs(y2 - y1);
        String negativeSign = "";
        if (!positive()){
            negativeSign = "-";
        }
        if (xD == greatestCommonFactor()){
            return slope += negativeSign + (int)(yD/xD);
        }
        int gcf = greatestCommonFactor();
        return slope += negativeSign + (int)yD/gcf + "/" + (int)xD/gcf;
    }
    public String lineInfo(){
        if (verticalLineTest()){
            String x = "These points are on a vertical line: x= " + x1;
            return x;
        }
        String line = ("The two points are : (" + x1 + "," + y1 + ")" + " and " + "(" + x2 + "," + y2 + ")");
        line += "\n" + "The equation between these points is: " + equation();
        line += "\n" + "The slope of this line is: " + slope();
        line += "\n" + "The y-intercept of the line is: " + yIntercept();
        line += "\n" + "The distance between the two points is " + distance();
        return line;
    }
    public String coordinateForX(double x){
        String point = "The point on the line is (" + x + ",";
        double yValue = x * Double.parseDouble(slope()) + yIntercept();
        return point += yValue + ")";
    }
}
