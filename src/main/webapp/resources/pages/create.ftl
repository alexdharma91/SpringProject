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


<#if status == 'created'>
    <h1>Успешно создан ${entity}</h1>
<#else>
   <h1>Создание ${entity}</h1>
</#if>

<#if status == 'creation'>
<form method="POST" action="/employee/create">

    <table class="table">
        <thead>
        <tr>
            <th>Поле</th>
            <th>Значение</th>
        </tr>
        </thead>
        <tbody>
            <#list fields as field>
            <tr>
                <td>${field.name}</td>
                <td><input class="form-control" type="number" name="${field.name}" value="ie"></td>
            </tr>
            </#list>
        </tbody>
    </table>

    <br />

    <button class="createEntity btn-success">${createText}</button>

</form>
</#if>

</body>
</html>