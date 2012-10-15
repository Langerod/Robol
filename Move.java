public abstract class Move implements Stmt { 
    
    private Exp exp;
    
    public void interpret() {
        exp.interpret(); 
        move();
    } 
    
    public Move(Exp exp){
        this.exp = exp;
    }
    
    abstract public void move();
    
    public int getValue(){
        return exp.getValue();
    }
}