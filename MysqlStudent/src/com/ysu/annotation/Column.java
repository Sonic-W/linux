package com.ysu.annotation;

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/*
 *  数据库列的注解类
 */
@Target(ElementType.FIELD)//定义字段
@Retention(RetentionPolicy.RUNTIME)//定义注解什么时候生效，运行时生效
public @interface Column {
	String name();
	boolean autoIncrease() default false;
	boolean primaryKey() default false;
	boolean updateEnable() default true;//默认可以更新
	boolean isForeignEntity() default false;//是否是自定义对象
	boolean autoCreateTime() default false;//自动创建时间
}
