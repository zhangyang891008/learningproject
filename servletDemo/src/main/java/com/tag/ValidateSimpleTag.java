package com.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 通过自定义标签，判断属性是否合法
 * 对应配置tag/mytag.tld
 * 测试页面tag.jsp
 *
 */
public class ValidateSimpleTag extends SimpleTagSupport{
	
	private String name;
	private String passwd;

	public void setName(String name) {
		this.name = name;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Override
	public void doTag() throws JspException, IOException {
		if(this.name != null && !this.name.equals("") && this.passwd != null && !this.passwd.equals("")) {
			getJspContext().getOut().write("<h2>validate success!</h2>");
		} else if(this.name == null || this.name.equals("")){
			getJspContext().getOut().write("<h2>validate failed! name cannot be null</h2>");
		} else if(this.passwd == null || this.passwd.equals("")) {
			getJspContext().getOut().write("<h2>validate failed! passwd cannot be null</h2>");
		}
	}

}
