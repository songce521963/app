package com.ltkj.app.common.model;

public class RoleRes {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_res.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_res.role_id
     *
     * @mbggenerated
     */
    private String roleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_res.res_id
     *
     * @mbggenerated
     */
    private String resId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role_res.id
     *
     * @return the value of sys_role_res.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role_res.id
     *
     * @param id the value for sys_role_res.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role_res.role_id
     *
     * @return the value of sys_role_res.role_id
     *
     * @mbggenerated
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role_res.role_id
     *
     * @param roleId the value for sys_role_res.role_id
     *
     * @mbggenerated
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role_res.res_id
     *
     * @return the value of sys_role_res.res_id
     *
     * @mbggenerated
     */
    public String getResId() {
        return resId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role_res.res_id
     *
     * @param resId the value for sys_role_res.res_id
     *
     * @mbggenerated
     */
    public void setResId(String resId) {
        this.resId = resId == null ? null : resId.trim();
    }
}