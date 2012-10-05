public class BooleanExp implements Handler{ 
    
    private Exp exp1;
    private Exp exp2;
    private String operator;
    private boolean value;
    
    public BooleanExp(Exp exp1, String operator, Exp exp2){
        this.exp1 = exp1;
        this.operator = operator;
        this.exp2 = exp2;
        interpret();
    }
    
    @Override 
    public void interpret() { 
        if(operator.equals(">")){
            value = (exp1.getValue() - exp2.getValue()) > 0;
        }else if(operator.equals("<")){
            value = (exp1.getValue() - exp2.getValue()) < 0;
        }else if(operator.equals("=")){
            value = (exp1.getValue() - exp2.getValue()) == 0;
        }else{
            System.err.println("Unexpected operator '" + operator + "' in Boolean-exp");
            System.exit(1);
        }
    }
    
    
    
    public boolean getValue(){
        return value;
    }
} 
