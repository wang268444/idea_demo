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
    <title>部门管理</title>
</head>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
    $(function () {
        $.ajax({
            "url": "queryDept.do",
            "type": "post",
            "dataType": "json",
            "success": function (data) {
                $("table").append("<tr><th>部门名称</th><th>创建时间</th><th>修改时间</th></tr>")
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
                    td = '<tr><td>' + item.deptName + '</td><td>' + create_Time + '</td><td>' + update_Time + '</td></tr>'
                    $("table").append(td)
                })
            }
        });
    })
</script>
<body>
部门管理
<table></table>
</body>
</html>
