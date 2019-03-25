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
    <title>订单管理</title>
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
<div id="p" class="easyui-panel" title="高级搜索">
    <div>
        <div style="float: left;padding-left: 20px;padding-top: 5px;">
            订单号: <input class="easyui-textbox" name="dishierName" id="orderno_q">
        </div>
        <div style="padding-top: 5px;">
            <a id="btn1" onclick="query()"   href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:false">查询</a>
            <a id="btn2" onclick="reloadDg()"  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:false">重置</a>
        </div>
    </div>
</div>
<div class="easyui-panel" style="width: 100%">
    <table id="dg"></table>
</div>
</body>
</html>
<script>
    $(document).ready(function () {
        $('#dg').datagrid({
            url: '/order/query.do',
            pagination:true,
            striped:true,
            rownumbers:true,
            title:'订单列表',
            loadMsg:'数据加载中...',
            columns: [[
                {field: 'id', title: 'Code', width: 100,hidden:true},
                {field: 'orderTitle', title: '订单标题', width: 100,align: 'center'},
                {field: 'orderNo', title: '订单编号', width: 100, align: 'center'},
                {field: 'orderMoney', title: '订单金额', width: 100, align: 'center',formatter:function(value,row,index){
                    return value+"元";
                }},
                {field: 'orderTime', title: '下单时间', width: 150, align: 'center',formatter:function(value,row,index){
                    return getMyDate(value);
                }},
                {field: 'orderEndTime', title: '订单完成时间', width: 150, align: 'center',formatter:function(value,row,index){
                    return getMyDate(value);
                }},
                {field: 'tableNumber', title: '桌位号', width: 100, align: 'center'},
                {field: 'orderDate', title: '下单日期', width: 100, align: 'center'},
                {field: 'remark', title: '备注', width: 100, align: 'center'},
                {field: 'waitTime', title: '预期等待时间', width: 100, align: 'center',formatter:function(value,row,index){
                    return value+"分钟";
                }},
                {field: 'status', title: '订单状态', width: 100, align: 'center',formatter:function(value,row,index){
                    if(value == '010'){
                        return "待制作";
                    }
                    if(value == '020'){
                        return "已完成";
                    }
                    return value;
                }}
            ]]
        });
    });
    function query() {
        var param = {};
        if ($('#orderno_q').val() != null || $('#orderno_q').val() != '') {
            param.orderNo = $('#orderno_q').val();
        }
        $('#dg').datagrid('reload', param);
    }
    function reloadDg() {
        var param = {};
        $('#orderno_q').val('')
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
