<%--
  Created by IntelliJ IDEA.
  User: chenghui
  Date: 2019/3/23
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script type="text/javascript"
        src="<%=request.getContextPath() %>/static/jquery-3.2.1/jquery-3.2.1.js"></script>
<script type="text/javascript"
        src="<%=request.getContextPath() %>/static/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
        src="<%=request.getContextPath() %>/static/easyui/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css"
      href="<%=request.getContextPath() %>/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
      href="<%=request.getContextPath() %>/static/easyui/themes/icon.css">
<link rel="shortcut icon" href="<%=request.getContextPath() %>/static/icon/sys.icon">
<link rel="stylesheet" href="/login/normalize.css" />
<link rel="stylesheet" href="/login/component.css" />
<style type="text/css">
    html, body, div,p{margin:0;padding:0;font-weight:400;}
    .login-content{background:url('/dcxt/img/login-background_dipper.jpg') no-repeat;width:100%;height:100%;}
    .login-header,.login-footer{width:100%;height:50px;color:#FFF;font-size:12px;line-height:50px;}
    .login-header .logo-img{display:block;float:left;height:50px;width:50px;background:url('/dcxt/img/user-lock.png') no-repeat scroll 0px -5px;}
    .login-header .logo-title{display:block;float:left;height:50px;font-size:20px;font-weight:bold;}
    .login-box{position:fixed;top:50%;left:50%;-webkit-transform:translate3d(-50%,-50%,0);transform:translate3d(-50%,-50%,0);width:500px;height:350px;background:url('/dcxt/img/login-box.png') no-repeat;padding:35px 65px 35px 65px;font-size:14px}
    :root .login-box{top:0px\0;margin:260px 0px 0px -250px\0;}

    .userInfo{width:370px;height:70px;overflow:hidden;margin-bottom:0px;}
    .userInfo .colName{float:left;display:inline-block;width:60px;height:40px;margin-bottom:0px;padding:0px;color:#fff;line-height:65px;text-align:left;}
    .userInfo input{float:left;height:40px;width:250px;background:none;border:none;border-bottom:1px solid #fff;color: #fff;padding-top:15px;*padding-top:0px;*line-height:60px;font-size:14px;}
    .userInfo .checkCodeDiv{padding:0px;width:160px;float:left;}
    .userInfo .checkCode{width:160px;}
    .userInfo .checkCodeBtnDiv{padding:0px;width:70px;float:left;margin-left:15px;}
    .userInfo .checkCodeBtn{width:50px;}
    .userInfo .userName{background:url('/dcxt/img/user-lock.png') no-repeat scroll 0px -5px;}
    .userInfo .userPwd{background:url('/dcxt/img/user-lock.png') no-repeat scroll 0px -70px;}
    .userInfo .code-text{float:left;display:inline-block;width:60px;height:40px;color:#fff;line-height:55px;}
    .userInfo .code{background:none;border:1px solid #fff;color:#fff;width:80px;height:32px;line-height:34px;text-align:center;display:block;float:right;letter-spacing:4px;font-size:14px;font-family:Arial;margin-top:8px;border-radius:20px;cursor:pointer;}

    .userInfo .btn-login{width:100%;height:40px;background:none;border:1px solid #fff;color:#fff;-moz-border-radius:20px;-webkit-border-radius:20px;border-radius:20px;}
    .userInfo .help-block{position:absolute;top:40px;left:0px;font-weight:bold;font-size:14px}
</style>
<head>
    <title>点餐系统</title>
</head>
<body>
<div class="login-content">
    <div class="login-header">
        <p class="logo-img"></p>
        <p class="logo-title">在线点餐系统</p>
    </div>
    <div id="large-header" class="large-header">
        <canvas id="demo-canvas"></canvas>
        <form  method="post" id="login_form" class="loginform">
            <div class="login-box">
                <div class="form-group userInfo">
                    <label class="col-lg-3 colName userName"></label>
                    <div class="col-lg-9 clearfix" style="width:310px;padding:0px;position:relative;">
                        <input type="text" name="username"  id="user_info"
                               data-bv-message="The username is not valid"

                               data-bv-notempty="true"
                               data-bv-notempty-message="用户名不能为空"

                               data-bv-regexp="true"
                               data-bv-regexp-regexp="[a-zA-Z0-9_\.]+"
                               data-bv-regexp-message="The username can only consist of alphabetical, number, dot and underscore"

                               data-bv-stringlength="true"
                               data-bv-stringlength-min="3"
                               data-bv-stringlength-max="30"
                               data-bv-stringlength-message="用户名在3-30个字符之间"

                        />
                    </div>
                </div>
                <div class="form-group userInfo">
                    <label class="col-lg-3 colName userPwd"></label>
                    <div class="col-lg-9 clearfix" style="width:310px;padding:0px;position:relative;">
                        <input type="password" name="password"  id="user_password"
                               data-bv-notempty="true"
                               data-bv-notempty-message="密码不能为空"
                               data-bv-stringlength="true"
                               data-bv-stringlength-min="3"
                               data-bv-stringlength-max="30"
                               data-bv-stringlength-message="密码在3-30个字符之间"
                        />
                    </div>
                </div>
                <div class="userInfo" style="padding:20px 0px 0px;">
                    <button type="button" id="btn" class="btn-login">登录</button>
                </div>
                <span id="messageId" class="code" style="color:red"></span>
            </div>
        </form>
    </div>
</div>
</body>
</html>
<script>
    $(document).ready(function () {
        $("#btn").click(function () {
            $('#login_form').form('submit', {
                url: '/login/login.do',
                onSubmit: function () {
                    if($("#user_info").val() == null ||$("#user_info").val() ==''){
                        $.messager.alert('警告','请输入登录账号');
                        return false;
                    }
                    if($("#user_password").val() == null ||$("#user_password").val() ==''){
                        $.messager.alert('警告','请输入密码');
                        return false;
                    }
                    return true;
                },
                success: function (data) {
                    var info=JSON.parse(data);
                    if(info.code != '0000'){
                        $.messager.alert('警告',info.desc);
                    }else{
                        location.href="/login/main.do?userid="+info.userid
                    }
                }
            });
        })
    });
</script>
