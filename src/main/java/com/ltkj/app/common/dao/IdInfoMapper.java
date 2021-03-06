package com.ltkj.app.common.dao;

import com.ltkj.app.common.model.IdInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface IdInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_id_info
     *
     * @mbggenerated
     */
    @Delete({
        "delete from act_id_info",
        "where ID_ = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_id_info
     *
     * @mbggenerated
     */
    @Insert({
        "insert into act_id_info (ID_, REV_, ",
        "USER_ID_, TYPE_, KEY_, ",
        "VALUE_, PARENT_ID_, ",
        "PASSWORD_)",
        "values (#{id,jdbcType=VARCHAR}, #{rev,jdbcType=INTEGER}, ",
        "#{userId,jdbcType=VARCHAR}, #{type,jdbcType=VARCHAR}, #{key,jdbcType=VARCHAR}, ",
        "#{value,jdbcType=VARCHAR}, #{parentId,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=LONGVARBINARY})"
    })
    int insert(IdInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_id_info
     *
     * @mbggenerated
     */
    int insertSelective(IdInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_id_info
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "ID_, REV_, USER_ID_, TYPE_, KEY_, VALUE_, PARENT_ID_, PASSWORD_",
        "from act_id_info",
        "where ID_ = #{id,jdbcType=VARCHAR}"
    })
    @ResultMap("ResultMapWithBLOBs")
    IdInfo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_id_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(IdInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_id_info
     *
     * @mbggenerated
     */
    @Update({
        "update act_id_info",
        "set REV_ = #{rev,jdbcType=INTEGER},",
          "USER_ID_ = #{userId,jdbcType=VARCHAR},",
          "TYPE_ = #{type,jdbcType=VARCHAR},",
          "KEY_ = #{key,jdbcType=VARCHAR},",
          "VALUE_ = #{value,jdbcType=VARCHAR},",
          "PARENT_ID_ = #{parentId,jdbcType=VARCHAR},",
          "PASSWORD_ = #{password,jdbcType=LONGVARBINARY}",
        "where ID_ = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKeyWithBLOBs(IdInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_id_info
     *
     * @mbggenerated
     */
    @Update({
        "update act_id_info",
        "set REV_ = #{rev,jdbcType=INTEGER},",
          "USER_ID_ = #{userId,jdbcType=VARCHAR},",
          "TYPE_ = #{type,jdbcType=VARCHAR},",
          "KEY_ = #{key,jdbcType=VARCHAR},",
          "VALUE_ = #{value,jdbcType=VARCHAR},",
          "PARENT_ID_ = #{parentId,jdbcType=VARCHAR}",
        "where ID_ = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(IdInfo record);
}