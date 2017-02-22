package com.ltkj.app.common.model;

import java.util.Date;

public class EvtLog {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_evt_log.LOG_NR_
     *
     * @mbggenerated
     */
    private Long logNr;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_evt_log.TYPE_
     *
     * @mbggenerated
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_evt_log.PROC_DEF_ID_
     *
     * @mbggenerated
     */
    private String procDefId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_evt_log.PROC_INST_ID_
     *
     * @mbggenerated
     */
    private String procInstId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_evt_log.EXECUTION_ID_
     *
     * @mbggenerated
     */
    private String executionId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_evt_log.TASK_ID_
     *
     * @mbggenerated
     */
    private String taskId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_evt_log.TIME_STAMP_
     *
     * @mbggenerated
     */
    private Date timeStamp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_evt_log.USER_ID_
     *
     * @mbggenerated
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_evt_log.LOCK_OWNER_
     *
     * @mbggenerated
     */
    private String lockOwner;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_evt_log.LOCK_TIME_
     *
     * @mbggenerated
     */
    private Date lockTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_evt_log.IS_PROCESSED_
     *
     * @mbggenerated
     */
    private Byte isProcessed;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_evt_log.DATA_
     *
     * @mbggenerated
     */
    private byte[] data;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_evt_log.LOG_NR_
     *
     * @return the value of act_evt_log.LOG_NR_
     *
     * @mbggenerated
     */
    public Long getLogNr() {
        return logNr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_evt_log.LOG_NR_
     *
     * @param logNr the value for act_evt_log.LOG_NR_
     *
     * @mbggenerated
     */
    public void setLogNr(Long logNr) {
        this.logNr = logNr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_evt_log.TYPE_
     *
     * @return the value of act_evt_log.TYPE_
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_evt_log.TYPE_
     *
     * @param type the value for act_evt_log.TYPE_
     *
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_evt_log.PROC_DEF_ID_
     *
     * @return the value of act_evt_log.PROC_DEF_ID_
     *
     * @mbggenerated
     */
    public String getProcDefId() {
        return procDefId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_evt_log.PROC_DEF_ID_
     *
     * @param procDefId the value for act_evt_log.PROC_DEF_ID_
     *
     * @mbggenerated
     */
    public void setProcDefId(String procDefId) {
        this.procDefId = procDefId == null ? null : procDefId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_evt_log.PROC_INST_ID_
     *
     * @return the value of act_evt_log.PROC_INST_ID_
     *
     * @mbggenerated
     */
    public String getProcInstId() {
        return procInstId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_evt_log.PROC_INST_ID_
     *
     * @param procInstId the value for act_evt_log.PROC_INST_ID_
     *
     * @mbggenerated
     */
    public void setProcInstId(String procInstId) {
        this.procInstId = procInstId == null ? null : procInstId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_evt_log.EXECUTION_ID_
     *
     * @return the value of act_evt_log.EXECUTION_ID_
     *
     * @mbggenerated
     */
    public String getExecutionId() {
        return executionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_evt_log.EXECUTION_ID_
     *
     * @param executionId the value for act_evt_log.EXECUTION_ID_
     *
     * @mbggenerated
     */
    public void setExecutionId(String executionId) {
        this.executionId = executionId == null ? null : executionId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_evt_log.TASK_ID_
     *
     * @return the value of act_evt_log.TASK_ID_
     *
     * @mbggenerated
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_evt_log.TASK_ID_
     *
     * @param taskId the value for act_evt_log.TASK_ID_
     *
     * @mbggenerated
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_evt_log.TIME_STAMP_
     *
     * @return the value of act_evt_log.TIME_STAMP_
     *
     * @mbggenerated
     */
    public Date getTimeStamp() {
        return timeStamp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_evt_log.TIME_STAMP_
     *
     * @param timeStamp the value for act_evt_log.TIME_STAMP_
     *
     * @mbggenerated
     */
    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_evt_log.USER_ID_
     *
     * @return the value of act_evt_log.USER_ID_
     *
     * @mbggenerated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_evt_log.USER_ID_
     *
     * @param userId the value for act_evt_log.USER_ID_
     *
     * @mbggenerated
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_evt_log.LOCK_OWNER_
     *
     * @return the value of act_evt_log.LOCK_OWNER_
     *
     * @mbggenerated
     */
    public String getLockOwner() {
        return lockOwner;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_evt_log.LOCK_OWNER_
     *
     * @param lockOwner the value for act_evt_log.LOCK_OWNER_
     *
     * @mbggenerated
     */
    public void setLockOwner(String lockOwner) {
        this.lockOwner = lockOwner == null ? null : lockOwner.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_evt_log.LOCK_TIME_
     *
     * @return the value of act_evt_log.LOCK_TIME_
     *
     * @mbggenerated
     */
    public Date getLockTime() {
        return lockTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_evt_log.LOCK_TIME_
     *
     * @param lockTime the value for act_evt_log.LOCK_TIME_
     *
     * @mbggenerated
     */
    public void setLockTime(Date lockTime) {
        this.lockTime = lockTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_evt_log.IS_PROCESSED_
     *
     * @return the value of act_evt_log.IS_PROCESSED_
     *
     * @mbggenerated
     */
    public Byte getIsProcessed() {
        return isProcessed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_evt_log.IS_PROCESSED_
     *
     * @param isProcessed the value for act_evt_log.IS_PROCESSED_
     *
     * @mbggenerated
     */
    public void setIsProcessed(Byte isProcessed) {
        this.isProcessed = isProcessed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_evt_log.DATA_
     *
     * @return the value of act_evt_log.DATA_
     *
     * @mbggenerated
     */
    public byte[] getData() {
        return data;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_evt_log.DATA_
     *
     * @param data the value for act_evt_log.DATA_
     *
     * @mbggenerated
     */
    public void setData(byte[] data) {
        this.data = data;
    }
}