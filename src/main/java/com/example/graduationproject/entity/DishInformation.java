package com.example.graduationproject.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author xxay
 * @since 2024-02-28
 */
@TableName("dish_information")
public class DishInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜品信息id
     */
    @TableId(value = "dish_infomation_id", type = IdType.AUTO)
    private Integer dishInfomationId;

    /**
     * 菜品编号
     */
    private String dishNo;

    /**
     * 菜品名称
     */
    private String dishName;

    /**
     * 菜品图片
     */
    private String picture;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 食材
     */
    private String intredients;

    /**
     * 做法
     */
    private String practice;

    /**
     * 营养成分：热量
     */
    private String preferredQuality;

    /**
     * 点击数
     */
    private Integer hits;

    /**
     * 点赞数
     */
    private Integer praiseLen;

    /**
     * 智能推荐
     */
    private Integer recommend;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 菜品历史
     */
    private String dishHistories;

    /**
     * 优选品质食材一
     */
    private String ingredientsOne;

    /**
     * 营养成分：蛋白质
     */
    private String carbohydrate;

    /**
     * 营养成分：碳水化合物
     */
    private String carbohydrates;

    /**
     * 营养成分：脂肪
     */
    private String fat;

    /**
     * 营养成分：纤维素
     */
    private String fibre;

    /**
     * 优选品质食材二
     */
    private String ingredientsTwo;

    /**
     * 优选品质食材三
     */
    private String ingredientsThree;

    /**
     * 优选品质食材四
     */
    private String ingredientsFour;

    /**
     * 优选品质食材五
     */
    private String ingredientsFive;

    /**
     * 购物车id
     */
    private Integer dishCartid;


    /**
     * 菜品分类id
     */
    private Integer dishDishclaid;


    private String dishAddress;

    private String dishCareers;

    private String dishFlavours;

    private String praiseLenS;

    private String praiseLenCs;

    private String praiseLenT;


    private String praiseLenG;


    private String praiseLenGn;

    private String praiseLenQt;

    private  Integer dishNumber;





    public Integer getDishInfomationId() {
        return dishInfomationId;
    }

    public void setDishInfomationId(Integer dishInfomationId) {
        this.dishInfomationId = dishInfomationId;
    }

    public String getDishNo() {
        return dishNo;
    }

    public void setDishNo(String dishNo) {
        this.dishNo = dishNo;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getIntredients() {
        return intredients;
    }

    public void setIntredients(String intredients) {
        this.intredients = intredients;
    }

    public String getPractice() {
        return practice;
    }

    public void setPractice(String practice) {
        this.practice = practice;
    }

    public String getPreferredQuality() {
        return preferredQuality;
    }

    public void setPreferredQuality(String preferredQuality) {
        this.preferredQuality = preferredQuality;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public Integer getPraiseLen() {
        return praiseLen;
    }

    public void setPraiseLen(Integer praiseLen) {
        this.praiseLen = praiseLen;
    }

    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getDishHistories() {
        return dishHistories;
    }

    public void setDishHistories(String dishHistories) {
        this.dishHistories = dishHistories;
    }

    public String getIngredientsOne() {
        return ingredientsOne;
    }

    public void setIngredientsOne(String ingredientsOne) {
        this.ingredientsOne = ingredientsOne;
    }

    public String getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(String carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public String getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(String carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public String getFibre() {
        return fibre;
    }

    public void setFibre(String fibre) {
        this.fibre = fibre;
    }

    public String getIngredientsTwo() {
        return ingredientsTwo;
    }

    public void setIngredientsTwo(String ingredientsTwo) {
        this.ingredientsTwo = ingredientsTwo;
    }

    public String getIngredientsThree() {
        return ingredientsThree;
    }

    public void setIngredientsThree(String ingredientsThree) {
        this.ingredientsThree = ingredientsThree;
    }

    public String getIngredientsFour() {
        return ingredientsFour;
    }

    public void setIngredientsFour(String ingredientsFour) {
        this.ingredientsFour = ingredientsFour;
    }

    public String getIngredientsFive() {
        return ingredientsFive;
    }

    public void setIngredientsFive(String ingredientsFive) {
        this.ingredientsFive = ingredientsFive;
    }

    public Integer getDishCartid() {
        return dishCartid;
    }

    public void setDishCartid(Integer dishCartid) {
        this.dishCartid = dishCartid;
    }


    public Integer getDishDishclaid() {
        return dishDishclaid;
    }

    public void setDishDishclaid(Integer dishDishclaid) {
        this.dishDishclaid = dishDishclaid;
    }



    public String getDishAddress() {
        return dishAddress;
    }

    public void setDishAddress(String dishAddress) {
        this.dishAddress = dishAddress;
    }

    public String getDishCareers() {
        return dishCareers;
    }

    public void setDishCareers(String dishCareers) {
        this.dishCareers = dishCareers;
    }

    public String getDishFlavours() {
        return dishFlavours;
    }

    public void setDishFlavours(String dishFlavours) {
        this.dishFlavours = dishFlavours;
    }

    public String getPraiseLenS() {
        return praiseLenS;
    }

    public void setPraiseLenS(String praiseLenS) {
        this.praiseLenS = praiseLenS;
    }

    public String getPraiseLenCs() {
        return praiseLenCs;
    }

    public void setPraiseLenCs(String praiseLenCs) {
        this.praiseLenCs = praiseLenCs;
    }

    public String getPraiseLenT() {
        return praiseLenT;
    }

    public void setPraiseLenT(String praiseLenT) {
        this.praiseLenT = praiseLenT;
    }

    public String getPraiseLenG() {
        return praiseLenG;
    }

    public void setPraiseLenG(String praiseLenG) {
        this.praiseLenG = praiseLenG;
    }

    public String getPraiseLenGn() {
        return praiseLenGn;
    }

    public void setPraiseLenGn(String praiseLenGn) {
        this.praiseLenGn = praiseLenGn;
    }

    public String getPraiseLenQt() {
        return praiseLenQt;
    }

    public void setPraiseLenQt(String praiseLenQt) {
        this.praiseLenQt = praiseLenQt;
    }

    public Integer getDishNumber() {
        return dishNumber;
    }

    public void setDishNumber(Integer dishNumber) {
        this.dishNumber = dishNumber;
    }

    @Override
    public String toString() {
        return "DishInformation{" +
                "dishInfomationId=" + dishInfomationId +
                ", dishNo='" + dishNo + '\'' +
                ", dishName='" + dishName + '\'' +
                ", picture='" + picture + '\'' +
                ", price=" + price +
                ", intredients='" + intredients + '\'' +
                ", practice='" + practice + '\'' +
                ", preferredQuality='" + preferredQuality + '\'' +
                ", hits=" + hits +
                ", praiseLen=" + praiseLen +
                ", recommend=" + recommend +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", dishHistories='" + dishHistories + '\'' +
                ", ingredientsOne='" + ingredientsOne + '\'' +
                ", carbohydrate='" + carbohydrate + '\'' +
                ", carbohydrates='" + carbohydrates + '\'' +
                ", fat='" + fat + '\'' +
                ", fibre='" + fibre + '\'' +
                ", ingredientsTwo='" + ingredientsTwo + '\'' +
                ", ingredientsThree='" + ingredientsThree + '\'' +
                ", ingredientsFour='" + ingredientsFour + '\'' +
                ", ingredientsFive='" + ingredientsFive + '\'' +
                ", dishCartid=" + dishCartid +
                ", dishDishclaid=" + dishDishclaid +
                ", dishAddress='" + dishAddress + '\'' +
                ", dishCareers='" + dishCareers + '\'' +
                ", dishFlavours='" + dishFlavours + '\'' +
                ", praiseLenS='" + praiseLenS + '\'' +
                ", praiseLenCs='" + praiseLenCs + '\'' +
                ", praiseLenT='" + praiseLenT + '\'' +
                ", praiseLenG='" + praiseLenG + '\'' +
                ", praiseLenGn='" + praiseLenGn + '\'' +
                ", praiseLenQt='" + praiseLenQt + '\'' +
                ", dishNumber=" + dishNumber +
                '}';
    }
}
