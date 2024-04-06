package verify;

 class inner_class {
    class inner{
        public void write(){
            System.out.print("内部类！");
        }
    }
}
class test {
    public static void main(String[] args) {
        // 创建外部类的实例
        inner_class outer = new inner_class();

        // 使用外部类的实例创建内部类的实例
        inner_class.inner in = outer.new inner();

        // 使用内部类的实例调用其方法
        in.write();

        /*inner_class.inner inner = new inner_class().new inner();
        inner.write();*/
        //我们首先使用new inner_class()创建了一个inner_class的实例，然后使用.new inner()创建了一个inner类的实例。
    }
}
