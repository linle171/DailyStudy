package com.linle.abstractTest;

/**
 * @author chendeli
 * @Description:
 * @date 2023/3/6 14:33
 */
public abstract  class Animal {
    String name;
    Integer age;

    abstract void say();

    String play(String s){
        return name + " play " + s;
    }
}
