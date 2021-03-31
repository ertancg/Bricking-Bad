package factories;

import brick.Brick;
import brick.HalfMetalBrick;
import brick.MineBrick;
import brick.SimpleBrick;
import brick.WrapperBrick;

public class BrickFactory {

    public static Brick getBrick(String type) {
        switch(type) {
        case "SimpleBrick" : return new SimpleBrick(0,0);
        case "HalfMetalBrick" : return new HalfMetalBrick(0,0);
        case "MineBrick" : return new MineBrick(0,0);
        case "WrapperBrick" : return new WrapperBrick(0,0);
        }
        return null;
    }

}