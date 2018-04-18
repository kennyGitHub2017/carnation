package com.sinco.carnation.transport.tools;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vc.thinker.b2b2c.core.domain.virtual.CglibBean;
import vc.thinker.b2b2c.core.domain.virtual.SysMap;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.express.service.ExpressCompanyCommonService;
import com.sinco.carnation.express.service.ExpressCompanyService;
import com.sinco.carnation.goods.GoodsConstants;
import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.bo.GoodsCartBO;
import com.sinco.carnation.goods.model.Goods;
import com.sinco.carnation.goods.model.GoodsCart;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.shop.bo.EcCommonBO;
import com.sinco.carnation.shop.constants.EcCommonConstants;
import com.sinco.carnation.shop.model.Transport;
import com.sinco.carnation.sys.dao.AreaDao;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.transport.service.TransportService;

/**
 * 
 * <p>
 * Title: TransportTools.java
 * </p>
 * 
 * <p>
 * Description:运费模板工具类，用来处理运费模板相关信息
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
 * @date 2014-11-14
 * 
 * @version 1.0.1
 */
@Component
public class TransportTools {
	@Autowired
	private TransportService transportService;

	@Autowired
	private AreaDao areaDao;

	@Autowired
	private GoodsService goodsService;
	@Autowired
	private UserService userService;
	@Autowired
	private ExpressCompanyService expressCompanyService;
	@Autowired
	private ExpressCompanyCommonService expressCompanyCommonService;

