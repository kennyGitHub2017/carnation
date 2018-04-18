package com.sinco.carnation.resource.bo.healthcircle;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

/**
 * 健康管理/健康圈 返回数据
 * 
 * @author yuleijia
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "HealthCircleBo", desc = "健康管理/健康圈")
public class HealthCircleBo {

	@JsonProperty("postList")
	@FieldMapping(desc = "帖子列表")
	private List<PostBO> postList;

	@JsonProperty("evaluateList")
	@FieldMapping(desc = "评论列表")
	private List<PostEvaluateBO> evaluateList;

	@JsonProperty("totalCount")
	@FieldMapping(desc = "总记录")
	private Long totalCount;

	@JsonProperty("post")
	@FieldMapping(desc = "帖子对象")
	private PostBO post;

	@JsonProperty("userCustomer")
	@FieldMapping(desc = "用户对象")
	private UserBO userBO;

	@JsonProperty("praiseList")
	@FieldMapping(desc = "点赞集合")
	private List<PostEvaluateBO> praiseList;

	@JsonProperty("islogin")
	@FieldMapping(desc = "是否登录")
	private Integer islogin;

	@JsonProperty("result")
	@FieldMapping(desc = "返回结果码")
	private Integer result;

	@JsonProperty("content")
	@FieldMapping(desc = "返回结果内容")
	private String content;

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<PostBO> getPostList() {
		return postList;
	}

	public void setPostList(List<PostBO> postList) {
		this.postList = postList;
	}

	public List<PostEvaluateBO> getEvaluateList() {
		return evaluateList;
	}

	public void setEvaluateList(List<PostEvaluateBO> evaluateList) {
		this.evaluateList = evaluateList;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public PostBO getPost() {
		return post;
	}

	public void setPost(PostBO post) {
		this.post = post;
	}

	public UserBO getUserBO() {
		return userBO;
	}

	public void setUserBO(UserBO userBO) {
		this.userBO = userBO;
	}

	public List<PostEvaluateBO> getPraiseList() {
		return praiseList;
	}

	public void setPraiseList(List<PostEvaluateBO> praiseList) {
		this.praiseList = praiseList;
	}

	public Integer getIslogin() {
		return islogin;
	}

	public void setIslogin(Integer islogin) {
		this.islogin = islogin;
	}

	public static final int result_succ = 200;

	public static final int result_succ_empty = 210;

	public static final int result_fail = 400;

	public static final int result_error = 500;

	public static final String content_empty = "当前对象未空";

}
