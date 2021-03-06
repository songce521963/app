package com.ltkj.app.common.dao;

import com.ltkj.app.common.model.HiTaskinst;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface HiTaskinstMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_hi_taskinst
     *
     * @mbggenerated
     */
    @Delete({
        "delete from act_hi_taskinst",
        "where ID_ = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_hi_taskinst
     *
     * @mbggenerated
     */
    @Insert({
        "insert into act_hi_taskinst (ID_, PROC_DEF_ID_, ",
        "TASK_DEF_KEY_, PROC_INST_ID_, ",
        "EXECUTION_ID_, NAME_, ",
        "PARENT_TASK_ID_, DESCRIPTION_, ",
        "OWNER_, ASSIGNEE_, ",
        "START_TIME_, CLAIM_TIME_, ",
        "END_TIME_, DURATION_, ",
        "DELETE_REASON_, PRIORITY_, ",
        "DUE_DATE_, FORM_KEY_, ",
        "CATEGORY_, TENANT_ID_)",
        "values (#{id,jdbcType=VARCHAR}, #{procDefId,jdbcType=VARCHAR}, ",
        "#{taskDefKey,jdbcType=VARCHAR}, #{procInstId,jdbcType=VARCHAR}, ",
        "#{executionId,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{parentTaskId,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
        "#{owner,jdbcType=VARCHAR}, #{assignee,jdbcType=VARCHAR}, ",
        "#{startTime,jdbcType=TIMESTAMP}, #{claimTime,jdbcType=TIMESTAMP}, ",
        "#{endTime,jdbcType=TIMESTAMP}, #{duration,jdbcType=BIGINT}, ",
        "#{deleteReason,jdbcType=VARCHAR}, #{priority,jdbcType=INTEGER}, ",
        "#{dueDate,jdbcType=TIMESTAMP}, #{formKey,jdbcType=VARCHAR}, ",
        "#{category,jdbcType=VARCHAR}, #{tenantId,jdbcType=VARCHAR})"
    })
    int insert(HiTaskinst record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_hi_taskinst
     *
     * @mbggenerated
     */
    int insertSelective(HiTaskinst record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_hi_taskinst
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "ID_, PROC_DEF_ID_, TASK_DEF_KEY_, PROC_INST_ID_, EXECUTION_ID_, NAME_, PARENT_TASK_ID_, ",
        "DESCRIPTION_, OWNER_, ASSIGNEE_, START_TIME_, CLAIM_TIME_, END_TIME_, DURATION_, ",
        "DELETE_REASON_, PRIORITY_, DUE_DATE_, FORM_KEY_, CATEGORY_, TENANT_ID_",
        "from act_hi_taskinst",
        "where ID_ = #{id,jdbcType=VARCHAR}"
    })
    @ResultMap("BaseResultMap")
    HiTaskinst selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_hi_taskinst
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(HiTaskinst record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_hi_taskinst
     *
     * @mbggenerated
     */
    @Update({
        "update act_hi_taskinst",
        "set PROC_DEF_ID_ = #{procDefId,jdbcType=VARCHAR},",
          "TASK_DEF_KEY_ = #{taskDefKey,jdbcType=VARCHAR},",
          "PROC_INST_ID_ = #{procInstId,jdbcType=VARCHAR},",
          "EXECUTION_ID_ = #{executionId,jdbcType=VARCHAR},",
          "NAME_ = #{name,jdbcType=VARCHAR},",
          "PARENT_TASK_ID_ = #{parentTaskId,jdbcType=VARCHAR},",
          "DESCRIPTION_ = #{description,jdbcType=VARCHAR},",
          "OWNER_ = #{owner,jdbcType=VARCHAR},",
          "ASSIGNEE_ = #{assignee,jdbcType=VARCHAR},",
          "START_TIME_ = #{startTime,jdbcType=TIMESTAMP},",
          "CLAIM_TIME_ = #{claimTime,jdbcType=TIMESTAMP},",
          "END_TIME_ = #{endTime,jdbcType=TIMESTAMP},",
          "DURATION_ = #{duration,jdbcType=BIGINT},",
          "DELETE_REASON_ = #{deleteReason,jdbcType=VARCHAR},",
          "PRIORITY_ = #{priority,jdbcType=INTEGER},",
          "DUE_DATE_ = #{dueDate,jdbcType=TIMESTAMP},",
          "FORM_KEY_ = #{formKey,jdbcType=VARCHAR},",
          "CATEGORY_ = #{category,jdbcType=VARCHAR},",
          "TENANT_ID_ = #{tenantId,jdbcType=VARCHAR}",
        "where ID_ = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(HiTaskinst record);
}