package factories;

import powerups.ChemicalBall;
import powerups.DLG;
import powerups.FireBall;
import powerups.GangOfBalls;
import powerups.Magnet;
import powerups.PowerUp;
import powerups.TallerPaddle;

public class PowerUpFactory {
    public static PowerUp getPowerUp(String type) {
        switch(type) {
        case "TallerPaddle" : return new TallerPaddle(0,0);
        case "Magnet" : return new Magnet(0,0);
        case "DLG" : return new DLG(0,0);
        case "FireBall" : return new FireBall(0,0);
        case "ChemicalBall" : return new ChemicalBall(0,0);
        case "GangOfBalls" : return new GangOfBalls(0,0);
        }
        return null;
    }
}
