//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.09 at 10:10:23 AM CST 
//

package com.sinco.carnation.elong.model.elong;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for EnumCurrencyCode.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="EnumCurrencyCode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="RMB"/>
 *     &lt;enumeration value="USD"/>
 *     &lt;enumeration value="HKD"/>
 *     &lt;enumeration value="MOP"/>
 *     &lt;enumeration value="SGD"/>
 *     &lt;enumeration value="TWD"/>
 *     &lt;enumeration value="AFA"/>
 *     &lt;enumeration value="ALL"/>
 *     &lt;enumeration value="ARP"/>
 *     &lt;enumeration value="ATS"/>
 *     &lt;enumeration value="AUD"/>
 *     &lt;enumeration value="BBD"/>
 *     &lt;enumeration value="BEF"/>
 *     &lt;enumeration value="BGL"/>
 *     &lt;enumeration value="BHD"/>
 *     &lt;enumeration value="BIF"/>
 *     &lt;enumeration value="BOP"/>
 *     &lt;enumeration value="BRC"/>
 *     &lt;enumeration value="BSD"/>
 *     &lt;enumeration value="BUK"/>
 *     &lt;enumeration value="CAD"/>
 *     &lt;enumeration value="CHF"/>
 *     &lt;enumeration value="CLP"/>
 *     &lt;enumeration value="CNY"/>
 *     &lt;enumeration value="COP"/>
 *     &lt;enumeration value="CRC"/>
 *     &lt;enumeration value="CSK"/>
 *     &lt;enumeration value="CUP"/>
 *     &lt;enumeration value="CYP"/>
 *     &lt;enumeration value="DEM"/>
 *     &lt;enumeration value="DJF"/>
 *     &lt;enumeration value="DKK"/>
 *     &lt;enumeration value="DOP"/>
 *     &lt;enumeration value="DZD"/>
 *     &lt;enumeration value="ECS"/>
 *     &lt;enumeration value="EGP"/>
 *     &lt;enumeration value="ESP"/>
 *     &lt;enumeration value="EUR"/>
 *     &lt;enumeration value="FIM"/>
 *     &lt;enumeration value="FJD"/>
 *     &lt;enumeration value="FRF"/>
 *     &lt;enumeration value="GBP"/>
 *     &lt;enumeration value="GHC"/>
 *     &lt;enumeration value="GMD"/>
 *     &lt;enumeration value="GNS"/>
 *     &lt;enumeration value="GQE"/>
 *     &lt;enumeration value="GRD"/>
 *     &lt;enumeration value="GTQ"/>
 *     &lt;enumeration value="GWP"/>
 *     &lt;enumeration value="GYD"/>
 *     &lt;enumeration value="HNL"/>
 *     &lt;enumeration value="HTG"/>
 *     &lt;enumeration value="HUF"/>
 *     &lt;enumeration value="IDR"/>
 *     &lt;enumeration value="IEP"/>
 *     &lt;enumeration value="INR"/>
 *     &lt;enumeration value="IQD"/>
 *     &lt;enumeration value="IRR"/>
 *     &lt;enumeration value="ISK"/>
 *     &lt;enumeration value="ITL"/>
 *     &lt;enumeration value="JMD"/>
 *     &lt;enumeration value="JOD"/>
 *     &lt;enumeration value="JPY"/>
 *     &lt;enumeration value="KES"/>
 *     &lt;enumeration value="KHR"/>
 *     &lt;enumeration value="KMF"/>
 *     &lt;enumeration value="KPW"/>
 *     &lt;enumeration value="KWD"/>
 *     &lt;enumeration value="LAK"/>
 *     &lt;enumeration value="LBP"/>
 *     &lt;enumeration value="LKR"/>
 *     &lt;enumeration value="LRD"/>
 *     &lt;enumeration value="LUF"/>
 *     &lt;enumeration value="LYD"/>
 *     &lt;enumeration value="MAD"/>
 *     &lt;enumeration value="MCF"/>
 *     &lt;enumeration value="MRO"/>
 *     &lt;enumeration value="MTP"/>
 *     &lt;enumeration value="MUR"/>
 *     &lt;enumeration value="MVR"/>
 *     &lt;enumeration value="MXP"/>
 *     &lt;enumeration value="MYR"/>
 *     &lt;enumeration value="NGN"/>
 *     &lt;enumeration value="NIC"/>
 *     &lt;enumeration value="NLG"/>
 *     &lt;enumeration value="NOK"/>
 *     &lt;enumeration value="NPR"/>
 *     &lt;enumeration value="NTD"/>
 *     &lt;enumeration value="NZD"/>
 *     &lt;enumeration value="OMR"/>
 *     &lt;enumeration value="PAB"/>
 *     &lt;enumeration value="PES"/>
 *     &lt;enumeration value="PHP"/>
 *     &lt;enumeration value="PLZ"/>
 *     &lt;enumeration value="PRK"/>
 *     &lt;enumeration value="PTE"/>
 *     &lt;enumeration value="PYG"/>
 *     &lt;enumeration value="QAR"/>
 *     &lt;enumeration value="ROL"/>
 *     &lt;enumeration value="RWF"/>
 *     &lt;enumeration value="SAR"/>
 *     &lt;enumeration value="SBD"/>
 *     &lt;enumeration value="SCR"/>
 *     &lt;enumeration value="SDP"/>
 *     &lt;enumeration value="SEK"/>
 *     &lt;enumeration value="SLL"/>
 *     &lt;enumeration value="SOS"/>
 *     &lt;enumeration value="SRG"/>
 *     &lt;enumeration value="SUR"/>
 *     &lt;enumeration value="SVC"/>
 *     &lt;enumeration value="SYP"/>
 *     &lt;enumeration value="THB"/>
 *     &lt;enumeration value="TND"/>
 *     &lt;enumeration value="TRL"/>
 *     &lt;enumeration value="TTD"/>
 *     &lt;enumeration value="TZS"/>
 *     &lt;enumeration value="UGS"/>
 *     &lt;enumeration value="UYP"/>
 *     &lt;enumeration value="VEB"/>
 *     &lt;enumeration value="VND"/>
 *     &lt;enumeration value="XAF"/>
 *     &lt;enumeration value="XOF"/>
 *     &lt;enumeration value="YDD"/>
 *     &lt;enumeration value="YER"/>
 *     &lt;enumeration value="YUD"/>
 *     &lt;enumeration value="ZAR"/>
 *     &lt;enumeration value="ZMK"/>
 *     &lt;enumeration value="ZRZ"/>
 *     &lt;enumeration value="ZWD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EnumCurrencyCode")
