/*
if ( CKEDITOR.env.ie && CKEDITOR.env.version < 9 ) {
    CKEDITOR.tools.enableHtml5Elements( document );
    alert("ie9+");
}

// The trick to keep the editor in the sample quite small
// unless user specified own height.
CKEDITOR.config.height = 150;
CKEDITOR.config.width = 'auto';
*/


$(document).ready(function(){
//    initFullText();
    
    // 数字类型格式化
    common.commonFormatNumber();
    
    // 查询的情况下，画面内容不可入力
    if ($("#pageFlag").val() == "search") {
        // 初始化二维码
        $("#QRCode").qrcode({ 
            render: "table", //table方式 
            width: 200, //宽度 
            height:200, //高度 
            text: $("#goodsId").val() //任意内容 
        });
        
        // 查询画面不可入里项目
        $("#goodsForm").find("input").each(function(index, element) {
            $(element).attr("disabled", true);
        });
        
        $("#goodsForm").find("select").each(function(index, element) {
            $(element).attr("disabled", true);
        });
        
        $("#goodsForm").find("textarea").each(function(index, element) {
            $(element).attr("disabled", true);
        });
        
        // 查询画面删除项
        $("#submitBtn").remove();
        $("#inputPicture1").remove();
        $("#inputPicture2").remove();
        
        // 导航栏文字内容
//        $("#navigationBar").html("商品查询");
    } else {
        // 二维码按钮移除
        $("#showQRbtn").remove();
        
        // 绑定图片上传按钮点击事件
        $("#pictureSubmit").bind("click", uploadPicture);
        
//        // 如果是更新页面的话
//        if ($("#pageFlag").val() == "update") {
//            $("#navigationBar").html("商品信息更新");
//        }
//        // 如果是商品拷贝页面的话
//        else if ($("#pageFlag").val() == "copy") {
//            $("#navigationBar").html("商品信息拷贝");
//        }
        
        // 验证时
        $("#goodsForm").validationEngine({
            onSuccess:function onSuccess() {
                // 绑定表单提交前事件，移除图片文件，防止表单提交时发生文件类型匹配错误
                $("#picture").remove();
                
                // 数字去逗号
                common.commonFormatRemoveComma();
            }
        });
    }
});

// 图片上传
function uploadPicture() {
    if (!commonCheckUtil.checkPicture('picture')) {
        return;
    }
    
    var data = {"goodsName":$('#goodsName').val(),"_csrf":$('#_csrf').val()};
    var url = contextPath + "/inventory/iframe/uploadFile.html";
    $.fileUploadAjax(url,'picture',data,undefined,function(data){
		$("#picSrcImg").attr("src", data['src']);
		$("#picSrc").val(data['src']);
		alert(data['message']);
	},function(data){
		alert(data['message']);
	});
}

// 调用显示二维码
function showQRCode() {
    $('#QRCodeModal').modal('show');
}



/*
var initFullText = (function() {
    var wysiwygareaAvailable = isWysiwygareaAvailable(),
        isBBCodeBuiltIn = !!CKEDITOR.plugins.get( 'bbcode' );
    
//    CKEDITOR.replace('editor',{
//        filebrowserBrowseUrl: '/browser/browse.php',
//        filebrowserUploadUrl: '/uploader/upload.php'
//    });

    return function() {
        var editorElement = CKEDITOR.document.getById( 'editor' );

        // :(((
        if ( isBBCodeBuiltIn ) {
            editorElement.setHtml(
                'Hello world!\n\n' +
                'I\'m an instance of [url=http://ckeditor.com]CKEditor[/url].'
            );
        }

        // Depending on the wysiwygare plugin availability initialize classic or inline editor.
        if ( wysiwygareaAvailable ) {
            CKEDITOR.replace( 'editor' );
        } else {
            editorElement.setAttribute( 'contenteditable', 'true' );
            CKEDITOR.inline( 'editor' );

            // TODO we can consider displaying some info box that
            // without wysiwygarea the classic editor may not work.
        }
    };

    function isWysiwygareaAvailable() {
        // If in development mode, then the wysiwygarea must be available.
        // Split REV into two strings so builder does not replace it :D.
        if ( CKEDITOR.revision == ( '%RE' + 'V%' ) ) {
            return true;
        }

        return !!CKEDITOR.plugins.get( 'wysiwygarea' );
    };
})();
*/