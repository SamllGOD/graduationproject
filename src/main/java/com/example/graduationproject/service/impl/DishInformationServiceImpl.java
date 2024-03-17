package com.example.graduationproject.service.impl;

import cn.hutool.core.lang.hash.Hash;
import com.example.graduationproject.entity.DishInformation;
import com.example.graduationproject.mapper.DishInformationMapper;
import com.example.graduationproject.service.IDishInformationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xxay
 * @since 2024-02-28
 */
@Service
public class DishInformationServiceImpl extends ServiceImpl<DishInformationMapper, DishInformation> implements IDishInformationService {
    @Resource
   private RedisTemplate redisTemplate;
    @Override
    public Map<String,Object> setredis(String businessid) {
        List<DishInformation> dishdata = this.baseMapper.getAllByBusinessId(businessid);
        if (dishdata != null){
            String key = "dish:"+ UUID.randomUUID();
            redisTemplate.opsForValue().set(key,dishdata,30, TimeUnit.MINUTES);
            HashMap<String, Object> map = new HashMap<>();
            map.put("key",key);
            return map;
        }
        return null;
    }

    @Override
    public Object dishinfo(String token) {
        Object o = redisTemplate.opsForValue().get(token);
        return o;
    }

    @Override
    public Map<String, Object> getdishmessagefordishid(String dishid) {
        DishInformation dishInformation = this.baseMapper.getDishmessageByDishId(dishid);
            double doublescore = 0.00;
            doublescore = (double) dishInformation.getDishscore() / dishInformation.getDishsold();
            if (dishInformation != null){
                HashMap<String, Object> map = new HashMap<>();
                map.put("dishdata",dishInformation);
                map.put("dishscore",doublescore);
                return map;
            }
        return null;
    }

    @Override
    public Map<String, Object> getalldishmessage() {
        List<DishInformation> allDishMessage = this.baseMapper.getAllDishMessage();
        HashMap<String, Object> map = new HashMap<>();
        map.put("dish",allDishMessage);
        return map;


    }

    @Override
    public Map<String, Object> getdishbydishtype(String dishtype) {
        List<DishInformation> dishInformationbydishtype = this.baseMapper.SelectDishByDishType(dishtype);
        HashMap<String, Object> map = new HashMap<>();
        map.put("dish",dishInformationbydishtype);
        return map;
    }

    @Override
    public Map<String, Object> getDishbydishcategory(String category) {

        List<DishInformation> dishInformationbycategory = this.baseMapper.SelectDishByDishCategory(category);
        HashMap<String, Object> map = new HashMap<>();
        map.put("dish",dishInformationbycategory);
        return map;



    }

    @Override
    public Map<String, Object> getdishbydishaddressordishcareers(String address, String careers) {
        List<DishInformation> dishInformations =
                this.baseMapper.selectDishByDishAddressOrDishCareers(address, careers);
        HashMap<String, Object> map = new HashMap<>();
            map.put("dish",dishInformations);
        return map;
    }

    @Override
    public Map<String, Object> getdishbypricebetween(String lowPrice, String highPrice) {
        List<DishInformation> dishInformation = this.baseMapper.selectDishByPriceBetween(lowPrice, highPrice);
        HashMap<String, Object> map = new HashMap<>();
        map.put("dish",dishInformation);
        return map;
    }

    @Override
    public Map<String, Object> getDishByDishName(String dishname) {
        List<DishInformation> dishInformation = this.baseMapper.selectDishByDishName(dishname);
        HashMap<String, Object> map = new HashMap<>();
        map.put("dish",dishInformation);
        return map;
    }

    @Override
    public void DeleteDishByDishIdAndDishBuId(String dishid, String buid) {
                    this.baseMapper.DeleteDishByDishIdAndDishBuId(dishid,buid);
    }

    @Override
    public void AddDishFromBuId(DishInformation dishInformation) {
        this.baseMapper.AddDishFromBuId(dishInformation);
    }
    @Override
    public Map<String, Object> getDishByCreateTime() {
        List<DishInformation> dishInformations = this.baseMapper.selectNewDish();
        HashMap<String, Object> map = new HashMap<>();
//        现在的时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
//        最新创建的商品的时间
        System.out.println(dishInformations.get(0).getCreateTime());
//        判断新品至今已经创建几天
        long betwwenDays = ChronoUnit.DAYS.between(dishInformations.get(0).getCreateTime(),localDateTime);
//        判断有没有新品上市来推送不同的商品
        if (betwwenDays < 3){
//            如果第一件是新品则将最新的五件商品推送出来
//            推送新品
            map.put("recommendDish",dishInformations);
            return map;
        }else {
//            随机推送评分大于3.6的商品
            List<DishInformation> dishInformations1 = this.baseMapper.selectLiMitFiveDish();
            map.put("recommendDish", dishInformations1);
            return map;
        }
    }

