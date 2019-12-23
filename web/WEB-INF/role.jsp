<%--
  Created by IntelliJ IDEA.
  User: NewLife
  Date: 2019/12/20
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>角色管理</title>
</head>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
    $(function () {
        $.ajax({
            "url": "queryRole.do",
            "type": "post",
            "dataType": "json",
            "success": function (data) {
                $("table").append("<tr><th>角色名称</th><th>所属部门</th><th>创建时间</th><th>修改时间</th><th>操作</th></tr>")
                $.each(data, function (index, item) {
                    var create_Time
                    if (item.create_Time == null) {
                        create_Time = ""
                    } else {
                        var create_Time = new Date(item.create_Time.time);
                        var y = create_Time.getFullYear();
                        var m = create_Time.getMonth() + 1;
                        var da = create_Time.getDate();
                        var h = create_Time.getHours();
                        var mm = create_Time.getMinutes();
                        var s = create_Time.getSeconds();
                        var s = s < 10 ? '0' + s : s;
                        create_Time = y + "-" + m + "-" + da + " " + h + ":" + mm + ":" + s;
                    }
                    var update_Time
                    if (item.update_Time == null) {
                        update_Time = ""
                    } else {
                        var update_Time = new Date(item.update_Time.time);
                        var y = update_Time.getFullYear();
                        var m = update_Time.getMonth() + 1;
                        var da = update_Time.getDate();
                        var h = update_Time.getHours();
                        var mm = update_Time.getMinutes();
                        var s = update_Time.getSeconds();
                        var s = s < 10 ? '0' + s : s;
                        update_Time = y + "-" + m + "-" + da + " " + h + ":" + mm + ":" + s;
                    }
                    td = '<tr><td>' + item.roleName + '</td><td>' + item.deptName + '</td><td>' + create_Time + '</td><td>' + update_Time + '</td><td><input type="button" value="修改" onClick="show(&quot;' + '角色修改' + '&quot;,' + item.roleId + ')"><input type="button" value="删除" onclick="remove(' + item.roleId + ')"></td></tr>'
                    $("table").append(td)
                })
            }
        })
        $.ajax({
            "url": "queryDept.do",
            "type": "post",
            "dataType": "json",
            "success": function (data) {
                $.each(data, function (index, item) {
                    option = '<option value="' + item.deptId + '">' + item.deptName + '</option>'
                    $("#deptId").append(option)
                })
            }
        })
    })

    function remove(roleid) {
        $.ajax({
            "url": "deleteRole.do",
            "type": "post",
            "data": {
                "roleId": roleid,
            },
            "success": function (data) {
                if (data == "success") {
                    window.location.reload()
                }
            }
        })
    }

    function add() {
        roleName = $("#roleName").val()
        deptId = $("#deptId").val()
        if (roleName == "" || roleName == null) {
            $("#roleNameError").html("角色名称不能为空！")
            return false
        }
        if (deptId == "" || deptId == null) {
            $("#deptIdError").html("所属部门不能为空！")
            return false
        }
        data = {
            "roleName": roleName,
            "deptId": deptId
        }
        addOrUpdateRole(data)
    }

    function update(roleId) {
        roleName = $("#roleName").val()
        deptId = $("#deptId").val()
        if (roleName == "" || roleName == null) {
            $("#roleNameError").html("角色名称不能为空！")
            return false
        }
        if (deptId == "" || deptId == null) {
            $("#deptIdError").html("所属部门不能为空！")
            return false
        }
        data = {
            "roleId": roleId,
            "roleName": roleName,
            "deptId": deptId
        }
        addOrUpdateRole(data)
    }

    function addOrUpdateRole(data) {
        $.ajax({
            "url": "addOrUpdateRole.do",
            "type": "post",
            "data": data,
            "success": function (data) {
                if (data == "success") {
                    window.location.reload()
                }
            }
        })
    }

    //显示隐藏层和弹出层
    function show(title, roleId) {
        $("#title").html(title)
        hidebg.style.display = "block";  //显示隐藏层
        document.getElementById("hidebox").style.display = "block";  //显示弹出层
        if (title == "角色添加") {
            $("#page").append('<input type="button" value="确定" onclick="add()">')
        } else {
            $("#page").append('<input type="button" value="确定" onclick="update(' + roleId + ')">')
        }
    }

    //去除隐藏层和弹出层
    function hide() {
        document.getElementById("hidebg").style.display = "none";
        document.getElementById("hidebox").style.display = "none";
        window.location.reload()
    }
</script>
<style>
    #hidebg {
        position: absolute;
        left: 0px;
        top: 0px;
        background-color: #000;
        width: 100%; /*宽度设置为100%，这样才能使隐藏背景层覆盖原页面*/
        height: 100%;
        filter: alpha(opacity=60); /*设置透明度为60%*/
        opacity: 0.6; /*非IE浏览器下设置透明度为60%*/
        display: none;
        z-Index: 2;
    }

    #hidebox {
        text-align: right;
        position: absolute;
        width: 400px;
        height: 300px;
        top: 200px;
        left: 35%;
        border-radius: 5px;
        background-color: #fff;
        display: none;
        z-Index: 3;
        padding: 10px;
    }
</style>
<body>
角色管理<br>
<table>
    <tr><input type="button" value="添加" onClick="show('角色添加')"></tr>
</table>
<div id="hidebg"></div>
<div id="hidebox"><span onClick="hide();" style="cursor:pointer;">关闭</span><br>
    <div style="text-align: center" id="page">
        <p id="title"></p>
        角色名称<input type="text" id="roleName"><br>
        <p id="roleNameError"></p>
        所属部门<select id="deptId">
        <option value="">请选择部门</option>
    </select><br>
        <p id="deptIdError"></p>
    </div>
</div>
</body>
</html>
