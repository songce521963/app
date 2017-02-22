package com.ltkj.app.common.model;

import java.util.Date;

public class Log {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_log.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_log.description
     *
     * @mbggenerated
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_log.exception_code
     *
     * @mbggenerated
     */
    private String exceptionCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_log.type
     *
     * @mbggenerated
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_log.exception_detail
     *
     * @mbggenerated
     */
    private String exceptionDetail;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_log.method
     *
     * @mbggenerated
     */
    private String method;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_log.params
     *
     * @mbggenerated
     */
    private String params;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_log.create_by
     *
     * @mbggenerated
     */
    private String createBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_log.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_log.request_ip
     *
     * @mbggenerated
     */
    private String requestIp;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_log.id
     *
     * @return the value of sys_log.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_log.id
     *
     * @param id the value for sys_log.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_log.description
     *
     * @return the value of sys_log.description
     *
     * @mbggenerated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_log.description
     *
     * @param description the value for sys_log.description
     *
     * @mbggenerated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_log.exception_code
     *
     * @return the value of sys_log.exception_code
     *
     * @mbggenerated
     */
    public String getExceptionCode() {
        return exceptionCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_log.exception_code
     *
     * @param exceptionCode the value for sys_log.exception_code
     *
     * @mbggenerated
     */
    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode == null ? null : exceptionCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_log.type
     *
     * @return the value of sys_log.type
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_log.type
     *
     * @param type the value for sys_log.type
     *
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_log.exception_detail
     *
     * @return the value of sys_log.exception_detail
     *
     * @mbggenerated
     */
    public String getExceptionDetail() {
        return exceptionDetail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_log.exception_detail
     *
     * @param exceptionDetail the value for sys_log.exception_detail
     *
     * @mbggenerated
     */
    public void setExceptionDetail(String exceptionDetail) {
        this.exceptionDetail = exceptionDetail == null ? null : exceptionDetail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_log.method
     *
     * @return the value of sys_log.method
     *
     * @mbggenerated
     */
    public String getMethod() {
        return method;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_log.method
     *
     * @param method the value for sys_log.method
     *
     * @mbggenerated
     */
    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_log.params
     *
     * @return the value of sys_log.params
     *
     * @mbggenerated
     */
    public String getParams() {
        return params;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_log.params
     *
     * @param params the value for sys_log.params
     *
     * @mbggenerated
     */
    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_log.create_by
     *
     * @return the value of sys_log.create_by
     *
     * @mbggenerated
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_log.create_by
     *
     * @param createBy the value for sys_log.create_by
     *
     * @mbggenerated
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_log.create_time
     *
     * @return the value of sys_log.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_log.create_time
     *
     * @param createTime the value for sys_log.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_log.request_ip
     *
     * @return the value of sys_log.request_ip
     *
     * @mbggenerated
     */
    public String getRequestIp() {
        return requestIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_log.request_ip
     *
     * @param requestIp the value for sys_log.request_ip
     *
     * @mbggenerated
     */
    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp == null ? null : requestIp.trim();
    }
}