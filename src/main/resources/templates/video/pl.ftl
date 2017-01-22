<!DOCTYPE html>
<html>
<head>
	<link href="${my_path}/static/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="${my_path}/static/css/froala_editor.min.css" rel="stylesheet" type="text/css">


    <style>
        body {
            text-align: center;
        }

        section {
            width: 80%;
            margin: auto;
            text-align: left;
        }
    </style>
</head>

<body>
  <section id="editor" style="width: 1000px;">
      <div id='edit' align="center">
            <div id="_content">&nbsp;</div>
      </div>
  </section>

  <script src="${my_path}/static/js/froala_editor.min.js"></script>
  <!--[if lt IE 9]>
  <script src="${my_path}/static/js/froala_editor_ie8.min.js"></script>
  <![endif]-->
  <script src="${my_path}/static/js/plugins/tables.min.js"></script>
  <script src="${my_path}/static/js/plugins/lists.min.js"></script>
  <script src="${my_path}/static/js/plugins/colors.min.js"></script>
  <script src="${my_path}/static/js/plugins/media_manager.min.js"></script>
  <script src="${my_path}/static/js/plugins/font_family.min.js"></script>
  <script src="${my_path}/static/js/plugins/font_size.min.js"></script>
  <script src="${my_path}/static/js/plugins/block_styles.min.js"></script>
  <script src="${my_path}/static/js/plugins/video.min.js"></script>

  <script>
      $(function(){
          $('#edit').editable({inlineMode: false, alwaysBlank: false})
      });
  </script>
</body>
</html>
