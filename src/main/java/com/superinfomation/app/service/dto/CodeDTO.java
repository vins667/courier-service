package com.superinfomation.app.service.dto;

public class CodeDTO {

	private Long id;
	private String desc;
	private String code;
	
	public CodeDTO() {
		
	}
	
	public CodeDTO(Long id,String desc) {
		this.id=id;
		this.desc=desc;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CodeDTO [id=" + id + ", desc=" + desc + ", code=" + code + "]";
	}
}
