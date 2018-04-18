package com.sinco.carnation.store.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.o2o.bo.StoreGroupAdjustBO;
import com.sinco.carnation.o2o.dao.StoreGroupAdjustDao;
import com.sinco.carnation.o2o.model.StoreGroupAdjust;
import com.sinco.carnation.o2o.vo.StoreGroupAdjustVO;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.dao.StoreDao;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class StoreGroupAdjustService {

	@Autowired
	private StoreGroupAdjustDao storeGroupAdjustDao;
	@Autowired
	private StoreDao storeDao;

	public boolean save(StoreGroupAdjust storeGroupAdjust) {
		/**
		 * init other field here
		 */
		try {
			this.storeGroupAdjustDao.save(storeGroupAdjust);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public StoreGroupAdjust getObjById(Long id) {
		StoreGroupAdjust storeGroupAdjust = this.storeGroupAdjustDao.get(id);
		if (storeGroupAdjust != null) {
			return storeGroupAdjust;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.storeGroupAdjustDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> storeGroupAdjust) {
		// TODO Auto-generated method stub
		for (Serializable id : storeGroupAdjust) {
			delete((Long) id);
		}
		return true;
	}

	public boolean update(StoreGroupAdjust storeGroupAdjust) {
		try {
			this.storeGroupAdjustDao.update(storeGroupAdjust);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void findPageByVO(MyPage<StoreGroupAdjustBO> page, StoreGroupAdjustVO vo) {
		this.storeGroupAdjustDao.findPageByVo(vo, page);
	}

	public List<StoreGroupAdjust> findListByVo(StoreGroupAdjustVO vo) {
		return storeGroupAdjustDao.findListByVo(vo);
	}

	public void deletes(List<StoreGroupAdjust> infos) {
		for (StoreGroupAdjust info : infos) {
			this.delete(info.getId());
		}
	}

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public void merchantAdjustInfoAudit(StoreGroupAdjust storeGroupAdjust, String type) throws Exception {
		if ("succeed".equals(type)) {
			StoreBO store = this.storeDao.findObjById(storeGroupAdjust.getStoreId());
			store.setGroupMainId(storeGroupAdjust.getAdjustGcMainId());
			store.setGroupDetailInfo(this.getStoreGC_detail_info(storeGroupAdjust.getAdjustGcInfo()));
			this.storeDao.update(store);
			this.storeGroupAdjustDao.delete(storeGroupAdjust.getId());
		}
		if ("defeat".equals(type)) {
			storeGroupAdjust.setApplyStatus(5);
			this.storeGroupAdjustDao.update(storeGroupAdjust);
		}
	}

	/**
	 * 由调整申请中的类目信息，得到商户详细经营类目信息
	 * 
	 * @param adjust_gc_info
	 * @return
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	private String getStoreGC_detail_info(String adjust_gc_info) {
		Map fromMap = Json.fromJson(HashMap.class, adjust_gc_info);
		if (fromMap == null) {
			return null;
		}
		String detailInfo = StringUtils.EMPTY;
		Iterator<Map> it = fromMap.values().iterator();
		while (it.hasNext()) {
			Map map = it.next();
			if (map.containsKey("gc_id") && StringUtils.isNotEmpty(String.valueOf(map.get("gc_id")))) {
				detailInfo += "," + String.valueOf(map.get("gc_id"));
			}
			if (StringUtils.isNotEmpty(detailInfo) && detailInfo.startsWith(",")) {
				detailInfo = detailInfo.substring(1);
			}
		}
		return detailInfo;

	}
}
