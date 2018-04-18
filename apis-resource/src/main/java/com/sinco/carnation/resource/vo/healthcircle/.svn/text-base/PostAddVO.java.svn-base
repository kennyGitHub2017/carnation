package com.sinco.carnation.resource.vo.healthcircle;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class PostAddVO extends BasicParamVO {
	@Param(desc = "发帖人id|添加不用传")
	private Long userId;

	@Param(desc = "发帖人位置信息")
	private String location;

	@Param(desc = "帖子内容|必须")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String content;

	@Param(desc = "用户自定义标签labelName")
	private String labelName;

	@Param(desc = "缩略图片地址")
	private String thumbnail;

	@Param(desc = "标签labelIds集合字符串")
	private String labelIds;

	public String getLabelIds() {
		return labelIds;
	}

	public void setLabelIds(String labelIds) {
		this.labelIds = labelIds;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}