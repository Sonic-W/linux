package com.ysu.annotation;

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/*
 * ���ݿ��ע����
 */
@Target(ElementType.TYPE)//ע����������
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
	String prefix() default "";//����ǰ׺
	String tableName();//����
	String sufix() default "";//������׺
}
