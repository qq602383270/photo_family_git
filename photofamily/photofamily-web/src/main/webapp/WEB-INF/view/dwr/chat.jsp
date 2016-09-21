<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/include/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>Chat</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

<script type="text/javascript" src="${ctx}/dwr/engine.js"></script>
<script type="text/javascript" src="${ctx}/dwr/util.js"></script>
<script type="text/javascript" src="${ctx}/dwr/interface/ChatService.js"></script>
<script type="text/javascript">
$(function(){  
$('#code').qrcode({
		width: '50%', //宽度 
	    height:'50%', //高度 
	    text: location.href //二维码内容
			}
		);
});
	function send() {

		var time = new Date();
		var content = dwr.util.getValue("content");
		var name = dwr.util.getValue("userName");
		var info = encodeURI(encodeURI(name + " :\n" + content));
		var msg = {
			"msg" : info,
			"time" : time
		};
		dwr.util.setValue("content", "");
		if (!!content) {
			ChatService.sendMessage(msg);
		} else {
			alert("发送的内容不能为空！");
		}
	}
	$("#code").qrcode({ 
	    render: "table", //table方式 
	    width: 200, //宽度 
	    height:200, //高度 
	    text: "www.helloweba.com" //任意内容 
	});
	function showMessage(data) {
		var message = decodeURI(decodeURI(data.msg));
		var text = dwr.util.getValue("info");
		if (!!text) {
			dwr.util.setValue("info", text + "\n" + data.time + "  " + message);
		} else {
			dwr.util.setValue("info", data.time + "  " + message);
		}
		$("#info")[0].scrollTop = $("#info")[0].scrollHeight;
	}
	function onEvent() {
		if (/* event.ctrlKey&& */event.keyCode == 13) {
			send();
		}
	}
</script>
</head>

<body onload="dwr.engine.setActiveReverseAjax(true);">
	<div class="doc-content">
		
		<div class="row">
		<table style="width: 100%">
		<tr>
		<td width="50%">
			<div class="span19">
				<div class="panel panel-primary" style="margin-left: 30px">
					<div class="panel-header clearfix">
						<h3 class="pull-left">对话框</h3>
					</div>
					<div class="panel-body" style="height: 300px">
						<textarea id="info" class="textarea" style="height: 95%; width: 95%; resize: none;border-style:none" readonly="readonly" ></textarea>
					</div>
				</div>
			</div>
		</td>
		 <td width="50%" align="center">
			<div id="code"></div> 
		</td>
		</div>
	</div>

	
	<hr />
	<table style="margin-left: 20px">
		<tr>
			<td>昵称：</td>
			<td><input type="text" id="userName" value="${username}" style="border-style:none"/></td>
		</tr>
		<tr>
			<td>消息：</td>
			<td>
				<div class="panel-body span18" style="height: 100px">
					<textarea id="content" style="height: 95%; width: 95%; resize: none;" onkeyup="onEvent()"></textarea>
				</div>
			</td>
		</tr>
	</table>


</body>
</html>