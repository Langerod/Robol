public class Backward extends Move implements Handler { 
     
    public Backward(Exp i){
        super(i);
    } 
    
    public void move(){
        Robot.move(getValue(), Direction.getNewDirection(Robot.getDirection(), "backward"));
    }
} 
