import android.net.Uri;

import com.example.floorvanlieshout.myfirstapp.Bestand;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Floor van Lieshout on 17-5-2017.
 */

public class Zorgverlener {
    private String specialisme;
    private ArrayList<Bestand> bestanden;

    public Zorgverlener(String hetSpecialisme) {
        specialisme = hetSpecialisme;
        bestanden = new ArrayList<>();
    }

    public void voegBestandenToe(Bestand b){
        bestanden.add(b);
    }

    public void voegBestandenToe(String deNaam, String deBeschrijving, Date deDatum, Uri deFotoUri){
        Bestand b = new Bestand(deNaam, deBeschrijving, deDatum, deFotoUri);
        bestanden.add(b);
    }

    public ArrayList<Bestand> getBestanden() {
        return bestanden;
    }

}
