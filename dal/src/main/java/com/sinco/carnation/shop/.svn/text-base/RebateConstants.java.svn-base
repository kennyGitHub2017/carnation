package com.sinco.carnation.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.sinco.carnation.user.model.RebateFeeRate;
import com.sinco.carnation.user.model.RebateRate;

public class RebateConstants {
	/**
	 * 消费返润类型说明: 101会员消费分润； 102注册会员分润； 103会员管理分润； 104注册店分润； 105终端管理分润； 106注册关联分润； 107区级管理分润； 108市级管理分润；
	 * 109注册店分润B； 110终端服务分润； 111区级服务分润； 112市级服务分润
	 */
	public final static String REBATE_TYPE_101 = "101";
	public final static String REBATE_TYPE_102 = "102";
	public final static String REBATE_TYPE_103 = "103";
	public final static String REBATE_TYPE_104 = "104";
	public final static String REBATE_TYPE_105 = "105";
	public final static String REBATE_TYPE_106 = "106";
	public final static String REBATE_TYPE_107 = "107";
	public final static String REBATE_TYPE_108 = "108";
	public final static String REBATE_TYPE_109 = "109";
	public final static String REBATE_TYPE_110 = "110";
	public final static String REBATE_TYPE_111 = "111";
	public final static String REBATE_TYPE_112 = "112";

	/** 201终端手续费分润；202区级手续费分润；203市级手续费分润；204推荐人手续费分润 */
	public final static String REBATE_TYPE_201 = "201";
	public final static String REBATE_TYPE_202 = "202";
	public final static String REBATE_TYPE_203 = "203";
	public final static String REBATE_TYPE_204 = "204";

	/** 301会员推荐返润；302店铺推荐返润 */
	public final static String REBATE_TYPE_301 = "301";
	public final static String REBATE_TYPE_302 = "302";

	/** 订单分润类型标识码 begin **/

	public final static String REBATE_MEMBER = "303";
	// 注册会员分润
	public final static String REBATE_MEMBER_FIRST = "304";
	// 分享注册分润1
	public final static String REBATE_MEMBER_SECOND = "305";
	// 分享注册分润2
	public final static String REBATE_MEMBER_THIRD = "306";

	// 商户注册分润
	public final static String REBATE_BINDING_SELLER = "307";
	// 签约商户管理分润
	public final static String REBATE_BINDING_SELLER_FIRST = "308";
	// 推荐签约管理分润1
	public final static String REBATE_BINDING_SELLER_SECOND = "309";
	// 推荐签约管理分润2
	public final static String REBATE_BINDING_SELLER_THIRD = "310";

	public final static String REBATE_SPENDING_SELLER = "311";
	// 签约商户服务分润
	public final static String REBATE_SPENDING_SELLER_FIRST = "312";
	// 推荐签约服务分润1
	public final static String REBATE_SPENDING_SELLER_SECOND = "313";
	// 推荐签约服务分润2
	public final static String REBATE_SPENDING_SELLER_THIRD = "314";

	// 区级服务分润
	public final static String REBATE_SPENDING_DISTRICT_OPERATOR = "315";
	// 推荐辖区服务分润
	public final static String REBATE_SPENDING_DISTRICT_OPERATOR_FIRST = "316";
	// 市级服务分润
	public final static String REBATE_SPENDING_CITY_OPERATOR = "317";
	// 推荐辖区服务分润
	public final static String REBATE_SPENDING_CITY_OPERATOR_FIRST = "318";

	// 区级管理分润
	public final static String REBATE_BINDING_DISTRICT_OPERATOR = "319";
	// 推荐辖区管理分润
	public final static String REBATE_BINDING_DISTRICT_OPERATOR_FIRST = "320";
	// 市级管理分润
	public final static String REBATE_BINDING_CITY_OPERATOR = "321";
	// 推荐辖区管理分润
	public final static String REBATE_BINDING_CITY_OPERATOR_FIRST = "322";

	public final static String REPEAT_REBATE = "323";

	public final static String REBATE_SUPPLIER = "324";
	// 上传产品分润
	public final static String REBATE_SUPPLIER_FIRST = "325";
	// 推荐上传分润1
	public final static String REBATE_SUPPLIER_SECOND = "326";
	// 推荐上传分润2
	public final static String REBATE_SUPPLIER_THIRD = "327";

	// 运营注册会员分润
	public final static String REBATE_MEMBER_RECOMMEND_CNOPERATOR_FIRST = "328";
	// 推荐运营注册分润1
	public final static String REBATE_MEMBER_RECOMMEND_CNOPERATOR_SECOND = "329";
	// 推荐运营注册分润2
	public final static String REBATE_MEMBER_RECOMMEND_CNOPERATOR_THIRD = "330";
	// 云购币专区订单分润
	public final static String REBATE_YUN_GOU_BI = "331";
	/** 订单分润类型标识码 end **/

