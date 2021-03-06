/*       BooksController.java     */

package com.ltkj.app.test.controller;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ltkj.app.bussinessCommon.service.BaseHashMapService;
import com.ltkj.app.common.controller.BaseController;
import com.ltkj.app.common.model.BaseHashMap;
import com.ltkj.app.common.model.Books;
import com.ltkj.app.common.model.MessageVo;
import com.ltkj.app.common.model.PageResult;
import com.ltkj.app.company.model.CompanyBeanCus;
import com.ltkj.app.test.model.BooksCus;
import com.ltkj.app.test.service.BookService;
import com.ltkj.core.CommonUtil;
import com.ltkj.core.Consts;
import com.ltkj.core.filter.AjaxValidation;

@Controller
@RequestMapping("test")
public class BooksController extends BaseController{
	
	@Resource
	private BookService bookService;
	@Resource
    private BaseHashMapService baseHashMapService;
	
	//显示公司信息页面
	@RequestMapping("/showList")
	public String show() throws Exception{
		//图书对象Model，传递到页面显示
		BooksCus booksModel = new BooksCus();
		
		//图书分类下拉列表
		BaseHashMap booksSort = new BaseHashMap();
		booksSort.setTypeName("book_sort");
		
		//查询出图书分类列表并填充到Model中
		booksModel.setBookSortList(baseHashMapService.queryHashMapList(booksSort));
		
		//将图书对象Model放到request中
		request.setAttribute("booksModel",booksModel);
		
		return "test/books_list";
	}
	
	//图书信息列表
	@RequestMapping("/queryBooks")
	@ResponseBody
	public PageResult queryBooksList(Books books) throws Exception{
		return bookService.queryBooksList(books);
	}
	
	//图书详细页面
	@RequestMapping("/booksInfo")
	public String booksInfo() throws Exception{
		//图书对象Model，传递到页面显示
		BooksCus booksModel = new BooksCus();		
		//图书分类下拉列表
		BaseHashMap booksSort = new BaseHashMap();
		booksSort.setTypeName("book_sort");		
		//查询出图书分类列表并填充到Model中
		booksModel.setBookSortList(baseHashMapService.queryHashMapList(booksSort));		
		//将图书对象Model放到request中
		request.setAttribute("booksModel",booksModel);
		
		return "test/books_info";
	} 
	
	//新增、更新图书
	@RequestMapping("/addAndUpdateBookInfo")
	public String addAndUpdateBookInfo(BooksCus books,RedirectAttributes attributes)  throws Exception{
		if("update".equals(books.getPageFlag())){
			//填充图书初始基本信息（调用共同，自动）
			CommonUtil.setUpdateInfo(books, "update");
			//更新图书
			bookService.updateBookInfo(books);
			// 添加需要传递的信息
            attributes.addFlashAttribute("message", Consts.UPDATE_SUCCESS);
		}
		//新增、拷贝图书
		else{
			//创建新增图书uuid
			books.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
			//1表示可查看逻辑删除用
			books.setIsActive("1");
			//填充图示初始基本信息（调用共同，自动）
			CommonUtil.setUpdateInfo(books, "insert");
			//新增图书
			bookService.addBooksInto(books);
			// 添加成功需要传递的信息
	        attributes.addFlashAttribute("message", Consts.INSERT_SUCCESS);
		}
        
		return REDIRECT + "showList.html"; 
	}
	
	//图书查看、编辑、拷贝操作
	@RequestMapping("/booksSearchOrEditOrCopy/{uuid}/{flag}")
	public String booksEditOrCopy(@PathVariable("uuid") String uuid, @PathVariable("flag") String flag) throws Exception{
		//图书对象Model，传递到页面显示
		BooksCus booksModel = new BooksCus();
		//图书信息，查询用
		BooksCus books = new BooksCus();
		books.setUuid(uuid);
		//通过id查询图书信息,Model获取图书信息结果
		booksModel = (BooksCus) bookService.queryBookById(books);		
		//页面区分Flag
		booksModel.setPageFlag(flag);
		//图书分类下拉列表
		BaseHashMap booksSort = new BaseHashMap();
		booksSort.setTypeName("book_sort");
		booksSort.setKey(booksModel.getBookSort());
		//查询出图书分类列表并填充到Model中
		booksModel.setBookSortList(baseHashMapService.queryHashMapList(booksSort));
		//将图书对象Model放到request中
		request.setAttribute("booksModel",booksModel);
		
		return "test/books_info";
	}
	
	//删除图书信息
	@RequestMapping("/moveBooksByIds")
	@ResponseBody	
	public MessageVo moveBooksByIds(@RequestBody List<String> booksIds) throws Exception{
		bookService.deleteBooksByIds(booksIds);
        return new MessageVo(Consts.DELETE_SUCCESS);

	}
	
	//图书编号check
	@RequestMapping("/checkBookNumber")
	@ResponseBody
	public List<Object> checkBookNumber(BooksCus books) throws Exception{
		return bookService.checkBookNumber(books);		
	}
		
}