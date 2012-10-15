import java.util.LinkedList;

public class While implements Stmt{
    
    private BooleanExp bExp;
    private LinkedList<Stmt> stmts;
    
    @Override 
    public void interpret(){
        bExp.interpret();
        while(bExp.getValue()){
            for(Stmt stmt : stmts){
                stmt.interpret();
            }
            bExp.interpret();
        }
    }
    
    public While(BooleanExp bExp){
        this.bExp = bExp;
        stmts = new LinkedList<Stmt>();
    }
    
    public void addStmt(Stmt stmt){
        stmts.add(stmt);
    }    
}