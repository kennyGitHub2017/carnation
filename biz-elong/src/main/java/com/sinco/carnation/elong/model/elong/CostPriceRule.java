//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.09 at 10:10:23 AM CST 
//


package com.sinco.carnation.elong.model.elong;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.alibaba.fastjson.annotation.JSONField;


/**
 * <p>Java class for CostPriceRule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CostPriceRule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BeginDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Enable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HotelId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IncrementId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="OperateIp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OperateTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Operater" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RatePlanId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RoomTypeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RuleId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="CalculationType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="SettlementType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Source" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CostPriceRule", propOrder = {
    "beginDate",
    "enable",
    "endDate",
    "hotelId",
    "incrementId",
    "operateIp",
    "operateTime",
    "operater",
    "ratePlanId",
    "roomTypeId",
    "ruleId",
    "calculationType",
    "value",
    "settlementType",
    "source"
})
public class CostPriceRule {

    @JSONField(name = "BeginDate")
    protected String beginDate;
    @JSONField(name = "Enable")
    protected boolean enable;
    @JSONField(name = "EndDate")
    protected String endDate;
    @JSONField(name = "HotelId")
    protected String hotelId;
    @JSONField(name = "IncrementId")
    protected long incrementId;
    @JSONField(name = "OperateIp")
    protected String operateIp;
    @JSONField(name = "OperateTime")
    protected String operateTime;
    @JSONField(name = "Operater")
    protected String operater;
    @JSONField(name = "RatePlanId")
    protected long ratePlanId;
    @JSONField(name = "RoomTypeId")
    protected String roomTypeId;
    @JSONField(name = "RuleId")
    protected long ruleId;
    @JSONField(name = "CalculationType")
    protected int calculationType;
    @JSONField(name = "Value")
    protected float value;
    @JSONField(name = "SettlementType")
    protected int settlementType;
    @JSONField(name = "Source")
    protected int source;

    /**
     * Gets the value of the beginDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeginDate() {
        return beginDate;
    }

    /**
     * Sets the value of the beginDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeginDate(String value) {
        this.beginDate = value;
    }

    /**
     * Gets the value of the enable property.
     * 
     */
    public boolean isEnable() {
        return enable;
    }

    /**
     * Sets the value of the enable property.
     * 
     */
    public void setEnable(boolean value) {
        this.enable = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDate(String value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the hotelId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelId() {
        return hotelId;
    }

    /**
     * Sets the value of the hotelId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelId(String value) {
        this.hotelId = value;
    }

    /**
     * Gets the value of the incrementId property.
     * 
     */
    public long getIncrementId() {
        return incrementId;
    }

    /**
     * Sets the value of the incrementId property.
     * 
     */
    public void setIncrementId(long value) {
        this.incrementId = value;
    }

    /**
     * Gets the value of the operateIp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperateIp() {
        return operateIp;
    }

    /**
     * Sets the value of the operateIp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperateIp(String value) {
        this.operateIp = value;
    }

    /**
     * Gets the value of the operateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperateTime() {
        return operateTime;
    }

    /**
     * Sets the value of the operateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperateTime(String value) {
        this.operateTime = value;
    }

    /**
     * Gets the value of the operater property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperater() {
        return operater;
    }

    /**
     * Sets the value of the operater property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperater(String value) {
        this.operater = value;
    }

    /**
     * Gets the value of the ratePlanId property.
     * 
     */
    public long getRatePlanId() {
        return ratePlanId;
    }

    /**
     * Sets the value of the ratePlanId property.
     * 
     */
    public void setRatePlanId(long value) {
        this.ratePlanId = value;
    }

    /**
     * Gets the value of the roomTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomTypeId() {
        return roomTypeId;
    }

    /**
     * Sets the value of the roomTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomTypeId(String value) {
        this.roomTypeId = value;
    }

    /**
     * Gets the value of the ruleId property.
     * 
     */
    public long getRuleId() {
        return ruleId;
    }

    /**
     * Sets the value of the ruleId property.
     * 
     */
    public void setRuleId(long value) {
        this.ruleId = value;
    }

    /**
     * Gets the value of the calculationType property.
     * 
     */
    public int getCalculationType() {
        return calculationType;
    }

    /**
     * Sets the value of the calculationType property.
     * 
     */
    public void setCalculationType(int value) {
        this.calculationType = value;
    }

    /**
     * Gets the value of the value property.
     * 
     */
    public float getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     */
    public void setValue(float value) {
        this.value = value;
    }

    /**
     * Gets the value of the settlementType property.
     * 
     */
    public int getSettlementType() {
        return settlementType;
    }

    /**
     * Sets the value of the settlementType property.
     * 
     */
    public void setSettlementType(int value) {
        this.settlementType = value;
    }

    /**
     * Gets the value of the source property.
     * 
     */
    public int getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     */
    public void setSource(int value) {
        this.source = value;
    }

}
