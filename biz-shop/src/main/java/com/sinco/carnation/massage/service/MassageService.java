package com.sinco.carnation.massage.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.massage.dao.MassageDao;
import com.sinco.carnation.massage.model.Massage;

@Service
@Transactional(rollbackFor = {ServiceException.class})
public class MassageService {
	@Autowired
	private MassageDao massageDao;

	/**
	 * 上传按摩数据
	 */
	public Massage uploadMassage(Massage massage, Long userId) {
		
		// 根据用户ID获取按摩数据
		Massage queryResult = getByUserId(userId);
		Massage result = new Massage();
		if (null == queryResult) {// 该用户未绑定数据则添加一条按摩数据
			// 封装参数
			result.setUserId(userId);
			result.setAdviceTime(massage.getAdviceTime());
			result.setAllTime(massage.getAllTime());
			result.setCreateTime(new Date());
			result.setLastUpdateTime(new Date());
			// 保存按摩数据
			save(result);

		} else {// 已存在则更新当前数据
			result = queryResult;
			if (CommUtil.isNotNull(massage.getAdviceTime())) {
				result.setAdviceTime(massage.getAdviceTime());
			}
			if (CommUtil.isNotNull(massage.getAllTime())) {
				// 计算总按摩时间
				Integer allTime = result.getAllTime() + massage.getAllTime();
				result.setAllTime(allTime);
			}
			result.setLastUpdateTime(new Date());
			// 更新按摩数据
			update(result);
		}
		return result;
	}

	/**
	 * 根据主键ID查询按摩信息
	 * 
	 * @param id
	 *            主键ID
	 * @return
	 */
	public Massage getById(Long id) {
		return massageDao.getById(id);
	}

	/**
	 * 根据用户ID查询按摩信息
	 * 
	 * @param id
	 *            主键ID
	 * @return
	 */
	public Massage getByUserId(Long userId) {
		return massageDao.getByUserId(userId);
	}

	/**
	 * 更新按摩信息
	 * 
	 * @param order
	 */
	public void update(Massage massage) {
		massageDao.update(massage);
	}

	/**
	 * 添加按摩信息
	 * 
	 * @param order
	 */
	public void save(Massage massage) {
		massageDao.save(massage);
	}
}
