<!DOCTYPE html>
<html>
<head lang="en">
    <script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://malsup.github.com/jquery.form.js"></script>

    <script>
        // wait for the DOM to be loaded
        $(document).ready(function() {
            // bind 'myForm' and provide a simple callback function
            //$('#form1').ajaxForm(function() {
            //    alert("Thank you for your comment!");
            //});

            $('#button1').bind("click",function(){
                alert("sdf");
            });
            // attach handler to form's submit event
            $('#form1').submit(function() {
                $(this).ajaxSubmit({
                    beforeSubmit: function(arr, $form, options) {
                        // The array of form data takes the following form:
                        // [ { name: 'username', value: 'jresig' }, { name: 'password', value: 'secret' } ]
                        // return false to cancel submit
                    },
                    success :function(responseText,statusText,xhr,jy ){
                       // alert(JSON.stringify(responseText));
                       // alert(statusText);
                       // alert(JSON.stringify(jy));
                       // console.log(responseText) ;
                    },
                    uploadProgress:function (event,position,total,percentComplete){
                        alert(percentComplete);
                    }
                });
                // return false to prevent normal browser submit and page navigation
                return false;
            });
        });
    </script>

    <meta charset="UTF-8">
    <title></title>
</head>
    <body>
    <form id="form1"  method="post" enctype="multipart/form-data" action="/upload">
        <div>
            <input id="File1" type="file" name="File1"/>
            <input type="submit" />
        </div>
    </form>
    <button id = "button1">提交</button>
    </body>
</html>