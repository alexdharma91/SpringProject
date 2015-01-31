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

<a href="/absence/create">
    <button class="btn-success createEntity">Создать отсутствие</button>
</a>

<table class="table">
    <thead>
    <tr>
        <th>Дата начала</th>
        <th>Дата конца</th>
        <th>Тип</th>
        <th>Редактировать</th>
        <th>Удалить</th>
    </tr>
    </thead>
    <tbody>
    <#list absences as absence>
    <tr>
        <td>${absence.startDate}</td>
        <td>${absence.endDate}</td>
        <td>${absence.type}</td>
        <td><button class="btn-primary">Редактировать</button></td>
        <td><button class="btn-danger">Удалить</button></td>
    </tr>
    </#list>
    </tbody>
</table>

</body>
</html>