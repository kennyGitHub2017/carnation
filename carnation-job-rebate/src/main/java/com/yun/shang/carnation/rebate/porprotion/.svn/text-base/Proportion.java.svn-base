package com.yun.shang.carnation.rebate.porprotion;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 结算比例对象
 * 
 * @author xing.wen
 * 
 */
public abstract class Proportion {
	// 会员推荐，第一层
	private BigDecimal memberLevelFirst;
	// 会员推荐，第二层
	private BigDecimal memberLevelSecond;
	// 会员推荐，第三层
	private BigDecimal memberLevelThird;
	// 会员绑定的商家
	private BigDecimal memberBindingSeller;
	// 会员绑定的商家的推荐第一层
	private BigDecimal memberBindingSellerLevelFirst;
	// 会员绑定的商家的推荐第二层
	private BigDecimal memberBindingSellerLevelSecond;
	// 会员绑定的商家的推荐第三层
	private BigDecimal memberBindingSellerLevelThird;
	// 会员绑定的商家所在的区域运营商
	private BigDecimal memberBindingSellerDistrictOpertor;
	// 会员绑定的商家所在的区域运营商 推荐第一层
	private BigDecimal memberBindingSellerDistrictOpertorLevelFirst;
	// 会员绑定的商家所在的市级运营商
	private BigDecimal memberBindingSellerCityOpertor;
	// 会员绑定的商家所在的市级运营商 推荐第一层
	private BigDecimal memberBindingSellerCityOpertorLevelFirst;

	public BigDecimal multiply(BigDecimal BVmount, BigDecimal proportion) {
		return BVmount.multiply(proportion).setScale(2, RoundingMode.DOWN);
	}

	public BigDecimal getMemberLevelFirst() {
		return memberLevelFirst;
	}

	public void setMemberLevelFirst(BigDecimal memberLevelFirst) {
		this.memberLevelFirst = memberLevelFirst;
	}

	public BigDecimal getMemberLevelSecond() {
		return memberLevelSecond;
	}

	public void setMemberLevelSecond(BigDecimal memberLevelSecond) {
		this.memberLevelSecond = memberLevelSecond;
	}

	public BigDecimal getMemberLevelThird() {
		return memberLevelThird;
	}

	public void setMemberLevelThird(BigDecimal memberLevelThird) {
		this.memberLevelThird = memberLevelThird;
	}

	public BigDecimal getMemberBindingSeller() {
		return memberBindingSeller;
	}

	public void setMemberBindingSeller(BigDecimal memberBindingSeller) {
		this.memberBindingSeller = memberBindingSeller;
	}

	public BigDecimal getMemberBindingSellerLevelFirst() {
		return memberBindingSellerLevelFirst;
	}

	public void setMemberBindingSellerLevelFirst(BigDecimal memberBindingSellerLevelFirst) {
		this.memberBindingSellerLevelFirst = memberBindingSellerLevelFirst;
	}

	public BigDecimal getMemberBindingSellerLevelSecond() {
		return memberBindingSellerLevelSecond;
	}

	public void setMemberBindingSellerLevelSecond(BigDecimal memberBindingSellerLevelSecond) {
		this.memberBindingSellerLevelSecond = memberBindingSellerLevelSecond;
	}

	public BigDecimal getMemberBindingSellerLevelThird() {
		return memberBindingSellerLevelThird;
	}

	public void setMemberBindingSellerLevelThird(BigDecimal memberBindingSellerLevelThird) {
		this.memberBindingSellerLevelThird = memberBindingSellerLevelThird;
	}

	public BigDecimal getMemberBindingSellerDistrictOpertor() {
		return memberBindingSellerDistrictOpertor;
	}

	public void setMemberBindingSellerDistrictOpertor(BigDecimal memberBindingSellerDistrictOpertor) {
		this.memberBindingSellerDistrictOpertor = memberBindingSellerDistrictOpertor;
	}

	public BigDecimal getMemberBindingSellerDistrictOpertorLevelFirst() {
		return memberBindingSellerDistrictOpertorLevelFirst;
	}

