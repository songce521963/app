package com.ltkj.app.inventory.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ltkj.app.common.dao.GoodsMapper;
import com.ltkj.app.common.model.Goods;
import com.ltkj.app.common.model.MessageVo;
import com.ltkj.app.common.model.PageResult;
import com.ltkj.app.inventory.dao.InvGoodsMapperCus;
import com.ltkj.app.inventory.model.InvGoodsDetailModel;
import com.ltkj.app.inventory.service.InvGoodsService;
import com.ltkj.app.management.model.UserCus;
import com.ltkj.app.unit.ExcelUtil;
import com.ltkj.core.CommonUtil;
import com.ltkj.core.FileUploadUtil;
import com.ltkj.core.SessionContext;

@Service
public class InvGoodsServiceImpl implements InvGoodsService {

	@Resource
	private InvGoodsMapperCus invGoodsMapperCus;

	@Resource
	private GoodsMapper goodsMapper;

	@Override
	public PageResult queryGoodsList(InvGoodsDetailModel goods) throws Exception {
		goods.setCompanyId(SessionContext.getLogInUser().getCompanyId());
		List<InvGoodsDetailModel> list = invGoodsMapperCus.queryGoodsList(goods);
		return new PageResult(list);
	}

	@Override
	public void addGoodsDetail(Goods goods) throws Exception {
		goods.setCompanyId(SessionContext.getLogInUser().getCompanyId());
		goods.setIsActive("1");
		goodsMapper.insertSelective(goods);
	}

	@Override
	public Goods queryGoodsWithPK(Goods goods) throws Exception {
		return invGoodsMapperCus.queryGoods(goods);
	}

	@Override
	public void updateGoodsDetail(Goods goods) throws Exception {
		goods.setCompanyId(SessionContext.getLogInUser().getCompanyId());
		goodsMapper.updateByPrimaryKeySelective(goods);
	}

	@Override
	public void deleteGoods(List<String> goodsIds) throws Exception {
		UserCus user = SessionContext.getLogInUser();

		Map<String, Object> hm = new HashMap<String, Object>();
		hm.put("list", goodsIds);
		hm.put("userId", user.getUserCode());
		hm.put("userName", user.getUserName());

		invGoodsMapperCus.deleteGoodsByIds(hm);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void uploadGoodsInfo(InvGoodsDetailModel goods, Map<String, Object> map, InvGoodsService invGoodsService)
			throws Exception {
		// 获取上传结果map
		Map<String, Object> objMap = ExcelUtil.getObjectList(goods.getFile(), Goods.class);

		// 获取上传文件映射出的对象数组
		List<Goods> goodsList = (List<Goods>) objMap.get(ExcelUtil.DATA);

		// 获取上传文件验证错误信息
		List<String> messageList = (List<String>) objMap.get(ExcelUtil.MESSAGE);

		// 返回错误日志
		map.put("messageList", messageList);

		// 如果有错误日志
		if (messageList.size() != 0) {
			return;
		}

		// 插入数据库
		for (int i = 0; i < goodsList.size(); i++) {
			// ID赋值
			goodsList.get(i).setGoodsId(CommonUtil.getUuid());

			// 共通信息赋值
			CommonUtil.setUpdateInfo(goodsList.get(i), "insert");

			// 插入数据库
			invGoodsService.addGoodsDetail(goodsList.get(i));
		}

	}

	@Override
	public List<InvGoodsDetailModel> queryGoodsByIds(List<String> goodsIds) throws Exception {
		List<InvGoodsDetailModel> list = invGoodsMapperCus.selectGoodsByIds(goodsIds);
		return list;
	}

	@Override
	public MessageVo recoveryGoods(Goods goods) throws Exception {
		invGoodsMapperCus.recoveryGoodsByGoodsId(goods);
		return new MessageVo("商品重新上架成功！");
	}

	@Override
	public MessageVo queryGoodsExist(List<String> goodsIds,HttpServletRequest request) throws Exception {
		int count = invGoodsMapperCus.selectGoodsCount(goodsIds);
		if(count == 0){
			UserCus user = SessionContext.getLogInUser();

			Map<String, Object> hm = new HashMap<String, Object>();
			hm.put("list", goodsIds);
			hm.put("userId", user.getUserCode());
			hm.put("userName", user.getUserName());
			
			// 根据ids查询出要删除的商品，删除savefile下的商品图片用
			List<InvGoodsDetailModel> goods =queryGoodsByIds(goodsIds);

			ArrayList<String> picSrc = new ArrayList<>();
			for (int i = 0; i < goods.size(); i++) {
				String pic = goods.get(i).getPicSrc();
				if (pic != null && !pic.isEmpty()) {
					picSrc.add(pic);
				}
			}
			// 判断要删除的商品图片是否为空
			if (picSrc.size() > 0) {
				FileUploadUtil.deletePicture(picSrc, request);
			}

			invGoodsMapperCus.deleteGoodsPhyByIds(hm);
			return new MessageVo("删除成功！");
		}else{
			return new MessageVo("此商品不能删除！");
		}
	}

	@Override
	public Integer queryGoodsIsExist(Goods goods) throws Exception {
		return invGoodsMapperCus.queryGoodsIsExist(goods);
	}
}
