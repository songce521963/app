package com.ltkj.app.common.model;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_order.order_id
     *
     * @mbggenerated
     */
    private String orderId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_order.company_id
     *
     * @mbggenerated
     */
    private String companyId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_order.department_id
     *
     * @mbggenerated
     */
    private String departmentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_order.department_name
     *
     * @mbggenerated
     */
    private String departmentName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_order.customer_id
     *
     * @mbggenerated
     */
    private String customerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_order.customer_name
     *
     * @mbggenerated
     */
    private String customerName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_order.customer_phone
     *
     * @mbggenerated
     */
    private String customerPhone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_order.goods_price
     *
     * @mbggenerated
     */
    private BigDecimal goodsPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_order.postage
     *
     * @mbggenerated
     */
    private BigDecimal postage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_order.order_price
     *
     * @mbggenerated
     */
    private BigDecimal orderPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_order.status
     *
     * @mbggenerated
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_order.description
     *
     * @mbggenerated
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_order.Is_Active
     *
     * @mbggenerated
     */
    private String isActive;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_order.CREATE_DT
     *
     * @mbggenerated
     */
    private Date createDt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_order.CREATE_OP
     *
     * @mbggenerated
     */
    private String createOp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_order.CREATE_PG
     *
     * @mbggenerated
     */
    private String createPg;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_order.UPDATE_DT
     *
     * @mbggenerated
     */
    private Date updateDt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_order.UPDATE_OP
     *
     * @mbggenerated
     */
    private String updateOp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_order.UPDATE_PG
     *
     * @mbggenerated
     */
    private String updatePg;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_order.order_id
     *
     * @return the value of s_order.order_id
     *
     * @mbggenerated
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_order.order_id
     *
     * @param orderId the value for s_order.order_id
     *
     * @mbggenerated
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_order.company_id
     *
     * @return the value of s_order.company_id
     *
     * @mbggenerated
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_order.company_id
     *
     * @param companyId the value for s_order.company_id
     *
     * @mbggenerated
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_order.department_id
     *
     * @return the value of s_order.department_id
     *
     * @mbggenerated
     */
    public String getDepartmentId() {
        return departmentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_order.department_id
     *
     * @param departmentId the value for s_order.department_id
     *
     * @mbggenerated
     */
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_order.department_name
     *
     * @return the value of s_order.department_name
     *
     * @mbggenerated
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_order.department_name
     *
     * @param departmentName the value for s_order.department_name
     *
     * @mbggenerated
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_order.customer_id
     *
     * @return the value of s_order.customer_id
     *
     * @mbggenerated
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_order.customer_id
     *
     * @param customerId the value for s_order.customer_id
     *
     * @mbggenerated
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_order.customer_name
     *
     * @return the value of s_order.customer_name
     *
     * @mbggenerated
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_order.customer_name
     *
     * @param customerName the value for s_order.customer_name
     *
     * @mbggenerated
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_order.customer_phone
     *
     * @return the value of s_order.customer_phone
     *
     * @mbggenerated
     */
    public String getCustomerPhone() {
        return customerPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_order.customer_phone
     *
     * @param customerPhone the value for s_order.customer_phone
     *
     * @mbggenerated
     */
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone == null ? null : customerPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_order.goods_price
     *
     * @return the value of s_order.goods_price
     *
     * @mbggenerated
     */
    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_order.goods_price
     *
     * @param goodsPrice the value for s_order.goods_price
     *
     * @mbggenerated
     */
    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_order.postage
     *
     * @return the value of s_order.postage
     *
     * @mbggenerated
     */
    public BigDecimal getPostage() {
        return postage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_order.postage
     *
     * @param postage the value for s_order.postage
     *
     * @mbggenerated
     */
    public void setPostage(BigDecimal postage) {
        this.postage = postage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_order.order_price
     *
     * @return the value of s_order.order_price
     *
     * @mbggenerated
     */
    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_order.order_price
     *
     * @param orderPrice the value for s_order.order_price
     *
     * @mbggenerated
     */
    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_order.status
     *
     * @return the value of s_order.status
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_order.status
     *
     * @param status the value for s_order.status
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_order.description
     *
     * @return the value of s_order.description
     *
     * @mbggenerated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_order.description
     *
     * @param description the value for s_order.description
     *
     * @mbggenerated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_order.Is_Active
     *
     * @return the value of s_order.Is_Active
     *
     * @mbggenerated
     */
    public String getIsActive() {
        return isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_order.Is_Active
     *
     * @param isActive the value for s_order.Is_Active
     *
     * @mbggenerated
     */
    public void setIsActive(String isActive) {
        this.isActive = isActive == null ? null : isActive.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_order.CREATE_DT
     *
     * @return the value of s_order.CREATE_DT
     *
     * @mbggenerated
     */
    public Date getCreateDt() {
        return createDt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_order.CREATE_DT
     *
     * @param createDt the value for s_order.CREATE_DT
     *
     * @mbggenerated
     */
    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_order.CREATE_OP
     *
     * @return the value of s_order.CREATE_OP
     *
     * @mbggenerated
     */
    public String getCreateOp() {
        return createOp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_order.CREATE_OP
     *
     * @param createOp the value for s_order.CREATE_OP
     *
     * @mbggenerated
     */
    public void setCreateOp(String createOp) {
        this.createOp = createOp == null ? null : createOp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_order.CREATE_PG
     *
     * @return the value of s_order.CREATE_PG
     *
     * @mbggenerated
     */
    public String getCreatePg() {
        return createPg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_order.CREATE_PG
     *
     * @param createPg the value for s_order.CREATE_PG
     *
     * @mbggenerated
     */
    public void setCreatePg(String createPg) {
        this.createPg = createPg == null ? null : createPg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_order.UPDATE_DT
     *
     * @return the value of s_order.UPDATE_DT
     *
     * @mbggenerated
     */
    public Date getUpdateDt() {
        return updateDt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_order.UPDATE_DT
     *
     * @param updateDt the value for s_order.UPDATE_DT
     *
     * @mbggenerated
     */
    public void setUpdateDt(Date updateDt) {
        this.updateDt = updateDt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_order.UPDATE_OP
     *
     * @return the value of s_order.UPDATE_OP
     *
     * @mbggenerated
     */
    public String getUpdateOp() {
        return updateOp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_order.UPDATE_OP
     *
     * @param updateOp the value for s_order.UPDATE_OP
     *
     * @mbggenerated
     */
    public void setUpdateOp(String updateOp) {
        this.updateOp = updateOp == null ? null : updateOp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_order.UPDATE_PG
     *
     * @return the value of s_order.UPDATE_PG
     *
     * @mbggenerated
     */
    public String getUpdatePg() {
        return updatePg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_order.UPDATE_PG
     *
     * @param updatePg the value for s_order.UPDATE_PG
     *
     * @mbggenerated
     */
    public void setUpdatePg(String updatePg) {
        this.updatePg = updatePg == null ? null : updatePg.trim();
    }
}