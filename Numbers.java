public class Numbers implements Handler{

    private int integer;
    
    @Override
    public void interpret(){   
        //no interpret logic needed
    }
    
    public Numbers(int integer){
        this.integer = integer;
    }
    
    public int getValue(){
        return integer;
    }
}