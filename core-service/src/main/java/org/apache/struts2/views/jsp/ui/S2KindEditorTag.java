package org.apache.struts2.views.jsp.ui;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.struts2.components.TextArea;

/**
 * 基于KindEditor封装的大文本录入组件标签
 * 用法示例：<s2:kindeditor name="description" label="描述" rows="3"/>
 */
public class S2KindEditorTag extends TextareaTag {

    /** 
     * 如果在元素中未定义此属性，则按照属性的类型、JSR303 Validator注解、Hibernate Entity注解等自动组合生成JQuery Validator校验语法字符串
     * 如果在元素中定义此属性则以直接定义属性值作为JQuery Validator校验语法字符串，不再进行自动校验逻辑计算处理 
     */
    protected String validator;

    protected void populateParams() {
        super.populateParams();

        TextArea uiBean = ((TextArea) component);
        uiBean.setTemplate("kindeditor");
        if (id == null) {
            //设置ID随机
            uiBean.setId("kindeditor_" + RandomStringUtils.randomAlphabetic(10));
        }
        if (this.theme == null) {
            uiBean.setTheme("bootstrap");
        }
        TagValidatorAttributeBuilder.buildValidatorAttribute(validator, this, this.getStack(),
                (HttpServletRequest) this.pageContext.getRequest(), uiBean);
    }
}