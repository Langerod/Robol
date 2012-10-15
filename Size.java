public class Size implements Handler { 
 
    private int x_bound_global;
    private int y_bound_global; 
    
    @Override    
    public void interpret() { 
        // no interpret logic needed 
    } 
 
    public Size(int x_bound, int y_bound){ 
        x_bound_global = x_bound; 
        y_bound_global = y_bound; 
    }
    
    public int getXBound(){
        return x_bound_global;
    }

    public int getYBound(){
        return y_bound_global;
    }
} 
