package com.example.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Target元注解表示允许这个注解可以使用的范围，这里我们只完成域的作用范围。
//@Retention元注解在这里表示该注解保留到运行时期。
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAutowired {

}