<%-- 
    Document   : signup
    Created on : Oct 26, 2023, 4:13:34 PM
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
                background-color: orangered;
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
                background-color: orangered;
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
                border: 1px solid orangered;
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
            <form action="signup" method="post">
                <h2>Đăng ký</h2>
                <div class="enter">
                    <img src="images/username.png"/>
                    <input type="text" placeholder="Tài khoản" name="user"/>
                </div>
                <div class="enter">
                    <img src="images/password.png"/>
                    <input type="password" placeholder="Mật khẩu" name="pass"/>
                </div>
                <div class="enter">
                    <img src="images/password.png"/>
                    <input type="password" placeholder="Nhập lại mật khẩu" name="rpass"/>
                </div>
                <button>ĐĂNG KÝ</button>
            </form>
        </div> 
    </body>
</html>
