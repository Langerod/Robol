public class Forward extends Move implements Handler { 
     
    public Forward(Exp i){
        super(i);
    } 
    
    public void move(){
        System.out.println("Move: forward(" + getValue() + ")");
        Robot.move(getValue(), Robot.getDirection());
    }
} 
