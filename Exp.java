public class Exp implements Handler{
    
    private String id = null;
    private Numbers nr = null;
    private Exp exp = null;
    private PlusExp pExp = null;
    private BooleanExp bExp = null;
    
    private int value = Integer.MIN_VALUE;
    private boolean bValue;
    
    
    @Override
    public void interpret(){
        if(id != null){
            value = Program.getExpFromIdentifier(id).getValue();
        }else if(nr != null){
            nr.interpret();
            value = nr.getValue();
        }else if(exp != null){
            exp.interpret();
            if(exp.hasNumber()){
                value = exp.getValue();
            }else{
                bValue = exp.getBoolean();
            }
        }else if(pExp != null){
            pExp.interpret();
            value = pExp.getValue();
        }else{
            bExp.interpret();
            bValue = bExp.getValue();
        }
    }
    
    public Exp(String id){
        this.id = id;
    }
    
    public Exp(Numbers nr){
        this.nr = nr;
    }
    
    public Exp(PlusExp pExp){
        this.pExp = pExp;
    }
    
    public Exp(BooleanExp bExp){
        this.bExp = bExp;
    }

    public int getValue(){
        return value;
    }
    
    public boolean getBoolean(){
        return bValue;
    }
    
    public boolean hasNumber(){
        return (value != Integer.MIN_VALUE);
    }   
}