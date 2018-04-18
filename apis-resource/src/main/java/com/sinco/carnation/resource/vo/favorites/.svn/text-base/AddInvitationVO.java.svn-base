package com.sinco.carnation.resource.vo.favorites;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class AddInvitationVO extends BasicParamVO {

	@Param(desc = "圈子id|必须")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long circleId;

	@Param(desc = "帖子标题|必须")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String title;

	@Param(desc = "帖子内容|必须")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String context;

	@Param(desc = "图片")
	private String images;

	public Long getCircleId() {
		return circleId;
	}

	public void setCircleId(Long circleId) {
		this.circleId = circleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

}
