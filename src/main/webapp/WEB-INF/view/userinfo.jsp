<%--
  Created by IntelliJ IDEA.
  User: chenghui
  Date: 2019/3/23
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
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
</head>
<body>
<div class="easyui-panel" title="高级搜索" style="width: 100%">
    <div>
        <div style="float: left;padding-left: 20px;padding-top: 5px;">
        用户名称: <input class="easyui-textbox" name="dishierName" id="userName_q">
        </div>
        <div style="padding-top: 5px;">
        <a id="btn1" onclick="queryDisher()"   href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:false">查询</a>
        <a id="btn2" onclick="reloadDg()"  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:false">重置</a>
        </div>
    </div>
</div>
<div class="easyui-panel" style="width:100%;height: 500px">
    <table id="dg"></table>
</div>
</body>
</html>
<script>
    $(document).ready(function () {
        $('#dg').datagrid({
            url: '/user/query.do',
            pagination: true,
            striped: true,
            rownumbers: true,
            fit: true,
            title: '用户列表',
            loadMsg: '数据加载中...',
            toolbar: '#tb',
            columns: [[
                {field: 'id', title: 'Code', width: 100,hidden:true},
                {field: 'userName', title: '用户名', width: 150, align: 'center'},
                {field: 'password', title: '密码', width: 150, align: 'center',formatter:function(value,row,index){
                    return "*********";
                }},
                {field: 'phone', title: '电话', width: 150, align: 'center'},
                {field: 'sex', title: '性别', width: 150, align: 'center',formatter:function(value,row,index){
                    if(value == '1'){
                        return "男";
                    }
                    if(value == '0'){
                        return "女";
                    }
                    return value;
                }},
                {field: 'age', title: '年龄', width: 150, align: 'center'},
                {field: 'createTime', title: '注册时间', width: 150, align: 'center',formatter:function(value,row,index){
                    return getMyDate(value);
                }},
            ]]
        });
    });
    function queryDisher() {
        var param = {};
        if ($('#userName_q').val() != null || $('#userName_q').val() != '') {
            param.userName = $('#userName_q').val();
        }
        $('#dg').datagrid('reload', param);
    }
    function reloadDg() {
        var param = {};
        $('#dishierName_q').val('')
        $('#disherType_q').combobox('clear')
        $('#dg').datagrid('reload', param);
    }
    function getMyDate(time){
        if(typeof(time)=="undefined"){
            return "";
        }
        var oDate = new Date(time),
                oYear = oDate.getFullYear(),
                oMonth = oDate.getMonth()+1,
                oDay = oDate.getDate(),
                oHour = oDate.getHours(),
                oMin = oDate.getMinutes(),
                oSen = oDate.getSeconds(),
                oTime = oYear +'-'+ getzf(oMonth) +'-'+ getzf(oDay) +' '+ getzf(oHour) +':'+ getzf(oMin) +':'+getzf(oSen);//最后拼接时间

        return oTime;
    };

    //补0操作,当时间数据小于10的时候，给该数据前面加一个0
    function getzf(num){
        if(parseInt(num) < 10){
            num = '0'+num;
        }
        return num;
    }
</script>
