package battleship.boats;

/**
 * Created by arthurdeschamps on 05.05.17.
 */
public class TorpedoBoat extends Boat {

    public TorpedoBoat() {
        super(3);

        final String imagePath = "assets/SeaWarfareSet/Destroyer/ShipDestroyerHull.png";
        this.setImagePath(imagePath);
    }

}
