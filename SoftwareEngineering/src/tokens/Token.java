package tokens;

public class Token {
}


abstract class Instruction extends Token{}

class Sense extends Instruction{}
class Mark extends Instruction{}
class Unmark  extends Instruction{}
class Drop extends Instruction{}
class Turn extends Instruction{}
class Move  extends Instruction{}
class Flip extends Instruction{}


abstract class Direction extends Token{}

class Here extends Direction{}
class Ahead extends Direction{}
class LeftAhead extends Direction{}
class RightAhead extends Direction{}

abstract class Condition extends Token{}

class Friend extends Condition{}
class Foe extends Condition{}
class FriendWithFood extends Condition{}
class FoeWithFood extends Condition{}
class Food extends Condition{}
class Rock extends Condition{}
class Marker extends Condition{}
class FoeMarker extends Condition{}
class Home extends Condition{}
class FoeHome extends Condition{}


abstract class Argument extends Token{}

class Left extends Argument{}
class Right extends Argument{}

class State extends Token{
    public int n;
    State(int n){
        this.n = n;
    }
}
