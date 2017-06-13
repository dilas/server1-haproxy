<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Server</title>
    <style type="text/css">
        body {
            font-family: Arial;
        }
    </style>
</head>
<body>
<h1>Hello World!</h1>
<ul>
    <li><b>IP:</b> ${request.ip()}</li>
    <li><b>Host:</b> ${request.host()}</li>
    <li><b>Server Port:</b> ${serverPort?c}</li>
    <li><b>User Agent:</b> ${request.userAgent()}</li>
    <li><b>X-Forward-For:</b> ${request.headers("X-Forwarded-For")}</li>
</ul>
</body>
</html>
