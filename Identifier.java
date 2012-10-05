public class Identifier implements Handler,Comparable<Identifier> { 
    
    private String id;
    private int value;
    
    @Override 
    public void interpret() { 
        // write the interpret logic here if there is any 
    }
    
    public Identifier(String id){
        this.id = id;
    }
    
    public Identifier(String id, int value){
        this.id = id;
        this.value = value;
    }
    
    public void setValue(int value){
        this.value = value;
    }
    
    public int getValue(){
        return value;
    }
    
    public String getName(){
        return id;
    }
    
    public int compareTo(Identifier id){
        return this.id.compareTo(id.getName());
    }
        
} 
