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
    <title>菜品管理</title>
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
        菜品名称: <input class="easyui-textbox" name="dishierName" id="dishierName_q">
        </div>
        <div style="float: left;padding-left: 20px;padding-top: 5px; padding-right: 10px;">
            菜品类型: <input id="disherType_q" class="easyui-combobox" name="disherType"
                         data-options="valueField:'param',textField:'paramValue',url:'/dic/dishertype.do',editable:true"/>
        </div>
        <div style="padding-top: 5px;">
        <a id="btn1" onclick="queryDisher()"   href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:false">查询</a>
        <a id="btn2" onclick="reloadDg()"  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:false">重置</a>
        </div>
    </div>
</div>
<input type="hidden" value="${imageurl}" id="url_info">
<div class="easyui-panel" style="width:100%;height: 800px">
    <table id="dg"></table>
</div>
<div id="tb">
    <a href="#" class="easyui-linkbutton" onclick="openDialog()" data-options="iconCls:'icon-edit',plain:true">上架菜品</a>
</div>
<div id="dialog" class="easyui-dialog" title="菜品上架">
    <form id="dialog_form" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>菜品名称:</td>
                <td>
                    <input class="easyui-textbox" name="dishierName" id="dishierName">
                </td>
            </tr>
            <tr>
                <td>菜品类型:</td>
                <td>
                    <input id="disherType" class="easyui-combobox" name="disherType"
                           data-options="valueField:'param',textField:'paramValue',url:'/dic/querydishtype.do',editable:true"/>
                </td>
            </tr>
            <tr>
                <td>菜品描述:</td>
                <td>
                    <input class="easyui-textbox" name="disherDesc" id="disherDesc">
                </td>
            </tr>
            <tr>
                <td>制作时间:</td>
                <td>
                    <input class="easyui-numberbox" name="makeTime" id="makeTime">
                </td>
            </tr>
            <tr>
                <td>菜品价格:</td>
                <td>
                    <input class="easyui-numberbox" name="price" id="price">
                </td>
            </tr>
            <tr>
                <td>菜品图片:</td>
                <td>
                    <input type="file"  name="file" id="disherImage">
                </td>
            </tr>
        </table>
    </form>
</div>
<div id="dialog_but">
    <a href="#" onclick="submitForm()" class="easyui-linkbutton">保存</a>
    <a href="#" onclick="closeDialog()" class="easyui-linkbutton">关闭</a>
</div>
</body>
</html>
<script>
    $(document).ready(function () {
        $('#dg').datagrid({
            url: '/disher/query.do',
            pagination: true,
            striped: true,
            rownumbers: true,
            fit: true,
            title: '菜品列表',
            loadMsg: '数据加载中...',
            toolbar: '#tb',
            columns: [[
                {field: 'id', title: 'Code', width: 100,hidden:true},
                {field: 'disherType', title: '菜品类型', width: 150, align: 'center'},
                {field: 'dishierName', title: '菜品名称', width: 150, align: 'center'},
                {field: 'price', title: '菜品价格', width: 150, align: 'center'},
                {field: 'makeTime', title: '制作时间', width: 150, align: 'center'},
                {field: 'disherImage', title: '菜品图片', width: 150, align: 'center',
                    formatter: function(value,row,index){
                        var iurl=$('#url_info').val()+"/"+value
                        return '<img style="width:100px;height:100px;" src="'+iurl+'" />'
                    }
                },
                {field: 'disherDesc', title: '菜品描述', width: 150, align: 'center'},
            ]]
        });
        $('#dialog').dialog({
            width: 450,
            height: 300,
            closed: true,
            modal: true,
            buttons: '#dialog_but'
        });
        $("#disherType").combobox('select', '010')
    });
    function openDialog() {
        $('#dialog').dialog('open')
    }
    function closeDialog() {
        $('#dialog').dialog('close');
        $('#dialog_form').form('clear');
    }
    function submitForm() {
        $('#dialog_form').form('submit', {
            url: '/disher/add.do',
            onSubmit: function () {
                if ($('#dishierName').val() == null || $('#dishierName').val() == '') {
                    $.messager.alert('警告', '菜品名称不能为空');
                    return false;
                }
                if ($('#makeTime').val() == null || $('#makeTime').val() == '') {
                    $.messager.alert('警告', '菜品制作时间不能为空');
                    return false;
                }
                if ($('#price').val() == null || $('#price').val() == '') {
                    $.messager.alert('警告', '菜品价格不能为空');
                    return false;
                }
                return true;
            },
            success: function (data) {
                var result = JSON.parse(data);
                if (result.code == '0000') {
                    closeDialog();
                    reloadDg();
                    $.messager.show({
                        title: '提示消息',
                        msg: '上架菜品成功',
                        timeout: 5000,
                        showType: 'slide'
                    });

                } else {
                    $.messager.alert('警告', result.desc);
                }
            }
        });
    }
    function queryDisher() {
        var param = {};
        if ($('#dishierName_q').val() != null || $('#dishierName_q').val() != '') {
            param.disherName = $('#dishierName_q').val();
        }
        if ($('#disherType_q').combobox('getValue') != null || $('#disherType_q').combobox('getValue') != '') {
            param.disherType = $('#disherType_q').combobox('getValue');
        }
        $('#dg').datagrid('reload', param);
    }
    function reloadDg() {
        var param = {};
        $('#dishierName_q').val('')
        $('#disherType_q').combobox('clear')
        $('#dg').datagrid('reload', param);
    }
</script>
