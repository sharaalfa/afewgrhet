<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div>
    <a href="/registration.jsp">Регистрация</a>
    <style>
        table {
            width: 300px; /* Ширина таблицы */
            border: 5px solid #5c4980; /* Рамка вокруг таблицы */
            margin: auto; /* Выравниваем таблицу по центру окна  */
        }
        td {
            text-align: center;
        }
    </style>
    <table>
        <tr>
            <td for="/login">Логин:</td>
            <td><input type="text" name="login" id="login" value="" placeholder="Input"><td/>
            <td for="password">Пароль:</td>
            <td><input type="password" name="password" id="password" value="" placeholder="Input"></td>

            <td><input type="submit" value="Войти" formmethod="post"></td>

        </tr>


    </table>
    <form action="/login" method="post">


    </form>
</div>

</body>
</html>