public class Move implements Handler, Stmt { 
    
    private Exp exp;
    
    public void interpret() { 
        // write the interpret logic here if there is any 
    } 
    
    public Move(Exp exp){
        this.exp = exp;
    }
} 
