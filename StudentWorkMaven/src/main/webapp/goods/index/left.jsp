<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="java.text.DecimalFormat"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()	+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>ѧ������ϵͳ</title>
<link rel="stylesheet" href="person/resources/css/reset.css" type="text/css"	media="screen" />
<link rel="stylesheet" href="person/resources/css/style.css" type="text/css"	media="screen" />
<link rel="stylesheet" href="person/resources/css/invalid.css" type="text/css"	media="screen" />

<script type="text/javascript"	src="person/resources/scripts/jquery-1.3.2.min.js"></script>
<script type="text/javascript"	src="person/resources/scripts/simpla.jquery.configuration.js"></script>
<script type="text/javascript" src="person/resources/scripts/facebox.js"></script>
<script type="text/javascript" src="person/resources/scripts/jquery.wysiwyg.js"></script>
<script type="text/javascript"	src="person/resources/scripts/jquery.datePicker.js"></script>
<script type="text/javascript" src="person/resources/scripts/jquery.date.js"></script>

</head>
<body class="left"> 

	<div id="body-wrapper">
		<div id="sidebar"
			style="background: url('../resources/images/bg-sidebar.gif') top left no-repeat;">
			<div id="sidebar-wrapper">
				<h1 id="sidebar-title">
					<a href="person/person_introduction.jsp" target="dmMain">ѧ������ϵͳ</a>
				</h1>
				<div id="profile-links">
					<p>
						<a>��ӭ��&#12288<%=session.getAttribute("username")%></a> | <a href="userExit" title="�˳�ϵͳ" target="_top">�˳�</a><br/>
					</p>
				</div>

			   
			   <ul id="main-nav">
					<li><a href="person/person/person_info.jsp" class="nav" target="dmMain">������Ϣ</a></li>
					<li><a href="#" class="nav-top-item">�ҵ�����</a>
						<ul>
							<li><a href="fund/client_add.jsp" target="dmMain">�˺�</a></li>
							<li><a href="fund/client_list.jsp" target="dmMain">д��</a></li>
							<li><a href="fund/client_list.jsp" target="dmMain">�ռ���</a></li>
							<li><a href="fund/client_list.jsp" target="dmMain">�ݸ���</a></li>
						</ul>
					</li>
					<li><a href="person/person/person_favorite.jsp" class="nav" target="dmMain">��ҳ�ղ�</a></li>
					<li><a href="person/person/person_life_account.jsp" class="nav" target="dmMain">�����˺�</a></li>
					<li><a href="person/person/person_diary_list.jsp" class="nav" target="dmMain">�����ռ�</a></li>
					<li><a href="person/person/person_contacts.jsp" class="nav" target="dmMain">ͨѶ¼</a></li>
					<li><a href="person/person/person_finance.jsp" class="nav" target="dmMain">���˲���</a></li>
					<li><a href="person/person/person_plan.jsp" class="nav" target="dmMain">�ƻ�Ŀ��</a></li>
					<li><a href="#" class="nav-top-item">�������</a>
						<ul>
							<li><a href="person/goods/goods_infoall.jsp"  target="dmMain">������Ʒ</a></li>
							<li><a href="person/goods/goods_rbpmy.jsp" target="dmMain">�ҵ�����</a></li>
						</ul>
					</li>
					<li><a href="#" class="nav-top-item">��������</a>
						<ul>
							<li><a href="person/goods/goods_infomy.jsp"  target="dmMain">�ҵ���Ʒ</a></li>
							<li><a href="person/goods/goods_rbpall.jsp" target="dmMain">��������</a></li>
						</ul>
					</li>
				</ul>
				
			</div>
		</div>
	</div>
</body>
</html>
