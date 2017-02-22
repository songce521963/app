package com.ltkj.app.test.dao;

import java.util.List;

import com.ltkj.app.common.model.Books;
import com.ltkj.app.test.model.BooksCus;

public interface BooksMapperCus {

	/**
	 * 查询图书信息列表
	 * @param books
	 * @return
	 * @throws Exception
	 */
	List<Books> selectBooksList(Books books) throws Exception;

	/**
	 * 通过id查询图书信息
	 * @param books
	 * @return
	 * @throws Exception
	 */
	BooksCus selectBookById(BooksCus books) throws Exception;

	/**
	 * 通过id删除图书信息
	 * @param booksIds
	 * @throws Exception
	 */
	void deleteBooksByIds(List<String> booksIds) throws Exception;

	/**
	 * check图书编号
	 * @param books
	 * @return
	 * @throws Exception
	 */
	Integer checkBookNumber(BooksCus books) throws Exception;

}
