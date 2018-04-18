package com.sinco.carnation.goods.tools;

import net.weedfs.client.WeedFSClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;

/**
 * 
 * <p>
 * Title: GoodsTools.java
 * </p>
 * 
 * <p>
 * Description:商品管理工具
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company: 新科聚合 thinker.vc
 * </p>
 * 
 * @author thinker
 * 
 * @date 2014-12-10
 * 
 * @version 1.0.1
 */
@Component
public class GoodsTools {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private AccessoryServiceImpl accessoryService;

	@Autowired
	private WeedFSClient fsClient;

	/**
	 * 异步生成商品二维码,使用@Async，有时session、商品主图片获取不到
	 * 
	 * @param request
	 * @param goods_id
	 */
//	@Async
//	public void createGoodsQRAsync(HttpServletRequest request, String goods_id, String goodsMainImgPath, String goodsUrl) {
//		String path = create(request, goods_id, goodsMainImgPath, goodsUrl);
//		Goods updateGoods = new Goods();
//		updateGoods.setId(Long.parseLong(goods_id));
//		updateGoods.setQrImgPath(path);
//		goodsService.update(updateGoods);
//	}

//	public String createGoodsQRSync(HttpServletRequest request, String goods_id, String goodsMainImgPath, String goodsUrl) {
//		return create(request, goods_id, goodsMainImgPath, goodsUrl);
//	}

//	private String create(HttpServletRequest request, String goods_id, String goodsMainImgPath, String goodsUrl) 
//	{
//		try {
//			BufferedImage image = ThinkerQRCodeUtil.createImage(goodsUrl, goodsMainImgPath, true);
//			
//			ByteArrayOutputStream os = new ByteArrayOutputStream();  
//			ImageIO.write(image, "jpg", os);  
//			InputStream is = new ByteArrayInputStream(os.toByteArray());  
//			RequestResult result = fsClient.upload(is, goodsMainImgPath, goodsMainImgPath);
//			return result.getUrl();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
}
