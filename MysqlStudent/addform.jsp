<%@page contentType="text/html;charset=utf-8" %> 

<html>
<head id="Head1" runat="server">
    <title>无标题页</title>
    <LINK href="style.css" type="text/css" rel="stylesheet">
    <script src="calendar.js"></script>
</head>
<body>
   <form method="post" name="stuform" action="register?op=reg" enctype="multipart/form-data" >
      <table width=600 border=0 cellpadding=0 cellspacing=0 align="center">
        <tr style="color:blue;font-size:14px;">
	  <td style="height: 14px">
          <img src="images/ADD.gif" width=14px height=14px/>学生信息管理--&gt;学生信息添加</td>
        </tr>
        <tr>
	  <td style="height: 26px">
         学号:
           <input type="text" name="stuno" size=20 />&nbsp;
         姓名:
         <input type="text" name="stuname" size=8 />         &nbsp;
         性别:
          <select name="stusex">
            <option value="男">男</option>
            <option value="女">女</option>
          </select><br/>
         出生日期:
         <input type=text readonly  size=10/>
          <input class="submit"  onClick="setDay(document.stuform.birthday);" style="width: 30px" type="button" value="选择">
        &nbsp;
         民族:
          <input type=text  size=4/>&nbsp;
         籍贯:
          <input type=text  size=10/><br />
         学院:
          <input type=text  size=8/>
          &nbsp;
         专业:
          <input type=text name="stumajor" size=8/>
          &nbsp;
         入学时间: 
          <input type=text readonly  size=10/>
          <input class="submit"   onClick="setDay(document.stuform.entrance);" style="width: 30px" type="button" value="选择">
          <br/>
        照片上传:
	      <input type=file name="stupic">
	      <br />
	   备注:
	   <textarea  rows=4 cols=50></textarea>      </td>
	</tr>
          <tr>
              <td style="height: 25px"><br>
                   <input type=submit name=submit value='添加'/>
                  <input type=button value='取消' onClick="javascript:location.href='addform.jsp';" />                  </td>
          </tr>
      </table>
</form>
</body>
</html>
