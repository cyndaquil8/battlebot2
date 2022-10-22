package despacito7;


import despacito7.util.AnimatingObject;
import despacito7.util.Coord;

class Player extends AnimatingObject{ //extends AnimatingObject
    public Player(){
        super(new Coord(10,10), ResourceLoader.createCharacterSprites(1));
        createAnimation("rightWalk",new int[]{0,4,8});
    }
}

// import java.util.HashMap;
// import java.util.Map;

// import despacito7.Constants.Direction;
// import despacito7.detail.Item;
// import despacito7.util.AnimatingObject;
// import despacito7.util.Coord;

// class Player extends AnimatingObject {
    // private static Player instance;
    // public static Player getPlayer() {
    //     if (instance == null) instance = new Player(new Coord(0,0));
    //     return instance;
    // }
    // private Direction dir = Direction.DOWN;
    // private int movestate;
    // private Map<Item, Integer> inventory = new HashMap<>();

    // private Player(Coord coord) {
    //     super(coord);
    // }
    
// }

