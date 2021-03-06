package com.ltkj.app.common.dao;

import com.ltkj.app.common.model.BookInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface BookInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table q_book_info
     *
     * @mbggenerated
     */
    @Delete({
        "delete from q_book_info",
        "where uuid = #{uuid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String uuid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table q_book_info
     *
     * @mbggenerated
     */
    @Insert({
        "insert into q_book_info (uuid, book_code, ",
        "book_name, book_category, ",
        "book_author, book_company, ",
        "book_date, book_price, ",
        "book_synopsis, book_sum, ",
        "book_num, book_url, ",
        "Is_Active, CREATE_DT, ",
        "CREATE_OP, CREATE_PG, ",
        "UPDATE_DT, UPDATE_OP, ",
        "UPDATE_PG)",
        "values (#{uuid,jdbcType=VARCHAR}, #{bookCode,jdbcType=VARCHAR}, ",
        "#{bookName,jdbcType=VARCHAR}, #{bookCategory,jdbcType=VARCHAR}, ",
        "#{bookAuthor,jdbcType=VARCHAR}, #{bookCompany,jdbcType=VARCHAR}, ",
        "#{bookDate,jdbcType=TIMESTAMP}, #{bookPrice,jdbcType=DECIMAL}, ",
        "#{bookSynopsis,jdbcType=VARCHAR}, #{bookSum,jdbcType=INTEGER}, ",
        "#{bookNum,jdbcType=INTEGER}, #{bookUrl,jdbcType=VARCHAR}, ",
        "#{isActive,jdbcType=VARCHAR}, #{createDt,jdbcType=TIMESTAMP}, ",
        "#{createOp,jdbcType=VARCHAR}, #{createPg,jdbcType=VARCHAR}, ",
        "#{updateDt,jdbcType=TIMESTAMP}, #{updateOp,jdbcType=VARCHAR}, ",
        "#{updatePg,jdbcType=VARCHAR})"
    })
    int insert(BookInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table q_book_info
     *
     * @mbggenerated
     */
    int insertSelective(BookInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table q_book_info
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "uuid, book_code, book_name, book_category, book_author, book_company, book_date, ",
        "book_price, book_synopsis, book_sum, book_num, book_url, Is_Active, CREATE_DT, ",
        "CREATE_OP, CREATE_PG, UPDATE_DT, UPDATE_OP, UPDATE_PG",
        "from q_book_info",
        "where uuid = #{uuid,jdbcType=VARCHAR}"
    })
    @ResultMap("BaseResultMap")
    BookInfo selectByPrimaryKey(String uuid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table q_book_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(BookInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table q_book_info
     *
     * @mbggenerated
     */
    @Update({
        "update q_book_info",
        "set book_code = #{bookCode,jdbcType=VARCHAR},",
          "book_name = #{bookName,jdbcType=VARCHAR},",
          "book_category = #{bookCategory,jdbcType=VARCHAR},",
          "book_author = #{bookAuthor,jdbcType=VARCHAR},",
          "book_company = #{bookCompany,jdbcType=VARCHAR},",
          "book_date = #{bookDate,jdbcType=TIMESTAMP},",
          "book_price = #{bookPrice,jdbcType=DECIMAL},",
          "book_synopsis = #{bookSynopsis,jdbcType=VARCHAR},",
          "book_sum = #{bookSum,jdbcType=INTEGER},",
          "book_num = #{bookNum,jdbcType=INTEGER},",
          "book_url = #{bookUrl,jdbcType=VARCHAR},",
          "Is_Active = #{isActive,jdbcType=VARCHAR},",
          "CREATE_DT = #{createDt,jdbcType=TIMESTAMP},",
          "CREATE_OP = #{createOp,jdbcType=VARCHAR},",
          "CREATE_PG = #{createPg,jdbcType=VARCHAR},",
          "UPDATE_DT = #{updateDt,jdbcType=TIMESTAMP},",
          "UPDATE_OP = #{updateOp,jdbcType=VARCHAR},",
          "UPDATE_PG = #{updatePg,jdbcType=VARCHAR}",
        "where uuid = #{uuid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(BookInfo record);
}