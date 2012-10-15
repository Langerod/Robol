public class Left extends Move implements Handler { 
     
    public Left(Exp i){
        super(i);
    } 

    public void move(){
        Robot.move(getValue(), Direction.getNewDirection(Robot.getDirection(), "left"));
    }
    
} 
