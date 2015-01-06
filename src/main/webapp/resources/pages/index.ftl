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
<@macro.navigator active=0/>

<button class="createEntity btn-success">Создать сорудника</button>

<table class="table">
    <thead>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Редактировать</th>
        <th>Удалить</th>
    </tr>
    </thead>
    <tfoot>
    <tr>
        <td>Иван</td>
        <td>Петров</td>
        <td><button class="btn-primary">Редактировать</button></td>
        <td><button class="btn-danger">Удалить</button></td>
    </tr>
    </tfoot>
    <tbody>
    <tr>
        <td>Дмитрий</td>
        <td>Петроы</td>
        <td><button class="btn-primary">Редактировать</button></td>
        <td><button class="btn-danger">Удалить</button></td>
    </tr>
    <tr>
        <td>Джамшут</td>
        <td>ППППП</td>
        <td><button class="btn-primary">Редактировать</button></td>
        <td><button class="btn-danger">Удалить</button></td>
    </tr>
    </tbody>
</table>


</body>
</html>