package com.sinco.carnation.juanpi.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class JuanpiGoodsClass extends BaseModel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**  **/
    private Long id;

    /** 分类新增时间 **/
    private Date addTime;

    /** 分类更新时间 **/
    private Date updateTime;

    /** 删除状态1是0否 **/
    private Integer deleteStatus;

    /** 卷皮一级分类名称 **/
    private String cateName;

    /** 卷皮一级分类ID **/
    private Long cateId;

    /** 卷皮二级分类名称 **/
    private String cate2Name;

    /** 卷皮二级分类ID **/
    private Long cate2Id;

    /** 卷皮三级分类名称 **/
    private String cate3Name;

    /** 卷皮三级分类ID **/
    private Long cate3Id;

    /** 是否关联云尚分类1是0否 **/
    private Integer isJoin;

    /** 云尚一级分类ID **/
    private Long classId;

    /** 云尚一级分类名称 **/
    private String className;

    /** 云尚二级分类ID **/
    private Long class2Id;

    /** 云尚二级分类名称 **/
    private String class2Name;

    /** 云尚三级分类ID **/
    private Long class3Id;

    /** 云尚三级分类名称 **/
    private String class3Name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public Long getCateId() {
        return cateId;
    }

    public void setCateId(Long cateId) {
        this.cateId = cateId;
    }

    public String getCate2Name() {
        return cate2Name;
    }

    public void setCate2Name(String cate2Name) {
        this.cate2Name = cate2Name;
    }

    public Long getCate2Id() {
        return cate2Id;
    }

    public void setCate2Id(Long cate2Id) {
        this.cate2Id = cate2Id;
    }

    public String getCate3Name() {
        return cate3Name;
    }

    public void setCate3Name(String cate3Name) {
        this.cate3Name = cate3Name;
    }

    public Long getCate3Id() {
        return cate3Id;
    }

    public void setCate3Id(Long cate3Id) {
        this.cate3Id = cate3Id;
    }

    public Integer getIsJoin() {
        return isJoin;
    }

    public void setIsJoin(Integer isJoin) {
        this.isJoin = isJoin;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Long getClass2Id() {
        return class2Id;
    }

    public void setClass2Id(Long class2Id) {
        this.class2Id = class2Id;
    }

    public String getClass2Name() {
        return class2Name;
    }

    public void setClass2Name(String class2Name) {
        this.class2Name = class2Name;
    }

    public Long getClass3Id() {
        return class3Id;
    }

    public void setClass3Id(Long class3Id) {
        this.class3Id = class3Id;
    }

    public String getClass3Name() {
        return class3Name;
    }

    public void setClass3Name(String class3Name) {
        this.class3Name = class3Name;
    }
}