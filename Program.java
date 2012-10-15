import java.util.LinkedList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;

public class Program implements Handler{ 
 
    private Grid grid; 
    private Robot robot;
    private LinkedList<Stmt> stmts;
    private static HashMap<String, Exp> ids;
    private String file;
    
    private IfThenElse ifThenElse;
    private boolean inElse;
    
    private While whileStmt;
    
    private Scanner sc;
    private String line;
    
    private boolean done;
    
    @Override 
    public void interpret() {

        try{           
            if(file == null){
                sc = new Scanner(System.in);
            }else{
                sc = new Scanner(new File(file));
            }
            
            System.out.println("****************************************");
            System.out.println("Robol interpreter with input from "
                               + ((file == null) ? " System.in." : (file + ".")));
            
            line = sc.nextLine().toLowerCase();
            if(line.startsWith("size")){
                addGrid(new Grid(new Size(Integer.parseInt(line.substring(5,line.indexOf("*"))), Integer.parseInt(line.substring(line.indexOf("*") + 1, line.indexOf(")"))))));
            }else{
                System.err.println("ERROR: Input didn't start with size(%*%)");
                System.exit(1);
            }
            
            do{
                line = sc.nextLine().toLowerCase();
                
                if(file != null){
                    System.out.println(line);
                }
                
                interpretStmt(line);
            }while(!line.equals("stop") && !done);
        }catch(Exception e){
            System.err.println("ERROR: An error occured during the input from "
                               + ((file == null) ? " System.in." : (file + ".")));
            e.printStackTrace();
            System.exit(1);
        }

        for(Stmt s : stmts){
            s.interpret();
        } 
    }
    
    private void interpretStmt(String line) throws Exception{
               
        String[] varID = line.split(" ");
              
        if(line.equals("}")){
            if(inElse){
                inElse = false;
            }else if((line = sc.nextLine()).equals("else")){
                interpretStmt(line);
            }else{
                ifThenElse = null;
                whileStmt = null;
                interpretStmt(line);
            }
        }else if(line.startsWith("start")){
            String[] args = line.substring(6, line.length() - 1).split(",");
            for(int i = 0; i < args.length; i++){
                args[i] = args[i].trim();
                
            }
            addStmt(new Start(new Exp(new Numbers(Integer.parseInt(args[0]))),
                              new Exp(new Numbers(Integer.parseInt(args[1]))),
                              Direction.getDirection(args[2])));
        }else if(line.startsWith("forward")){
            addStmt(new Forward(expFromLine(line.substring(7))));
        }else if(line.startsWith("backward")){
            addStmt(new Backward(expFromLine(line.substring(8))));
        }else if(line.startsWith("left")){
            addStmt(new Left(expFromLine(line.substring(4))));
        }else if(line.startsWith("right")){
            addStmt(new Right(expFromLine(line.substring(5))));
        }else if(line.startsWith("var")){
            String[] var = line.split(" ");
            new VarDecl(var[1], expFromLine(line.substring(line.indexOf("=") + 1))).interpret();
        }else if(line.startsWith("stop")){
            addStmt(new Stop());
            done = true;
        }else if(line.startsWith("down")){

        }else if(line.startsWith("up")){

        }else if(line.startsWith("if")){
            IfThenElse tmp = new IfThenElse(bExpFromLine(line.substring(3, line.length() - 1)));
            addStmt(tmp);
            ifThenElse = tmp;
            sc.nextLine();
        }else if(line.startsWith("else")){
            if(ifThenElse == null){
                System.err.println("ERROR: Else without if.");
                System.exit(1);
            }
            ifThenElse.setElse();
            inElse = true;
            sc.nextLine();      
        }else if(line.startsWith("while")){
            While tmp = new While(bExpFromLine(line.substring(6, line.length() - 1)));
            addStmt(tmp);
            whileStmt = tmp;
            sc.nextLine();
        }else if(line.contains("=")){
            Assignment ass = new Assignment(varID[0],
                                            expFromLine(line.substring(line.indexOf("=") + 1)));
            addStmt(ass);
        }else{
            System.err.println("ERROR: Unknown command '" + line + "'.");
            System.exit(1);
        }
    }
                
    private BooleanExp bExpFromLine(String line){
        String[] exps = null;
        String logic = null;
        
        if(line.contains(">")){
            exps = line.split(">", 2);
            logic = ">";
        }else if(line.contains("<")){
            exps = line.split("<", 2);
            logic = "<";
        }else if(line.contains("=")){
            exps = line.split("=", 2);
            logic = "=";
        }else{
            System.err.println("ERROR: If with no boolean expression: '"+line+"'");
            System.exit(1);
        }
        
        for(int i = 0; i < exps.length; i++){
            exps[i] = exps[i].trim();
        }
        
        return new BooleanExp(expFromLine(exps[0]), logic, expFromLine(exps[1]));
    }
    
