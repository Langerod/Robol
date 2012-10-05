public class Exp implements Handler{
    
    private Identifier id = null;
    private Numbers nr = null;
    private Exp exp = null;
    private PlusExp pExp = null;
    private BooleanExp bExp = null;
    
    private int value = Integer.MIN_VALUE;
    private boolean bValue;
    
    
    @Override
    public void interpret(){

    }
    
    public Exp(Identifier id){
        this.id = id;
        value = id.getValue();
    }
    
    public Exp(Numbers nr){
        this.nr = nr;
        value = nr.getValue();
    }
    
    public Exp(PlusExp pExp){
        this.pExp = pExp;
        value = pExp.getValue();
    }
    
    public Exp(BooleanExp bExp){
        this.bExp = bExp;
        bValue = bExp.getValue();
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