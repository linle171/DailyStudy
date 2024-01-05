package com.linle.test;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;

/**
 * @description:
 * @author: chendeli
 * @date: 2023-10-27 10:51
 */

public class LinleBean implements InitializingBean {
    public LinleBean() {
        System.out.println("进入linle-bean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化后LinleBean");
    }
}
