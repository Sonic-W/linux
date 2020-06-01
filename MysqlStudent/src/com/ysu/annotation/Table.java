package com.ysu.annotation;

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/*
 * 数据库表注解类
 */
@Target(ElementType.TYPE)//注解在类上面
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
	String prefix() default "";//表名前缀
	String tableName();//表名
	String sufix() default "";//表名后缀
}
