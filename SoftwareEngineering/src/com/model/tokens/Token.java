package com.model.tokens;

public class Token {
}

abstract class Instruction extends Token{}


abstract class Direction extends Token{}

abstract class Condition extends Token{}


abstract class Lr extends Token{}

//class St extends Token{
//    public int n;
//    St(int n) throws com.model.com.model.exceptions.BrainSyntaxIncorrectException {
//        if(n<10000)
//            this.n = n;
//        else
//            throw new com.model.com.model.exceptions.BrainSyntaxIncorrectException("Out of range");
//    }
//}
//
//class I extends Token {
//    public int n;
//    I(int n) throws com.model.com.model.exceptions.BrainSyntaxIncorrectException {
//        if(n<6)
//            this.n = n;
//        else
//            throw new com.model.com.model.exceptions.BrainSyntaxIncorrectException("Out of range");
//    }
//}


