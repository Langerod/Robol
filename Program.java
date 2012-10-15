import java.util.LinkedList;

public class Program implements Handler{ 
 
    private Grid grid; 
    private Robot robot;
    private LinkedList<Stmt> stmts;
        
    @Override 
    public void interpret() { 
        for(Stmt s : stmts){
            s.interpret();
        } 
    } 
  
    public Program(){ 
        stmts = new LinkedList<Stmt>();
        robot = new Robot();
        grid = new Grid();
        robot.addGrid(grid);
    } 
  
    public void addGrid(Grid grid_ins){ 
        grid = grid_ins;
        robot.addGrid(grid_ins);
    } 
  
    public void addRobot(Robot robot_ins){ 
        robot = robot_ins; 
    }
    
    public void addStmt(Stmt stmt){
        stmts.add(stmt);
    }
} 
