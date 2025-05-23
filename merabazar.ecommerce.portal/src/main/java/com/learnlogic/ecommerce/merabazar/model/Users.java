package com.learnlogic.ecommerce.merabazar.model;

// Generated May 31, 2015 3:00:15 AM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Users generated by hbm2java
 */
@Entity
@Table(name = "users", catalog = "merabazar")
public class Users implements java.io.Serializable {

	private long userId;
	private Orders orders;
	private String userFname;
	private String userLname;
	private String userPhone;
	private String userEmail;
	private String userPassword;
	private String userCity;
	private String userState;
	private String userZipcode;
	private Date userRegistrationdate;
	private Boolean userEmailverifiction;
	private String userVerificationcode;
	private String userIp;
	private String userCountry;
	private String userAddress1;
	private String userAddress2;
	private String userCreditcard;
	private String userCardType;
	private String userBillingaddress1;
	private String userBillingaddress2;
	private String userShippingaddress1;
	private String userShippingaddress2;
	private Date userCredmonth;
	private Date userCredexp;
	private byte[] userImage;
	private Set orderses = new HashSet(0);
	private Set shoppingcarts = new HashSet(0);

	public Users() {
	}

	public Users(long userId, String userFname, String userLname) {
		this.userId = userId;
		this.userFname = userFname;
		this.userLname = userLname;
	}

	public Users(long userId, Orders orders, String userFname,
			String userLname, String userPhone, String userEmail,
			String userPassword, String userCity, String userState,
			String userZipcode, Date userRegistrationdate,
			Boolean userEmailverifiction, String userVerificationcode,
			String userIp, String userCountry, String userAddress1,
			String userAddress2, String userCreditcard, String userCardType,
			String userBillingaddress1, String userBillingaddress2,
			String userShippingaddress1, String userShippingaddress2,
			Date userCredmonth, Date userCredexp, byte[] userImage,
			Set orderses, Set shoppingcarts) {
		this.userId = userId;
		this.orders = orders;
		this.userFname = userFname;
		this.userLname = userLname;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userCity = userCity;
		this.userState = userState;
		this.userZipcode = userZipcode;
		this.userRegistrationdate = userRegistrationdate;
		this.userEmailverifiction = userEmailverifiction;
		this.userVerificationcode = userVerificationcode;
		this.userIp = userIp;
		this.userCountry = userCountry;
		this.userAddress1 = userAddress1;
		this.userAddress2 = userAddress2;
		this.userCreditcard = userCreditcard;
		this.userCardType = userCardType;
		this.userBillingaddress1 = userBillingaddress1;
		this.userBillingaddress2 = userBillingaddress2;
		this.userShippingaddress1 = userShippingaddress1;
		this.userShippingaddress2 = userShippingaddress2;
		this.userCredmonth = userCredmonth;
		this.userCredexp = userCredexp;
		this.userImage = userImage;
		this.orderses = orderses;
		this.shoppingcarts = shoppingcarts;
	}

