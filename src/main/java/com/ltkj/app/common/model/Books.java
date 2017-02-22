package com.ltkj.app.common.model;

import java.math.BigDecimal;
import java.util.Date;

public class Books {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zwy_books.uuid
     *
     * @mbggenerated
     */
    private String uuid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zwy_books.book_number
     *
     * @mbggenerated
     */
    private String bookNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zwy_books.book_name
     *
     * @mbggenerated
     */
    private String bookName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zwy_books.book_sort
     *
     * @mbggenerated
     */
    private String bookSort;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zwy_books.book_author
     *
     * @mbggenerated
     */
    private String bookAuthor;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zwy_books.writer_id
     *
     * @mbggenerated
     */
    private String writerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zwy_books.book_price
     *
     * @mbggenerated
     */
    private BigDecimal bookPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_goods.pic_src
     *
     * @mbggenerated
     */
    private String picSrc;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zwy_books.book_discount
     *
     * @mbggenerated
     */
    private Integer bookDiscount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zwy_books.book_desc
     *
     * @mbggenerated
     */
    private String bookDesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zwy_books.is_active
     *
     * @mbggenerated
     */
    private String isActive;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zwy_books.create_dt
     *
     * @mbggenerated
     */
    private Date createDt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zwy_books.create_op
     *
     * @mbggenerated
     */
    private String createOp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zwy_books.create_pg
     *
     * @mbggenerated
     */
    private String createPg;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zwy_books.update_dt
     *
     * @mbggenerated
     */
    private Date updateDt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zwy_books.update_op
     *
     * @mbggenerated
     */
    private String updateOp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zwy_books.update_pg
     *
     * @mbggenerated
     */
    private String updatePg;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zwy_books.uuid
     *
     * @return the value of zwy_books.uuid
     *
     * @mbggenerated
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zwy_books.uuid
     *
     * @param uuid the value for zwy_books.uuid
     *
     * @mbggenerated
     */
    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zwy_books.book_number
     *
     * @return the value of zwy_books.book_number
     *
     * @mbggenerated
     */
    public String getBookNumber() {
        return bookNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zwy_books.book_number
     *
     * @param bookNumber the value for zwy_books.book_number
     *
     * @mbggenerated
     */
    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber == null ? null : bookNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zwy_books.book_name
     *
     * @return the value of zwy_books.book_name
     *
     * @mbggenerated
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zwy_books.book_name
     *
     * @param bookName the value for zwy_books.book_name
     *
     * @mbggenerated
     */
    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zwy_books.book_sort
     *
     * @return the value of zwy_books.book_sort
     *
     * @mbggenerated
     */
    public String getBookSort() {
        return bookSort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zwy_books.book_sort
     *
     * @param bookSort the value for zwy_books.book_sort
     *
     * @mbggenerated
     */
    public void setBookSort(String bookSort) {
        this.bookSort = bookSort == null ? null : bookSort.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zwy_books.book_author
     *
     * @return the value of zwy_books.book_author
     *
     * @mbggenerated
     */
    public String getBookAuthor() {
        return bookAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zwy_books.book_author
     *
     * @param bookAuthor the value for zwy_books.book_author
     *
     * @mbggenerated
     */
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor == null ? null : bookAuthor.trim();
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zwy_books.writer_id
     *
     * @param updatePg the value for zwy_books.writer_id
     *
     * @mbggenerated
     */
	public String getWriterId() {
		return writerId;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zwy_books.writer_id
     *
     * @param updatePg the value for zwy_books.writer_id
     *
     * @mbggenerated
     */
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zwy_books.book_price
     *
     * @return the value of zwy_books.book_price
     *
     * @mbggenerated
     */
    public BigDecimal getBookPrice() {
        return bookPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zwy_books.book_price
     *
     * @param bookPrice the value for zwy_books.book_price
     *
     * @mbggenerated
     */
    public void setBookPrice(BigDecimal bookPrice) {
        this.bookPrice = bookPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zwy_books.book_discount
     *
     * @return the value of zwy_books.book_discount
     *
     * @mbggenerated
     */
    public Integer getBookDiscount() {
        return bookDiscount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zwy_books.book_discount
     *
     * @param bookDiscount the value for zwy_books.book_discount
     *
     * @mbggenerated
     */
    public void setBookDiscount(Integer bookDiscount) {
        this.bookDiscount = bookDiscount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zwy_books.book_desc
     *
     * @return the value of zwy_books.book_desc
     *
     * @mbggenerated
     */
    public String getBookDesc() {
        return bookDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zwy_books.book_desc
     *
     * @param bookDesc the value for zwy_books.book_desc
     *
     * @mbggenerated
     */
    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc == null ? null : bookDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zwy_books.is_active
     *
     * @return the value of zwy_books.is_active
     *
     * @mbggenerated
     */
    public String getIsActive() {
        return isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zwy_books.is_active
     *
     * @param isActive the value for zwy_books.is_active
     *
     * @mbggenerated
     */
    public void setIsActive(String isActive) {
        this.isActive = isActive == null ? null : isActive.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zwy_books.create_dt
     *
     * @return the value of zwy_books.create_dt
     *
     * @mbggenerated
     */
    public Date getCreateDt() {
        return createDt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zwy_books.create_dt
     *
     * @param createDt the value for zwy_books.create_dt
     *
     * @mbggenerated
     */
    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zwy_books.create_op
     *
     * @return the value of zwy_books.create_op
     *
     * @mbggenerated
     */
    public String getCreateOp() {
        return createOp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zwy_books.create_op
     *
     * @param createOp the value for zwy_books.create_op
     *
     * @mbggenerated
     */
    public void setCreateOp(String createOp) {
        this.createOp = createOp == null ? null : createOp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zwy_books.create_pg
     *
     * @return the value of zwy_books.create_pg
     *
     * @mbggenerated
     */
    public String getCreatePg() {
        return createPg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zwy_books.create_pg
     *
     * @param createPg the value for zwy_books.create_pg
     *
     * @mbggenerated
     */
    public void setCreatePg(String createPg) {
        this.createPg = createPg == null ? null : createPg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zwy_books.update_dt
     *
     * @return the value of zwy_books.update_dt
     *
     * @mbggenerated
     */
    public Date getUpdateDt() {
        return updateDt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zwy_books.update_dt
     *
     * @param updateDt the value for zwy_books.update_dt
     *
     * @mbggenerated
     */
    public void setUpdateDt(Date updateDt) {
        this.updateDt = updateDt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zwy_books.update_op
     *
     * @return the value of zwy_books.update_op
     *
     * @mbggenerated
     */
    public String getUpdateOp() {
        return updateOp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zwy_books.update_op
     *
     * @param updateOp the value for zwy_books.update_op
     *
     * @mbggenerated
     */
    public void setUpdateOp(String updateOp) {
        this.updateOp = updateOp == null ? null : updateOp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zwy_books.update_pg
     *
     * @return the value of zwy_books.update_pg
     *
     * @mbggenerated
     */
    public String getUpdatePg() {
        return updatePg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zwy_books.update_pg
     *
     * @param updatePg the value for zwy_books.update_pg
     *
     * @mbggenerated
     */
    public void setUpdatePg(String updatePg) {
        this.updatePg = updatePg == null ? null : updatePg.trim();
    }

	public String getPicSrc() {
		return picSrc;
	}

	public void setPicSrc(String picSrc) {
		this.picSrc = picSrc;
	}
        
}