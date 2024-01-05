package com.linle.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: chendeli
 * @date: 2023-10-27 10:51
 */
public class TestSpring {
    @Test
    public void testIoC() {
        ApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        LinleBean lagouBean = applicationContext.getBean(LinleBean.class);
        System.out.println(lagouBean);
    }
}
