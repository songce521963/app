package com.ltkj.app.common.model;

import java.util.Date;

public class RuExecution {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_ru_execution.ID_
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_ru_execution.REV_
     *
     * @mbggenerated
     */
    private Integer rev;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_ru_execution.PROC_INST_ID_
     *
     * @mbggenerated
     */
    private String procInstId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_ru_execution.BUSINESS_KEY_
     *
     * @mbggenerated
     */
    private String businessKey;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_ru_execution.PARENT_ID_
     *
     * @mbggenerated
     */
    private String parentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_ru_execution.PROC_DEF_ID_
     *
     * @mbggenerated
     */
    private String procDefId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_ru_execution.SUPER_EXEC_
     *
     * @mbggenerated
     */
    private String superExec;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_ru_execution.ACT_ID_
     *
     * @mbggenerated
     */
    private String actId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_ru_execution.IS_ACTIVE_
     *
     * @mbggenerated
     */
    private Byte isActive;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_ru_execution.IS_CONCURRENT_
     *
     * @mbggenerated
     */
    private Byte isConcurrent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_ru_execution.IS_SCOPE_
     *
     * @mbggenerated
     */
    private Byte isScope;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_ru_execution.IS_EVENT_SCOPE_
     *
     * @mbggenerated
     */
    private Byte isEventScope;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_ru_execution.SUSPENSION_STATE_
     *
     * @mbggenerated
     */
    private Integer suspensionState;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_ru_execution.CACHED_ENT_STATE_
     *
     * @mbggenerated
     */
    private Integer cachedEntState;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_ru_execution.TENANT_ID_
     *
     * @mbggenerated
     */
    private String tenantId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_ru_execution.NAME_
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column act_ru_execution.LOCK_TIME_
     *
     * @mbggenerated
     */
    private Date lockTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_ru_execution.ID_
     *
     * @return the value of act_ru_execution.ID_
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_ru_execution.ID_
     *
     * @param id the value for act_ru_execution.ID_
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_ru_execution.REV_
     *
     * @return the value of act_ru_execution.REV_
     *
     * @mbggenerated
     */
    public Integer getRev() {
        return rev;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_ru_execution.REV_
     *
     * @param rev the value for act_ru_execution.REV_
     *
     * @mbggenerated
     */
    public void setRev(Integer rev) {
        this.rev = rev;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_ru_execution.PROC_INST_ID_
     *
     * @return the value of act_ru_execution.PROC_INST_ID_
     *
     * @mbggenerated
     */
    public String getProcInstId() {
        return procInstId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_ru_execution.PROC_INST_ID_
     *
     * @param procInstId the value for act_ru_execution.PROC_INST_ID_
     *
     * @mbggenerated
     */
    public void setProcInstId(String procInstId) {
        this.procInstId = procInstId == null ? null : procInstId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_ru_execution.BUSINESS_KEY_
     *
     * @return the value of act_ru_execution.BUSINESS_KEY_
     *
     * @mbggenerated
     */
    public String getBusinessKey() {
        return businessKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_ru_execution.BUSINESS_KEY_
     *
     * @param businessKey the value for act_ru_execution.BUSINESS_KEY_
     *
     * @mbggenerated
     */
    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey == null ? null : businessKey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_ru_execution.PARENT_ID_
     *
     * @return the value of act_ru_execution.PARENT_ID_
     *
     * @mbggenerated
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_ru_execution.PARENT_ID_
     *
     * @param parentId the value for act_ru_execution.PARENT_ID_
     *
     * @mbggenerated
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_ru_execution.PROC_DEF_ID_
     *
     * @return the value of act_ru_execution.PROC_DEF_ID_
     *
     * @mbggenerated
     */
    public String getProcDefId() {
        return procDefId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_ru_execution.PROC_DEF_ID_
     *
     * @param procDefId the value for act_ru_execution.PROC_DEF_ID_
     *
     * @mbggenerated
     */
    public void setProcDefId(String procDefId) {
        this.procDefId = procDefId == null ? null : procDefId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_ru_execution.SUPER_EXEC_
     *
     * @return the value of act_ru_execution.SUPER_EXEC_
     *
     * @mbggenerated
     */
    public String getSuperExec() {
        return superExec;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_ru_execution.SUPER_EXEC_
     *
     * @param superExec the value for act_ru_execution.SUPER_EXEC_
     *
     * @mbggenerated
     */
    public void setSuperExec(String superExec) {
        this.superExec = superExec == null ? null : superExec.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_ru_execution.ACT_ID_
     *
     * @return the value of act_ru_execution.ACT_ID_
     *
     * @mbggenerated
     */
    public String getActId() {
        return actId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_ru_execution.ACT_ID_
     *
     * @param actId the value for act_ru_execution.ACT_ID_
     *
     * @mbggenerated
     */
    public void setActId(String actId) {
        this.actId = actId == null ? null : actId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_ru_execution.IS_ACTIVE_
     *
     * @return the value of act_ru_execution.IS_ACTIVE_
     *
     * @mbggenerated
     */
    public Byte getIsActive() {
        return isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_ru_execution.IS_ACTIVE_
     *
     * @param isActive the value for act_ru_execution.IS_ACTIVE_
     *
     * @mbggenerated
     */
    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_ru_execution.IS_CONCURRENT_
     *
     * @return the value of act_ru_execution.IS_CONCURRENT_
     *
     * @mbggenerated
     */
    public Byte getIsConcurrent() {
        return isConcurrent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_ru_execution.IS_CONCURRENT_
     *
     * @param isConcurrent the value for act_ru_execution.IS_CONCURRENT_
     *
     * @mbggenerated
     */
    public void setIsConcurrent(Byte isConcurrent) {
        this.isConcurrent = isConcurrent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_ru_execution.IS_SCOPE_
     *
     * @return the value of act_ru_execution.IS_SCOPE_
     *
     * @mbggenerated
     */
    public Byte getIsScope() {
        return isScope;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_ru_execution.IS_SCOPE_
     *
     * @param isScope the value for act_ru_execution.IS_SCOPE_
     *
     * @mbggenerated
     */
    public void setIsScope(Byte isScope) {
        this.isScope = isScope;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_ru_execution.IS_EVENT_SCOPE_
     *
     * @return the value of act_ru_execution.IS_EVENT_SCOPE_
     *
     * @mbggenerated
     */
    public Byte getIsEventScope() {
        return isEventScope;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_ru_execution.IS_EVENT_SCOPE_
     *
     * @param isEventScope the value for act_ru_execution.IS_EVENT_SCOPE_
     *
     * @mbggenerated
     */
    public void setIsEventScope(Byte isEventScope) {
        this.isEventScope = isEventScope;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_ru_execution.SUSPENSION_STATE_
     *
     * @return the value of act_ru_execution.SUSPENSION_STATE_
     *
     * @mbggenerated
     */
    public Integer getSuspensionState() {
        return suspensionState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_ru_execution.SUSPENSION_STATE_
     *
     * @param suspensionState the value for act_ru_execution.SUSPENSION_STATE_
     *
     * @mbggenerated
     */
    public void setSuspensionState(Integer suspensionState) {
        this.suspensionState = suspensionState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_ru_execution.CACHED_ENT_STATE_
     *
     * @return the value of act_ru_execution.CACHED_ENT_STATE_
     *
     * @mbggenerated
     */
    public Integer getCachedEntState() {
        return cachedEntState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_ru_execution.CACHED_ENT_STATE_
     *
     * @param cachedEntState the value for act_ru_execution.CACHED_ENT_STATE_
     *
     * @mbggenerated
     */
    public void setCachedEntState(Integer cachedEntState) {
        this.cachedEntState = cachedEntState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_ru_execution.TENANT_ID_
     *
     * @return the value of act_ru_execution.TENANT_ID_
     *
     * @mbggenerated
     */
    public String getTenantId() {
        return tenantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_ru_execution.TENANT_ID_
     *
     * @param tenantId the value for act_ru_execution.TENANT_ID_
     *
     * @mbggenerated
     */
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_ru_execution.NAME_
     *
     * @return the value of act_ru_execution.NAME_
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_ru_execution.NAME_
     *
     * @param name the value for act_ru_execution.NAME_
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column act_ru_execution.LOCK_TIME_
     *
     * @return the value of act_ru_execution.LOCK_TIME_
     *
     * @mbggenerated
     */
    public Date getLockTime() {
        return lockTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column act_ru_execution.LOCK_TIME_
     *
     * @param lockTime the value for act_ru_execution.LOCK_TIME_
     *
     * @mbggenerated
     */
    public void setLockTime(Date lockTime) {
        this.lockTime = lockTime;
    }
}