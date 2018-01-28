import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class LoadPoints {

    public Vector<Point> points= new Vector<Point>();

    LoadPoints(String path) throws IOException {
        try {
            FileReader FR = new FileReader(path);
            BufferedReader BR = new BufferedReader(FR);
            String line;

            while((line = BR.readLine())!=null) {
                String[] tmp=line.split("\t");
                points.add(new Point(tmp[0],Double.parseDouble(tmp[1]),Double.parseDouble(tmp[2]),Double.parseDouble(tmp[3])));
            }
            FR.close();
            BR.close();
        }
        catch (Exception e) {
            System.out.println("Problem with opening file");
            System.exit(1);
        }
    }

    public Vector<Point> getPoints() {
        return points;
    }
}
