package com.example.graduationproject.controller;

import com.example.graduationproject.common.vo.Result;
import com.example.graduationproject.service.ICartService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xxay
 * @since 2024-02-28
 */
@RestController
@RequestMapping("/cart")
public class CartController {
    @Resource
   private ICartService iCartService;



    @PostMapping("dishjoincart")
public Result<?> dishjoincart(@RequestParam("userid") String userid,
                              @RequestParam("dishinfoid") String dishinfoid,
                              @RequestParam("cartdishnumber") Integer cartdishnumber,
                              @RequestParam("carttotalprice") Double carttotalprice){
            iCartService.dishjoincart(userid,dishinfoid,cartdishnumber,carttotalprice);
            return Result.success("添加成功");
    }


    @PatchMapping("upCartInfoDishNumber")
    public Result<?> upCartInfoDishNumber(@RequestParam("cartdishnumber") String cartdishnumber,
                                            @RequestParam("cartinfoid")  String cartinfoid){
        iCartService.upCartInfoDishNumber(cartdishnumber,cartinfoid);
        return Result.success("修改成功");
    }

    @DeleteMapping("deleteCartDishByCartInfoId")
    public Result<?> deleteCartDishByCartInfoId(@RequestParam("cartinfoid") String cartinfoid){
        iCartService.deleteCartDishByCartInfoId(cartinfoid);
        return Result.success("删除成功");
    }


}
