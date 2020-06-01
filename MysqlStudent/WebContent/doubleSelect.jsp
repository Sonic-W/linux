<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Inse</title>
</head>
<body>
  <form method = "post" action="DoubleSelect">
    <table>
      <tr>
        <td>
                学号:
           <input type="text" name="stuno" size=20 />
        </td>
       
      </tr>
      
      <tr>
       <td>
        姓名：
        <input type="text" name="stuname" size=20/>
        </td>
      </tr>
      
      <tr>
       <td>
        性别:
          <select name="stusex">
            <option value="男">男</option>
            <option value="女">女</option>
          </select>
        </td>
      </tr>
      
      <tr>
       <td>
        专业：
        <input type="text" name="stumajor" size=20/>
        </td>
      </tr>
      
      <tr>
       <td>
        <input type=submit name=submit value='检索'/>
        </td>
      </tr>
    </table>
  </form>
</body>
</html>