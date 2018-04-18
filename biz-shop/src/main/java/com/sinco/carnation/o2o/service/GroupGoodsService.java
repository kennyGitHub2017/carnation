package com.sinco.carnation.o2o.service;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.o2o.bo.GroupAccessoryBO;
import com.sinco.carnation.o2o.bo.GroupClassBO;
import com.sinco.carnation.o2o.bo.GroupGoodsBO;
import com.sinco.carnation.o2o.bo.GroupOrderBO;
import com.sinco.carnation.o2o.constants.GroupGoodsConstants;
import com.sinco.carnation.o2o.dao.GroupAccessoryDao;
import com.sinco.carnation.o2o.dao.GroupGoodsDao;
import com.sinco.carnation.o2o.dao.GroupOrderDao;
import com.sinco.carnation.o2o.model.GroupAccessory;
import com.sinco.carnation.o2o.model.GroupClass;
import com.sinco.carnation.o2o.model.GroupGoods;
import com.sinco.carnation.o2o.vo.GroupGoodsListShowVO;
import com.sinco.carnation.o2o.vo.GroupGoodsVO;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.dao.StoreDao;
import com.sinco.carnation.sys.dao.AccessoryDao;
import com.sinco.carnation.sys.model.Accessory;
import com.sinco.carnation.user.bo.AlbumBO;
import com.sinco.carnation.user.dao.AlbumDao;
import com.sinco.carnation.user.model.Album;
import com.sinco.dal.common.MyPage;
import com.sinco.dic.client.DicContent;
import com.sinco.dic.client.model.DicParentBase;

import vc.thinker.b2b2c.core.tools.CommUtil;

@Service
@Transactional
public class GroupGoodsService {

	@Autowired
	private GroupGoodsDao groupGoodsDao;
	@Autowired
	private DicContent dicContent;
	@Autowired
	private StoreDao storeDao;
	@Autowired
	private AlbumDao albumDao;
	@Autowired
	private GroupAccessoryDao groupAccessoryDao;
	@Autowired
	private AccessoryDao accessoryDao;
	@Autowired
	private GroupOrderDao groupOrderDao;
	@Autowired
	private GroupOrderService groupOrderService;
	/**
	 * 查找服务列表
	 * 
	 * @param vo
	 * @return
	 */
	public List<GroupGoodsBO> findListShow(GroupGoodsListShowVO vo) {
		return groupGoodsDao.findListShow(vo);
	}

	/**
	 * 查找服务列表
	 * 
	 * @param vo
	 * @return
	 */
	public List<GroupGoodsBO> findListPageShow(GroupGoodsListShowVO vo, MyPage<GroupGoodsBO> page) {
		return groupGoodsDao.findListPageShow(vo, page);
	}

	/**
	 * 后端查找服务列表
	 * 
	 * @param page
	 * @param vo
	 * @return
	 */
	public List<GroupGoodsBO> findListByVO(MyPage<GroupGoodsBO> page, GroupGoodsVO vo) {
		return groupGoodsDao.findListByVO(page, vo);
	}

	public List<GroupGoodsBO> findOperatorGoodsListByVO(MyPage<GroupGoodsBO> page, GroupGoodsVO vo) {
		return groupGoodsDao.findOperatorGoodsListByVO(page, vo);
	}

