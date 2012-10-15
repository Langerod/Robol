public class Grid implements Handler { 
    
    private Size size_Global = new Size(0,0); 
 
    @Override 
    public void interpret() { 
        // no interpret logic needed (yet?)
    }
    
    public Grid(){
    }
   
    public Grid(Size size_ins){ 
        size_Global = size_ins; 
    } 
    
    public int getXBound(){
        return size_Global.getXBound();
    }
    
    public int getYBound(){
        return size_Global.getYBound();
    }
 
} 
