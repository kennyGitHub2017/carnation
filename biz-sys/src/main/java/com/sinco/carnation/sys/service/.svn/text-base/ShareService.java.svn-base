package com.sinco.carnation.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.sys.bo.ShareBO;
import com.sinco.carnation.sys.dao.ShareDao;
import com.sinco.carnation.sys.model.Share;
import com.sinco.carnation.sys.vo.ShareVO;

@Service
@Transactional(rollbackFor = ServiceException.class)
public class ShareService {

	@Autowired
	private ShareDao shareDao;

	public ShareBO findOne(Long id) {
		ShareBO result = shareDao.findOne(id);
		return result == null ? new ShareBO() : result;
	}

	public void save(Share record) throws ServiceException {
		if (null == record) {
			throw new ServiceException("信息不能为空");
		}
		if(null == record.getMark()){
			throw new ServiceException("标识不能为空");
		}
		if (shareDao.save(record) < 1) {
			throw new ServiceException("保存失败");
		}
	}

	public List<ShareBO> listByVO(ShareVO vo) {
		List<ShareBO> list = shareDao.listByVO(vo);
		return list == null ? new ArrayList<ShareBO>() : list;
	}
	
	public ShareBO findOneByGoodsId(Long goodsId) {
		return this.shareDao.findOneByGoodsId(goodsId);
	}
	
	public ShareBO getByShareIdMark(String mark , Long shareId){
		ShareBO result = new ShareBO();
		ShareVO vo = new ShareVO();
		vo.setMark(mark);
		vo.setShareId(shareId);
		List<ShareBO> list = listByVO(vo);
		if (list.size() > 0)
			result = list.get(0);
		return result;
	}
}
