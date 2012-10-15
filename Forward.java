public class Forward extends Move implements Handler { 
     
    public Forward(Exp i){
        super(i);
    } 
    
    public void move(){
        Robot.move(getValue(), Robot.getDirection());
    }
} 
