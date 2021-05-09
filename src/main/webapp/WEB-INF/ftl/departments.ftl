<!DOCTYPE html>
<html>
    <head>
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="/styles/common.css"/>
        <script src="/styles/jquery.js"></script>
    </head>
    <body>
        <#include 'top.ftl'>
        <div class="page-body">
            <#include 'leftMenu.ftl'>
            <div class="page-content">
                <div class="content-nav">
                    人员管理 > 部门管理
                </div>
                <form action="/admin/adddepartment">
                    <fieldset>
                        <legend>添加部门</legend>
                        部门名称:
                        <input type="text" id="departmentname" name="departmentname" maxlength="20"/>
                        <input type="submit" class="clickbutton" value="添加"/>
                    </fieldset>
                </form>
                <table class="listtable">
                    <caption>所有部门:</caption>
                    <tr class="listheader">
                        <th>部门编号</th>
                        <th>部门名称</th>
                        <th>操作</th>
                    </tr>
                    <#if deps ??>
                        <#list deps as dep>
                            <tr>
                                <td>${dep.departmentid}</td>
                                <td id="depname${dep.departmentid}">${dep.departmentname}</td>
                                <td>
                                    <a class="clickbutton" id="edit${dep.departmentid}" onclick="editDep(${dep.departmentid})">编辑</a>
                                    <a class="clickbutton" style="display: none" id="cancel${dep.departmentid}" onclick="cancelDep(${dep.departmentid})">取消</a>
                                    <a class="clickbutton" href="/admin/deletedep?departmentid=${dep.departmentid}">删除</a>
                                </td>
                            </tr>
                        </#list>
                    </#if>
                </table>
            </div>
        </div>
        <div class="page-footer">
            <hr/>
            更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
            <img src="/images/footer.png" alt="CoolMeeting"/>
        </div>

    <script>
        // 定义一个全局变量depname
        let depname;
        // cancelDep(depid) 中depid的值从onclick后获取
        function cancelDep(depid) {
            // 取得id为edit + depid的按钮。即编辑按钮
            let editBtn = $('#edit' + depid);
            // 取得id为cancel + depid的按钮，即取消按钮
            let cancelBtn = $('#cancel' + depid);
            // 取得id为depname + depid的按钮，即td第二行
            let ele = $('#depname' + depid);
            // 给取消按钮创建css样式
            cancelBtn.css('display', 'none');
            // 给编辑按钮创建html文字
            editBtn.html('编辑');
            // 给ele赋值
            ele.html(depname);
        }
        function editDep(depid) {
            // 取得id为edit + depid的按钮。即编辑按钮
            let editBtn = $('#edit' + depid);
            // 取得id为cancel + depid的按钮，即取消按钮
            let cancelBtn = $('#cancel' + depid);
            // 取得id为depname + depid的按钮，即td第二行
            let ele = $('#depname' + depid);
            // 点击编辑将 td 第二行的值赋给全局变量depname
            depname = ele.html();

            // 如果取消按钮的css样式为none，则将取消按钮的css样式改为inline，编辑按钮改为确定
            if (cancelBtn.css('display') === 'none') {
                cancelBtn.css('display', 'inline');
                editBtn.html('确定');
                // td 第二行的值depName，下一行使用。
                let depName = ele.text();
                // td 第二行改为input标签
                ele.html('<input type="text" value="'+depName+'" />')
            }else {
                // 如果取消按钮的css样式不为none，则将td的子元素input标签赋给children
                let children = ele.children('input');
                // 将children的值赋给val
                let val = children.val();
                // 提交ajax请求。
                $.post('/admin/updatedep',{id:depid, name:val}, function (msg) {
                    // 如果提交成功
                    if (msg == 'success') {
                        // 取消按钮隐藏
                        cancelBtn.css('display', 'none');
                        // 编辑按钮的值改为编辑
                        editBtn.html('编辑');
                        // td第二行的值改为val的值，即新名称。
                        ele.html(val);
                    }
                })
            }
        }
    </script>
    </body>
</html>