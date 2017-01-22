
<html>
<head>
    <meta charset="utf-8" />
    <title>Auto Height Examples</title>
    <style>
        form {
            margin: 0;
        }
        textarea {
            display: block;
        }
    </style>
    <link rel="stylesheet" href="${my_path}/static/css/default.css" />
    <script charset="utf-8" src="${my_path}/static/css/kindeditor-min.js"></script>
    <script charset="utf-8" src="${my_path}/static/lang/zh_CN.js"></script>
    <script>
        KindEditor.ready(function(K) {
            K.create('textarea[name="content"]', {
                autoHeightMode : true,
                afterCreate : function() {
                    this.loadPlugin('autoheight');
                }
            });
        });
    </script>
</head>
<body>
<form>
    <textarea name="content" style="width:1000px;height:200px;"></textarea>
</form>
</body>
</html>
