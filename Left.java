public class Left extends Move implements Handler { 
     
    public Left(Exp i){
        super(i);
    } 

    public void move(){
        System.out.println("Move: left");
        Robot.move(getValue(), Direction.getNewDirection(Robot.getDirection(), "left"));
    }
    
} 