    @Override
    public Map<String, Object> getDishByMySelf() {





        return null;
    }

    @Override
    public Map<String, Object> getDishByPriceCommend(Double price,
                                                     Integer rulesDish,
                                                     Integer dishcategoryRouNumber,
                                                     Integer dishcategoryshuNumber,
                                                     Integer dishcategorytangNumber,
                                                     Integer dishcategoryzhuNumber) {
        //获取需要的菜品总数量
        Integer countdish = dishcategoryRouNumber+
                            dishcategoryshuNumber+
                            dishcategorytangNumber+
                            dishcategoryzhuNumber;
        System.out.println(countdish);
        //获取每件菜品的平均价钱
        Double Average = price/countdish;
        System.out.println(Average);
        //设置List容器存放查询出来的菜品
        HashMap<String, Object> map = new HashMap<>();
        //默认先查询主食: 价钱:Average 数量 dishcategoryzhuNumber

        if (rulesDish == 0){
            //优先主食即默认
            if (dishcategoryzhuNumber != 0 && price > 0){
                List<DishInformation> dishInformationszhushi = this.baseMapper.selectZhuDish(Average, dishcategoryzhuNumber);
                //将菜品放入MAp
                map.put("zs",dishInformationszhushi);
                //更新总量
                countdish -= dishcategoryzhuNumber;
//            判断返回了几件菜品
                HashMap<String, Double> map1 = this.ifDishinfoListBetween1Andn(countdish, Average, dishInformationszhushi, price);
                //获取到了剩余价钱
                price= map1.get("price");
                Average = map1.get("Average");
            }
            // 查询蔬菜
            if (dishcategoryshuNumber!= 0 && price > 0){
                List<DishInformation> dishInformationsshucai = this.baseMapper.selectshucai(Average, dishcategoryshuNumber);
                map.put("sc",dishInformationsshucai);
                countdish -= dishcategoryzhuNumber;
                HashMap<String, Double> map1 = this.ifDishinfoListBetween1Andn(countdish, Average, dishInformationsshucai, price);
                //获取到了剩余价钱
                price= map1.get("price");
                Average = map1.get("Average");
            }
            System.out.println(map);
// 查询肉
            if (dishcategorytangNumber != 0 && price > 0){
                List<DishInformation> dishInformationstangpin = this.baseMapper.selecttangpin(Average, dishcategorytangNumber);
                map.put("tp",dishInformationstangpin);
                countdish -= dishcategoryshuNumber;
                HashMap<String, Double> map1 = this.ifDishinfoListBetween1Andn(countdish, Average, dishInformationstangpin, price);
                //获取到了剩余价钱
                price= map1.get("price");
                Average = map1.get("Average");
            }
// 查询汤
            if (dishcategoryRouNumber != 0 && price > 0){
                List<DishInformation> dishInformationsroulei = this.baseMapper.selectroulei(Average, dishcategoryRouNumber);
                map.put("rl",dishInformationsroulei);
                countdish -= dishcategoryzhuNumber;
                HashMap<String, Double> map1 = this.ifDishinfoListBetween1Andn(countdish, Average, dishInformationsroulei, price);
                //获取到了剩余价钱
                price= map1.get("price");
                Average = map1.get("Average");
            }
        } else if (rulesDish == 1){
            //优先汤
            if (dishcategorytangNumber != 0 && price > 0){
                List<DishInformation> dishInformationstangpin = this.baseMapper.selecttangpin(Average, dishcategorytangNumber);
                map.put("tp",dishInformationstangpin);
                countdish -= dishcategoryshuNumber;
                HashMap<String, Double> map1 = this.ifDishinfoListBetween1Andn(countdish, Average, dishInformationstangpin, price);
                //获取到了剩余价钱
                price= map1.get("price");
                Average = map1.get("Average");
            }
            if (dishcategoryzhuNumber != 0 && price > 0){
                List<DishInformation> dishInformationszhushi = this.baseMapper.selectZhuDish(Average, dishcategoryzhuNumber);
                //将菜品放入MAp
                map.put("zs",dishInformationszhushi);
                //更新总量
                countdish -= dishcategoryzhuNumber;
//            判断返回了几件菜品
                HashMap<String, Double> map1 = this.ifDishinfoListBetween1Andn(countdish, Average, dishInformationszhushi, price);
                //获取到了剩余价钱
                price= map1.get("price");
                Average = map1.get("Average");
            }
            System.out.println(map);
            if (dishcategoryshuNumber!= 0 && price > 0){
                List<DishInformation> dishInformationsshucai = this.baseMapper.selectshucai(Average, dishcategoryshuNumber);
                map.put("sc",dishInformationsshucai);
                countdish -= dishcategoryzhuNumber;
                HashMap<String, Double> map1 = this.ifDishinfoListBetween1Andn(countdish, Average, dishInformationsshucai, price);
                //获取到了剩余价钱
                price= map1.get("price");
                Average = map1.get("Average");
            }
            if (dishcategoryRouNumber != 0 && price > 0){
                List<DishInformation> dishInformationsroulei = this.baseMapper.selectroulei(Average, dishcategoryRouNumber);
                map.put("rl",dishInformationsroulei);
                countdish -= dishcategoryzhuNumber;
                HashMap<String, Double> map1 = this.ifDishinfoListBetween1Andn(countdish, Average, dishInformationsroulei, price);
                //获取到了剩余价钱
                price= map1.get("price");
                Average = map1.get("Average");
            }
        }else if(rulesDish == 2){
            if (dishcategoryshuNumber!= 0 && price > 0){
                List<DishInformation> dishInformationsshucai = this.baseMapper.selectshucai(Average, dishcategoryshuNumber);
                map.put("sc",dishInformationsshucai);
                countdish -= dishcategoryzhuNumber;
                HashMap<String, Double> map1 = this.ifDishinfoListBetween1Andn(countdish, Average, dishInformationsshucai, price);
                //获取到了剩余价钱
                price= map1.get("price");
                Average = map1.get("Average");
            }
            //优先蔬菜
            if (dishcategoryzhuNumber != 0 && price > 0){
                List<DishInformation> dishInformationszhushi = this.baseMapper.selectZhuDish(Average, dishcategoryzhuNumber);
                //将菜品放入MAp
                map.put("zs",dishInformationszhushi);
                //更新总量
                countdish -= dishcategoryzhuNumber;
//            判断返回了几件菜品
                HashMap<String, Double> map1 = this.ifDishinfoListBetween1Andn(countdish, Average, dishInformationszhushi, price);
                //获取到了剩余价钱
                price= map1.get("price");
                Average = map1.get("Average");
            }
            System.out.println(map);
            if (dishcategorytangNumber != 0 && price > 0){
                List<DishInformation> dishInformationstangpin = this.baseMapper.selecttangpin(Average, dishcategorytangNumber);
                map.put("tp",dishInformationstangpin);
                countdish -= dishcategoryshuNumber;
                HashMap<String, Double> map1 = this.ifDishinfoListBetween1Andn(countdish, Average, dishInformationstangpin, price);
                //获取到了剩余价钱
                price= map1.get("price");
                Average = map1.get("Average");
            }
            if (dishcategoryRouNumber != 0 && price > 0){
                List<DishInformation> dishInformationsroulei = this.baseMapper.selectroulei(Average, dishcategoryRouNumber);
                map.put("rl",dishInformationsroulei);
                countdish -= dishcategoryzhuNumber;
                HashMap<String, Double> map1 = this.ifDishinfoListBetween1Andn(countdish, Average, dishInformationsroulei, price);
                //获取到了剩余价钱
                price= map1.get("price");
                Average = map1.get("Average");
            }
        }else {
            if (dishcategoryRouNumber != 0 && price > 0){
                List<DishInformation> dishInformationsroulei = this.baseMapper.selectroulei(Average, dishcategoryRouNumber);
                map.put("rl",dishInformationsroulei);
                countdish -= dishcategoryzhuNumber;
                HashMap<String, Double> map1 = this.ifDishinfoListBetween1Andn(countdish, Average, dishInformationsroulei, price);
                //获取到了剩余价钱
                price= map1.get("price");
                Average = map1.get("Average");
            }
            //优先蔬菜
            if (dishcategoryzhuNumber != 0 && price > 0){
                List<DishInformation> dishInformationszhushi = this.baseMapper.selectZhuDish(Average, dishcategoryzhuNumber);
                //将菜品放入MAp
                map.put("zs",dishInformationszhushi);
                //更新总量
                countdish -= dishcategoryzhuNumber;
//            判断返回了几件菜品
                HashMap<String, Double> map1 = this.ifDishinfoListBetween1Andn(countdish, Average, dishInformationszhushi, price);
                //获取到了剩余价钱
                price= map1.get("price");
                Average = map1.get("Average");
            }
            System.out.println(map);
            if (dishcategorytangNumber != 0 && price > 0){
                List<DishInformation> dishInformationstangpin = this.baseMapper.selecttangpin(Average, dishcategorytangNumber);
                map.put("tp",dishInformationstangpin);
                countdish -= dishcategoryshuNumber;
                HashMap<String, Double> map1 = this.ifDishinfoListBetween1Andn(countdish, Average, dishInformationstangpin, price);
                //获取到了剩余价钱
                price= map1.get("price");
                Average = map1.get("Average");
            }
            if (dishcategoryshuNumber!= 0 && price > 0){
                List<DishInformation> dishInformationsshucai = this.baseMapper.selectshucai(Average, dishcategoryshuNumber);
                map.put("sc",dishInformationsshucai);
                countdish -= dishcategoryzhuNumber;
                HashMap<String, Double> map1 = this.ifDishinfoListBetween1Andn(countdish, Average, dishInformationsshucai, price);
                //获取到了剩余价钱
                price= map1.get("price");
                Average = map1.get("Average");
            }
        }
        map.put("haveprice",price);
        return map;
    }

