public class VarDecl implements Stmt{
    
    private String id;
    private Exp exp;
    
    @Override 
    public void interpret(){
        exp.interpret();
        Program.addIdentifier(id, exp);
    }
    
    public VarDecl(String id, Exp exp){
        this.id = id;
        this.exp = exp;
    }
}