	@Id
	@Column(name = "UserId", unique = true, nullable = false)
	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "User_order")
	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	@Column(name = "User_fname", nullable = false, length = 45)
	public String getUserFname() {
		return this.userFname;
	}

	public void setUserFname(String userFname) {
		this.userFname = userFname;
	}

	@Column(name = "User_lname", nullable = false, length = 45)
	public String getUserLname() {
		return this.userLname;
	}

	public void setUserLname(String userLname) {
		this.userLname = userLname;
	}

	@Column(name = "User_phone", length = 20)
	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	@Column(name = "User_email", length = 45)
	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Column(name = "User_password", length = 45)
	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Column(name = "User_city", length = 45)
	public String getUserCity() {
		return this.userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	@Column(name = "User_state", length = 45)
	public String getUserState() {
		return this.userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	@Column(name = "User_zipcode", length = 45)
	public String getUserZipcode() {
		return this.userZipcode;
	}

	public void setUserZipcode(String userZipcode) {
		this.userZipcode = userZipcode;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "User_registrationdate", length = 19)
	public Date getUserRegistrationdate() {
		return this.userRegistrationdate;
	}

	public void setUserRegistrationdate(Date userRegistrationdate) {
		this.userRegistrationdate = userRegistrationdate;
	}

	@Column(name = "User_emailverifiction")
	public Boolean getUserEmailverifiction() {
		return this.userEmailverifiction;
	}

	public void setUserEmailverifiction(Boolean userEmailverifiction) {
		this.userEmailverifiction = userEmailverifiction;
	}

	@Column(name = "User_verificationcode", length = 45)
	public String getUserVerificationcode() {
		return this.userVerificationcode;
	}

	public void setUserVerificationcode(String userVerificationcode) {
		this.userVerificationcode = userVerificationcode;
	}

	@Column(name = "User_ip", length = 45)
	public String getUserIp() {
		return this.userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	@Column(name = "User_country", length = 45)
	public String getUserCountry() {
		return this.userCountry;
	}

	public void setUserCountry(String userCountry) {
		this.userCountry = userCountry;
	}

	@Column(name = "User_Address1", length = 45)
	public String getUserAddress1() {
		return this.userAddress1;
	}

	public void setUserAddress1(String userAddress1) {
		this.userAddress1 = userAddress1;
	}

	@Column(name = "User_Address2", length = 45)
	public String getUserAddress2() {
		return this.userAddress2;
	}

	public void setUserAddress2(String userAddress2) {
		this.userAddress2 = userAddress2;
	}

	@Column(name = "User_creditcard", length = 45)
	public String getUserCreditcard() {
		return this.userCreditcard;
	}

	public void setUserCreditcard(String userCreditcard) {
		this.userCreditcard = userCreditcard;
	}

	@Column(name = "User_cardType", length = 45)
	public String getUserCardType() {
		return this.userCardType;
	}

	public void setUserCardType(String userCardType) {
		this.userCardType = userCardType;
	}

	@Column(name = "User_billingaddress1", length = 45)
	public String getUserBillingaddress1() {
		return this.userBillingaddress1;
	}

	public void setUserBillingaddress1(String userBillingaddress1) {
		this.userBillingaddress1 = userBillingaddress1;
	}

	@Column(name = "User_billingaddress2", length = 45)
	public String getUserBillingaddress2() {
		return this.userBillingaddress2;
	}

	public void setUserBillingaddress2(String userBillingaddress2) {
		this.userBillingaddress2 = userBillingaddress2;
	}

	@Column(name = "User_shippingaddress1", length = 45)
	public String getUserShippingaddress1() {
		return this.userShippingaddress1;
	}

	public void setUserShippingaddress1(String userShippingaddress1) {
		this.userShippingaddress1 = userShippingaddress1;
	}

	@Column(name = "User_shippingaddress2", length = 45)
	public String getUserShippingaddress2() {
		return this.userShippingaddress2;
	}

	public void setUserShippingaddress2(String userShippingaddress2) {
		this.userShippingaddress2 = userShippingaddress2;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "User_credmonth", length = 19)
	public Date getUserCredmonth() {
		return this.userCredmonth;
	}

	public void setUserCredmonth(Date userCredmonth) {
		this.userCredmonth = userCredmonth;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "User_credexp", length = 19)
	public Date getUserCredexp() {
		return this.userCredexp;
	}

	public void setUserCredexp(Date userCredexp) {
		this.userCredexp = userCredexp;
	}

	@Column(name = "User_image")
	public byte[] getUserImage() {
		return this.userImage;
	}

	public void setUserImage(byte[] userImage) {
		this.userImage = userImage;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public Set getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set orderses) {
		this.orderses = orderses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public Set getShoppingcarts() {
		return this.shoppingcarts;
	}

	public void setShoppingcarts(Set shoppingcarts) {
		this.shoppingcarts = shoppingcarts;
	}

}
