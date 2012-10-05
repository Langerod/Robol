public class Numbers implements Handler{

    private int integer;
    
    @Override
    public void interpret(){   
    }
    
    public Numbers(int integer){
        this.integer = integer;
    }
    
    public int getValue(){
        return integer;
    }
}