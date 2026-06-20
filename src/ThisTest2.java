package oops;
//this referes a current class object
//this can be used with variable, method and constructor
//this cannot be referred from static context
public class ThisTest2 {
    String name="shivdarshan";

    ThisTest2()
    {
        //this() must be at first line inside constructor
        System.out.println(" 0 param constructor");
        System.out.println("sadfdsf");
        this("thisssssssssssssss");

    }

    ThisTest2(String param)
    {
        System.out.println(" 1 param constructor: "+param);
        super();
    }

    public void showName()
    {
        String name="shreyash";
        System.out.println(name);
        System.out.println(this.name);
    }

    //this keyword at method level
    public void testMethod()
    {
        System.out.println("i am from test method");
        this.showName(); //call another instance method
    }

    public static void main(String[] args) {
        ThisTest2 thisTest2=new ThisTest2();//constructor call
        thisTest2.testMethod();

//        String name="viayalaxmi";
//        System.out.println(name);
//        System.out.println(this.name);  //not allowed
    }
}
