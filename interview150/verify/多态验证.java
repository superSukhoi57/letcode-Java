package verify;
//多态就是将子类的值赋给父类，父类调用重写方法时是调用子类的！
public class 多态验证 {
    public static void main(String[] args) {
    多态验证 multi=new 多态验证();
    son little=new son();
    multi.verify(little);
    }
    public void verify( father fa){
        //fa.hobby()//子类的方法多态访问不了！
        fa.work();
    }
}

class father{
    private int age;
    father(){
        age=28;
    }
    public void work(){
        System.out.print("BOSS!");
    }
}
class son extends father{
    public void hobby(){
        System.out.print("CF");
    }
    @Override
    public void work(){
        System.out.print("student");
    }
}
 interface port{
   int a=10;
   public abstract void run();
   public default void work(){
       System.out.print("add");
   }

}