	/**
	 * 根据json查询对应的运费数据信息
	 * 
	 * @param json
	 * @param mark
	 * @return
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	public String query_transprot(String json, String mark) {
		String ret = "";
		List<Map> list = Json.fromJson(ArrayList.class, CommUtil.null2String(json));
		if (list != null && list.size() > 0) {
			for (Map map : list) {
				if (CommUtil.null2String(map.get("city_id")).equals("-1")) {
					ret = CommUtil.null2String(map.get(mark));
				}
			}
		}
		return ret;
	}

	/**
	 * 解析出运费模板列表
	 * 
	 * @param json
	 *            运费json数据
	 * @param type
	 *            0为解析所有信息（包含全国配送），1为解析所有区域配送信息
	 * @return 运费模板列表信息
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	public List<CglibBean> query_all_transprot(String json, int type) throws ClassNotFoundException {
		List<CglibBean> cbs = new ArrayList<CglibBean>();
		List<Map> list = Json.fromJson(ArrayList.class, CommUtil.null2String(json));
		if (list != null && list.size() > 0) {
			if (type == 0) {
				for (Map map : list) {
					HashMap propertyMap = new HashMap();
					propertyMap.put("city_id", Class.forName("java.lang.String"));
					propertyMap.put("city_name", Class.forName("java.lang.String"));
					propertyMap.put("trans_weight", Class.forName("java.lang.String"));
					propertyMap.put("trans_fee", Class.forName("java.lang.String"));
					propertyMap.put("trans_add_weight", Class.forName("java.lang.String"));
					propertyMap.put("trans_add_fee", Class.forName("java.lang.String"));
					CglibBean cb = new CglibBean(propertyMap);
					cb.setValue("city_id", CommUtil.null2String(map.get("city_id")));
					cb.setValue("city_name", CommUtil.null2String(map.get("city_name")));
					cb.setValue("trans_weight", CommUtil.null2String(map.get("trans_weight")));
					cb.setValue("trans_fee", CommUtil.null2String(map.get("trans_fee")));
					cb.setValue("trans_add_weight", CommUtil.null2String(map.get("trans_add_weight")));
					cb.setValue("trans_add_fee", CommUtil.null2String(map.get("trans_add_fee")));
					cbs.add(cb);
				}
			}
			if (type == 1) {
				for (Map map : list) {
					if (!CommUtil.null2String(map.get("city_id")).equals("-1")) {
						HashMap propertyMap = new HashMap();
						propertyMap.put("city_id", Class.forName("java.lang.String"));
						propertyMap.put("city_name", Class.forName("java.lang.String"));
						propertyMap.put("trans_weight", Class.forName("java.lang.String"));
						propertyMap.put("trans_fee", Class.forName("java.lang.String"));
						propertyMap.put("trans_add_weight", Class.forName("java.lang.String"));
						propertyMap.put("trans_add_fee", Class.forName("java.lang.String"));
						CglibBean cb = new CglibBean(propertyMap);
						cb.setValue("city_id", CommUtil.null2String(map.get("city_id")));
						cb.setValue("city_name", CommUtil.null2String(map.get("city_name")));
						cb.setValue("trans_weight", CommUtil.null2String(map.get("trans_weight")));
						cb.setValue("trans_fee", CommUtil.null2String(map.get("trans_fee")));
						cb.setValue("trans_add_weight", CommUtil.null2String(map.get("trans_add_weight")));
						cb.setValue("trans_add_fee", CommUtil.null2String(map.get("trans_add_fee")));
						cbs.add(cb);
					}
				}
			}
		}
		return cbs;
	}

	/**
	 * 根据运费模板信息、商品重量及配送城市计算商品运费，配送城市根据IP自动获取
	 * 
	 * @param json
	 * @param weight
	 * @param city_name
	 * @return 商品的配送费用
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	public float cal_goods_trans_fee(String trans_id, String type, String weight, String volume,
			String city_name) {
		Transport trans = this.transportService.getObjById(CommUtil.null2Long(trans_id));
		if (trans == null) {
			return 0;
		}
		String json = "";
		if (type.equals("mail")) {
			json = trans.getTransMailInfo();
		}
		if (type.equals("express")) {
			json = trans.getTransExpressInfo();
		}
		if (type.equals("ems")) {
			json = trans.getTransEmsInfo();
		}
		float fee = 0;
		boolean cal_flag = false;// 是否已经计算过运费，用在没有特殊配置的区域，没有特殊配置的区域使用默认价格计算
		List<Map> list = Json.fromJson(ArrayList.class, CommUtil.null2String(json));
		if (list != null && list.size() > 0) {
			for (Map map : list) {
				String[] city_list = CommUtil.null2String(map.get("city_name")).split("、");
				for (String city : city_list) {
					if (city_name.indexOf(city) >= 0 || city.equals(city_name)) {
						cal_flag = true;
						float trans_weight = CommUtil.null2Float(map.get("trans_weight"));
						float trans_fee = CommUtil.null2Float(map.get("trans_fee"));
						float trans_add_weight = CommUtil.null2Float(map.get("trans_add_weight"));
						float trans_add_fee = CommUtil.null2Float(map.get("trans_add_fee"));
						if (trans.getTransType() == 0) {// 按照件数计算运费
							fee = trans_fee;
						}
						if (trans.getTransType() == 1) {// 按照重量计算运费用
							float goods_weight = CommUtil.null2Float(weight);
							if (goods_weight > 0) {
								fee = trans_fee;
								float other_price = 0;
								if (trans_add_weight > 0) {
									other_price = (float) (trans_add_fee * (Math.ceil(CommUtil.subtract(
											goods_weight, trans_weight) / trans_add_weight)));
								}
								fee = fee + other_price;
							}
						}
						if (trans.getTransType() == 2) {// 按照体积计算运费用
							float goods_volume = CommUtil.null2Float(volume);
							if (goods_volume > 0) {
								fee = trans_fee;
								float other_price = 0;
								if (trans_add_weight > 0) {
									other_price = (float) (trans_add_fee * (Math.ceil(CommUtil.subtract(
											goods_volume, trans_weight) / trans_add_weight)));
								}
								fee = fee + other_price;
							}
						}
						break;
					}
				}
			}
			if (!cal_flag) {// 如果没有找到配置所在的区域运费信息，则使用全国价格进行计算
				for (Map map : list) {
					String[] city_list = CommUtil.null2String(map.get("city_name")).split("、");
					for (String city : city_list) {
						if (city.equals("全国")) {
							float trans_weight = CommUtil.null2Float(map.get("trans_weight"));
							float trans_fee = CommUtil.null2Float(map.get("trans_fee"));
							float trans_add_weight = CommUtil.null2Float(map.get("trans_add_weight"));
							float trans_add_fee = CommUtil.null2Float(map.get("trans_add_fee"));
							if (trans.getTransType() == 0) {// 按照件数计算运费
								fee = trans_fee;
							}
							if (trans.getTransType() == 1) {// 按照重量计算运费用
								float goods_weight = CommUtil.null2Float(weight);
								if (goods_weight > 0) {
									fee = trans_fee;
									float other_price = 0;
									if (trans_add_weight > 0) {
										other_price = (float) (trans_add_fee * (Math.ceil(CommUtil.subtract(
												goods_weight, trans_weight) / trans_add_weight)));
									}
									fee = fee + other_price;
								}
							}
							if (trans.getTransType() == 2) {// 按照体积计算运费用
								float goods_volume = CommUtil.null2Float(volume);
								if (goods_volume > 0) {
									fee = trans_fee;
									float other_price = 0;
									if (trans_add_weight > 0) {
										other_price = (float) (trans_add_fee * (Math.ceil(CommUtil.subtract(
												goods_volume, trans_weight) / trans_add_weight)));
									}
									fee = fee + other_price;
								}
							}
							break;
						}
					}
				}
			}
		}
		return fee;
	}
	
	/////////////BEGIN
	public Double query_cart_trans_self(List<GoodsCartBO> carts, String area_id) {
		Double express_fee = 0.0;
		Area area = this.areaDao.findParentById(CommUtil.null2Long(area_id));
		String city_name = area.getAreaName();
		
		for (GoodsCart gc : carts) {
			Goods goods = this.goodsService.getObjById(gc.getGoodsId());// 重新查询，避免卖家修改商品、运费模板导致计算运费错误
			
			if (goods.getGoodsTransfee() == GoodsConstants.goods_Transfee_0) {//买家承担
				Transport transport = this.transportService.getObjById(goods.getTransportId());//判断是否是模板
				if (transport != null) {//是否是模板
					
					float a = this.cal_order_trans(transport.getTransMailInfo(),
											transport.getTransType(), goods.getGoodsWeight(),
											goods.getGoodsVolume(), city_name, gc.getCount());
					float b = this.cal_order_trans(transport.getTransExpressInfo(),
											transport.getTransType(), goods.getGoodsWeight(),
											goods.getGoodsVolume(), city_name, gc.getCount());
					float c = this.cal_order_trans(transport.getTransEmsInfo(), transport.getTransType(),
											goods.getGoodsWeight(), goods.getGoodsVolume(), city_name,
											gc.getCount());
					express_fee = express_fee + a + b + c;
					
				} else {//统一运费
					express_fee = express_fee + CommUtil.null2Float(goods.getExpressTransFee());
				}
				
			} else { //卖家承担
				express_fee = express_fee + 0;
			}
		}
		return express_fee;
	}
	////////////END

	public List<SysMap> query_cart_trans(List<GoodsCartBO> carts, String area_id) {
		List<SysMap> sms = new ArrayList<SysMap>();
		if (area_id != null && !area_id.equals("")) {
			Area area = this.areaDao.findParentById(CommUtil.null2Long(area_id));
			String city_name = area.getAreaName();
			// System.out.println(city_name);
			float mail_fee = 0;
			float express_fee = 0;
			float ems_fee = 0;

			Transport oneTransport = null;

			for (GoodsCart gc : carts) {
				Goods goods = this.goodsService.getObjById(gc.getGoodsId());// 重新查询，避免卖家修改商品、运费模板导致计算运费错误
				if (goods.getGoodsTransfee() == GoodsConstants.goods_Transfee_0) {// 买家承担费用
					Transport transport = this.transportService.getObjById(goods.getTransportId());

					if (oneTransport == null) {
						oneTransport = transport;
					}
					if (transport != null) {
						mail_fee = mail_fee
								+ this.cal_order_trans(transport.getTransMailInfo(),
										transport.getTransType(), goods.getGoodsWeight(),
										goods.getGoodsVolume(), city_name, gc.getCount());
						express_fee = express_fee
								+ this.cal_order_trans(transport.getTransExpressInfo(),
										transport.getTransType(), goods.getGoodsWeight(),
										goods.getGoodsVolume(), city_name, gc.getCount());
						ems_fee = ems_fee
								+ this.cal_order_trans(transport.getTransEmsInfo(), transport.getTransType(),
										goods.getGoodsWeight(), goods.getGoodsVolume(), city_name,
										gc.getCount());
					} else {
						mail_fee = mail_fee + CommUtil.null2Float(goods.getMailTransFee());
						express_fee = express_fee + CommUtil.null2Float(goods.getExpressTransFee());
						ems_fee = ems_fee + CommUtil.null2Float(goods.getEmsTransFee());
					}
				}
			}
			if (mail_fee == 0 && express_fee == 0 && ems_fee == 0) {
				sms.add(new SysMap("商家承担", 0));
			} else {
				if (carts.size() == 1) {// 当只有一个购物车时,只显示开通的快递方式
					if (oneTransport != null) {
						if (oneTransport != null) {
							if (oneTransport.getTransMail()) {
								sms.add(new SysMap("平邮[" + mail_fee + "元]", mail_fee));
							}
							if (oneTransport.getTransExpress()) {
								sms.add(new SysMap("快递[" + express_fee + "元]", express_fee));
							}
							if (oneTransport.getTransEms()) {
								sms.add(new SysMap("EMS[" + ems_fee + "元]", ems_fee));
							}
						}
					} else {
						sms.add(new SysMap("平邮[" + mail_fee + "元]", mail_fee));
						sms.add(new SysMap("快递[" + express_fee + "元]", express_fee));
						sms.add(new SysMap("EMS[" + ems_fee + "元]", ems_fee));
					}
				} else {
					sms.add(new SysMap("平邮[" + mail_fee + "元]", mail_fee));
					sms.add(new SysMap("快递[" + express_fee + "元]", express_fee));
					sms.add(new SysMap("EMS[" + ems_fee + "元]", ems_fee));
				}
			}
		}
		return sms;
	}

	public List<SysMap> query_cart_trans(List<GoodsCartBO> carts, Map<Long, List<GoodsCartBO>> er_goods,
			Map<Goods, List<GoodsCartBO>> ac_goods, String area_id) {
		if (er_goods != null) {
			for (Long id : er_goods.keySet()) {
				List<GoodsCartBO> list = er_goods.get(id);
				carts.addAll(list);
			}
		}
		if (ac_goods != null) {
			for (Goods id : ac_goods.keySet()) {
				List<GoodsCartBO> list = ac_goods.get(id);
				carts.addAll(list);
			}
		}
		List<SysMap> sms = new ArrayList<SysMap>();
		if (area_id != null && !area_id.equals("")) {
			Area area = this.areaDao.findParentById(CommUtil.null2Long(area_id));
			String city_name = area.getAreaName();
			// System.out.println(city_name);
			float mail_fee = 0;
			float express_fee = 0;
			float ems_fee = 0;
			Transport oneTransport = null;
			for (GoodsCartBO gc : carts) {
				GoodsBO goods = this.goodsService.findBOByid(gc.getGoodsId());// 重新查询，避免卖家修改商品、运费模板导致计算运费错误
				if (goods.getGoodsTransfee() == GoodsConstants.goods_Transfee_0) {// 买家承担费用
					Transport transport = this.transportService.getObjById(goods.getTransportId());

					if (oneTransport == null) {
						oneTransport = transport;
					}
					if (transport != null) {
						mail_fee = mail_fee
								+ this.cal_order_trans(transport.getTransMailInfo(),
										transport.getTransType(), goods.getGoodsWeight(),
										goods.getGoodsVolume(), city_name, gc.getCount());
						express_fee = express_fee
								+ this.cal_order_trans(transport.getTransExpressInfo(),
										transport.getTransType(), goods.getGoodsWeight(),
										goods.getGoodsVolume(), city_name, gc.getCount());
						ems_fee = ems_fee
								+ this.cal_order_trans(transport.getTransEmsInfo(), transport.getTransType(),
										goods.getGoodsWeight(), goods.getGoodsVolume(), city_name,
										gc.getCount());
					} else {
						mail_fee = mail_fee + CommUtil.null2Float(goods.getMailTransFee());
						express_fee = express_fee + CommUtil.null2Float(goods.getExpressTransFee());
						ems_fee = ems_fee + CommUtil.null2Float(goods.getEmsTransFee());
					}
				}
			}
			if (mail_fee == 0 && express_fee == 0 && ems_fee == 0) {
				sms.add(new SysMap("商家承担", 0));
			} else {
				if (carts.size() == 1) {// 当只有一个购物车时,只显示开通的快递方式
					if (oneTransport != null) {
						if (oneTransport.getTransMail()) {
							sms.add(new SysMap("平邮[" + mail_fee + "元]", mail_fee));
						}
						if (oneTransport.getTransExpress()) {
							sms.add(new SysMap("快递[" + express_fee + "元]", express_fee));
						}
						if (oneTransport.getTransEms()) {
							sms.add(new SysMap("EMS[" + ems_fee + "元]", ems_fee));
						}

					} else {
						sms.add(new SysMap("平邮[" + mail_fee + "元]", mail_fee));
						sms.add(new SysMap("快递[" + express_fee + "元]", express_fee));
						sms.add(new SysMap("EMS[" + ems_fee + "元]", ems_fee));
					}
				} else {
					sms.add(new SysMap("平邮[" + mail_fee + "元]", mail_fee));
					sms.add(new SysMap("快递[" + express_fee + "元]", express_fee));
					sms.add(new SysMap("EMS[" + ems_fee + "元]", ems_fee));
				}
			}
		}

		/*
		 * Iterator<SysMap> iterator = sms.iterator(); while
		 * (iterator.hasNext()) { SysMap sysMap = iterator.next(); if
		 * (CommUtil.null2Float(sysMap.getValue()) <= 0) { sms.remove(sysMap); }
		 * }
		 */
		CollectionUtils.filter(sms, new Predicate() {
			@Override
			public boolean evaluate(Object object) {
				return CommUtil.null2Float(((SysMap) object).getValue()) > 0;
			}
		});

