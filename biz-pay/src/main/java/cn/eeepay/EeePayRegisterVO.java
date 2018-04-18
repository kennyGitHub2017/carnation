package cn.eeepay;

import java.util.List;

/**
 * 第三方刷卡的注册返回结果
 * 
 * @author james
 * 
 */
public class EeePayRegisterVO {

	/**
	 * 费率值为数字(暂定0.5-2之前)
	 */
	private float ratioValue;

	/**
	 * 代理商编号
	 */
	private String agentNo;

	/**
	 * 进件方式 1客户端进件
	 */
	private String addType = "1";
	/**
	 * 客户端类型： 100120传统POS 6移联商通, 24超级刷
	 */
	private String appType;
	/**
	 * 商户名称
	 */
	private String name;
	private String mobile;
	private String password;
	/**
	 * 机具号
	 */
	private String sn;
	/**
	 * 机具类型 2传统POS, 4移联商通, 5超级刷
	 */
	private String posType;
	/**
	 * 身份证
	 */
	private String idCardNo;

	/**
	 * 银行名称
	 */
	private String bankName;
	/**
	 * 银行卡开户名
	 */
	private String accountName;
	/**
	 * 银行卡账号
	 */
	private String accountNo;
	/**
	 * 开户行的省
	 */
	private String accountProvince;
	/**
	 * 开户行的市
	 */
	private String accountCity;
	/**
	 * 联行行号
	 */
	private String cnapsNo;
	/**
	 * 密保问题
	 */
	private String querstion;
	/**
	 * 密码保答案
	 */
	private String answer;
	/**
	 * 经营地址所在省
	 */
	private String province;
	/**
	 * 经营地址所在市
	 */
	private String city;
	/**
	 * 经营地址详情
	 */
	private String address;

	private List<String> files;

	public String getAgentNo() {
		return agentNo;
	}

	public void setAgentNo(String agentNo) {
		this.agentNo = agentNo;
	}

	public float getRatioValue() {
		return ratioValue;
	}

	public void setRatioValue(float ratioValue) {
		this.ratioValue = ratioValue;
	}

	public List<String> getFiles() {
		return files;
	}

	public void setFiles(List<String> files) {
		this.files = files;
	}

	public String getAddType() {
		return addType;
	}

	public void setAddType(String addType) {
		this.addType = addType;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getPosType() {
		return posType;
	}

	public void setPosType(String posType) {
		this.posType = posType;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountProvince() {
		return accountProvince;
	}

	public void setAccountProvince(String accountProvince) {
		this.accountProvince = accountProvince;
	}

	public String getAccountCity() {
		return accountCity;
	}

	public void setAccountCity(String accountCity) {
		this.accountCity = accountCity;
	}

	public String getCnapsNo() {
		return cnapsNo;
	}

	public void setCnapsNo(String cnapsNo) {
		this.cnapsNo = cnapsNo;
	}

	public String getQuerstion() {
		return querstion;
	}

	public void setQuerstion(String querstion) {
		this.querstion = querstion;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
