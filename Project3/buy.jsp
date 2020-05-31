<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
	</head>
	<body>
		<h2 align="center">商品列表</h2>
    <div align="center">
      <form action="processbuy.jsp" method="post">
        <table border="0" cellspacing="30">
          <tr>
            <th>商品名称</th>
            <th>购买</th>
            <th>价格</th>
          </tr>
          <tr>
          	<td>笔记本</td>
            <td><input type="checkbox" name="item" value="computer"></td>
            <td>￥5000</td>
          </tr>
          <tr>
          	<td>汽车</td>
            <td><input type="checkbox" name="item" value="car"></td>
            <td>￥200000</td>
          </tr>
          <tr>
          	<td>香水</td>
            <td><input type="checkbox" name="item" value="flower"></td>
            <td>￥500</td>
          </tr>
          <tr>
          	<td>书籍</td>
            <td><input type="checkbox" name="item" value="book"></td>
            <td>￥20</td>
          </tr>
		</table>
		
		<input type="submit" value="购买">      
      </form>
    </div>
	</body>
</html>
