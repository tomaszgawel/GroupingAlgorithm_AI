import java.io.IOException;

public class GroupingController {

    Grouping Group = new Grouping("data.txt");
    Point c1=Group.getCentroid1();
    Point c2=Group.getCentroid2();
    Point c3=Group.getCentroid3();


    public GroupingController() throws IOException {

            int i=0;
            while(true)
            {

                Group.findNearestCentroid();
                Group.calcNewCentroids();

                if(checkPoint(c1,Group.getCentroid1()) && checkPoint(c2,Group.getCentroid2()) && checkPoint(c3,Group.getCentroid3())
                        && Group.notZero1 && Group.notZero2 && Group.notZero3) {
                    System.out.println("\nCENTROIDS AND GROUPS FOUND ON "+(i+1)+". ATTEMPT\n");
                    break;
                }
                else{
                    i++;
                    c1=Group.getCentroid1();
                    c2=Group.getCentroid2();
                    c3=Group.getCentroid3();

                }

                if(i==9999)
                {
                    System.out.print("First centroid: ");
                    Group.getCentroid1().printPoint();
                    System.out.print("Second centroid: ");
                    Group.getCentroid2().printPoint();
                    System.out.print("Third centroid: ");
                    Group.getCentroid3().printPoint();
                    System.out.println();
                    System.out.println("TO MANY ATTEMPTS, CENTROIDS NOT FOUND");
                    System.exit(1);
                }

            }

            System.out.print("First centroid: ");
            Group.getCentroid1().printPoint();
            System.out.println("First group of points: ");
            Group.printGroup(Group.cluster1);
            System.out.println();

            System.out.print("Second centroid: ");
            Group.getCentroid2().printPoint();
            System.out.println("Second group of points: ");
            Group.printGroup(Group.cluster2);
            System.out.println();

            System.out.print("Third centroid: ");
            Group.getCentroid3().printPoint();
            System.out.println("Third group of points: ");
            Group.printGroup(Group.cluster3);

    }

    private boolean checkPoint(Point p1,Point p2)
    {
        if( p1.getX()== p2.getX() && p1.getY() == p2.getY() && p1.getZ() == p2.getZ() )
            return true;
        else return false;
    }
}