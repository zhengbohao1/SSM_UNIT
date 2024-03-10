package com.itzbh.domain;

/**
 * 品牌
 *
 * alt + 鼠标左键：整列编辑
 *
 * 在实体类中，基本数据类型建议使用其对应的包装类型
 */

public class Brand {
    // id 主键
    private Integer id;
    // 品牌名称
    private String brand_name;
    // 企业名称
    private String company_name;
    // 排序字段
    private int ordered;
    // 描述信息
    private String description;
    // 状态：0：禁用  1：启用
    private int status=-1;


    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brand_name;
    }

    public void setBrandName(String brandName) {
        this.brand_name = brandName;
    }

    public String getCompanyName() {
        return company_name;
    }

    public void setCompanyName(String companyName) {
        this.company_name = companyName;
    }

    public int getOrdered() {
        return ordered;
    }

    public void setOrdered(int ordered) {
        this.ordered = ordered;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public String getstatusStr(){
        if(this.status==1){
            return "启用";
        }
        else if(this.status==0){
            return "禁用";
        }
        else return "状态出错";
    }



    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandName='" + brand_name + '\'' +
                ", companyName='" + company_name + '\'' +
                ", ordered=" + ordered +
                ", description='" + description + '\'' +
                ", status=" + getstatusStr() +
                '}';
    }
}
