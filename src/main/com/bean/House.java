package com.bean;

import lombok.Data;

import java.util.Date;

/**
 * @author wang
 */
@Data
public class House {

	private Integer id;
	// 租赁方式
	private Integer rentalMode;
	// 租金
	private Integer rental;
	// 户型
	private Integer houseType;
	// 省id
	private Integer province;
	// 市id
	private Integer city;
	// 区id
	private Integer area;
	// 区名称
	private String areaName;
	// 地址
	private String address;
	private Date publishDate;
	private String updateDate;
	private String pic;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRentalMode() {
		return rentalMode;
	}

	public void setRentalMode(Integer rentalMode) {
		this.rentalMode = rentalMode;
	}

	public Integer getRental() {
		return rental;
	}

	public void setRental(Integer rental) {
		this.rental = rental;
	}

	public Integer getHouseType() {
		return houseType;
	}

	public void setHouseType(Integer houseType) {
		this.houseType = houseType;
	}

	public Integer getProvince() {
		return province;
	}

	public void setProvince(Integer province) {
		this.province = province;
	}

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
}
