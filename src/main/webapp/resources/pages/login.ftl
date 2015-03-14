<#import "spring.ftl" as spring>
<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" type="text/css" href="<@spring.url "/resources/css/styles.css"/>">
    <link rel="stylesheet" type="text/css" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"/>
    <script src="<@spring.url "/resources/js/client.js" />"></script>
    <title>${title}</title>
</head>
<body>

<div class="page-header">
    <h1>Example page header
        <small>Subtext for header</small>
    </h1>
</div>

<div id="loginPanel">
    <form action="http://localhost:8081/log/in" method="POST">
        <input type="text" name="login" class="form-control login" placeholder="login" aria-describedby="sizing-addon2">
        <br />
        <input type="text" name="password" class="form-control" placeholder="password" aria-describedby="sizing-addon2">
        <br/>
        <input type="submit"  class="btn-primary enterButton">
    </form>
</div>

</body>
</html>