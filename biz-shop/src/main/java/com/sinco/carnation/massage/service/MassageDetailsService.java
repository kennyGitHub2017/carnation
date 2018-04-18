package com.sinco.carnation.massage.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.massage.dao.MassageDetailsDao;
import com.sinco.carnation.massage.model.Massage;
import com.sinco.carnation.massage.model.MassageDetails;

@Service
@Transactional(rollbackFor = {ServiceException.class})
public class MassageDetailsService {
	@Autowired
	private MassageDetailsDao massageDetailsDao;

	@Autowired
	private MassageService massageService;

	/**
	 * 上传按摩详细数据
	 */
	public MassageDetails uploadMassageDetails(Integer time, Long userId) {
		// 根据用户ID获取按摩详细数据
		MassageDetails queryResult = getByUserId(userId);
		MassageDetails massageDetails = new MassageDetails();
		if (null == queryResult) {// 该用户未绑定数据则添加一条按摩详细数据
			// 封装参数
			massageDetails.setUserId(userId);
			massageDetails.setDate(CommUtil.convertDateToString(new Date()));
			massageDetails.setTime(time);
			massageDetails.setCreateTime(new Date());
			massageDetails.setLastUpdateTime(new Date());
			// 保存按摩数据
			save(massageDetails);
		} else {// 已存在则更新当前数据
			massageDetails = queryResult;
			// 累加当日按摩分钟数
			Integer newTime = massageDetails.getTime() + time;
			massageDetails.setTime(newTime);
			massageDetails.setLastUpdateTime(new Date());
			// 更新按摩数据
			update(massageDetails);
		}
		Massage massage = new Massage();
		massage.setAllTime(time);
		massageService.uploadMassage(massage, userId);
		return massageDetails;
	}

	/**
	 * 根据主键ID查询按摩详细信息
	 * 
	 * @param id
	 *            主键ID
	 * @return
	 */
	public MassageDetails getById(Long id) {
		return massageDetailsDao.getById(id);
	}

	/**
	 * 根据用户ID查询当天按摩详细信息
	 * 
	 * @param id
	 *            主键ID
	 * @return
	 */
	public MassageDetails getByUserId(Long userId) {
		return massageDetailsDao.getByUserId(userId);
	}

	/**
	 * 更新按摩详细信息
	 * 
	 * @param order
	 */
	public void update(MassageDetails massageDetails) {
		massageDetailsDao.update(massageDetails);
	}

	/**
	 * 添加按摩详细信息
	 * 
	 * @param order
	 */
	public void save(MassageDetails massageDetails) {
		massageDetailsDao.save(massageDetails);
	}
}
