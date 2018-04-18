package com.sinco.carnation.circle.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.sns.bo.FoodCaloriesBO;
import com.sinco.carnation.sns.bo.FoodClassBO;
import com.sinco.carnation.sns.dao.CircleInvitationDao;
import com.sinco.carnation.sns.dao.FoodCaloriesDao;
import com.sinco.carnation.sns.dao.FoodClassDao;
import com.sinco.carnation.sns.model.Circle;
import com.sinco.carnation.sns.model.CircleInvitation;
import com.sinco.carnation.sns.vo.CircleInvitationVO;
import com.sinco.carnation.sys.dao.SysKeyWordMapDao;
import com.sinco.carnation.sys.enums.EmSysKeyWordMapType;
import com.sinco.carnation.sys.model.SysKeyWordMap;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class InvitationServiceImpl {

	@Autowired
	private CircleInvitationDao invitationDao;
	@Autowired
	private FoodClassDao foodDao;
	@Autowired
	private FoodCaloriesDao foodCaloriesDao;
	@Autowired
	private CircleServiceImpl circleService;
	@Autowired
	private SysKeyWordMapDao sysKeyWordMapDao;

	public boolean save(CircleInvitation invitation) {
		/**
		 * init other field here
		 */
		try {

			this.invitationDao.save(invitation);
			/** 添加关键字,先删除，再添加 lkn **/
			this.sysKeyWordMapDao.deleteByTypeIdAdTypeCode(invitation.getId(), new Long(
					EmSysKeyWordMapType.SnsCircleType.getValue()));
			SysKeyWordMap km = new SysKeyWordMap();
			String[] arrayList = invitation.getKeyWordIdStr().split(",");
			for (int i = 0; i < arrayList.length; i++) {
				km.setKeyWordId(Long.parseLong(arrayList[i].trim()));
				km.setTypeId(invitation.getId());
				km.setTypeCode(new Long(EmSysKeyWordMapType.SnsCircleType.getValue()));
				this.sysKeyWordMapDao.insertKeyWordMap(km);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public CircleInvitation getObjById(Long id) {
		CircleInvitation invitation = this.invitationDao.get(id);
		if (invitation != null) {
			return invitation;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.invitationDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> invitationIds) {
		for (Serializable id : invitationIds) {
			delete((Long) id);
		}
		return true;
	}

	public void selectPageByVO(CircleInvitationVO vo, MyPage<CircleInvitation> page) {
		List<CircleInvitation> listResult = invitationDao.selectPageByVO(vo, page);
		page.setContent(listResult);
	}

	public void selectPageByOfficVO(CircleInvitationVO vo, MyPage<CircleInvitation> page) {
		List<CircleInvitation> listResult = invitationDao.selectPageByOfficVO(vo, page);
		page.setContent(listResult);
	}

	public boolean update(CircleInvitation invitation) {
		try {
			this.invitationDao.update(invitation);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void queryFoodList(Integer parentId, MyPage<FoodClassBO> page) {
		page.setContent(foodDao.queryFoodList(parentId, page));
	}

	public List<FoodCaloriesBO> queryFoodCaloriesById(Long classId) {
		return foodCaloriesDao.queryFoodCaloriesById(classId);
	}

	/**
	 * 删除帖子并更新圈子的邀请数量
	 * 
	 * @param ids
	 *            帖子ID
	 * @param cid
	 *            圈子ID
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	public void batchDeleteAndUpdate(List ids, String cid) {
		batchDelete(ids);
		Circle obj = this.circleService.getObjById(CommUtil.null2Long(cid));
		obj.setInvitationCount(obj.getInvitationCount() - ids.size());
		this.circleService.update(obj);
	}
}