@XmlEnum
public enum EnumCurrencyCode {

	RMB, USD, HKD, MOP, SGD, TWD, AFA, ALL, ARP, ATS, AUD, BBD, BEF, BGL, BHD, BIF, BOP, BRC, BSD, BUK, CAD, CHF, CLP, CNY, COP, CRC, CSK, CUP, CYP, DEM, DJF, DKK, DOP, DZD, ECS, EGP, ESP, EUR, FIM, FJD, FRF, GBP, GHC, GMD, GNS, GQE, GRD, GTQ, GWP, GYD, HNL, HTG, HUF, IDR, IEP, INR, IQD, IRR, ISK, ITL, JMD, JOD, JPY, KES, KHR, KMF, KPW, KWD, LAK, LBP, LKR, LRD, LUF, LYD, MAD, MCF, MRO, MTP, MUR, MVR, MXP, MYR, NGN, NIC, NLG, NOK, NPR, NTD, NZD, OMR, PAB, PES, PHP, PLZ, PRK, PTE, PYG, QAR, ROL, RWF, SAR, SBD, SCR, SDP, SEK, SLL, SOS, SRG, SUR, SVC, SYP, THB, TND, TRL, TTD, TZS, UGS, UYP, VEB, VND, XAF, XOF, YDD, YER, YUD, ZAR, ZMK, ZRZ, ZWD;

	public String value() {
		return name();
	}

	public static EnumCurrencyCode fromValue(String v) {
		return valueOf(v);
	}

	private static final Map<String, String> mapInfo = new HashMap<String, String>();

	public String getDescription() {
		return getCurrencyString(this.value());
	}

	/**
	 * 注意：其他货币标示符合代理商可自行添加
	 */
	static {
		mapInfo.put("RMB", "￥");
		mapInfo.put("HKD", "$");
		mapInfo.put("USD", "$");
	}

	/**
	 * 
	 * 获取货币符号
	 * 
	 * @param key
	 * @return
	 */
	public static String getCurrencyString(String key) {
		return mapInfo.containsKey(key) ? mapInfo.get(key) : "--";
	}

}
