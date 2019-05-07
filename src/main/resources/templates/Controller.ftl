package ${package}.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import lombok.extern.slf4j.Slf4j;
import work.devtools.common.domain.web.DevToolsResponse;


import ${package}.entity.${className};
import ${package}.dto.${dtoName};
import ${package}.service.${className}Service;
import ${package}.DO.*;
import ${package}.utils.PageUtils;



/**
* ${comment}
*
* @author ${author}
* @email ${email}
* @date ${datetime}
*/

@RestController
@RequestMapping("/${classname}")
@Slf4j
public class ${className}Controller {

    @Autowired
    private Dev_${name}Service dev_${name}Service;

    /**
    * 查询初始化:初始化前端页面
    * @param devToolsRequest
    * @return
    */
    @GetMapping(value="/queryInit")
    public DevToolsResponse queryInit(@RequestBody  QueryCondition queryCondition) {

        DevToolsResponse devToolsResponse = new DevToolsResponse();

        return  devToolsResponse;
    }

    @ResponseBody
    @GetMapping("/query")
    public DevToolsResponse list(@RequestParam Map<String, Object> params){
        //查询列表数据
        QueryParams queryParams = new QueryParams(params);
        List<${dtoName}> ${classname}List = dev_${name}Service.list(query);
        int total = dev_${name}Service.count(query);
        PageUtils pageUtils = new PageUtils(${classname}List, total);
        return pageUtils;
    }

    /**
    * 新增页面
    * @param
    * @return
    */
    @PostMapping("/insertInit")
        public DevToolsResponse insertInit(){

        DevToolsResponse devToolsResponse = new DevToolsResponse();
        //前端传递的参数

        //传递参数转换 ，并查询得到栏位属性信息：可控 可输入
        //TODO 根据程序编号和界面编号得到error新增页面控件的栏位属性信息：UI


        return devToolsResponse;
    }

    /**
    * 新增保存
    * @return
    */
    @PostMapping("/insert")
    public DevToolsResponse insert(@RequestBody  Dev_${name} dev_${name}){
        DevToolsResponse devToolsResponse = new DevToolsResponse();

        //TODO 校验
        try {
            dev_${name}Service.save(dev_${name});

            //TODO
            return devToolsResponse;
        }catch (Exception e){
            e.printStackTrace();
        }
        return devToolsResponse;

    }

    /**
    * 修改画面
    * @param devToolsRequest
    * @return
    */
    @PostMapping("/updateInit/{${pk.attrname}}")
        public DevToolsResponse updateInit(@RequestBody  DevToolsRequest devToolsRequest,@PathVariable("${pk.attrname}") ${pk.attrType} ${pk.attrname}){
        DevToolsResponse devToolsResponse = new DevToolsResponse();
        Map<String, Object> data = (Map<String, Object>) devToolsRequest.getData();

    //TODO
        return devToolsResponse;
    }

    @PostMapping("/update")
    public DevToolsResponse update(Dev_${name} dev_${name}){
        DevToolsResponse devToolsResponse = new DevToolsResponse();
        Map<String, Object> data = (Map<String, Object>) devToolsRequest.getData();
        //TODO

        try {
             dev_${name}Service.update(dev_${name});


            return devToolsResponse;
        }catch (Exception e){
             e.printStackTrace();
        }
        return devToolsResponse;

    }



    /**
    * 删除
    */
    @PostMapping( "/delete")
    @ResponseBody
    public DevToolsResponse delete( ${pk.attrType} ${pk.attrname}){
        DevToolsResponse devToolsResponse = new DevToolsResponse();
        if(dev_${name}Service.remove(${pk.attrname})>0){
            //TODO
            return devToolsResponse;
        }
        return devToolsResponse;
    }

    /**
    * 删除
    */
    @PostMapping( "/batchDelete")
    @ResponseBody
    public DevToolsResponse delete(@RequestParam("ids[]") ${pk.attrType}[] ${pk.attrname}s){
        DevToolsResponse devToolsResponse = new DevToolsResponse();
        dev_${name}Service.batchRemove(${pk.attrname}s);
        //TODO
        return devToolsResponse;
    }
}
