package Model;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;

/**
 *
 * @author admin
 */
public class Centroid {

    private ArrayList<Double> points = new ArrayList<>();
    private ArrayList<Documents> docs = new ArrayList<>();
    private ArrayList<Double> newpoints = new ArrayList<>();

    public Centroid(ArrayList<Double> set_points) {
        points.addAll(0, set_points);
        newpoints.addAll(0, set_points);
    }

    ArrayList<Double> getpoints() {
        return points;
    }

    void AssignDocumentToCentroid(Documents d) {
        docs.add(d);
    }

    void clearlistOfDoc() {
        docs = new ArrayList<>();
    }

    void setPoints(ArrayList<Double> set_points) {
        points = new ArrayList<>();
        points.addAll(0, set_points);
    }

    ArrayList<Documents> getdocs() {
        return docs;
    }

    void setnewPoints(ArrayList<Double> temp) {

        newpoints = new ArrayList<>();
        newpoints.addAll(0, temp);

    }

    boolean compareCentroidPoints() {
        int counter = 0;
        if (points.size() == newpoints.size()) {
            for (int z = 0; z < points.size(); z++) {
                if (points.get(z).compareTo(newpoints.get(z)) == 0) {
                    counter += 0;
                } else {
                    counter++;
                }
            }
        } else {
            try {
                throw new CannotProceed("Number of components do not match", null, null);
            } catch (CannotProceed ex) {
                Logger.getLogger(Centroid.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return counter == 0;
    }

    void replaceOldPointsWithNew() {
        points = newpoints;
        newpoints = new ArrayList<>();
    }

}
