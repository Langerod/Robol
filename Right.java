public class Right extends Move{ 
     
    public Right(Exp i){
        super(i);
    } 
      
    public void move(){
        Robot.move(getValue(), Direction.getNewDirection(Robot.getDirection(), "right"));
    }
} 