	public void setMemberBindingSellerDistrictOpertorLevelFirst(
			BigDecimal memberBindingSellerDistrictOpertorLevelFirst) {
		this.memberBindingSellerDistrictOpertorLevelFirst = memberBindingSellerDistrictOpertorLevelFirst;
	}

	public BigDecimal getMemberBindingSellerCityOpertor() {
		return memberBindingSellerCityOpertor;
	}

	public void setMemberBindingSellerCityOpertor(BigDecimal memberBindingSellerCityOpertor) {
		this.memberBindingSellerCityOpertor = memberBindingSellerCityOpertor;
	}

	public BigDecimal getMemberBindingSellerCityOpertorLevelFirst() {
		return memberBindingSellerCityOpertorLevelFirst;
	}

	public void setMemberBindingSellerCityOpertorLevelFirst(
			BigDecimal memberBindingSellerCityOpertorLevelFirst) {
		this.memberBindingSellerCityOpertorLevelFirst = memberBindingSellerCityOpertorLevelFirst;
	}

	public abstract int getLevel();

	public abstract void setLevel(int level);

	public abstract BigDecimal getMemberSpendingSeller();

	public abstract void setMemberSpendingSeller(BigDecimal memberSpendingSeller);

	public abstract BigDecimal getMemberSpendingSellerLevelFirst();

	public abstract void setMemberSpendingSellerLevelFirst(BigDecimal memberSpendingSellerLevelFirst);

	public abstract BigDecimal getMemberSpendingSellerLevelSecond();

	public abstract void setMemberSpendingSellerLevelSecond(BigDecimal memberSpendingSellerLevelSecond);

	public abstract BigDecimal getMemberSpendingSellerLevelThird();

	public abstract void setMemberSpendingSellerLevelThird(BigDecimal memberSpendingSellerLevelThird);

	public abstract BigDecimal getMemberSpendingSellerDistrictOpertor();

	public abstract void setMemberSpendingSellerDistrictOpertor(BigDecimal memberSpendingSellerDistrictOpertor);

	public abstract BigDecimal getMemberSpendingSellerDistrictOpertorFirst();

	public abstract void setMemberSpendingSellerDistrictOpertorFirst(
			BigDecimal memberSpendingSellerDistrictOpertorFirst);

	public abstract BigDecimal getMemberSpendingSellerCityOpertor();

	public abstract void setMemberSpendingSellerCityOpertor(BigDecimal memberSpendingSellerCityOpertor);

	public abstract BigDecimal getMemberSpendingSellerCityOpertorFirst();

	public abstract void setMemberSpendingSellerCityOpertorFirst(
			BigDecimal memberSpendingSellerCityOpertorFirst);

	public abstract BigDecimal getMemberSpendingSupplier();

	public abstract void setMemberSpendingSupplier(BigDecimal memberSpendingSupplier);

	public abstract BigDecimal getMemberSpendingSupplierFirst();

	public abstract void setMemberSpendingSupplierFirst(BigDecimal memberSpendingSupplierFirst);

	public abstract BigDecimal getMemberSpendingSupplierSecond();

	public abstract void setMemberSpendingSupplierSecond(BigDecimal memberSpendingSupplierSecond);

	public abstract BigDecimal getMemberSpendingSupplierThird();

	public abstract void setMemberSpendingSupplierThird(BigDecimal memberSpendingSupplierThird);

	public abstract BigDecimal getMemberRecommendCNoperatorFirst();

	public abstract void setMemberRecommendCNoperatorFirst(BigDecimal memberRecommendCNoperatorFirst);

	public abstract BigDecimal getMemberRecommendCNoperatorSecond();

	public abstract void setMemberRecommendCNoperatorSecond(BigDecimal memberRecommendCNoperatorSecond);

	public abstract BigDecimal getMemberRecommendCNoperatorThird();

	public abstract void setMemberRecommendCNoperatorThird(BigDecimal memberRecommendCNoperatorThird);

}
