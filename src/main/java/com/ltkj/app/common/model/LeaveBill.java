package com.ltkj.app.common.model;

import java.util.Date;

public class LeaveBill {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_leave_bill.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_leave_bill.leave_type
     *
     * @mbggenerated
     */
    private String leaveType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_leave_bill.from_time
     *
     * @mbggenerated
     */
    private Date fromTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_leave_bill.end_time
     *
     * @mbggenerated
     */
    private Date endTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_leave_bill.days
     *
     * @mbggenerated
     */
    private String days;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_leave_bill.comments
     *
     * @mbggenerated
     */
    private String comments;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_leave_bill.state
     *
     * @mbggenerated
     */
    private String state;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_leave_bill.user_id
     *
     * @mbggenerated
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_leave_bill.create_user
     *
     * @mbggenerated
     */
    private String createUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_leave_bill.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_leave_bill.update_user
     *
     * @mbggenerated
     */
    private String updateUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_leave_bill.update_time
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_leave_bill.id
     *
     * @return the value of s_leave_bill.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_leave_bill.id
     *
     * @param id the value for s_leave_bill.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_leave_bill.leave_type
     *
     * @return the value of s_leave_bill.leave_type
     *
     * @mbggenerated
     */
    public String getLeaveType() {
        return leaveType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_leave_bill.leave_type
     *
     * @param leaveType the value for s_leave_bill.leave_type
     *
     * @mbggenerated
     */
    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType == null ? null : leaveType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_leave_bill.from_time
     *
     * @return the value of s_leave_bill.from_time
     *
     * @mbggenerated
     */
    public Date getFromTime() {
        return fromTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_leave_bill.from_time
     *
     * @param fromTime the value for s_leave_bill.from_time
     *
     * @mbggenerated
     */
    public void setFromTime(Date fromTime) {
        this.fromTime = fromTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_leave_bill.end_time
     *
     * @return the value of s_leave_bill.end_time
     *
     * @mbggenerated
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_leave_bill.end_time
     *
     * @param endTime the value for s_leave_bill.end_time
     *
     * @mbggenerated
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_leave_bill.days
     *
     * @return the value of s_leave_bill.days
     *
     * @mbggenerated
     */
    public String getDays() {
        return days;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_leave_bill.days
     *
     * @param days the value for s_leave_bill.days
     *
     * @mbggenerated
     */
    public void setDays(String days) {
        this.days = days == null ? null : days.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_leave_bill.comments
     *
     * @return the value of s_leave_bill.comments
     *
     * @mbggenerated
     */
    public String getComments() {
        return comments;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_leave_bill.comments
     *
     * @param comments the value for s_leave_bill.comments
     *
     * @mbggenerated
     */
    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_leave_bill.state
     *
     * @return the value of s_leave_bill.state
     *
     * @mbggenerated
     */
    public String getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_leave_bill.state
     *
     * @param state the value for s_leave_bill.state
     *
     * @mbggenerated
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_leave_bill.user_id
     *
     * @return the value of s_leave_bill.user_id
     *
     * @mbggenerated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_leave_bill.user_id
     *
     * @param userId the value for s_leave_bill.user_id
     *
     * @mbggenerated
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_leave_bill.create_user
     *
     * @return the value of s_leave_bill.create_user
     *
     * @mbggenerated
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_leave_bill.create_user
     *
     * @param createUser the value for s_leave_bill.create_user
     *
     * @mbggenerated
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_leave_bill.create_time
     *
     * @return the value of s_leave_bill.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_leave_bill.create_time
     *
     * @param createTime the value for s_leave_bill.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_leave_bill.update_user
     *
     * @return the value of s_leave_bill.update_user
     *
     * @mbggenerated
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_leave_bill.update_user
     *
     * @param updateUser the value for s_leave_bill.update_user
     *
     * @mbggenerated
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_leave_bill.update_time
     *
     * @return the value of s_leave_bill.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_leave_bill.update_time
     *
     * @param updateTime the value for s_leave_bill.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}