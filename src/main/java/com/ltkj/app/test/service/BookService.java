package com.ltkj.app.test.service;

import java.util.List;

import com.ltkj.app.common.model.Books;
import com.ltkj.app.common.model.PageResult;
import com.ltkj.app.test.model.BooksCus;

public interface BookService {

	/**
	 * 查询图书信息列表
	 * @return
	 * @throws Exception
	 */
	public PageResult queryBooksList(Books books) throws Exception;

	/**
	 * 新增图书
	 * @param books
	 * @throws Exception
	 */
	public void addBooksInto(Books books) throws Exception;

	/**
	 * 通过id查询图书信息
	 * @param books
	 * @return
	 * @throws Exception
	 */
	public BooksCus queryBookById(BooksCus books) throws Exception;

	/**
	 * 更新图书
	 * @param books
	 * @throws Exception
	 */
	public void updateBookInfo(BooksCus books) throws Exception;

	/**
	 * 通过id删除图书信息
	 * @param booksIds
	 * @throws Exception
	 */
	public void deleteBooksByIds(List<String> booksIds) throws Exception;

	/**
	 * check图书编号
	 * @param books
	 * @return
	 * @throws Exception
	 */
	public List<Object> checkBookNumber(BooksCus books) throws Exception;

}
