<%--
  Created by IntelliJ IDEA.
  User: chenghui
  Date: 2019/3/24
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单详情</title>
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
<div id="orderInfos" class="easyui-panel" title="订单信息">
</div>
<input type="hidden" id="order_no">
<div class="easyui-panel" style="width: 100%">
    <table id="dg"></table>
</div>
<div id="tb">
    <a href="#" class="easyui-linkbutton" onclick="wcOrder()" data-options="iconCls:'icon-redo',plain:true">点击完成</a>
</div>
</body>
</html>
<script>
    $(document).ready(function () {
        $('#dg').datagrid({
            url: '/orderdetail/queryOrderdetail.do',
            striped: true,
            rownumbers: true,
            toolbar:'#tb',
            title:'订单详情',
            loadMsg: '数据加载中...',
            columns: [[
                {field: 'id', title: 'Code', width: 100},
                {field: 'disherName', title: '菜品名称', width: 100, align: 'center'},
                {field: 'money', title: '菜品单价', width: 100, align: 'center'},
                {field: 'number', title: '菜品数量', width: 100, align: 'center'},
                {field: 'totalMoney', title: '总金额', width: 100, align: 'center'},
                {field: 'createTime', title: '创建时间', width: 100, align: 'center'},
                {field: 'orderNo', title: '订单号', width: 100, align: 'center'},
                {field: 'orderDate', title: '下单日期', width: 100, align: 'center'},
                {field: 'disherTypeName', title: '菜品类型', width: 100, align: 'center'}
            ]]
        });
        $.ajax({
            type: "POST",
            url: "/orderdetail/queryOrder.do",
            success: function (data) {
                var htmlstr = "";
                if (data.code != '0000') {
                    htmlstr = "<h1 align='center' >" + data.desc + "</h1>"
                } else {
                    var orderInfo = JSON.parse(data.desc);
                    $("#order_no").val(orderInfo.orderNo)
                    htmlstr = "<table border='1' style='width:100%;'>" +
                            "<tr>" +
                            "<td align='right'>订单标题:</td><td>" + orderInfo.orderTitle + "</td>" +
                            "<td align='right'>订单编号:</td><td>" + orderInfo.orderNo + "</td>" +
                            "<td align='right'>订单总金额:</td><td>" + orderInfo.orderMoney + "</td>" +
                            "</tr>" +
                            "<tr>" +
                            "<td align='right'>下单时间:</td><td>" + orderInfo.orderTime + "</td>" +
                            "<td align='right'>订单完成时间:</td><td>" + orderInfo.orderEndTime + "</td>" +
                            "<td align='right'>所属桌号:</td><td>" + orderInfo.tableNumber + "</td>" +
                            "</tr>" +
                            "<tr>" +
                            "<td align='right'>订单备注:</td><td>" + orderInfo.remark + "</td>" +
                            "<td align='right'>预计等待时间:</td><td>" + orderInfo.waitTime + "</td>" +
                            "<td align='right'>订单状态:</td><td>" + orderInfo.status + "</td>" +
                            "</tr>"
                    "</table>";
                }
                $("#orderInfos").html(htmlstr);
                var param={};
                param.orderNo=orderInfo.orderNo
                $('#dg').datagrid('load',param);
            }
        });
    });
    function wcOrder(){
        var orderNo=$("#order_no").val();
        var  param1={}
        param1.orderNo=orderNo;
        $.ajax({
            type: "POST",
            url: "/orderdetail/endOrder.do",
            data:param1,
            success: function (data) {
                if(data.code  !='0000'){
                    $.messager.alert('警告','系统异常,请稍后重试');
                }else{
                  var   htmlstr = "<h1 align='center' >" +"订单已经全部处理完成"+ "</h1>"
                    $("#orderInfos").html(htmlstr);
                    $('#dg').datagrid('loadData',[]);
                    $.messager.show({
                        title:'我的消息',
                        msg:'订单已完成。',
                        timeout:5000,
                        showType:'slide'
                    });
                }

            }
        });
    }

</script>