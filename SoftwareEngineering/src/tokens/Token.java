package tokens;

public class Token {
}

abstract class Instruction extends Token{}


abstract class Direction extends Token{}

abstract class Condition extends Token{}


abstract class Lr extends Token{}

//class St extends Token{
//    public int n;
//    St(int n) throws BrainSyntaxIncorrectException {
//        if(n<10000)
//            this.n = n;
//        else
//            throw new BrainSyntaxIncorrectException("Out of range");
//    }
//}
//
//class I extends Token {
//    public int n;
//    I(int n) throws BrainSyntaxIncorrectException {
//        if(n<6)
//            this.n = n;
//        else
//            throw new BrainSyntaxIncorrectException("Out of range");
//    }
//}


