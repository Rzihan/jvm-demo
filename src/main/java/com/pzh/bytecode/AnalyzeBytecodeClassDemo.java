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

    public static void main(String[] args) {
        AnalyzeBytecodeClassDemo analyzeBytecodeClassDemo = new AnalyzeBytecodeClassDemo();
        analyzeBytecodeClassDemo.setX(8);
        in = 20;
    }

    public void setX(int x) {
        this.x = x;
    }
}
