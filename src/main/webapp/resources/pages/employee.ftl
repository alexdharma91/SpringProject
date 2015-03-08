<#import "spring.ftl" as spring>
<#import "macro.ftl" as macro>
<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" type="text/css" href="<@spring.url "/resources/css/styles.css"/>">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"/>
    <script src="<@spring.url "/resources/js/client.js" />"></script>
    <title>${title}</title>
</head>
<body>

<@macro.pageHeader headerText=title/>
<@macro.navigator active=0/>

<a href="/employee/create">
    <button class="createEntity btn-success">Создать сорудника</button>
</a>

<table class="table">
    <thead>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Login</th>
        <th>Password</th>
        <th>Редактировать</th>
        <th>Удалить</th>
    </tr>
    </thead>
    <tbody>
    <#list employees as employee>
    <tr>
        <td>${employee.name!''}</td>
        <td>${employee.surName!''}</td>
        <td>${employee.login!''}</td>
        <td>${employee.password!''}</td>
        <td> <a href="/employee/edit?employeeId=${employee.id!''}">
            <button class="btn-primary">Редактировать</button>
        </a></td>

        <td> <a href="/employee/delete?employeeId=${employee.id!''}">
            <button class="btn-danger">Удалить</button>
        </a></td>

    </tr>
    </#list>
    </tbody>
</table>

</body>
</html>