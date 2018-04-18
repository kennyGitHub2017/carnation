package com.sinco.carnation.healthcircle.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sinco.carnation.healthcircle.bo.PostBO;
import com.sinco.carnation.healthcircle.dao.PostDao;
import com.sinco.carnation.healthcircle.dao.PostEvaluateDao;
import com.sinco.carnation.healthcircle.dao.PostPraiseDao;
import com.sinco.carnation.healthcircle.model.Post;
import com.sinco.carnation.healthcircle.model.PostEvaluate;
import com.sinco.carnation.healthcircle.model.PostPraise;
import com.sinco.carnation.healthcircle.vo.PostSelectVO;
import com.sinco.carnation.healthcircle.vo.PostVO;
import com.sinco.carnation.healthcircle.vo.SelectPriseCenterVO;
import com.sinco.carnation.label.dao.LabelCenterDao;
import com.sinco.carnation.label.dao.LabelDao;
import com.sinco.carnation.label.model.Label;
import com.sinco.carnation.sys.service.IntegralService;
import com.sinco.carnation.user.dao.UserCustomerDao;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.common.utils.StringUtils;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class PostService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private PostDao postDao;
	@Autowired
	private PostPraiseDao paPostPraiseDao;
	@Autowired
	private PostEvaluateDao postEvaluateDao;
	@Autowired
	private LabelDao labelDao;
	@Autowired
	private UserCustomerDao userCustomerDao;
	@Autowired
	private LabelCenterDao labelCenterDao;
	@Autowired
	private IntegralService integralService;

	/**
	 * 查询帖子列表
	 * 
	 * @return
	 */

	public List<Post> findPageByType(MyPage<Post> page, int postType, Long userId, Integer ispush) {
		PostVO vo = new PostVO();
		vo.setPostType(postType);
		vo.setIspush(ispush);
		// vo.setUserId(userId);
		List<Post> list = null;
		if (postType == 0) {
			list = postDao.findPageByVo(page, vo);
		} else {
			list = postDao.findHotPageByVo(page, vo);
		}

		list = ispraise(list, userId);
		return list;
	}

	/**
	 * 根据标签查询帖子列表
	 * 
	 * @param page
	 * @param labelId
	 * @param userId
	 * @param type
	 * @return
	 */
	public List<Post> findPageByLabel(MyPage<Post> page, String labelName, Long userId, Integer type) {
		SelectPriseCenterVO vo = new SelectPriseCenterVO();
		// vo.setLabelId(labelId);
		vo.setLabelName(labelName);
		vo.setType(type);
		List<Post> list = postDao.findPageByLabel(page, vo);
		list = ispraise(list, userId);
		return list;
	}

	/**
	 * 根据帖子id查询详情，含点赞用户名详情
	 * 
	 * @param id
	 * @param userId
	 * @return
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	public Post selectById(Long id, Long userId) {
		Post post = postDao.selectById(id);
		List<String> praiselist = paPostPraiseDao.selectUsernameByPostId(id);// 点赞会员头像路径集合
		if (post != null && null != praiselist && praiselist.size() > 0) {
			post.setPraiseList(praiselist);
		}
		List<Post> list = new ArrayList();
		if (post != null) {
			list.add(post);
			list = ispraise(list, userId);
			post = list.get(0);
		}
		return post;
	}

	public int updatePraiseNum(PostPraise vo) {
		PostPraise pa = paPostPraiseDao.selectByVo(vo);
		if (pa != null) {
			return 400;
		}
		// 更新点赞次数
		postDao.updatePraiseNum(vo.getPostId());
		// 增加点赞记录
		paPostPraiseDao.saveByVo(vo);
		return 100;
	}

	public int updatePostEvaluete(PostEvaluate vo) {
		// 新增评论记录
		/*List<UserCustomer> customer = userCustomerDao.searchCustomer(vo.getToUserid());
		// 设置用户昵称
		if (null != customer && customer.size() > 0) {
			vo.setToUserName(customer.get(0).getNickname());
		}*/

		List<UserCustomer> customer_ = userCustomerDao.searchCustomer(vo.getFromUserid());
		// 设置用户昵称
		if (null != customer_ && customer_.size() > 0) {
			vo.setFromUserName(customer_.get(0).getNickname());
		}
		postEvaluateDao.save(vo);
		// 更新评论数
		// 获取评论前三条记录
		JSONArray jsonArray = new JSONArray();
		List<PostEvaluate> postEvaluates = postDao.getTopThirdEvaluate(vo.getPostId());
		if (postEvaluates != null && postEvaluates.size() > 0) {
			for (PostEvaluate postEvaluate : postEvaluates) {
				JSONObject json = new JSONObject();
				json.put("content", postEvaluate.getContent());
				json.put("fromUserName", postEvaluate.getFromUserName());
				jsonArray.add(json);
			}
		}
		postDao.updateEvalueteNum(vo.getPostId(), jsonArray.toJSONString());
		return 100;
	}

	/**
	 * 发帖
	 * 
	 * @param userId
	 * @param content
	 * @param labelId
	 * @param location
	 * @param title
	 * @param images
	 * @return
	 */
	@SuppressWarnings("unused")
	public Post addPost(Long userId, String content, String labelIds, String location, String thumbnail,
			String labelName) {
		Post post = new Post();
		List<UserCustomer> customer = userCustomerDao.searchCustomer(userId);
		// 设置用户昵称
		if (null != customer && customer.size() > 0) {
			post.setNickname(customer.get(0).getNickname());
		}
		post.setContent(content);// 帖子内容
		post.setLocation(location);// 帖子位置信息
		post.setUserId(userId);
		post.setEvaluateNum(0);
		post.setPostType(0);
		post.setReadNum(0);
		post.setPraiseNum(0);
		post.setDeleteStatus(0);
		post.setThumbnail(thumbnail);
		post.setLabelIds(labelIds);
		postDao.insert(post);// 保存帖子
		// 切割标签ids进行标签与帖子关联
		String valus = null;
		this.insertList(labelIds, post.getId());
		return post;
	}

	/**
	 * 保存帖子表中间关系,批量插入
	 * 
	 * @param label
	 * @return
	 */
	public void insertList(String labelIds, Long postId) {
		String valus = null;
		if (StringUtils.isNotEmpty(labelIds) && postId != null) {
			String[] Ids = labelIds.split("\\|");// labelid集合
			if (ArrayUtils.isNotEmpty(Ids)) {
				for (int i = 0; i < Ids.length; i++) {
					if (i == 0) {
						valus = "(" + "id," + Ids[i] + ',' + 1 + ',' + postId + ",now()" + ")";
					} else {
						valus = valus + "," + "(" + "id," + Ids[i] + ',' + 1 + ',' + postId + ",now()" + ")";
					}
				}
			}
			valus = "INSERT INTO label_center(id,label_id,type,data_id,add_time) VALUES" + valus;
			labelCenterDao.batchInsert(valus);
		}

	}

	public Long addLabel(Label label) {
		labelDao.save(label);
		return label.getId();
	}

	public List<Post> findPageByUserId(MyPage<Post> page, Long userId) {
		PostVO vo = new PostVO();
		vo.setUserId(userId);
		List<Post> list = postDao.findPageByVo(page, vo);
		list = ispraise(list, userId);
		return list;
	}

	public List<Post> findPageByUserId(MyPage<Post> page, Long userId, Long currentUserId) {
		PostVO vo = new PostVO();
		vo.setUserId(userId);
		List<Post> list = postDao.findPageByVo(page, vo);
		list = ispraise(list, currentUserId);
		return list;
	}

	public int cancleUsersPraise(PostPraise vo) {
		PostPraise pa = paPostPraiseDao.selectByVo(vo);
		if (pa == null) {
			return 400;
		}
		// 更新点赞次数
		postDao.updateDecPraiseNum(vo.getPostId());
		// 删除点赞记录
		paPostPraiseDao.deleteByVo(vo);
		return 100;
	}

	/**
	 * 判断是否当前用户是否点赞过
	 * 
	 * @param list
	 * @param userId
	 * @return
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	public List<Post> ispraise(List<Post> list, Long userId) {
		Map map = new HashMap();
		if (null != userId) {
			List<PostPraise> praiselist = paPostPraiseDao.selectByUserId(userId);
			for (PostPraise postPraise : praiselist) {
				if (map.containsKey(postPraise.getPostId()) == false) {
					map.put(postPraise.getPostId(), userId);
				}
			}
			for (Post post : list) {
				if (map.get(post.getId()) == userId) {
					post.setIspraise(1);
				} else {
					post.setIspraise(0);
				}
			}
		} else {
			for (Post post : list) {
				post.setIspraise(0);
			}
		}
		return list;
	}

	/**
	 * 
	 * @param eval
	 * @return
	 */
	public int updateReplyEvaluete(PostEvaluate eval) {
		// 新增评论记录
		if (eval.getToUserid() != null) {
			List<UserCustomer> customer = userCustomerDao.searchCustomer(eval.getToUserid());
			// 设置用户昵称
			if (null != customer && customer.size() > 0) {
				eval.setToUserName(customer.get(0).getNickname());
			}
		}
		if (eval.getFromUserid() != null) {
			List<UserCustomer> customer_ = userCustomerDao.searchCustomer(eval.getFromUserid());
			// 设置用户昵称
			if (null != customer_ && customer_.size() > 0) {
				eval.setFromUserName(customer_.get(0).getNickname());
			}
		}
		postEvaluateDao.save(eval);
		return 100;
	}

	public List<PostBO> findByPage(MyPage<PostBO> page, PostSelectVO vo) {
		return postDao.findByPage(page, vo);
	}

	public void ispush(String id, String ispush) {
		Post post = new Post();
		post.setId(Long.valueOf(id));
		post.setIspush(Integer.valueOf(ispush));
		postDao.update(post);

	}

	public void batchDelete(List<Long> idList) {
		this.postDao.deleteByIds(idList);

	}

	public Post getObjById(long parseLong) {
		// TODO Auto-generated method stub
		Post post = postDao.get(parseLong);
		if (post != null) {
			return post;
		}
		return null;
	}

	public void deleteByUIdPId(Long userId, Long postId) {
		this.postDao.deleteByUIdPId(userId, postId);
	}

	public Post findById(Long id) {
		Post post = postDao.selectById(id);
		return post;
	}

	/**
	 * 发帖时间限制
	 * 
	 * @throws ParseException
	 */
	@SuppressWarnings("static-access")
	public int limitAddPost(Long userId) {
		int s = postDao.selectCurrentNumber(userId);
		if (s == 0) {// 当天未发
			return 100;
		} else {
			Post post = postDao.selectLatelyPost(userId);// 最近发帖时间查询
			if (post == null) {
				return 100;
			}
			try {
				int re = 0;
				if (1 <= s && s <= 2) {// 发第二条与第三条间隔一分钟
					re = this.compareTime(post.getAddTime(), 1);
					if (re == 3) {
						return 101;// 提示太频繁，请稍后再试
					}
				} else if (s == 3) {// 第四条发间隔3分钟
					re = this.compareTime(post.getAddTime(), 3);
					if (re == 3) {
						return 102;// 提示太频繁，请3分钟后再试
					}
				} else if (s > 3) {// 从第四条开始间隔时间为5min
					re = this.compareTime(post.getAddTime(), 5);
					if (re == 3) {
						return 103;// 提示太频繁，请5分钟后再试
					}
				}
			} catch (ParseException e) {
				logger.info("发帖时间格式错误");
			}
			return 100;
		}
	}

	public static int compareTime(Date date1, int s) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar afterTime = Calendar.getInstance();
		afterTime.add(Calendar.MINUTE, -s); // 当前分钟-s
		Date date2 = (Date) afterTime.getTime();
		Date dt1 = df.parse(df.format(date1));
		Date dt2 = df.parse(df.format(date2));
		if (dt1.getTime() > dt2.getTime()) {
			return 3; // date1时间在date2后面
		} else if (dt1.getTime() < dt2.getTime()) {
			return 2;// date1时间在date2前面
		} else {
			return 1;// date1=date2
		}
	}

	/** 查询未加分记录 **/
	public List<Post> listByisAddIntegral() {
		return postDao.listByisAddIntegral();
	}

	/** 更新加分状态 **/
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int updateIsAddIntegralByid(@Param("id") Long id) {
		return postDao.updateIsAddIntegralByid(id);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void addIntegralByid(Long id, Long uid, String type, Date time) {
		try {
			// 变状态
			if (this.updateIsAddIntegralByid(id) > 0) {
				// 加积分
				integralService.addIntegral(type, uid, null, null, null, null, time);
			}
		} catch (Exception e) {
			logger.error("[circlePostAddIntegral] error , uid = " + uid);
			logger.error("[circlePostAddIntegral] error , e=" + e);
		}
	}

	/** 查询未加分记录 **/
	public List<PostPraise> listPraiseByisAddIntegral() {
		return paPostPraiseDao.listByisAddIntegral();
	}

	/** 更新加分状态 **/
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int updatePraiseIsAddIntegralByid(Long id) {
		return paPostPraiseDao.updateIsAddIntegralByid(id);
	}

	/** 点赞加积分 **/
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void addPraiseIntegralByid(Long id, Long uid, String type, Date time, Long postId, String typeB) {
		try {
			if (this.updatePraiseIsAddIntegralByid(id) > 0) {
				// 加积分
				integralService.addIntegral(type, uid, null, null, null, null, time);
				Post post = this.findById(postId);
				if (post != null && post.getUid() != null) {
					// 被点赞加积分
					integralService.addIntegral(typeB, post.getUserId(), null, null, null, null, time);
				}
			}
		} catch (Exception e) {
			logger.error("[addPraiseIntegralByid] errot uid = " + uid + e);
		}

	}

}
