<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Info</title>
</head>
<body>
<a href="/">index page (main page)</a>
<h1>USER INFO</h1>
<table>
    <tr>
        <td>Id</td>
        <td>${user.id}</td>
    </tr>
    <tr>
        <td>Name</td>
        <td>${user.name}</td>
    </tr>
    <tr>
        <td>Email</td>
        <td>${user.email}</td>
    </tr>
    <tr>
        <td>Age</td>
        <td>${user.age}</td>
    </tr>
</table>
<a href="/users"><=== Back to user list</a>
</body>
</html>