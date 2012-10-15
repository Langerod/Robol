public class Assignment implements Stmt{
    
    private String id;
    private Exp exp;
    
    @Override 
    public void interpret(){
        exp.interpret();       
        Program.changeIdentifier(id, exp);
    }
    
    public Assignment(String id, Exp exp){
        this.id = id;
        this.exp = exp;
    }
}