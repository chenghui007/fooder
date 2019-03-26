<%--
  Created by IntelliJ IDEA.
  User: chenghui
  Date: 2019/3/23
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>点餐系统</title>
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
</head>
<body>
<div id="cc" class="easyui-layout" data-options="fit:true">
    <div data-options="region:'north',title:'在线点餐系统',split:true" style="height:100px;">

    </div>
    <div data-options="region:'south',title:'版权@123.com',split:true,collapsible:false">
    </div>
    <div data-options="region: 'west',title:'菜单导航',split:true" style="width:200px;">
        <ul id="tree_info"></ul>
    </div>
    <div data-options="region:'center',title:''">
        <div id="tabs" class="easyui-tabs" data-options="fit:true" >
            <div title="首页">
              <h1  style="margin-left: 20px"> 欢迎使用在线点餐系统</h1>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<script>
    $(document).ready(function () {
        var userid=getParam('userid');
        $('#tree_info').tree({
            url: '/login/tree.do?userid='+userid,
            parentField:"pid",
            lines:'tree',
            loadFilter: function (data) {
                var arr=[];
                var pageTree=[];
                for(var i=0;i<data.length;i++){
                    var item={};
                    item.id=data[i].id;
                    item.text=data[i].menuName;
                    item.iconCls=data[i].menuIcon;
                    item.checked=false;
                    item.state='open';
                    item.attributes=data[i].menuUrl;
                    item.pid=data[i].pid;
                    arr.push(item);
                    if(item.pid == null || item.pid == 0){
                        pageTree.push(item);
                    }
                }
                for(var i=0;i<pageTree.length;i++){
                    var chrl=[];
                    for(var j=0;j<arr.length;j++){
                        if(arr[j].pid == pageTree[i].id){
                            chrl.push(arr[j]);
                        }
                    }
                    pageTree[i].children=chrl;
                }
                return pageTree;
            },
            onClick: function(node){
                if(node.attributes == null || node.attributes == ''){
                    return;
                }
                exisitTabs(node.text,node.attributes);
            }

        });
    });
    function  exisitTabs(title,url){
        var ex=$('#tabs').tabs('exists',title);
        if(ex){
            $('#tabs').tabs('select',title);
        }else{
            $('#tabs').tabs('add',{
                title:title,
                content:'<iframe style="width: 100%;height: 100%" src="'+url+'" ></iframe>',
                closable:true,
            });
        }
    }
    /**
     * 获取指定的URL参数值
     * URL:http://www.quwan.com/index?name=tyler
     * 参数：paramName URL参数
     * 调用方法:getParam("name")
     * 返回值:tyler
     */
    function getParam(paramName) {
        paramValue = "", isFound = !1;
        if (this.location.search.indexOf("?") == 0 && this.location.search.indexOf("=") > 1) {
            arrSource = unescape(this.location.search).substring(1, this.location.search.length).split("&"), i = 0;
            while (i < arrSource.length && !isFound) arrSource[i].indexOf("=") > 0 && arrSource[i].split("=")[0].toLowerCase() == paramName.toLowerCase() && (paramValue = arrSource[i].split("=")[1], isFound = !0), i++
        }
        return paramValue == "" && (paramValue = null), paramValue
    }
</script>
