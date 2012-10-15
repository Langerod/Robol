import java.util.LinkedList;

public class IfThenElse implements Stmt{
    
    private BooleanExp bExp;
    private LinkedList<Stmt> ifStmts;
    private LinkedList<Stmt> elseStmts;
    private boolean isElse;
    
    @Override 
    public void interpret(){
        bExp.interpret();
        if(bExp.getValue()){
            for(Stmt stmt : ifStmts){
                stmt.interpret();
            }
        }else if(isElse){
            for(Stmt stmt : elseStmts){
                stmt.interpret();
            }
        }
    }
    
    public IfThenElse(BooleanExp bExp){
        this.bExp = bExp;
        ifStmts = new LinkedList<Stmt>();
        isElse = false;
    }
    
    public void addIfStmt(Stmt stmt){
        ifStmts.add(stmt);
    }
    
    public void addElseStmt(Stmt stmt){
        elseStmts.add(stmt);
    }
    
    public void setElse(){
        elseStmts = new LinkedList<Stmt>();
        isElse = true;
    }
    
    
}