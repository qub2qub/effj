package effj.ch08.item46;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by den on 2017-11-05
 */
public class FacesIteration {

    enum Face {ONE, TWO, THREE, FOUR, FIVE, SIX}

    public static void main(String[] args) {
        Collection<Face> faces = Arrays.asList(Face.values());

        for (Iterator<Face> i = faces.iterator(); i.hasNext(); ) {
            for (Iterator<Face> j = faces.iterator(); j.hasNext(); ) {
                System.out.println(i.next() + " -- " + j.next());
            }
        }
    }

}