		return sms;
	}

	@SuppressWarnings("unused")
	private void next() {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	private float cal_order_trans(String trans_json, int trans_type, Object goods_weight,
			Object goods_volume, String city_name, int count) {
		float fee = 0;
		boolean cal_flag = false;
		if (trans_json != null && !trans_json.equals("")) {
			List<Map> list = Json.fromJson(ArrayList.class, trans_json);
			if (list != null && list.size() > 0) {
				float trans_weight = 0;
				float trans_fee = 0;
				float trans_add_weight = 0;
				float trans_add_fee = 0;

				for (Map map : list) {
					String[] city_list = CommUtil.null2String(map.get("city_name")).split("、");
					for (String city : city_list) {
						// System.out.println("==========="+city+" "+city_name);
						if (city.equals(city_name) || city_name.indexOf(city) == 0) {// 城市匹配，如“沈阳市”和“沈阳”是一致的
							cal_flag = true;
							trans_weight = CommUtil.null2Float(map.get("trans_weight"));
							trans_fee = CommUtil.null2Float(map.get("trans_fee"));
							trans_add_weight = CommUtil.null2Float(map.get("trans_add_weight"));
							trans_add_fee = CommUtil.null2Float(map.get("trans_add_fee"));
							break;
						}
					}
				}

				if (!cal_flag) {// 如果没有找到配置所在的区域运费信息，则使用全国价格进行计算
					for (Map map : list) {
						String[] city_list = CommUtil.null2String(map.get("city_name")).split("、");
						for (String city : city_list) {
							if (city.equals("全国")) {
								trans_weight = CommUtil.null2Float(map.get("trans_weight"));
								trans_fee = CommUtil.null2Float(map.get("trans_fee"));
								trans_add_weight = CommUtil.null2Float(map.get("trans_add_weight"));
								trans_add_fee = CommUtil.null2Float(map.get("trans_add_fee"));
							}
						}
					}
				}

				if (trans_type == 0) {// 按照件数计算运费
					if (CommUtil.null2Int(count) > (int) trans_weight) {
						fee = trans_fee;
						float other_price = 0;
						if (trans_add_weight > 0) {
							other_price = trans_add_fee
									* Math.round(Math.ceil(CommUtil.subtract(count, trans_weight)
											/ trans_add_weight));
						}
						fee = fee + other_price;
					} else {
						fee = trans_fee;
					}
				}
				if (trans_type == 1) {// 按照重量计算运费用
					if (CommUtil.mul(goods_weight, count) > CommUtil.null2Double(trans_weight)) {
						fee = trans_fee;
						float other_price = 0;
						if (trans_add_weight > 0) {
							other_price = trans_add_fee
									* Math.round(Math.ceil(CommUtil.subtract(
											CommUtil.mul(goods_weight, count), trans_weight)
											/ trans_add_weight));
						}
						fee = fee + other_price;
					} else {
						fee = trans_fee;
					}
				}
				if (trans_type == 2) {// 按照体积计算运费用
					if (CommUtil.mul(goods_volume, count) > CommUtil.null2Double(trans_weight)) {
						fee = trans_fee;
						float other_price = 0;
						if (trans_add_weight > 0) {
							other_price = trans_add_fee
									* Math.round(Math.ceil(CommUtil.subtract(
											CommUtil.mul(goods_volume, count), trans_weight)
											/ trans_add_weight));
						}
						fee = fee + other_price;
					} else {
						fee = trans_fee;
					}
				}

			}
		}
		return fee;
	}

	/**
	 * 查询当前快递是否为商家常用物流
	 * 
	 * @param id
	 *            快递id
	 * @return 是否为常用物流公司
	 */
	public int query_common_ec(String id, String storeId) {
		int ret = 0;
		if (CommUtil.null2Long(id) > 0 && CommUtil.null2Long(storeId) > 0) {
			List<EcCommonBO> eccs = this.expressCompanyCommonService.selectAllByCondition(0,
					CommUtil.null2Long(storeId));
			// Map params = new HashMap();
			// User user =
			// this.userService.getObjById(SecurityUserHolder.getCurrentUser().getId());
			// user = user.getParent() == null ? user : user.getParent();
			// Store store = user.getStore();
			// List<ExpressCompanyCommon> eccs = new
			// ArrayList<ExpressCompanyCommon>();
			// if (store != null) {
			// params.put("ecc_type", 0);
			// params.put("ecc_store_id", store.getId());
			// eccs = this.expressCompanyCommonService.query(
			// "select obj from ExpressCompanyCommon obj where obj.ecc_type=:ecc_type and obj.ecc_store_id=:ecc_store_id",
			// params, -1, -1);
			for (EcCommonBO ecc : eccs) {
				if (ecc.getEccEcId().equals(CommUtil.null2Long(id))) {
					ret = 1;
				}
			}
		} else {
			// params.put("ecc_type", 1);
			// eccs = this.expressCompanyCommonService
			// .query("select obj from ExpressCompanyCommon obj where obj.ecc_type=:ecc_type",
			// params, -1, -1);
			List<EcCommonBO> eccs = this.expressCompanyCommonService.selectAllByEccType(1);
			for (EcCommonBO ecc : eccs) {
				if (ecc.getEccEcId().equals(CommUtil.null2Long(id))) {
					ret = 1;
				}
			}
			// }
		}
		return ret;
	}

	/**
	 * 为自营查询当前快递是否为商家常用物流
	 * 
	 * @param id
	 *            快递id
	 * @return 是否为常用物流公司
	 */
	public int query_common_ec_for_self(String id) {
		int ret = 0;
		if (!CommUtil.null2String(id).equals("")) {
			List<EcCommonBO> eccs = this.expressCompanyCommonService
					.selectAllByEccType(EcCommonConstants.ECC_TYPE_SELF);
			for (EcCommonBO ecc : eccs) {
				if (ecc.getEccEcId().equals(CommUtil.null2Long(id))) {
					ret = 1;
					break;
				}
			}
		}
		return ret;
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String s = "[{\"trans_weight\":1,\"trans_fee\":13.5,\"trans_add_weight\":1,\"trans_add_fee\":2},{\"city_id\":1,\"city_name\":\"沈阳\",\"trans_weight\":1,\"trans_fee\":13.5,\"trans_add_weight\":1,\"trans_add_fee\":2}]";
		List<Map> list = Json.fromJson(ArrayList.class, s);
		for (Map map : list) {
			System.out.println(map.get("city_id"));
		}
	}
}
