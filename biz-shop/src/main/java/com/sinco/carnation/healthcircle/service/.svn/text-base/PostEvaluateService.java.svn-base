package com.sinco.carnation.healthcircle.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.DateFormatUtil;

import com.sinco.carnation.healthcircle.dao.PostEvaluateDao;
import com.sinco.carnation.healthcircle.model.Post;
import com.sinco.carnation.healthcircle.model.PostEvaluate;
import com.sinco.carnation.sys.service.IntegralService;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class PostEvaluateService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private PostEvaluateDao postEvaluateDao;
	@Autowired
	private PostService postService;
	@Autowired
	private IntegralService integralService;
	/**
	 * 拆分集合成评论与回复的关系
	 * 
	 * @param list
	 * @return
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	public List<PostEvaluate> getList(List<PostEvaluate> list) {
		List<PostEvaluate> flist = new ArrayList();// 存放type=0
		Map<Long, PostEvaluate> map = new HashMap();// 存放tpye=1
		for (PostEvaluate eval : list) {
			if (eval.getType() != null && eval.getType() == 0) {
				flist.add(eval);
			} else {
				map.put(eval.getId(), eval);
			}
		}
		for (PostEvaluate evaluate : flist) {
			Iterator it = map.keySet().iterator();
			while (it.hasNext()) {
				Long i = (Long) it.next();
				PostEvaluate eval = map.get(i);
				if (eval != null && eval.getPid() != null
						&& eval.getPid().longValue() == evaluate.getId().longValue()) {
					evaluate.getReplyList().add(eval);
				}
			}
		}
		return flist;
	}

	public List<PostEvaluate> selectPageByPostId(MyPage<PostEvaluate> page, Long postId) {
		List<PostEvaluate> list = postEvaluateDao.selectPageByPostId(page, postId);
		SimpleDateFormat todayDf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (PostEvaluate evs : list) {
			evs.setAddtiemFormat(DateFormatUtil.formatDisplayTime(todayDf.format(evs.getAddTime()),
					"yyyy-MM-dd HH:mm:ss"));
		}
		// 区分评论与回复
		list = getList(list);
		return list;
	}
	

	/** 查询未加分记录 **/
	public List<PostEvaluate> listByisAddIntegral(){
		return postEvaluateDao.listByisAddIntegral();
	}
	/** 更新加分状态 **/
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int updateIsAddIntegralByid(Long id){
		return postEvaluateDao.updateIsAddIntegralByid(id);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void addIntegralByid(Long id ,Long uid , String type ,Date time ,Long postId ,String typeB){
		try {
			//变状态
			if(this.updateIsAddIntegralByid(id)>0){
				//评论加积分
				integralService.addIntegral(type, uid, null, null, null, null);
				if (null != postId) {
					Post post = postService.findById(postId);
					if (post != null && post.getUid() != null)
						//被评论加积分
						integralService.addIntegral(typeB, post.getUserId(), null, null, null, null);
				}
			}
		} catch (Exception e) {
			logger.error("[healthCircleEvaluateAddIntegral] error , uid = "+ uid);
			logger.error("[healthCircleEvaluateAddIntegral] error"+e);
		}
	}
}
