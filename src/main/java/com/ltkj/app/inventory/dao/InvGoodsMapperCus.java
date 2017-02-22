package com.ltkj.app.inventory.dao;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.ltkj.app.common.model.Goods;
import com.ltkj.app.inventory.model.InvGoodsDetailModel;

public interface InvGoodsMapperCus {

	/**
	 * 查询商品一览
	 * 
	 * @param goods
	 * @return
	 * @throws Exception
	 */
	public List<InvGoodsDetailModel> queryGoodsList(InvGoodsDetailModel goods) throws Exception;

	/**
	 * 查询商品
	 * 
	 * @param goods
	 * @return
	 * @throws Exception
	 */
	public Goods queryGoods(Goods goods) throws Exception;

	/**
	 * 下架商品
	 * 
	 * @param goodsIds
	 * @return
	 * @throws Exception
	 */
	public int deleteGoodsByIds(Map<String, Object> goodsIds) throws Exception;

	/**
	 * 商品重新上架
	 * 
	 * @param media
	 * @throws Exception
	 */
	public void recoveryGoodsByGoodsId(Goods goods) throws Exception;

	/**
	 * 删除商品
	 * 
	 * @param goodsIds
	 * @return
	 * @throws Exception
	 */
	public int deleteGoodsPhyByIds(Map<String, Object> goodsIds) throws Exception;

	/**
	 * 根据ids查询出要删除的商品
	 * 
	 * @param goodsIds
	 * @return
	 * @throws Exception
	 */
	public List<InvGoodsDetailModel> selectGoodsByIds(List<String> goodsIds) throws Exception;
	
	/**
	 * 查询订单中是否有要删除的商品
	 * @param goodsIds
	 * @return
	 * @throws Exception
	 */
	public Integer selectGoodsCount(List<String> goodsIds) throws Exception;
	
	/**
	 * 查看商品详细前check在数据中是否存在
	 * @param goods
	 * @return
	 * @throws Exception
	 */
	public Integer queryGoodsIsExist(Goods goods) throws Exception;

}