	public final static String REBATE_STATUS_0 = "0";
	public final static String REBATE_STATUS_1 = "1";

	/** 返利利率方式 */
	public final static String RETATE_LOCAL = "LOCAL_SELL";
	public final static String RETATE_EXPORT = "EXPORT_SALES";

	public static Map<String, RebateRate> MAP_RATE;
	public final static String DEFAULT_RATE = "DEFAULT_RATE";
	public static Map<String, RebateFeeRate> MAP_FEE_RATE;

	public static String getRebateNameByType(String rebateType) {
		String rebateName = null;
		if (StringUtils.isNotEmpty(rebateType)) {
			switch (rebateType) {
			/**
			 * 消费返润类型说明: 101会员消费分润； 102注册会员分润； 103会员管理分润； 104注册店分润； 105终端管理分润； 106注册关联分润； 107区级管理分润；
			 * 108市级管理分润； 109注册店分润B； 110终端服务分润； 111区级服务分润； 112市级服务分润
			 */
			/** 201终端手续费分润；202区级手续费分润；203市级手续费分润；204推荐人手续费分润 */
				case REBATE_TYPE_101:
					rebateName = "会员消费分润";
					break;
				case REBATE_TYPE_102:
					rebateName = "注册会员分润";
					break;
				case REBATE_TYPE_103:
					rebateName = "会员管理分润";
					break;
				case REBATE_TYPE_104:
					rebateName = "注册店分润";
					break;
				case REBATE_TYPE_105:
					rebateName = "终端管理分润";
					break;
				case REBATE_TYPE_106:
					rebateName = "注册关联分润";
					break;
				case REBATE_TYPE_107:
					rebateName = "区级管理分润";
					break;
				case REBATE_TYPE_108:
					rebateName = "市级管理分润";
					break;
				case REBATE_TYPE_109:
					rebateName = "注册店分润B";
					break;
				case REBATE_TYPE_110:
					rebateName = "终端服务分润";
					break;
				case REBATE_TYPE_111:
					rebateName = "区级服务分润";
					break;
				case REBATE_TYPE_112:
					rebateName = "市级服务分润";
					break;
				case REBATE_TYPE_201:
					rebateName = "终端手续费分润";
					break;
				case REBATE_TYPE_202:
					rebateName = "区级手续费分润";
					break;
				case REBATE_TYPE_203:
					rebateName = "市级手续费分润";
					break;
				case REBATE_TYPE_204:
					rebateName = "推荐人手续费分润";
					break;
				case REBATE_TYPE_301:
					rebateName = "推荐购买分润";
					break;
				case REBATE_TYPE_302:
					rebateName = "推荐产品分润";
					break;

				case REBATE_MEMBER:
					rebateName = "会员订单分润";
					break;
				case REBATE_MEMBER_FIRST:
					rebateName = "注册会员分润";
					break;
				case REBATE_MEMBER_SECOND:
					rebateName = "分享注册分润1";
					break;
				case REBATE_MEMBER_THIRD:
					rebateName = "分享注册分润2";
					break;

				case REBATE_BINDING_SELLER:
					rebateName = "商户注册分润";
					break;
				case REBATE_BINDING_SELLER_FIRST:
					rebateName = "签约商户管理分润";
					break;
				case REBATE_BINDING_SELLER_SECOND:
					rebateName = "推荐签约管理分润1";
					break;
				case REBATE_BINDING_SELLER_THIRD:
					rebateName = "推荐签约管理分润2";
					break;

				case REBATE_SPENDING_SELLER:
					rebateName = "消费商家订单分润";
					break;
				case REBATE_SPENDING_SELLER_FIRST:
					rebateName = "签约商户服务分润";
					break;
				case REBATE_SPENDING_SELLER_SECOND:
					rebateName = "推荐签约服务分润1";
					break;
				case REBATE_SPENDING_SELLER_THIRD:
					rebateName = "推荐签约服务分润2";
					break;

				case REBATE_SPENDING_DISTRICT_OPERATOR:
					rebateName = "区级服务分润";
					break;
				case REBATE_SPENDING_DISTRICT_OPERATOR_FIRST:
					rebateName = "推荐辖区服务分润";
					break;
				case REBATE_SPENDING_CITY_OPERATOR:
					rebateName = "市级服务分润";
					break;
				case REBATE_SPENDING_CITY_OPERATOR_FIRST:
					rebateName = "推荐辖区服务分润";
					break;

				case REBATE_BINDING_DISTRICT_OPERATOR:
					rebateName = "区级管理分润";
					break;
				case REBATE_BINDING_DISTRICT_OPERATOR_FIRST:
					rebateName = "推荐辖区管理分润";
					break;
				case REBATE_BINDING_CITY_OPERATOR:
					rebateName = "市级管理分润";
					break;
				case REBATE_BINDING_CITY_OPERATOR_FIRST:
					rebateName = "推荐辖区管理分润";
					break;
				case REPEAT_REBATE:
					rebateName = "CN帐户购买，请登录结算系统查看分润.";
					break;
				case REBATE_SUPPLIER:
					rebateName = "供应商分润";
					break;
				case REBATE_SUPPLIER_FIRST:
					rebateName = "上传产品分润";
					break;
				case REBATE_SUPPLIER_SECOND:
					rebateName = "推荐上传分润1";
					break;
				case REBATE_SUPPLIER_THIRD:
					rebateName = "推荐上传分润2";
					break;

				case REBATE_MEMBER_RECOMMEND_CNOPERATOR_FIRST:
					rebateName = "运营注册会员分润";
					break;
				case REBATE_MEMBER_RECOMMEND_CNOPERATOR_SECOND:
					rebateName = "推荐运营注册分润1";
					break;
				case REBATE_MEMBER_RECOMMEND_CNOPERATOR_THIRD:
					rebateName = "推荐运营注册分润2";
					break;
				case REBATE_YUN_GOU_BI:
					rebateName = "云购币订单分润";
					break;
			}
		}
		return rebateName;
	}
	
