<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/include/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>支付宝支付</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

<script type="text/javascript">
	function arrays(){
		var arrs=[{"name":"wangyonghe","mobile":"18510970050"},{"name":"guosai","mobile":"18510970050"}];
		for(var i=0;i<10;i++){
			//arrs.push("a_"+i);
			console.log(i);
		}
		$.ajax({
            dataType: "json",
            contentType : 'application/json',
            type: "POST",
            url:"${ctx}/alipay/arrays",
            data:JSON.stringify(arrs),
            error: function(data) {
                alert("Connection error");
            },
            success: function(data) {
            }
        });
	}
</script>
</head>

<body>
<form action="initCode">
	金额:<input name="amount" type="text" />
	<input type="submit"/>
</form>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button onclick="arrays()" text="测试数组" />
</body>
</html>