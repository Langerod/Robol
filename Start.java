public class Start implements Stmt{
    
    private Exp x;
    private Exp y;
    private Direction dir;
    
    @Override 
    public void interpret(){
        x.interpret();
        y.interpret();
        Robot.setPosAndDir(x.getValue(), y.getValue(), dir);
        System.out.println("Interpret:START: " + x.getValue() + " " + y.getValue() + " " +dir);
    }
    
    public Start(Exp x, Exp y, Direction dir){
        this.x = x;
        this.y = y;
        this.dir = dir;
        //System.out.println("START: " + x.getValue() + " " + y.getValue() + " " +dir);
    }
    
    public int getX(){
        return x.getValue();
    }
    
    public int getY(){
        return y.getValue();
    }
    
    public Direction getDir(){
        return dir;
    }
}