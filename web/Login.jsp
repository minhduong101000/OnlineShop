<%-- 
    Document   : Login
    Created on : Oct 26, 2023, 3:27:26 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body{
                background-color: #1c8ef8;
                font-family: sans-serif;
                /*#167bff*/
            }
            .login{
                width: 350px;
                height: 350px;
                text-align: center;
                border: 1px solid grey;
                border-radius: 10px;
                margin: 30px auto;
                background-color: white;
            }
            button{
                width: 250px;
                height: 40px;
                border-radius: 5px;
                border: none;
                background-color: #167bff;
                color: white;
            }
            button:hover{
                width: 222px;
                height: 44px;
            }
            b{
                float:right;
                padding-right: 40px;
                margin-top: 20px;
                text-decoration: none;
            }
            .enter{
                width: 250px;
                height: auto;
                border: 1px solid #167bff;
                margin-bottom: 10px;
                border-radius: 5px;
                margin-left: auto;
                margin-right: auto;
            }
            .enter img{
                width: 20px;
                vertical-align: middle;
            }
            .enter input{
                border: none;
                outline: none;
                height: 30px;
                width: 200px;
                padding-left: 15px;
            }
        </style>
    </head>
    <body>
        <div class="login">
            <form action="login" method="post">
                <h2>Đăng nhập</h2>
                <h3 style="color: red">${requestScope.error}</h3>
                <div class="enter">
                    <img src="images/username.png"/>
                    <input type="text" placeholder="Tài khoản" name="user" value="${cookie.cuser.value}"/>
                </div>
                <div class="enter">
                    <img src="images/password.png"/>
                    <input type="password" placeholder="Mật khẩu" name="pass" value="${cookie.cpass.value}"/>
                </div>
                <button>ĐĂNG NHẬP</button>
                <br/>
                <input type="checkbox"
                       ${cookie.crem!=null?'checked':''} name="rem" value="ON"/>Remember me<br/>
                <h4><a style="color:red" href="signup.jsp">Đăng ký</a></h4>
            </form>
        </div> 
    </body>
</html>
