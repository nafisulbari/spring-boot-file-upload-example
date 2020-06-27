<h1>SpringBoot file upload example</h1>

<#--if the flag has a message it will show-->
<#if flag??>
    <h2 style="color: #a39146">${flag}</h2>
</#if>

<form action="/upload-action" enctype="multipart/form-data" method="post">
    <label>Please select a file</label><br><br>
    <input type="file" name="myfile"><br><br>
    <input type="submit" value="Submit">
</form>