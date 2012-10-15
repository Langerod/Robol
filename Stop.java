public class Stop implements Stmt{
    
    @Override
    public void interpret(){
        System.out.println("****************************************");
        System.out.println("The result is " + Robot.getPosAndDir());
    }
           
}