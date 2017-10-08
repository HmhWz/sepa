package com.hmh.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class BeanUtil implements ApplicationContextAware
{
    private static ApplicationContext applicationContext;

    public static Object getBean(String beanName)
    {
        return applicationContext.getBean(beanName);
    }

    public static <T> T getBean(String beanName, Class<T> clazs)
    {
        return null == getBean(beanName) ? null : clazs.cast(getBean(beanName));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        BeanUtil.applicationContext = applicationContext;
    }

}
