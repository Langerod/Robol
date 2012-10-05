public class Start implements Handler, Stmt{
    
    private Exp x;
    private Exp y;
    private Direction dir;
    
    @Override 
    public void interpret() { 
    }
    
    public Start(Exp x, Exp y, Direction dir){
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
    
}