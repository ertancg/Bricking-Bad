package factories;

import alien.Alien;
import alien.CooperativeAlien;
import alien.DrunkAlien;
import alien.ProtectingAlien;
import alien.RepairingAlien;

public class AlienFactory {

    public static Alien getAlien(String type) {

        switch(type) {
        case "CooperativeAlien" : return new CooperativeAlien(0,0);
        case "ProtectingAlien" : return new ProtectingAlien(0,0);
        case "RepairingAlien" : return new RepairingAlien(0,0);
        case "DrunkAlien" : return new DrunkAlien(0,0);
        }
        return null;
    }
}