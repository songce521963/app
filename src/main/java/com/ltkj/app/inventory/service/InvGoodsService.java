package com.ltkj.app.inventory.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.ltkj.app.common.model.Goods;
import com.ltkj.app.common.model.MessageVo;
import com.ltkj.app.common.model.PageResult;
import com.ltkj.app.inventory.model.InvGoodsDetailModel;

public interface InvGoodsService {

    /**
     * 查询商品信息一览
     * 
     * @param goods
     * @return
     * @throws Exception
     */
    public PageResult queryGoodsList(InvGoodsDetailModel goods) throws Exception;

    /**
     * 新规商品详细信息
     * 
     * @param goods
     * @throws Exception
     */
    public void addGoodsDetail(Goods goods) throws Exception;

    /**
     * 查询商品信息
     * 
     * @param goods
     * @throws Exception
     */
    public Goods queryGoodsWithPK(Goods goods) throws Exception;

    /**
     * 更新商品详细信息
     * 
     * @param goods
     * @throws Exception
     */
    public void updateGoodsDetail(Goods goods) throws Exception;

    /**
     * 下架商品信息
     * 
     * @param goods
     */
    public void deleteGoods(List<String> goodsIds) throws Exception;
    
    /**
	 * 恢商品重新上架
	 * @param media
	 * @return
	 * @throws Exception
	 */
	public MessageVo recoveryGoods(Goods goods)throws Exception;
    
    /**
     * 导入商品信息
     * 
     * @param goods
     * @param map
     * @param invGoodsService
     */
    public void uploadGoodsInfo(InvGoodsDetailModel goods, Map<String, Object> map, InvGoodsService invGoodsService)
            throws Exception;

	/**
	 * 根据商品ids查询对应图片
	 * @param goodsIds
	 * @return
	 * @throws Exception
	 */
	public List<InvGoodsDetailModel> queryGoodsByIds(List<String> goodsIds) throws Exception;
	
	/**
	 * 判断在订单中是否有要删除的商品
	 * @param goodsIds
	 * @return
	 * @throws Exception
	 */
	public MessageVo queryGoodsExist(List<String> goodsIds,HttpServletRequest request) throws Exception;
	
	/**
	 * 查看商品详细前check在数据中是否存在
	 * @param goods
	 * @return
	 * @throws Exception
	 */
	public Integer queryGoodsIsExist(Goods goods) throws Exception;
}
