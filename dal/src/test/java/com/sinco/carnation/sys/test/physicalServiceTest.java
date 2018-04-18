package com.sinco.carnation.sys.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.sinco.carnation.sys.bo.SysKeyWordMapBO;
import com.sinco.carnation.sys.dao.SysKeyWordMapDao;
import com.sinco.carnation.user.bo.PhysicalSuggestBO;
import com.sinco.carnation.user.dao.PhysicalSuggestDao;
import com.sinco.carnation.user.vo.PhysicalSuggestVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class physicalServiceTest {

	@Autowired
	private PhysicalSuggestDao physicalSuggestDao;

	@Autowired
	private SysKeyWordMapDao sysKeyWordMapDao;

	@SuppressWarnings("unused")
	@Test
	/**
	 * 3.改善建议(体检类型id和枚举类结果id)
	 */
	public void queryPhysicalSuggestByCond() {

		// Assert.assertEquals(1, result);
		PhysicalSuggestVO suggestVO = new PhysicalSuggestVO();
		suggestVO.setIsEnabled(1);// 开启
		suggestVO.setDeleteStatus((byte) 0);// 正常数据
		suggestVO.setPhysicalTypeId(8l);// 体检项目类型
		suggestVO.setResultType(1);// 结果值id
		// List<PhysicalSuggestBO> listBO = physicalSuggestDao.queryPhysicalSuggestByCond(suggestVO);

		List<PhysicalSuggestBO> list = physicalSuggestDao.queryPhysicalSuggestByCond(suggestVO);
		Map<Integer, List<PhysicalSuggestBO>> map = new HashMap<Integer, List<PhysicalSuggestBO>>();
		List<PhysicalSuggestBO> dietList = new ArrayList<PhysicalSuggestBO>();
		List<PhysicalSuggestBO> exeList = new ArrayList<PhysicalSuggestBO>();
		List<PhysicalSuggestBO> liftList = new ArrayList<PhysicalSuggestBO>();
		List<PhysicalSuggestBO> machList = new ArrayList<PhysicalSuggestBO>();
		List<PhysicalSuggestBO> othersList = new ArrayList<PhysicalSuggestBO>();

		for (PhysicalSuggestBO suggestBO : list) {
			if (suggestBO != null) {
				if (suggestBO.getSuggestType() == 1) {
					dietList.add(suggestBO);
				} else if (suggestBO.getSuggestType() == 2) {
					exeList.add(suggestBO);
				} else if (suggestBO.getSuggestType() == 3) {
					liftList.add(suggestBO);
				} else if (suggestBO.getSuggestType() == 4) {
					machList.add(suggestBO);
				} else if (suggestBO.getSuggestType() == 5) {
					othersList.add(suggestBO);
				}
			}
		}
		map.put(1, dietList);
		map.put(2, exeList);
		map.put(3, liftList);
		map.put(4, machList);
		map.put(5, othersList);

		// map;
		List<Long> idsList = new ArrayList<Long>();
		for (List<PhysicalSuggestBO> list1 : map.values()) {
			// 遍历该list的值
			for (PhysicalSuggestBO bo : list1) {
				if (bo != null) {
					idsList.add(bo.getId());
				}
			}

		}
		long suggestTypeCode = 1l; // 建议类型

		List<SysKeyWordMapBO> keyList = sysKeyWordMapDao.findListByCond4Recommed(idsList, 3, suggestTypeCode);

		Assert.notNull(map);
		// physicalService.queryPhysicalSuggestByCond(suggestVO);
	}

}