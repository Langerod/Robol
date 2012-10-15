public class Robot implements Handler { 
    
    private static int xPos;
    private static int yPos;
    private static Direction direction;
    private static Grid grid;
        
    @Override 
    public void interpret() { 
        // write the interpret logic here if there is any        
    }  
    
    public Robot(){  
    }
    
    public Robot(int x, int y, Direction dir){
        xPos = x;
        yPos = y;
        direction = dir;
        
        //System.out.println(x + " " + y + " " + dir);
    }
    
    public static void move(int distance, Direction dir){
        
        //System.out.println("Robot moves " + Direction.directionToString(dir) + " " + distance);
        
        direction = dir;
        switch(dir){
        case x : 
            if((xPos + distance) > grid.getXBound()){
                System.err.println("ERROR: Can't move outside grid ("+xPos+","+yPos
                                   +")->("+xPos+distance+","+yPos+")");
                System.exit(1);
            }
            xPos += distance; break;
        case y : 
            if((yPos + distance) > grid.getYBound()){
                System.err.println("ERROR: Can't move outside grid ("+xPos+","+yPos
                                   +")->("+xPos+","+yPos+distance+")");
                System.exit(1); 
                
            }
            yPos += distance; break;
        case minusX : 
            if((xPos - distance) < 0){
                System.err.println("ERROR: Can't move outside grid (" + xPos + "," + yPos
                                   + ")->(" + (xPos - distance) + "," + yPos + ")");
                System.exit(1); 
                
            }
            xPos -= distance; break;
        case minusY : 
            if((yPos - distance) < 0){
                System.err.println("ERROR: Can't move outside grid (" + xPos + "," + yPos
                                   + ")->(" + xPos + "," + (yPos - distance) + ")");
                System.exit(1); 
                
            }
            yPos -= distance; break;
        }
    }
    
    public static void setPosAndDir(int x, int y, Direction dir){
        xPos = x;
        yPos = y;
        direction = dir;
        //System.out.println(x + " " + y + " " + dir);
    }
    
    public static int getYPos(){
        return yPos;
    }
    
    public static int getXPos(){
        return xPos;
    }
    
    public static Direction getDirection(){
        return direction;
    }
    
    public static String getPosAndDir(){
        return "(" + xPos + "," + yPos + "," + Direction.directionToString(direction) + ")";
    }
    
    public void addGrid(Grid grid){
        this.grid = grid;
    }
 
} 
