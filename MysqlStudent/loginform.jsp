<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<jsp:useBean id="user" class="com.ysu.entity.User" scope="request" />
<jsp:setProperty name="user"  property="*" />
<jsp:forward page="login" />//通过java的反射技术实现
//使用转发，原因是因为要保证他在同一次请求过程中