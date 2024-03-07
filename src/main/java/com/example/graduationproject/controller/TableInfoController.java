package com.example.graduationproject.controller;

import com.example.graduationproject.common.vo.Result;
import com.example.graduationproject.entity.TableInfo;
import com.example.graduationproject.service.ITableInfoService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xxay
 * @since 2024-02-28
 */
@RestController
@RequestMapping("/tableinfo")
public class TableInfoController {
    @Resource
  private   ITableInfoService iTableInfoService;
    @GetMapping("getTableIdByDiningId")
    public Result<?> getTableIdByDiningId(@RequestParam("diningid") String dinid){
         Map<String,Object> data = iTableInfoService.getTableIdByDiningId(dinid);
         if (data != null){
             return Result.success(data);
         }
         return Result.fail("未找到数据");
    }

    @PostMapping("InsertTableByDiningID")
    public Result<?> InsertTableByDiningID(@RequestBody TableInfo tableInfo){
        iTableInfoService.save(tableInfo);
        return Result.success("增加成功");
    }


}
