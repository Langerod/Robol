public enum Direction{
    x, y, minusX, minusY;
        
    public static Direction getDirection(String dir){
        System.out.println("DIRECTION: '" + dir.charAt(0) + "'");
        
        if(dir.charAt(0) == '-'){
            System.out.print("MINUS ");
            if(dir.charAt(1) == 'x'){
                System.out.println("X");
                return minusX;
            }else{
                System.out.println("Y");
                return minusY;
            }
        }else{
            System.out.print("PLUS ");
            if(dir.charAt(0) == 'x'){
                System.out.println("X");
                return x;
            }else{
                System.out.println("Y");
                return y;
            }
        }
    }
    
    public static String directionToString(Direction dir){
        switch(dir){
        case x : return "x";
        case y  : return "y";
        case minusX : return "-x";
        case minusY : return "-y";
        }
        return "Error in enum Direction: invalid enum in directionToString.";
    }
    
    public static Direction getNewDirection(Direction prev, String dir){
        if(dir.equals("right")){
            switch(prev){
            case x : return minusY;
            case y : return x;
            case minusX : return y;
            case minusY : return minusX;
            }
        }else if(dir.equals("left")){
            switch(prev){
            case x : return y;
            case y : return minusX;
            case minusX : return minusY;
            case minusY : return x;
            }
        }else if(dir.equals("backward")){
            switch(prev){
            case x : return minusX;
            case y : return minusY;
            case minusX : return x;
            case minusY : return y;
            }
        }
        return prev;
    }
}