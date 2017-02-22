package com.ltkj.app.inventory.model;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

import com.ltkj.app.common.model.Goods;

/**
 * 商品信息详细页面用模型
 * 
 * @author wyj
 */
public class InvGoodsDetailModel extends Goods {
    /**
     * 商品所属栏目下拉框
     */
    private String primaryCategoryList;

    /**
     * 商品所属分类下拉框
     */
    private String smallCategoryList;

    /**
     * 商品所属栏目显示信息
     */
    private String primaryCategoryInfo;

    /**
     * 页面区分
     */
    private String pageFlag;

    /**
     * 商品图片
     */
    private MultipartFile picture;

    /**
     * 上传文件
     */
    private MultipartFile file;

    /**
     * 商品所属分类显示信息
     */
    private String smallCategoryInfo;

    /**
     * 商品图片
     */
    private File upload; // 文件
    private String uploadContentType; // 文件类型
    private String uploadFileName; // 文件名
    
    /**
     * 商品提醒补货标记
     */
    private boolean checkCount;
    
    private String oldPicSrc;

	public boolean isCheckCount() {
		return checkCount;
	}

	public void setCheckCount(boolean checkCount) {
		this.checkCount = checkCount;
	}

	public String getPrimaryCategoryList() {
        return primaryCategoryList;
    }

    public void setPrimaryCategoryList(String primaryCategoryList) {
        this.primaryCategoryList = primaryCategoryList;
    }

    public String getSmallCategoryList() {
        return smallCategoryList;
    }

    public void setSmallCategoryList(String smallCategoryList) {
        this.smallCategoryList = smallCategoryList;
    }

    public String getPrimaryCategoryInfo() {
        return primaryCategoryInfo;
    }

    public void setPrimaryCategoryInfo(String primaryCategoryInfo) {
        this.primaryCategoryInfo = primaryCategoryInfo;
    }

    public String getSmallCategoryInfo() {
        return smallCategoryInfo;
    }

    public void setSmallCategoryInfo(String smallCategoryInfo) {
        this.smallCategoryInfo = smallCategoryInfo;
    }

    public String getPageFlag() {
        return pageFlag;
    }

    public void setPageFlag(String pageFlag) {
        this.pageFlag = pageFlag;
    }

    public MultipartFile getPicture() {
        return picture;
    }

    public void setPicture(MultipartFile picture) {
        this.picture = picture;
    }

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadContentType() {
        return uploadContentType;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

	public String getOldPicSrc() {
		return oldPicSrc;
	}

	public void setOldPicSrc(String oldPicSrc) {
		this.oldPicSrc = oldPicSrc;
	}
}