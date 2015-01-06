<#import "spring.ftl" as spring>
<#import "macro.ftl" as macro>
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

<@macro.pageHeader headerText=title/>
<@macro.navigator active=1/>

<button class="btn-success createEntity">Создать выплату</button>

<table class="table">
    <thead>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Сумма</th>
        <th>Налог</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>Дмитрий</td>
        <td>Петроы</td>
        <td>60000</td>
        <td>10000</td>
    </tr>
    <tr>
        <td>Дмитрий</td>
        <td>Петроы</td>
        <td>60000</td>
        <td>10000</td>
    </tr>
    <tr>
        <td>Дмитрий</td>
        <td>Петроы</td>
        <td>60000</td>
        <td>10000</td>
    </tr>
    <tr>
        <td>Дмитрий</td>
        <td>Петроы</td>
        <td>60000</td>
        <td>10000</td>
    </tr>
    </tbody>
</table>


</body>
</html>