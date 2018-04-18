package com.sinco.carnation.resource.vo.favorites;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class ConsultingVO extends BasicParamVO {
	@Param(desc = "咨询提问id；修改问题时使用")
	private Long id;

	/** 专家用户id **/
	@Param(desc = "专家用户id")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long expertsUserId;

	/** 提问标题 **/
	@Param(desc = "提问标题")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private String title;

	/** 提问图片 **/
	@Param(desc = "提问图片,多图片用｜连接")
	private String images;

	/** 提问内容 **/
	@Param(desc = "提问内容")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getExpertsUserId() {
		return expertsUserId;
	}

	public void setExpertsUserId(Long expertsUserId) {
		this.expertsUserId = expertsUserId;
	}
}
