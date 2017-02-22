package com.ltkj.app.inventory.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ltkj.app.bussinessCommon.service.BaseHashMapService;
import com.ltkj.app.common.controller.BaseController;
import com.ltkj.app.common.model.BaseHashMap;
import com.ltkj.app.common.model.Goods;
import com.ltkj.app.common.model.MessageVo;
import com.ltkj.app.common.model.PageResult;
import com.ltkj.app.inventory.model.InvGoodsDetailModel;
import com.ltkj.app.inventory.service.InvGoodsService;
import com.ltkj.core.CommonUtil;
import com.ltkj.core.Consts;
import com.ltkj.core.FileUploadUtil;

@Controller
@RequestMapping(InventoryManageController.INVENTORY)
public class InventoryManageController extends BaseController {

	// 库存管理页面
	protected final static String INVENTORY = "/inventory";
	protected final static String INVENTORY_GOODS_LIST = "/inventory/inventory_goods_list";
	protected final static String INVENTORY_GOODS_LIST_QUERY = "/inventory_goods_list_query";
	protected final static String INVENTORY_GOODS_DETAIL = "/inventory/inventory_goods_detail";
	protected final static String INVENTORY_GOODS_UPLOAD = "/inventory/inventory_goods_upload";
	protected final static String GOODS_NOT_EXIST = "/inventory/goods_not_exist";

	protected final static String INVENTORY_UPDATE = "update";

	@Resource
	private InvGoodsService invGoodsService;

	@Resource
	private BaseHashMapService baseHashMapService;

	// 货品一览画面
	@RequestMapping("/inventory_goods_list")
	public String inventoryGoodsList(@ModelAttribute("message") String message) throws Exception {
		// 商品Model,传递到页面使用
		InvGoodsDetailModel goodsModel = new InvGoodsDetailModel();

		// 商品所属栏目下拉框查询条件
		BaseHashMap primaryCategory = new BaseHashMap();
		primaryCategory.setTypeName(Consts.GOODS_PRIMARY_CATEGORY);

		// 查询出商品所属栏目并填充到商品Model中
		goodsModel.setPrimaryCategoryList(baseHashMapService.queryHashMapList(primaryCategory));

		// 商品所属栏目下拉框查询条件
		BaseHashMap smallCategory = new BaseHashMap();
		smallCategory.setTypeName(Consts.GOODS_SMALL_CATEGORY);

		// 查询出商品所属栏目并填充到商品Model中
		goodsModel.setSmallCategoryList(baseHashMapService.queryHashMapList(smallCategory));

		// 将Model放入到reuqest中
		request.setAttribute("goodsModel", goodsModel);

		return INVENTORY_GOODS_LIST;
	}

	// 货品一览页面初期化
	@RequestMapping("/inventory_goods_list_query")
	@ResponseBody
	public PageResult queryGoodsList(InvGoodsDetailModel goods) throws Exception {
		return invGoodsService.queryGoodsList(goods);
	}

	// 货品一览页面初期化
	@RequestMapping("/inventory_goods_upload")
	public String goodsUploadInit() throws Exception {
		return INVENTORY_GOODS_UPLOAD;
	}

	// 货品详细新规画面
	@RequestMapping("/inventory_goods_detail")
	public String inventoryGoodsDetail() throws Exception {
		// 商品Model,传递到页面使用
		InvGoodsDetailModel goodsModel = new InvGoodsDetailModel();

		// 商品所属栏目下拉框查询条件
		BaseHashMap primaryCategory = new BaseHashMap();
		primaryCategory.setTypeName(Consts.GOODS_PRIMARY_CATEGORY);

		// 查询出商品所属栏目并填充到商品Model中
		goodsModel.setPrimaryCategoryList(baseHashMapService.queryHashMapList(primaryCategory));

		// 商品所属栏目下拉框查询条件
		BaseHashMap smallCategory = new BaseHashMap();
		smallCategory.setTypeName(Consts.GOODS_SMALL_CATEGORY);

		// 查询出商品所属栏目并填充到商品Model中
		goodsModel.setSmallCategoryList(baseHashMapService.queryHashMapList(smallCategory));

		// 将Model放入到reuqest中
		request.setAttribute("goodsModel", goodsModel);

		return INVENTORY_GOODS_DETAIL;
	}

	// 货品详细编辑画面
	@RequestMapping("/inventory_goods_detail_param/{goodsId}/{flag}")
	public String inventoryGoodsDetailParam(@PathVariable("goodsId") String goodsId, @PathVariable("flag") String flag)
			throws Exception {
		// 商品Model,传递到页面使用
		InvGoodsDetailModel goodsModel = new InvGoodsDetailModel();

		// 查询数据用model
		Goods goods = new Goods();

		goods.setGoodsId(goodsId);
		int count = invGoodsService.queryGoodsIsExist(goods);
		if(count == 0){
			return GOODS_NOT_EXIST;
		}else{
			// 获得商品信息查询结果
			goodsModel = (InvGoodsDetailModel) invGoodsService.queryGoodsWithPK(goods);

			// 页面区分flag
			goodsModel.setPageFlag(flag);

			// 商品所属栏目下拉框查询条件
			BaseHashMap primaryCategory = new BaseHashMap();
			primaryCategory.setTypeName(Consts.GOODS_PRIMARY_CATEGORY);
			primaryCategory.setKey(goodsModel.getPrimaryCategory());

			// 查询出商品所属栏目并填充到商品Model中
			goodsModel.setPrimaryCategoryList(baseHashMapService.queryHashMapList(primaryCategory));

			// 商品所属栏目下拉框查询条件
			BaseHashMap smallCategory = new BaseHashMap();
			smallCategory.setTypeName(Consts.GOODS_SMALL_CATEGORY);
			smallCategory.setKey(goodsModel.getSmallCategory());

			// 查询出商品所属栏目并填充到商品Model中
			goodsModel.setSmallCategoryList(baseHashMapService.queryHashMapList(smallCategory));

			// 将Model放入到reuqest中
			request.setAttribute("goodsModel", goodsModel);

			return INVENTORY_GOODS_DETAIL;
		}
	}

