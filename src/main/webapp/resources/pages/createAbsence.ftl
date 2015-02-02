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


<#if status == 'creation'>
<form method="POST" action="/absence/create">

    <table class="table">
        <thead>
        <tr>
            <th>Поле</th>
            <th>Значение</th>
        </tr>
        </thead>
        <tbody>

        <tr>
            <td>Тип</td>
            <td><select name="carlist" value="${absence.type!''}">
            <option value="0">Отпуск</option>
            <option value="1">Отгул больничный</option>
            <option value="2">Opel</option>
        </select></td>
        </tr>

        <tr>
            <td>Начальная дата</td>
            <td><input class="form-control" type="date" name="startDate" value="${absence.startDate?string('yyyy-MM-dd')!'?'}"></td>
        </tr>
        <tr>
            <td>Конечная дата</td>
            <td><input class="form-control" type="date" name="endDate" value="${absence.endDate?string('yyyy-MM-dd')!'?'}"></td>
        </tr>

        </tbody>
    </table>

    <br />

    <button class="createEntity btn-success">${createText}</button>

</form>
</#if>

</body>
</html>