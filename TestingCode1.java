//package no.uio.ifi.no;

public class TestingCode1 {
 
    public static void main(String[] args){
        Program pro_inst = new Program(); 
        pro_inst.addGrid( new Grid ( new Size(64,64))); 
        pro_inst.addStmt(new Start(new Exp(new Numbers(23)), new Exp(new Numbers(30)), new Direction("‐x"))); 
        pro_inst.addStmt(new Forward(new Exp(new Numbers(15))));
        pro_inst.addStmt(new Left(new Exp(new Numbers(15))));
        pro_inst.addStmt(new Right(new Exp(new PlusExp(new Exp(new Numbers(2)), "+", new Exp(new Numbers(3))))));
        pro_inst.addStmt(new Backward(new Exp(new PlusExp(new Exp(new Numbers(10)), "+", new Exp(new Numbers(27))))));
        pro_inst.addStmt(new Stop());
    } 
} 
