package vc.thinker.b2b2c.utils;

import java.util.ArrayList;
import java.util.List;

import com.sinco.carnation.user.bo.RebateRecordBO;

import vc.thinker.b2b2c.core.tools.CommUtil;

public class RebateUtil {
	// 分润类型
	@SuppressWarnings("unused")
	private static final String[][] arraysold = { {"101", "会员消费返润"}, {"102", "注册会员分润"}, {"103", "会员管理返润"},
			{"104", "注册店返润"}, {"105", "终端管理返润"}, {"106", "注册关联返润"}, {"107", "区级管理返润"}, {"108", "市级管理返润"},
			{"109", "注册店返润"}, {"110", "终端服务返润"}, {"111", "区级服务返润"}, {"112", "市级服务返润"}, {"201", "终端手续费返润"},
			{"202", "区级手续费返润"}, {"203", "市级手续费返润"}, {"204", "推荐人手续费返润"}};
	private static final String[][] arrays = { {"304", "注册会员分润"}, {"305", "分享注册分润1"}, {"306", "分享注册分润2"},
			{"307", "商户注册分润"}, {"308", "签约商户管理分润"}, {"309", "推荐签约管理分润1"}, {"310", "推荐签约管理分润2"},
			{"312", "签约商户服务分润 "}, {"313", "推荐签约服务分润1"}, {"314", "推荐签约服务分润2"}, {"315", "区级服务分润 "},
			{"316", "推荐辖区服务分润"}, {"317", "市级服务分润"}, {"318", "推荐辖区服务分润"}, {"319", "区级管理分润 "},
			{"320", "推荐辖区管理分润"}, {"321", "市级管理分润"}, {"322", "推荐辖区管理分润"}, {"325", "上传产品分润"},
			{"326", "推荐上传分润1"}, {"327", "推荐上传分润2"}, {"328", "运营注册会员分润"}, {"329", "推荐运营注册分润1"},
			{"330", "推荐运营注册分润2"}, {"331", "云购币专区订单分润"}};
	// 注册会员分润 "304";
	// 分享注册分润1 "305";
	// 分享注册分润2 "306";
	// 商户注册分润 "307";
	// 签约商户管理分润 "308";
	// 推荐签约管理分润1 "309";
	// 推荐签约管理分润2 "310";
	// 签约商户服务分润 "312";
	// 推荐签约服务分润1 "313";
	// 推荐签约服务分润2 "314";
	// 区级服务分润 "315";
	// 推荐辖区服务分润 "316";
	// 市级服务分润 "317";
	// 推荐辖区服务分润 "318";
	// 区级管理分润 "319";
	// 推荐辖区管理分润 "320";
	// 市级管理分润 "321";
	// 推荐辖区管理分润 "322";
	// 上传产品分润 "325";
	// 推荐上传分润1 "326";
	// 推荐上传分润2 "327";
	// 运营注册会员分润 "328";
	// 推荐运营注册分润1 "329";
	// 推荐运营注册分润2 "330";
	// 云购币专区订单分润 "331";

	private static final List<RebateRecordBO> list = new ArrayList<RebateRecordBO>();

	public static List<RebateRecordBO> getRebateTypeList() {
		if (list != null && list.size() == 25) {
			return list;
		} else {
			for (int i = 0; i < arrays.length; i++) {
				RebateRecordBO rabate = new RebateRecordBO();
				rabate.setId(CommUtil.null2Long(arrays[i][0]));
				rabate.setRebateType(arrays[i][1]);
				list.add(rabate);
			}
		}
		return list;

	}
}
