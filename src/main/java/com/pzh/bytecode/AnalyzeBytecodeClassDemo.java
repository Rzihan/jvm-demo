package com.pzh.bytecode;

/**
 * 用于自行分析字节码的文件结构
 * @author Pan梓涵
 * @date 2019/8/8 22:04
 */
public class AnalyzeBytecodeClassDemo {

    String str = "Welcome";

    private int x = 5;

    public static Integer in = 10;

    private final Object object = new Object();

    public static void main(String[] args) {
        AnalyzeBytecodeClassDemo analyzeBytecodeClassDemo = new AnalyzeBytecodeClassDemo();
        analyzeBytecodeClassDemo.setX(8);
        in = 20;
    }

    /**
    1、未加synchronized的字节码
    private void setX(int);
    descriptor: (I)V
    flags: ACC_PRIVATE
    Code:
      stack=2, locals=2, args_size=2
         0: aload_0
         1: iload_1
         2: putfield      #4                  // Field x:I
         5: return
      LineNumberTable:
        line 23: 0
        line 24: 5
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       6     0  this   Lcom/pzh/bytecode/AnalyzeBytecodeClassDemo;
            0       6     1     x   I

    2、加了synchronized之后的字节码
    private synchronized void setX(int);
    descriptor: (I)V
    flags: ACC_PRIVATE, ACC_SYNCHRONIZED
    Code:
      stack=2, locals=2, args_size=2
         0: aload_0
         1: iload_1
         2: putfield      #4                  // Field x:I
         5: return
      LineNumberTable:
        line 45: 0
        line 46: 5
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       6     0  this   Lcom/pzh/bytecode/AnalyzeBytecodeClassDemo;
            0       6     1     x   I

     下面两个是成对出现的
     moniterenter
     moniterexit

     synchronized可修饰实例方法，也可修饰静态方法
     */
    private synchronized void setX(int x) {
        this.x = x;
    }

    private void test() {
        synchronized (object) {
            System.out.println("hello world");
        }
    }

    private synchronized static void test2() {

    }
}
