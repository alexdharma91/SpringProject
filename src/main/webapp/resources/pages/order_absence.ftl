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
<@macro.navigator active=2/>


<button class="btn-success createEntity">Создать отсутствие</button>

<table class="table">
    <thead>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Дата начала</th>
        <th>Дата конца</th>
        <th>Тип отсутствия</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>Дмитрий</td>
        <td>Петроы</td>
        <td>01.10</td>
        <td>02.10</td>
        <td>Отпуск</td>
    </tr>
    <tr>
        <td>Дмитрий</td>
        <td>Петроы</td>
        <td>01.10</td>
        <td>02.10</td>
        <td>Больничный</td>
    </tr>
    <tr>
        <td>Дмитрий</td>
        <td>Петроы</td>
        <td>01.10</td>
        <td>02.10</td>
        <td>Отгул</td>
    </tr>
    <tr>
        <td>Дмитрий</td>
        <td>Петроы</td>
        <td>01.10</td>
        <td>02.10</td>
        <td>Отгул</td>
    </tr>
    </tbody>
</table>








</body>
</html>