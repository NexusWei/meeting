<!DOCTYPE html>
<html>
    <head>
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="/styles/common.css"/>
    </head>
    <body>
        <#include 'top.ftl'>
        <div class="page-body">
            <#include 'leftMenu.ftl'>
            <div class="page-content">
                <div class="content-nav">
                    修改密码
                </div>
                <form method="post" action="/admin/dochangepassword">
                    <fieldset>
                        <legend>修改密码信息</legend>
                        <table class="formtable" style="width:50%">
                            <tr>
                                <td>原密码:</td>
                                <td>
                                    <input id="password" name="password" type="password" onkeyup="validateOldAndNew()" />
                                </td>
                            </tr>
                            <tr>
                                <td>新密码:</td>
                                <td>
                                    <input id="newpassword" name="newpassword" type="password" onkeyup="validate()" />
                                </td>
                            </tr>
                            <tr>
                                <td>确认新密码：</td>
                                <td>
                                    <input id="confirm" type="password" onkeyup="validate()" />
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" class="command">
                                    <input type="submit" value="确认修改" id="submit" class="clickbutton"/>
                                    <input type="button" value="返回" class="clickbutton" onclick="window.history.back();"/>
                                </td>
                            </tr>
                        </table>
                        <#-- error不一定总是存在，如果error不存在，显示空字符串-->
                        <div style="color: #ff0114" id="error">${error!''}</div>
                    </fieldset>
                </form>
            </div>
        </div>
        <div class="page-footer">
            <hr/>
            更多问题，欢迎联系管理员
            <img src="/images/footer.png" alt="CoolMeeting"/>
        </div>

        <script src="/styles/jquery.js"></script>
        <script type="text/javascript">
            function validateOldAndNew() {
                let password = $("#password").val();
                let newpassword = $("#newpassword").val();

                if (password === newpassword) {
                    $("#error").html("新密码和旧密码不能相同，请修改")
                    $("#submit").attr("disabled", true);
                }else {
                    $("#submit").attr("disabled", false);
                }
            }

            function validate() {
                let newpassword = $("#newpassword").val();
                let confirm = $("#confirm").val();

                if (newpassword === confirm) {
                    $("#error").html("<font color='green'>两次密码相同</font>")
                    $("#submit").attr("disabled", false);
                }else {
                    $("#error").html("两次密码不相同，请修改");
                    $("#submit").attr("disabled", true);
                }
            }
        </script>
    </body>
</html>