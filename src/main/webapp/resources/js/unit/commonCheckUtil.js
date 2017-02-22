var commonCheckUtil = {
    // 验证上传图片文件大小,HTML5！
    checkPicture : function checkPicture(elementId) {
        var file = document.getElementById(elementId).files[0];
        var fileErroMessage = "请上传jpg/png类型的图片文件";
        var sizeErroMessage = "上传图片大小不能超过2MB.";
        var maxSize = 2 * 1024 * 1024;

        if (!file) {
            alert("请选择上传的文件");
            return false;
        }

        var fnArr = file.name.split(".");
        var fileName;

        // 验证上传文件的后缀名
        if (fnArr.length > 1) {
            fileName = fnArr[fnArr.length - 1].toLowerCase();

            if (fileName != "jpg" && fileName != "png" && fileName != "gif") {
                alert(fileErroMessage);
                return false;
            }

        } else {
            alert(fileErroMessage);
            return false;
        }

        // 验证文件大小
        if (file) {
            var fileSize = 0;
            if (file.size > maxSize) {
                alert(sizeErroMessage);
                return false;
            }
        }

        return true;
    },
    checkExcel : function checkExcel(elementId) {
        var file = document.getElementById(elementId).files[0];
        var fileErroMessage = "请上传xls/xlsx类型的图片文件";

        if (!file) {
            alert("请选择上传的文件");
            return false;
        }

        var fnArr = file.name.split(".");
        var fileName;

        // 验证上传文件的后缀名
        if (fnArr.length > 1) {
            fileName = fnArr[fnArr.length - 1].toLowerCase();

            if (fileName != "xls" && fileName != "xlsx") {
                alert(fileErroMessage);
                return false;
            }

        } else {
            alert(fileErroMessage);
            return false;
        }

        return true;
    }
}