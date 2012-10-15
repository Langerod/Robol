public class Right extends Move{ 
     
    public Right(Exp i){
        super(i);
    } 
      
    public void move(){
        //System.out.println("Move: right");
        Robot.move(getValue(), Direction.getNewDirection(Robot.getDirection(), "right"));
    }
} 
