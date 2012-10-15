public class Identifier implements Handler,Comparable<Identifier> { 
    
    private String id;
    private Exp exp;
    
    @Override 
    public void interpret() {
        exp.interpret();       
    }
    
    public Identifier(String id){
        this.id = id;
    }
    
    public Identifier(String id, Exp exp){
        this.id = id;
        this.exp = exp;
    }
    
    public void setExp(Exp exp){
        exp.interpret();
        this.exp = exp;
        System.out.println(id + " = " + exp.getValue());
    }
    
    public int getValue(){
        return exp.getValue();
    }
        
    public String getName(){
        return id;
    }
    
    public int compareTo(Identifier id){
        return this.id.compareTo(id.getName());
    }
           
} 
