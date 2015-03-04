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

<a href="/payout/create">
    <button class="btn-success createEntity">Создать выплату</button>
</a>

<table class="table">
    <thead>
    <tr>
        <th>Отправитель</th>
        <th>Получатель</th>
        <th>Сумма</th>
        <th>Тип</th>
        <th>Редактировать</th>
        <th>Удалить</th>
    </tr>
    </thead>
    <tbody>
<#list payouts as payout>
    <tr>
        <td>${payout.initiatorId!''}</td>
        <td>${payout.employeeId!''}</td>
        <td>${payout.amount!''}</td>
        <td>${payout.type!''}</td>

        <td> <a href="/payout/edit?payoutId=${payout.id!''}">
            <button class="btn-primary">Редактировать</button>
        </a></td>

        <td> <a href="/payout/delete?payoutId=${payout.id!''}">
            <button class="btn-danger">Удалить</button>
        </a></td>

    </tr>
</#list>
    </tbody>
</table>


</body>
</html>