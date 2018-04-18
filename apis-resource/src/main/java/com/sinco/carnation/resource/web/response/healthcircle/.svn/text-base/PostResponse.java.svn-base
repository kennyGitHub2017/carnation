package com.sinco.carnation.resource.web.response.healthcircle;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.api.response.Utf8mb4ToJson;
import com.sinco.carnation.resource.bo.healthcircle.PostBO;
import com.sinco.carnation.resource.bo.healthcircle.UserBO;

public class PostResponse extends ApiResponse implements Utf8mb4ToJson {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("postList")
	@ReturnMapping(desc = "帖子列表")
	private List<PostBO> postList;

	/*@JsonProperty("evaluateList")
	@ReturnMapping(desc="评论列表")
	private List<PostEvaluateBO> evaluateList;*/

	@JsonProperty("totalCount")
	@ReturnMapping(desc = "总记录")
	private Long totalCount;

	@JsonProperty("post")
	@ReturnMapping(desc = "帖子对象")
	private PostBO post;

	@JsonProperty("userCustomer")
	@ReturnMapping(desc = "用户对象")
	private UserBO userBO;

	/*@JsonProperty("praiseList")
	@ReturnMapping(desc="点赞集合")
	private List<PostEvaluateBO> praiseList;*/

	@JsonProperty("islogin")
	@ReturnMapping(desc = "是否登录")
	private Integer islogin;
	
	@JsonProperty("praiseNum")
	@ReturnMapping(desc = "点赞数")
	private Integer praiseNum;

	/*public List<PostEvaluateBO> getPraiseList() {
		return praiseList;
	}

	public void setPraiseList(List<PostEvaluateBO> praiseList) {
		this.praiseList = praiseList;
	}*/

	public Integer getIslogin() {
		return islogin;
	}

	public void setIslogin(Integer islogin) {
		this.islogin = islogin;
	}

	public UserBO getUserBO() {
		return userBO;
	}

	public void setUserBO(UserBO userBO) {
		this.userBO = userBO;
	}

	/*public List<PostEvaluateBO> getEvaluateList() {
		return evaluateList;
	}

	public void setEvaluateList(List<PostEvaluateBO> evaluateList) {
		this.evaluateList = evaluateList;
	}*/

	public PostBO getPost() {
		return post;
	}

	public void setPost(PostBO post) {
		this.post = post;
	}

	public List<PostBO> getPostList() {
		return postList;
	}

	public void setPostList(List<PostBO> postList) {
		this.postList = postList;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getPraiseNum() {
		return praiseNum;
	}

	public void setPraiseNum(Integer praiseNum) {
		this.praiseNum = praiseNum;
	}

}
