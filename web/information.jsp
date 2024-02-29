<%-- 
    Document   : information
    Created on : Oct 25, 2023, 4:44:42 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            #wrapper{
                font-family: arial;
                margin-left: 30px;
                width: 90%
            }
            .clr{
                clear:both;
            }
            /*Phan menu*/
            #menu_tab{
                width: 100%;
            }
            ul.menu{
                float:left;
                background:url(images/background_menu.jpg)repeat-x;
                display:block;
                list-style-type: none;
                font-weight:bold;
                height: 55px;
                padding: 12px;
                width: 100%;
            }
            ul.menu li{
                display: inline;
                font-size: 14px;
                padding-top: 15px;
                text-align: center;
                line-height: 30px;
                color: #E2D9BC;
            }
            ul.menu li a{
                margin: 10px;
                padding-left: 0px;
                text-decoration: none;
                text-align: center;
                color: #E2D9BC;
                position: relative;
            }
            ul.menu li a img{
                float: left;
                margin-left: 10px;
            }
            ul.menu li a:hover{
                color:#F90;
            }
            ul.menu li a:active{
                color: #FF0;
            }
            ul.menu li a:focus{
                color: #96F;
            }
            #content{
                margin-left: 20px;
            }
            table{
                border-collapse: collapse;
            }
            td{
                text-align: center;
            }
            .left2{
                width: 85%;
                float: left;
            }
            .loginLeft2{
                width: 15%;
                float: left;

            }
            input[type=submit]{
                width: auto;
                height: auto;
                background-color: #F90;
                border-radius: 10px;
            }
            #bag{
                text-align: right;
                margin-right: 0px;
                margin-top: 0px;
            }
        </style>
    </head>
    <body>
        <div id="bag">
            <a href="show" style="text-decoration: none">
                (${requestScope.size})
                <img src="images/giohang.png" width="30px" height="30px"/>
            </a>
        </div>
        <div id="wrapper">
            <div id="content">
                <form name="f" action="" method="post">
                    Enter number of items to buy:
                    <input style="text-align: center" type="number" name="num" value="1"/>
                    <hr/>
                    <table border="1px" >
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Image</th>
                            <th>Category name</th>
                            <th>Action</th>
                        </tr>
                        <c:set value="${requestScope.product}" var="p"/>
                        <c:set value="${p.ID}" var="id"/>
                        <tr>
                            <td>${p.ID}</td>
                            <td>${p.name}</td>
                            <td><fmt:formatNumber pattern="##.#" value="${p.price}"/></td>
                            <td><img src="${p.image}" width="80px" height="80px"</td>
                            <td>${p.category.name}</td>
                            <td><input type="submit" onclick="buy('${id}')" value="Buy item"/></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>
<script type="text/javascript">
    function buy(id) {
        var m = document.f.num.value;
        document.f.action = "buy?id=" + id + "&num=" + m;
        document.f.submit();
    }
</script>