	public GroupGoodsBO findOperatorGoodsById(Long goodsId, Long operatorId) {
		return groupGoodsDao.findOperatorGoodsById(goodsId, operatorId);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean save(GroupGoodsBO groupGoods, Long userId) {
		this.groupGoodsDao.save(groupGoods);

		if (StringUtils.isNotBlank(groupGoods.getImagePaths())) {
			String[] imgArray = groupGoods.getImagePaths().split("\\|");
			if (imgArray.length > 0) {
				Album album = null;
				List<AlbumBO> albumList = this.albumDao.getDefaultAlbum(userId);
				if (CollectionUtils.isNotEmpty(albumList)) {
					album = albumList.get(0);
				} else {
					album = new Album();
					album.setAddTime(new Date());
					album.setAlbumName("默认相册");
					album.setAlbumSequence(-10000);
					album.setAlbumDefault(true);
					album.setUserId(userId);
					this.albumDao.save(album);
				}

				groupAccessoryDao.deleteByGroupGoodsId(groupGoods.getId());
				for (int i = 0; i < imgArray.length; i++) {
					if (StringUtils.isNotBlank(imgArray[i])) {
						List<Accessory> listAcc = accessoryDao.findByPath(imgArray[i]);
						Accessory accessory = new Accessory();
						if (CollectionUtils.isNotEmpty(listAcc)) {
							accessory = listAcc.get(0);
						} else {
							accessory.setAlbumId(album.getId());
							accessory.setPath(imgArray[i]);
							accessory.setAddTime(new Date());
							accessory.setUserId(userId);
							accessoryDao.save(accessory);
						}
						try {
							GroupAccessory groupAccessory = new GroupAccessory();
							groupAccessory.setGroupGoodsId(groupGoods.getId());
							groupAccessory.setAccessoryId(accessory.getId());
							groupAccessoryDao.save(groupAccessory);
						} catch (Exception e) {
							// log.info("保存唯一键冲突，不做处理", e.getMessage());
							e.printStackTrace();
						}
					}
				}
			}
		}

		return true;
	}

	public GroupGoodsBO getObjById(Long id) {
		return this.groupGoodsDao.get(id);
	}

	public boolean delete(Long id) {
		this.groupGoodsDao.remove(id);
		return true;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean batchDelete(List<Serializable> groupGoodsIds) {
		// TODO Auto-generated method stub
		for (Serializable id : groupGoodsIds) {
			delete((Long) id);
		}
		return true;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean update(GroupGoods groupGoods) {
		this.groupGoodsDao.update(groupGoods);
		return true;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean update(List<GroupGoods> list) {
		if (null != list && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				this.groupGoodsDao.update(list.get(i));
			}
		}
		return true;
	}

	public Map<Integer, Integer> findCountByStoreId(Long storeId) {
		Map<Integer, Integer> resultMap = new HashMap<>();
		List<Map<String, Integer>> list = groupGoodsDao.findCountByStoreId(storeId);
		if (CollectionUtils.isNotEmpty(list)) {
			for (Map<String, Integer> map : list) {
				if (map.get("ggStatus").equals(GroupGoodsConstants.GROUP_GOODS_STATUS_ILLEGAL_DOWN)) {
					resultMap.put(2, CommUtil.null2Int(map.get("count")));
				} else if (map.get("ggStatus").equals(GroupGoodsConstants.GROUP_GOODS_STATUS_STORE)) {
					resultMap.put(1, CommUtil.null2Int(map.get("count")));
				} else {
					resultMap
							.put(CommUtil.null2Int(map.get("ggStatus")), CommUtil.null2Int(map.get("count")));
				}
			}
		}
		return resultMap;
	}

	@SuppressWarnings("rawtypes")
	public String genericGoodsClassInfo(GroupClass gc) {
		String goods_class_info = gc.getGcName() + ">";
		if (gc.getParentId() != null) {
			DicParentBase dicClass = (DicParentBase) dicContent.getDic(GroupClassBO.class,
					String.valueOf(gc.getId()));
			GroupClassBO groupClassBO = (GroupClassBO) dicContent.getDic(GroupClassBO.class,
					dicClass.getParentCode());
			String class_info = genericGoodsClassInfo(groupClassBO);
			goods_class_info = class_info + goods_class_info;
		}
		return goods_class_info;
	}

	public void queryGroupGoodsPageList(Long uid, Integer goodsType, Integer ggStatus,
			MyPage<GroupGoodsBO> page) {
		StoreBO storeBO = storeDao.queryStoreInfo(uid,true, false);
		if (storeBO != null) {
			page.setContent(groupGoodsDao.queryGroupGoodsPageList(storeBO.getId(), goodsType, ggStatus, page));
		}
	}

	public GroupGoodsBO queryGroupGoodsById(Long goodsId) {
		return groupGoodsDao.queryGroupGoodsById(goodsId);
	}

	public GroupGoodsBO queryGroupDetails(String groupSn, Long sellerUid) {
		GroupGoodsBO groupGoods = groupGoodsDao.queryGroupDetails(groupSn, sellerUid);
		if(null == groupGoods){
			return groupGoods;
		}
		GroupOrderBO bo = groupOrderDao.queryGroupOrderId(Long.valueOf(groupGoods.getOrderId()));
		if(null == bo){
			return groupGoods;
		}
		if(groupOrderService.getOrderStatus(Long.valueOf(groupGoods.getOrderId()))==-1){
			groupGoods.setStatus(GroupGoodsConstants.GROUP_INFO_STATUS_OVERDUE);
		}
		return groupGoods;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public GroupGoods goodsShelves(GroupGoods record) {
		return groupGoodsDao.save(record);
	}

	/**
	 * 查询店铺下的券 by young
	 * 
	 * @param storeId
	 * @return
	 */
	public List<GroupGoodsBO> queryByStoreId(Long storeId, Integer goodsType, Integer ggStatus) {
		return groupGoodsDao.queryGroupGoodsPageList(storeId, goodsType, ggStatus, null);
	}

	public List<GroupGoodsBO> selectGoodsYourLike(Long goodsId, Integer start, Integer offset,
			Set<Long> goodsIds, Long areaId) {
		return groupGoodsDao.selectGoodsYourLike(goodsId, start, offset, goodsIds, areaId);
	}

	public List<GroupGoodsBO> findAllByStoreId(Long id) {
		return groupGoodsDao.findAllByStoreId(id);
	}

	/**
	 * 查询销量前10
	 * 
	 * @param storeId
	 * @return
	 */
	public List<GroupGoods> findTopByStoreId(Long storeId) {
		return groupGoodsDao.findTopByStoreId(storeId);
	}

	public List<GroupGoodsBO> queryGroupGoodsList(Integer goodType, Integer status, Long storeId) {
		return groupGoodsDao.queryGroupGoodsList(goodType, status, storeId);
	}

	public void queryRefundgoodsPageList(Long storeId, MyPage<GroupGoodsBO> page) {
		page.setContent(groupGoodsDao.queryRefundgoodsPageList(storeId, page));
	}

	/**
	 * 过期服务处理
	 */
	public boolean groupGoodsExpired() {
		// 过期服务
		List<GroupGoodsBO> ggs = this.groupGoodsDao.findExpiredGroupGoods();
		if (null != ggs && ggs.size() > 0) {
			for (GroupGoodsBO bo : ggs) {
				try {
					groupGoodsExpired(bo);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * 过期服务处理
	 */
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public void groupGoodsExpired(GroupGoodsBO bo) throws Exception {
		// 过期状态3
		bo.setGgStatus(3);
		groupGoodsDao.update(bo);
	}

	public GroupGoodsBO queryAwayStoreInfo(Long storeId) {
		return groupGoodsDao.queryAwayStoreInfo(storeId);
	}

	public void queryGroupGoodsFavaList(Long uid, MyPage<GroupGoodsBO> page) {
		page.setContent(groupGoodsDao.queryGroupGoodsFavaList(uid, page));
	}

	public boolean deleteGroupPhoto(Long imageId, Long groupGoodsId) {
		try {
			groupAccessoryDao.deleteByPrimaryKey(imageId, groupGoodsId);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public String getGroupAccessoryByGoodId(Long goodId) {
		StringBuilder builder = new StringBuilder();
		List<GroupAccessoryBO> accessoryList = groupAccessoryDao.findByGroupGoodsId(goodId);
		if (accessoryList != null && accessoryList.size() > 0) {
			for (GroupAccessoryBO accessory : accessoryList) {
				Accessory ory = accessoryDao.findOne(accessory.getAccessoryId());
				builder.append(ory.getPath()).append(";");
			}
			return builder.toString().substring(0, builder.toString().length() - 1);
		}
		return null;
	}

	public int findCountWarnGoods(Long storeId) {
		return groupGoodsDao.findCountWarnGoods(storeId);
	}
}
