package com.ltkj.app.common.dao;

import com.ltkj.app.common.model.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface RoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role
     *
     * @mbggenerated
     */
    @Delete({
        "delete from sys_role",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role
     *
     * @mbggenerated
     */
    @Insert({
        "insert into sys_role (id, company_id, ",
        "role_name, role_key, ",
        "comments, create_time, ",
        "create_user, update_time, ",
        "update_user)",
        "values (#{id,jdbcType=VARCHAR}, #{companyId,jdbcType=VARCHAR}, ",
        "#{roleName,jdbcType=VARCHAR}, #{roleKey,jdbcType=VARCHAR}, ",
        "#{comments,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{createUser,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{updateUser,jdbcType=VARCHAR})"
    })
    int insert(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role
     *
     * @mbggenerated
     */
    int insertSelective(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "id, company_id, role_name, role_key, comments, create_time, create_user, update_time, ",
        "update_user",
        "from sys_role",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @ResultMap("BaseResultMap")
    Role selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role
     *
     * @mbggenerated
     */
    @Update({
        "update sys_role",
        "set company_id = #{companyId,jdbcType=VARCHAR},",
          "role_name = #{roleName,jdbcType=VARCHAR},",
          "role_key = #{roleKey,jdbcType=VARCHAR},",
          "comments = #{comments,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "create_user = #{createUser,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "update_user = #{updateUser,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Role record);
}