	// 添加请假单信息
	@RequestMapping("/edit_goods_detail")
	public String editGoodsDetail(InvGoodsDetailModel goods, RedirectAttributes attributes) throws Exception {
		// 更新的情况下
		if (INVENTORY_UPDATE.equals(goods.getPageFlag())) {
			// 删除savafile文件夹下该商品原来的图片
			List<String> goodsId = new ArrayList<>();
			goodsId.add(goods.getGoodsId());
			List<InvGoodsDetailModel> oldGoods = invGoodsService.queryGoodsByIds(goodsId);
			ArrayList<String> oldPicSrc = new ArrayList<>();
			for (int i = 0; i < oldGoods.size(); i++) {
				String picSrc = oldGoods.get(i).getPicSrc();
				if (picSrc != null && !picSrc.isEmpty()) {
					oldPicSrc.add(picSrc);
				}
			}
			if (oldPicSrc.size() > 0) {
				FileUploadUtil.deletePicture(oldPicSrc, request);
			}

			// copy商品图片到saveFile，删除临时文件夹
			FileUploadUtil.copyPictureToSave(request);

			// 填充商品信息,调用共通
			CommonUtil.setUpdateInfo(goods, "update");
			// 替换商品图片正式文件夹路径
			goods.setPicSrc(goods.getPicSrc().replace("tempfile", "savefile"));
			// 新规商品详细信息
			invGoodsService.updateGoodsDetail(goods);

			// 添加需要传递的信息
			attributes.addFlashAttribute("message", Consts.UPDATE_SUCCESS);
		}
		// 新规或拷贝的情况下
		else {
			// 创建商品ID
			goods.setGoodsId(UUID.randomUUID().toString().replaceAll("-", ""));

			// copy商品图片到saveFile，删除临时文件夹
			FileUploadUtil.copyPictureToSave(request);

			// 填充商品信息,调用共通
			CommonUtil.setUpdateInfo(goods, "insert");
			// 替换商品图片正式文件夹路径
			goods.setPicSrc(goods.getPicSrc().replace("tempfile", "savefile"));
			// 新规商品详细信息
			invGoodsService.addGoodsDetail(goods);

			// 添加需要传递的信息
			attributes.addFlashAttribute("message", Consts.INSERT_SUCCESS);
		}

		return REDIRECT + INVENTORY_GOODS_LIST + ".html";
	}

	// 下架货品详细
	@RequestMapping("/inventory_goods_delete")
	@ResponseBody
	public MessageVo deleteGoods(@RequestBody List<String> goodsIds) throws Exception {
		// 删除该信息
		invGoodsService.deleteGoods(goodsIds);

		return new MessageVo("下架成功！");
	}

	// 商品重新上架
	@RequestMapping("/recovery_goods")
	@ResponseBody
	public MessageVo recoveryGoods(@RequestBody Goods goods) throws Exception {
		return invGoodsService.recoveryGoods(goods);
	}

	// 物理删除前check是否可以删除
	@RequestMapping("/order_exist_goods")
	@ResponseBody
	public MessageVo orderExistsGoods(@RequestBody List<String> goodsIds) throws Exception {
		return invGoodsService.queryGoodsExist(goodsIds, request);
	}

	// 查询goods详细前check是否可以删除
//	@RequestMapping("/check_goods_exist")
//	@ResponseBody
//	public Integer checkGoodsExist(String goodsId) throws Exception {
//		Goods goods = new Goods();
//		goods.setGoodsId(goodsId);
//		return invGoodsService.queryGoodsIsExist(goods);
//	}

	/**
	 * 上传商品预览用图片
	 * 
	 * @param goods
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/iframe/uploadFile", method = RequestMethod.POST)
	public String uploadFile(InvGoodsDetailModel goods, Map<String, Object> map) throws Exception {
		// 上传后文 件的路径
		String filePath = FileUploadUtil.fileUp(goods.getPicture(), true, request);
		map.put("src", filePath);
		return UPLOADFILE;
	}

	/**
	 * 导入商品信息
	 * 
	 * @param goods
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/iframe/uploadGoodsInfo", method = RequestMethod.POST)
	public String uploadGoodsInfo(InvGoodsDetailModel goods, Map<String, Object> map) throws Exception {
		invGoodsService.uploadGoodsInfo(goods, map, invGoodsService);

		return UPLOADFILE;
	}

	/*
	 * @RequestMapping(value = "/iframe/uploadFile2") public void
	 * uploadFile(@RequestParam("upload") MultipartFile multipartFile,
	 * HttpServletRequest request, HttpServletResponse response) {
	 * response.setContentType("text/html;charset=UTF-8"); //
	 * response.setHeader("X-Frame-Options", "SAMEORIGIN");
	 * 
	 * System.out.println(
	 * "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" +
	 * multipartFile.getName());
	 * 
	 * String CKEditorFuncNum = request.getParameter("CKEditorFuncNum");
	 * PrintWriter out; String s =
	 * "<script type=\"text/javascript\">window.parent.CKEDITOR.tools.callFunction("
	 * + CKEditorFuncNum + ", '" + multipartFile.getOriginalFilename() +
	 * "');</script>"; try { out = response.getWriter(); out.print(s);
	 * out.flush(); } catch (IOException e) { e.printStackTrace(); } }
	 */
}
