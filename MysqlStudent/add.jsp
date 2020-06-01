<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<jsp:useBean id="student" class="com.ysu.entity.Student" scope="request" />
<jsp:setProperty name="student"  property="*" />
<%
out.println();
%>
<%-- <jsp:forward page="register?op=reg" /> --%>