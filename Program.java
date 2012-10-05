public class Program implements Handler{ 
 
    private Grid grid_Global = new Grid(); 
    private Robot robot_Global = new Robot(); 
    
    @Override 
    public void interpret() { 
        // write the interpret logic here if there is any 
    } 
  
    public Program(){ 
  
    } 
  
    public void addGrid(Grid grid_ins){ 
        grid_Global = grid_ins; 
    } 
  
    public void addRobot(Robot robot_ins){ 
        robot_Global = robot_ins; 
    }
    
    public void addStmt(Stmt stmt){
        
    }
    //.... 
 
} 