	public static List<String> listRebateCode(){
		List<String> list = new ArrayList<>();
//		list.add(REBATE_TYPE_101);
//		list.add(REBATE_TYPE_102);
//		list.add(REBATE_TYPE_103);
//		list.add(REBATE_TYPE_104);
//		list.add(REBATE_TYPE_105);
//		list.add(REBATE_TYPE_106);
//		list.add(REBATE_TYPE_107);
//		list.add(REBATE_TYPE_108);
//		list.add(REBATE_TYPE_109);
//		list.add(REBATE_TYPE_110);
//		list.add(REBATE_TYPE_111);
//		list.add(REBATE_TYPE_112);
		/** 201终端手续费分润；202区级手续费分润；203市级手续费分润；204推荐人手续费分润 */
//		list.add(REBATE_TYPE_201);
//		list.add(REBATE_TYPE_202);
//		list.add(REBATE_TYPE_203);
//		list.add(REBATE_TYPE_204);

		/** 301会员推荐返润；302店铺推荐返润 */
//		list.add(REBATE_TYPE_301);
//		list.add(REBATE_TYPE_302);

		/** 订单分润类型标识码 begin **/
//		list.add(REBATE_MEMBER);
		list.add(REBATE_MEMBER_FIRST);
		list.add(REBATE_MEMBER_SECOND);
		list.add(REBATE_MEMBER_THIRD);

		// 商户注册分润
		list.add(REBATE_BINDING_SELLER);
		// 签约商户管理分润
		list.add(REBATE_BINDING_SELLER_FIRST);
		// 推荐签约管理分润1
		list.add(REBATE_BINDING_SELLER_SECOND);
		// 推荐签约管理分润2
		list.add(REBATE_BINDING_SELLER_THIRD);

		list.add(REBATE_SPENDING_SELLER);
		
		// 签约商户服务分润
		list.add(REBATE_SPENDING_SELLER_FIRST);
		// 推荐签约服务分润1
		list.add(REBATE_SPENDING_SELLER_SECOND);
		// 推荐签约服务分润2
		list.add(REBATE_SPENDING_SELLER_THIRD);

		// 区级服务分润
		list.add(REBATE_SPENDING_DISTRICT_OPERATOR);
		// 推荐辖区服务分润
		list.add(REBATE_SPENDING_DISTRICT_OPERATOR_FIRST);
		// 市级服务分润
		list.add(REBATE_SPENDING_CITY_OPERATOR);
		// 推荐辖区服务分润
		list.add(REBATE_SPENDING_CITY_OPERATOR_FIRST);

		// 区级管理分润
		list.add(REBATE_BINDING_DISTRICT_OPERATOR);
		// 推荐辖区管理分润
		list.add(REBATE_BINDING_DISTRICT_OPERATOR_FIRST);
		// 市级管理分润
		list.add(REBATE_BINDING_CITY_OPERATOR);
		// 推荐辖区管理分润
		list.add(REBATE_BINDING_CITY_OPERATOR_FIRST);

		list.add(REPEAT_REBATE);

		list.add(REBATE_SUPPLIER);
		// 上传产品分润
		list.add(REBATE_SUPPLIER_FIRST);
		// 推荐上传分润1
		list.add(REBATE_SUPPLIER_SECOND);
		// 推荐上传分润2
		list.add(REBATE_SUPPLIER_THIRD);

		// 运营注册会员分润
		list.add(REBATE_MEMBER_RECOMMEND_CNOPERATOR_FIRST);
		// 推荐运营注册分润1
		list.add(REBATE_MEMBER_RECOMMEND_CNOPERATOR_SECOND);
		// 推荐运营注册分润2
		list.add(REBATE_MEMBER_RECOMMEND_CNOPERATOR_THIRD);
		// 云购币专区订单分润
		list.add(REBATE_YUN_GOU_BI);
		
		return list;
	}
}
