package com.ltkj.app.common.dao;

import com.ltkj.app.common.model.IdUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface IdUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_id_user
     *
     * @mbggenerated
     */
    @Delete({
        "delete from act_id_user",
        "where ID_ = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_id_user
     *
     * @mbggenerated
     */
    @Insert({
        "insert into act_id_user (ID_, REV_, ",
        "FIRST_, LAST_, EMAIL_, ",
        "PWD_, PICTURE_ID_)",
        "values (#{id,jdbcType=VARCHAR}, #{rev,jdbcType=INTEGER}, ",
        "#{first,jdbcType=VARCHAR}, #{last,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, ",
        "#{pwd,jdbcType=VARCHAR}, #{pictureId,jdbcType=VARCHAR})"
    })
    int insert(IdUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_id_user
     *
     * @mbggenerated
     */
    int insertSelective(IdUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_id_user
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "ID_, REV_, FIRST_, LAST_, EMAIL_, PWD_, PICTURE_ID_",
        "from act_id_user",
        "where ID_ = #{id,jdbcType=VARCHAR}"
    })
    @ResultMap("BaseResultMap")
    IdUser selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_id_user
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(IdUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_id_user
     *
     * @mbggenerated
     */
    @Update({
        "update act_id_user",
        "set REV_ = #{rev,jdbcType=INTEGER},",
          "FIRST_ = #{first,jdbcType=VARCHAR},",
          "LAST_ = #{last,jdbcType=VARCHAR},",
          "EMAIL_ = #{email,jdbcType=VARCHAR},",
          "PWD_ = #{pwd,jdbcType=VARCHAR},",
          "PICTURE_ID_ = #{pictureId,jdbcType=VARCHAR}",
        "where ID_ = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(IdUser record);
}