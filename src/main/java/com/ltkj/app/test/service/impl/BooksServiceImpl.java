package com.ltkj.app.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ltkj.app.common.dao.BooksMapper;
import com.ltkj.app.common.model.Books;
import com.ltkj.app.common.model.PageResult;
import com.ltkj.app.test.dao.BooksMapperCus;
import com.ltkj.app.test.model.BooksCus;
import com.ltkj.app.test.service.BookService;
import com.ltkj.core.filter.AjaxValidation;

@Service
public class BooksServiceImpl implements BookService{

	@Resource
	private BooksMapperCus booksMapperCus;
	@Resource
	private BooksMapper booksMapper;
	
	/* (non-Javadoc)
	 * 查询图书列表
	 */
	@Override
	public PageResult queryBooksList(Books books) throws Exception {
		List<Books> list = booksMapperCus.selectBooksList(books);
		return new PageResult(list);
	}

	/* (non-Javadoc)
	 * 新增图书信息
	 */
	@Override
	public void addBooksInto(Books books) throws Exception {
		booksMapper.insertSelective(books);
	}

	/* (non-Javadoc)
	 * 通过id查询图书信息，填充用
	 */
	@Override
	public BooksCus queryBookById(BooksCus books) throws Exception {
		return booksMapperCus.selectBookById(books);
	}

	/* (non-Javadoc)
	 * 更新图书信息
	 */
	@Override
	public void updateBookInfo(BooksCus books) throws Exception {
		booksMapper.updateByPrimaryKeySelective(books);
	}

	/* (non-Javadoc)
	 * 通过id删除图书信息
	 */
	@Override
	public void deleteBooksByIds(List<String> booksIds) throws Exception {
		booksMapperCus.deleteBooksByIds(booksIds);
	}

	/* (non-Javadoc)
	 * check图书编号
	 */
	@Override
	public List<Object> checkBookNumber(BooksCus books) throws Exception {
		Integer count;
		if(books.getPageFlag().equals("update")){
			count = 0;
		}else{
			books.setUuid("");
			count = booksMapperCus.checkBookNumber(books);
		}	
		return AjaxValidation.ajaxCheck(books.getFieldId(), count);
		
	}
	
	
}