    @Override
    public Map<String, Object> getMyselfPointDish(Double price, Integer bigdishnumber,
                                                  Integer dishcategoryRouNumber,
                                                  Integer dishcategoryshuNumber,
                                                  Integer dishcategorytangNumber,
                                                  Integer dishcategoryzhuNumber) {

        //获取需要的菜品总数量
        Integer countdish = dishcategoryRouNumber+
                dishcategoryshuNumber+
                dishcategorytangNumber+
                dishcategoryzhuNumber;
        System.out.println(countdish);
        //获取每件菜品的平均价钱
        Double Average = price/countdish;
        System.out.println(Average);
        //设置List容器存放查询出来的菜品
        HashMap<String, Object> map = new HashMap<>();
        if (bigdishnumber != 0 && price > 0){
            List<DishInformation> dishInformationsdacai = this.baseMapper.selectdacai(bigdishnumber);
            map.put("dc",dishInformationsdacai);
            HashMap<String, Double> map1 = this.ifDishinfoListBetween1Andn(countdish, Average, dishInformationsdacai, price);
            //获取到了剩余价钱
            price= map1.get("price");
            Average = map1.get("Average");
        }
        if (dishcategorytangNumber != 0 && price > 0){
            List<DishInformation> dishInformationstangpin = this.baseMapper.selecttangpin(Average, dishcategorytangNumber);
            map.put("tp",dishInformationstangpin);
            countdish -= dishcategoryshuNumber;
            HashMap<String, Double> map1 = this.ifDishinfoListBetween1Andn(countdish, Average, dishInformationstangpin, price);
            //获取到了剩余价钱
            price= map1.get("price");
            Average = map1.get("Average");
        }
        if (dishcategoryzhuNumber != 0 && price > 0){
            List<DishInformation> dishInformationszhushi = this.baseMapper.selectZhuDish(Average, dishcategoryzhuNumber);
            //将菜品放入MAp
            map.put("zs",dishInformationszhushi);
            //更新总量
            countdish -= dishcategoryzhuNumber;
//            判断返回了几件菜品
            HashMap<String, Double> map1 = this.ifDishinfoListBetween1Andn(countdish, Average, dishInformationszhushi, price);
            //获取到了剩余价钱
            price= map1.get("price");
            Average = map1.get("Average");
        }
        System.out.println(map);
        if (dishcategoryshuNumber!= 0 && price > 0){
            List<DishInformation> dishInformationsshucai = this.baseMapper.selectshucai(Average, dishcategoryshuNumber);
            map.put("sc",dishInformationsshucai);
            countdish -= dishcategoryzhuNumber;
            HashMap<String, Double> map1 = this.ifDishinfoListBetween1Andn(countdish, Average, dishInformationsshucai, price);
            //获取到了剩余价钱
            price= map1.get("price");
            Average = map1.get("Average");
        }
        if (dishcategoryRouNumber != 0 && price > 0){
            List<DishInformation> dishInformationsroulei = this.baseMapper.selectroulei(Average, dishcategoryRouNumber);
            map.put("rl",dishInformationsroulei);
            countdish -= dishcategoryzhuNumber;
            HashMap<String, Double> map1 = this.ifDishinfoListBetween1Andn(countdish, Average, dishInformationsroulei, price);
            //获取到了剩余价钱
            price= map1.get("price");
            Average = map1.get("Average");
        }





        map.put("haveprice",price);
        return map;
    }

    //封装函数
    private HashMap<String,Double> ifDishinfoListBetween1Andn
                    (Integer countdish,Double Average,List<DishInformation> dishInformationsroulei
                     ,Double price){
        //            判断返回了几件菜品
        if (dishInformationsroulei.size() == 1){
            //如果商品等于1件
            price -= dishInformationsroulei.get(0).getPrice().doubleValue();
            Average = price/countdish;
        }else if (dishInformationsroulei.size() > 1){
//                如果商品大于1件
            Double mathprice = 0.00;
            for (DishInformation dishInformation: dishInformationsroulei){
                System.out.println(dishInformation.getPrice());
                mathprice  += dishInformation.getPrice().doubleValue();
            }
            //获取到了剩余价钱
            price-= mathprice;
            Average = price/countdish;
        }
        HashMap<String,Double> map = new HashMap<>();
        map.put("Average",Average);
        map.put("price",price);
        return map;
    }
}
