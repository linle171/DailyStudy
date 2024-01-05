package com.linle.concurrent.blockqueue;

/**
 * @author chendeli
 * @Description:
 * @date 2023/6/5 15:31
 */
public class AgeNum implements Comparable {
    Integer age;

    public AgeNum(Integer age) {
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        AgeNum temp = (AgeNum) o;
        return age.compareTo(temp.age);
    }
}
