import java.io.IOException;
import java.util.Random;
import java.util.Vector;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Grouping extends LoadPoints {

    private Random rand = new Random();
    private Point centroid1,centroid2,centroid3;
    public Vector<Point> cluster1,cluster2,cluster3;
    public boolean notZero1=false,notZero2=false,notZero3=false;

    public Grouping(String path) throws IOException {
        super(path);
        drawPoints();
        cluster1=new Vector<Point>();
        cluster2=new Vector<Point>();
        cluster3=new Vector<Point>();
    }

    private void drawPoints() {
        centroid1=new Point("C1",rand.nextDouble(),rand.nextDouble(),rand.nextDouble());
        centroid2=new Point("C2",rand.nextDouble(),rand.nextDouble(),rand.nextDouble());
        centroid3=new Point("C3",rand.nextDouble(),rand.nextDouble(),rand.nextDouble());
    }

    private double calcDistance(Point p1,Point p2)
    {
       return sqrt(pow((p1.getX()-p2.getX()),2)+pow((p1.getY()-p2.getY()),2)+pow((p1.getZ()-p2.getZ()),2));
    }

    public void findNearestCentroid()
    {
        cluster1.clear(); cluster2.clear(); cluster3.clear();

        for(int i=0;i<points.size();i++) {

            if(calcDistance(points.elementAt(i),centroid1) <= calcDistance(points.elementAt(i),centroid2) &&
                    calcDistance(points.elementAt(i),centroid1) <= calcDistance(points.elementAt(i),centroid3)){
                cluster1.add(points.elementAt(i));
            }

            else if(calcDistance(points.elementAt(i),centroid2) <= calcDistance(points.elementAt(i),centroid1) &&
                    calcDistance(points.elementAt(i),centroid2) <= calcDistance(points.elementAt(i),centroid3)){
                cluster2.add(points.elementAt(i));
            }

            else if(calcDistance(points.elementAt(i),centroid3) <= calcDistance(points.elementAt(i),centroid1) &&
                    calcDistance(points.elementAt(i),centroid3) <= calcDistance(points.elementAt(i),centroid2)){
                cluster3.add(points.elementAt(i));
            }
        }
    }

    public void calcNewCentroids() {
        double sumX=0; double sumY=0; double sumZ=0;

        for(int i=0;i<cluster1.size();i++)
        {
            sumX+=cluster1.elementAt(i).getX();
            sumY+=cluster1.elementAt(i).getY();
            sumZ+=cluster1.elementAt(i).getZ();
        }
        if(cluster1.size()!=0) {
            centroid1 = new Point("C1",sumX / cluster1.size(), sumY / cluster1.size(), sumZ / cluster1.size());
            notZero1 = true;
        }
        else notZero1 = false;

        sumX=0; sumY=0; sumZ=0;

        for(int i=0;i<cluster2.size();i++)
        {
            sumX+=cluster2.elementAt(i).getX();
            sumY+=cluster2.elementAt(i).getY();
            sumZ+=cluster2.elementAt(i).getZ();
        }
        if(cluster2.size()!=0){
            centroid2 = new Point("C2",sumX / cluster2.size(),sumY / cluster2.size(),sumZ / cluster2.size());
            notZero2 = true;
        }
        else notZero2 = false;

        sumX=0; sumY=0; sumZ=0;

        for(int i=0;i<cluster3.size();i++)
        {
            sumX+=cluster3.elementAt(i).getX();
            sumY+=cluster3.elementAt(i).getY();
            sumZ+=cluster3.elementAt(i).getZ();
        }
        if(cluster3.size()!=0){
            centroid3 = new Point("C3",sumX / cluster3.size(),sumY / cluster3.size(),sumZ / cluster3.size());
            notZero3 = true;
        }
        else notZero3 = false;

    }

    public void printGroup(Vector<Point> cluster)
    {
        for(int i=0;i<cluster.size();i++){
            cluster.elementAt(i).printPoint();
        }
    }

    public Point getCentroid1() {
        return centroid1;
    }

    public void setCentroid1(Point centroid1) {
        this.centroid1 = centroid1;
    }

    public Point getCentroid2() {
        return centroid2;
    }

    public void setCentroid2(Point centroid2) {
        this.centroid2 = centroid2;
    }

    public Point getCentroid3() {
        return centroid3;
    }

    public void setCentroid3(Point centroid3) {
        this.centroid3 = centroid3;
    }
}
