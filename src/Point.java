import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Point {

    private double X,Y,Z;
    private String index;

    Point(String i,double x,double y, double z) {
        this.index=i;
        this.X=x;
        this.Y=y;
        this.Z=z;
    }

    public void printPoint()
    {
        NumberFormat formatter = new DecimalFormat("#0.00");
        System.out.println(index+" ( "+formatter.format(getX())+" ; "+formatter.format(getY())+" ; "+formatter.format(getZ())+" )");
    }

    public double getX() {
        return X;
    }

    public void setX(double x) {
        X = x;
    }

    public double getY() {
        return Y;
    }

    public void setY(double y) {
        Y = y;
    }

    public double getZ() {
        return Z;
    }

    public void setZ(double z) {
        Z = z;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }
}
