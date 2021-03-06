package com.ltkj.app.common.model;

import java.util.Date;

public class RuJob {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_ru_job.ID_
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_ru_job.REV_
     *
     * @mbggenerated
     */
    private Integer rev;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_ru_job.TYPE_
     *
     * @mbggenerated
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_ru_job.LOCK_EXP_TIME_
     *
     * @mbggenerated
     */
    private Date lockExpTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_ru_job.LOCK_OWNER_
     *
     * @mbggenerated
     */
    private String lockOwner;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_ru_job.EXCLUSIVE_
     *
     * @mbggenerated
     */
    private Boolean exclusive;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_ru_job.EXECUTION_ID_
     *
     * @mbggenerated
     */
    private String executionId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_ru_job.PROCESS_INSTANCE_ID_
     *
     * @mbggenerated
     */
    private String processInstanceId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_ru_job.PROC_DEF_ID_
     *
     * @mbggenerated
     */
    private String procDefId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_ru_job.RETRIES_
     *
     * @mbggenerated
     */
    private Integer retries;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_ru_job.EXCEPTION_STACK_ID_
     *
     * @mbggenerated
     */
    private String exceptionStackId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_ru_job.EXCEPTION_MSG_
     *
     * @mbggenerated
     */
    private String exceptionMsg;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_ru_job.DUEDATE_
     *
     * @mbggenerated
     */
    private Date duedate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_ru_job.REPEAT_
     *
     * @mbggenerated
     */
    private String repeat;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_ru_job.HANDLER_TYPE_
     *
     * @mbggenerated
     */
    private String handlerType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_ru_job.HANDLER_CFG_
     *
     * @mbggenerated
     */
    private String handlerCfg;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_ru_job.TENANT_ID_
     *
     * @mbggenerated
     */
    private String tenantId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_ru_job.ID_
     *
     * @return the value of act_ru_job.ID_
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_ru_job.ID_
     *
     * @param id the value for act_ru_job.ID_
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_ru_job.REV_
     *
     * @return the value of act_ru_job.REV_
     *
     * @mbggenerated
     */
    public Integer getRev() {
        return rev;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_ru_job.REV_
     *
     * @param rev the value for act_ru_job.REV_
     *
     * @mbggenerated
     */
    public void setRev(Integer rev) {
        this.rev = rev;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_ru_job.TYPE_
     *
     * @return the value of act_ru_job.TYPE_
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_ru_job.TYPE_
     *
     * @param type the value for act_ru_job.TYPE_
     *
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_ru_job.LOCK_EXP_TIME_
     *
     * @return the value of act_ru_job.LOCK_EXP_TIME_
     *
     * @mbggenerated
     */
    public Date getLockExpTime() {
        return lockExpTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_ru_job.LOCK_EXP_TIME_
     *
     * @param lockExpTime the value for act_ru_job.LOCK_EXP_TIME_
     *
     * @mbggenerated
     */
    public void setLockExpTime(Date lockExpTime) {
        this.lockExpTime = lockExpTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_ru_job.LOCK_OWNER_
     *
     * @return the value of act_ru_job.LOCK_OWNER_
     *
     * @mbggenerated
     */
    public String getLockOwner() {
        return lockOwner;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_ru_job.LOCK_OWNER_
     *
     * @param lockOwner the value for act_ru_job.LOCK_OWNER_
     *
     * @mbggenerated
     */
    public void setLockOwner(String lockOwner) {
        this.lockOwner = lockOwner == null ? null : lockOwner.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_ru_job.EXCLUSIVE_
     *
     * @return the value of act_ru_job.EXCLUSIVE_
     *
     * @mbggenerated
     */
    public Boolean getExclusive() {
        return exclusive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_ru_job.EXCLUSIVE_
     *
     * @param exclusive the value for act_ru_job.EXCLUSIVE_
     *
     * @mbggenerated
     */
    public void setExclusive(Boolean exclusive) {
        this.exclusive = exclusive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_ru_job.EXECUTION_ID_
     *
     * @return the value of act_ru_job.EXECUTION_ID_
     *
     * @mbggenerated
     */
    public String getExecutionId() {
        return executionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_ru_job.EXECUTION_ID_
     *
     * @param executionId the value for act_ru_job.EXECUTION_ID_
     *
     * @mbggenerated
     */
    public void setExecutionId(String executionId) {
        this.executionId = executionId == null ? null : executionId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_ru_job.PROCESS_INSTANCE_ID_
     *
     * @return the value of act_ru_job.PROCESS_INSTANCE_ID_
     *
     * @mbggenerated
     */
    public String getProcessInstanceId() {
        return processInstanceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_ru_job.PROCESS_INSTANCE_ID_
     *
     * @param processInstanceId the value for act_ru_job.PROCESS_INSTANCE_ID_
     *
     * @mbggenerated
     */
    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId == null ? null : processInstanceId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_ru_job.PROC_DEF_ID_
     *
     * @return the value of act_ru_job.PROC_DEF_ID_
     *
     * @mbggenerated
     */
    public String getProcDefId() {
        return procDefId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_ru_job.PROC_DEF_ID_
     *
     * @param procDefId the value for act_ru_job.PROC_DEF_ID_
     *
     * @mbggenerated
     */
    public void setProcDefId(String procDefId) {
        this.procDefId = procDefId == null ? null : procDefId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_ru_job.RETRIES_
     *
     * @return the value of act_ru_job.RETRIES_
     *
     * @mbggenerated
     */
    public Integer getRetries() {
        return retries;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_ru_job.RETRIES_
     *
     * @param retries the value for act_ru_job.RETRIES_
     *
     * @mbggenerated
     */
    public void setRetries(Integer retries) {
        this.retries = retries;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_ru_job.EXCEPTION_STACK_ID_
     *
     * @return the value of act_ru_job.EXCEPTION_STACK_ID_
     *
     * @mbggenerated
     */
    public String getExceptionStackId() {
        return exceptionStackId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_ru_job.EXCEPTION_STACK_ID_
     *
     * @param exceptionStackId the value for act_ru_job.EXCEPTION_STACK_ID_
     *
     * @mbggenerated
     */
    public void setExceptionStackId(String exceptionStackId) {
        this.exceptionStackId = exceptionStackId == null ? null : exceptionStackId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_ru_job.EXCEPTION_MSG_
     *
     * @return the value of act_ru_job.EXCEPTION_MSG_
     *
     * @mbggenerated
     */
    public String getExceptionMsg() {
        return exceptionMsg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_ru_job.EXCEPTION_MSG_
     *
     * @param exceptionMsg the value for act_ru_job.EXCEPTION_MSG_
     *
     * @mbggenerated
     */
    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg == null ? null : exceptionMsg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_ru_job.DUEDATE_
     *
     * @return the value of act_ru_job.DUEDATE_
     *
     * @mbggenerated
     */
    public Date getDuedate() {
        return duedate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_ru_job.DUEDATE_
     *
     * @param duedate the value for act_ru_job.DUEDATE_
     *
     * @mbggenerated
     */
    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_ru_job.REPEAT_
     *
     * @return the value of act_ru_job.REPEAT_
     *
     * @mbggenerated
     */
    public String getRepeat() {
        return repeat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_ru_job.REPEAT_
     *
     * @param repeat the value for act_ru_job.REPEAT_
     *
     * @mbggenerated
     */
    public void setRepeat(String repeat) {
        this.repeat = repeat == null ? null : repeat.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_ru_job.HANDLER_TYPE_
     *
     * @return the value of act_ru_job.HANDLER_TYPE_
     *
     * @mbggenerated
     */
    public String getHandlerType() {
        return handlerType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_ru_job.HANDLER_TYPE_
     *
     * @param handlerType the value for act_ru_job.HANDLER_TYPE_
     *
     * @mbggenerated
     */
    public void setHandlerType(String handlerType) {
        this.handlerType = handlerType == null ? null : handlerType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_ru_job.HANDLER_CFG_
     *
     * @return the value of act_ru_job.HANDLER_CFG_
     *
     * @mbggenerated
     */
    public String getHandlerCfg() {
        return handlerCfg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_ru_job.HANDLER_CFG_
     *
     * @param handlerCfg the value for act_ru_job.HANDLER_CFG_
     *
     * @mbggenerated
     */
    public void setHandlerCfg(String handlerCfg) {
        this.handlerCfg = handlerCfg == null ? null : handlerCfg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_ru_job.TENANT_ID_
     *
     * @return the value of act_ru_job.TENANT_ID_
     *
     * @mbggenerated
     */
    public String getTenantId() {
        return tenantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_ru_job.TENANT_ID_
     *
     * @param tenantId the value for act_ru_job.TENANT_ID_
     *
     * @mbggenerated
     */
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }
}