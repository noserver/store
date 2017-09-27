package packA;
public class Father{
    protected void doSomething(){
        System.out.println("do something");
    }
    public static void main(String[] args){
        ChildA cc = new ChildA();
        cc.doSomething();
    }   
}
class ChildA extends Father{
    // public void doSomething(){
    //     System.out.println("child do something");
    // }
}