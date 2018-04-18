package com.sinco.carnation.sys.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class AreaAd extends BaseModel {

	private static final long serialVersionUID = 2267114614266501322L;

	/**  **/
    private Long id;

    /** 专区名称 **/
    private String name;

    /** 专区代码 **/
    private String code;

    /** 专区样式 **/
    private String style;

    /** 排序 **/
    private Integer orders;

    /** 位置0PC, 1APP **/
    private Integer pos;

    /** 0启用1禁用 **/
    private Integer disabled;

    /** 创建人 **/
    private Long createBy;

    /** 创建时间 **/
    private Date createTime;

    /** 修改人 **/
    private Long modifyBy;

    /** 修改时间 **/
    private Date modifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }

    public Integer getDisabled() {
        return disabled;
    }

    public void setDisabled(Integer disabled) {
        this.disabled = disabled;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(Long modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}