<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Server</title>
    <style type="text/css">
        body {
            font-family: Arial;
        }
        h1 {
            color: #24279c;
        }
    </style>
</head>
<body>
<h1>Application 1</h1>
<ul>
    <li><b>IP:</b> ${request.ip()}</li>
    <li><b>Host:</b> ${request.host()}</li>
    <li><b>Server Port:</b> ${serverPort?c}</li>
    <li><b>User Agent:</b> ${request.userAgent()}</li>
    <li><b>X-Forward-For:</b> ${request.headers("X-Forwarded-For")}</li>
    <li><b>URL:</b> ${request.url()}</li>
</ul>
</body>
</html>