    private Exp expFromLine(String line){
        
        if(line.contains(">") || line.contains("<") || line.contains("=")){
            return new Exp(bExpFromLine(line));
        }
        
        String[] plusMin;
        String[] args1;
                
        if(line.contains("+") || line.contains("-")){
            if(line.contains("(")){
                args1 = line.substring(line.indexOf("(") + 1, line.indexOf(")")).split("[+-]");
            }else{
                args1 = line.trim().split("[+-]");
            }
        }else{
            if(line.contains("(")){
                args1 = new String[]{line.substring(line.indexOf("(") + 1, line.indexOf(")"))};
            }else{
                args1 = new String[]{line.trim()}; 
            }             
        }
               
        int occ = 0;
        char[] chars = line.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == '+' || chars[i] == '-'){
                chars[occ++] = chars[i];
            }
        }
        
        plusMin = new String[occ];
        for(int i = 0; i < occ; i ++){
            plusMin[i] = "" + chars[i];
        }
        
        for(int i = 0; i < args1.length; i++){
            args1[i] = args1[i].trim();
        }
             
        String[][] args2 = new String[args1.length][];
        for(int i = 0; i < args2.length; i++){
            if(args1[i].contains("*")){
                args2[i] = args1[i].split("[*]");
            }else{
                args2[i] = new String[]{args1[i]};
            }
        }
        
        
        Exp exp;
        
        if(isNumeric(args2[0][0])){
            exp = new Exp(new Numbers(Integer.parseInt(args2[0][0])));
        }else{
            exp = new Exp(args2[0][0]);
        }
        
        for(int j = 1; j < args2[0].length; j++){
            if(isNumeric(args2[0][j])){
                exp = new Exp(new PlusExp(exp, "*", new Exp(new Numbers(Integer.parseInt(args2[0][j])))));
            }else{
                exp = new Exp(new PlusExp(exp, "*", new Exp(args2[0][j])));
            }
        }
        
        for(int i = 1; i < args2.length; i++){
            Exp tmpExp;
            if(isNumeric(args2[i][0])){
                tmpExp = new Exp(new Numbers(Integer.parseInt(args2[i][0])));
            }else{
                tmpExp = new Exp(args2[i][0]);
            }
            for(int j = 1; j < args2[i].length; j++){
                if(isNumeric(args2[i][j])){
                    tmpExp = new Exp(new PlusExp(tmpExp,
                                                 "*",
                                                 new Exp(new Numbers(Integer.parseInt(args2[i][j]))))); 
                }else{
                    tmpExp = new Exp(new PlusExp(tmpExp, "*" ,new Exp(args2[i][j]))); 
                }
            }
            exp = new Exp(new PlusExp(exp, plusMin[i-1], tmpExp));
        }
        
        return exp;
    }
        
    private boolean isNumeric(String s){
        try{
            Integer.parseInt(s);
        }catch(Exception e){
            return false;
        }
        return true;
    }
  
    public Program(){
        file = null;
        stmts = new LinkedList<Stmt>();
        robot = new Robot();
        grid = new Grid();
        robot.addGrid(grid);
        ids = new HashMap<String, Exp>();
        ifThenElse = null;
        inElse = false;
        whileStmt = null;
        done = false;
    }
    
    public Program(String file){
        this.file = file;
        stmts = new LinkedList<Stmt>();
        robot = new Robot();
        grid = new Grid();
        robot.addGrid(grid);
        ids = new HashMap<String, Exp>();
        ifThenElse = null;
        inElse = false;
        whileStmt = null;
        done = false;
    }
    
    public static void main(String[] args){
        if(args.length == 1){
            new Program(args[0]).interpret();
        }else{
            new Program().interpret();
        }
    }
  
    public void addGrid(Grid grid_ins){ 
        grid = grid_ins;
        robot.addGrid(grid_ins);
    } 
  
    public void addRobot(Robot robot_ins){ 
        robot = robot_ins; 
    }
    
    public void addStmt(Stmt stmt){
        if(ifThenElse != null){
            if(inElse){
                ifThenElse.addElseStmt(stmt);
            }else{
                ifThenElse.addIfStmt(stmt);
            }
        }else if(whileStmt != null){
            whileStmt.addStmt(stmt);
        }else{
            stmts.add(stmt);
        }
    }
    
    public static void addIdentifier(String id, Exp exp){
        if(ids.put(id, exp) != null){
            System.err.println("ERROR: Can't declare two variables with "
                                 + "same identifier ("+id+").");
            System.exit(1);
        }
    }
    
    public static void changeIdentifier(String id, Exp exp){
        ids.put(id, exp);        
    }
    
    public static Exp getExpFromIdentifier(String id){
        return ids.get(id);
    }
           
           
    
} 
