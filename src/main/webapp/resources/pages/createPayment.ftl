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

<@macro.mainPageLink 'payout'/>

<#if status == 'creation'>
<form method="POST" action="/payout/create">

    <table class="table">
        <thead>
        <tr>
            <th>Поле</th>
            <th>Значение</th>
        </tr>
        </thead>

        <tbody>

        <tr>
            <td>Тип выплаты</td>
            <td><select name="type" value="${payout.type!''}">
                <option value="0">Зарплата</option>
                <option value="1">Премия</option>
            </select></td>
        </tr>

        <tr>
            <td>Назначающий</td>
            <td><select name="initiatorId" value="${payout.initiatorId!''}">
                <#list initiators as initiator>
                    <option value="${initiator.id}">${initiator.name + ' ' + initiator.surName}</option>
                </#list>
            </select></td>
        </tr>

        <tr>
            <td>Получатель</td>
            <td><select name="employeeId" value="${payout.employeeId!''}">
             <#list recievers as reciever>
                 <option value="${reciever.id}">${reciever.name + ' ' + reciever.surName}</option>
             </#list>
            </select></td>
        </tr>

        <tr>
            <td>Количество</td>
            <td><input class="form-control" name="surName" value="${payout.amount!''}"></td>
        </tr>



        </tbody>
    </table>

    <br />

    <button class="createEntity btn-success">${createText}</button>

</form>
</#if>

</body>
</html>