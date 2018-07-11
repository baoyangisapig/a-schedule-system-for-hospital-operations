<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2018/7/10
  Time: 8:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- 可选的Bootstrap主题文件（一般不使用） -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"></script>

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
    $(
        function () {
            $(document).ready(function () {
                $.post(
                    "http://localhost:8080/manage/show",
                    {

                    },
                    function (data) {
                        var data1=JSON.parse(data);
                        $('#biao').html("");
                        for(i=0;i<data1.length;i++){
                        var name=data1[i].name;
                        var number=data1[i].number;

                        var img=data1[i].img;
                        var intro=data1[i].intro;
                        var str="<tr><td>"+name+"</td><td>"+number+"</td><td><img src=\""+img+"\" height='80px' weight='40px'></td><td>"+intro+"</td><td><input type=\"checkbox\" name=\"ckb\" value=\""+i+"\" />选择</td><tr>";
                        $("#biao").append(str);
                        }

                    }
                ).error(
                    function () {
                        alert(出现错误);
                    }
                )
            })

        }
    )
    </script>
    <script>
        $(
            function () {
                $("#btn").click(
                    function () {
                        var s=document.getElementsByName("ckb");
                        var s1="";
                        var j=0;
                        for(var i=0;i<s.length;i++)
                        {
                            if(s[i].checked)
                            {
                                s1+=s[i].value+",";
                                j=j+1;
                            }
                        }
                        if(j>2)
                        {
                            alert("最多只能选择两名麻醉师")
                        }
                        else
                        {
                            location.href="http://localhost:8080/manage/do?s1="+s1+"";
                        }

                    }
                )
            }
        )
    </script>
</head>
<body background="../../../bootstrap/img/index.jpg" style="background-repeat:no-repeat ;background-size:100% 100%;">
<p style="text-align: center;font-size: 40px;font-weight: bold">麻醉师配置系统</p>
<p style="font-size: 15px;color: #101010">对${patient}患者的${name}手术进行手动排班</p>
<table class="table table-striped">
    <thead>
    <tr>
        <th>麻醉师姓名</th>
        <th>麻醉师工号</th>
        <th>麻醉师照片</th>
        <th>医师简介</th>
        <th>选择麻醉师加入该台手术</th>
    </tr>
    </thead>
    <tbody id="biao">

    </tbody>
</table>
<button class="btn-danger" style="margin-left: 1400px" id="btn">确认提交</button>
</body>
</html>
