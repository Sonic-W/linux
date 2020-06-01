package com.ysu.annotation;

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/*
 *  ���ݿ��е�ע����
 */
@Target(ElementType.FIELD)//�����ֶ�
@Retention(RetentionPolicy.RUNTIME)//����ע��ʲôʱ����Ч������ʱ��Ч
public @interface Column {
	String name();
	boolean autoIncrease() default false;
	boolean primaryKey() default false;
	boolean updateEnable() default true;//Ĭ�Ͽ��Ը���
	boolean isForeignEntity() default false;//�Ƿ����Զ������
	boolean autoCreateTime() default false;//�Զ�����ʱ��
}
