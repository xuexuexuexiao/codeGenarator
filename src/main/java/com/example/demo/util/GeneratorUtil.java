package com.example.demo.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Huxiaoxue
 * @version V1.0
 * @ClassName
 * @desc:
 * @create: 2019-05-07
 **/
@Slf4j
public class GeneratorUtil {


    /**
     * 获取配置信息
     */
    public static Configuration templateConfiguration;

    /**
     * 获取所有的模板名称
     */
    public static List<String> getTemplates(){
        List<String> list  = new ArrayList<>();
        list.add("Controller.ftl");
        list.add("Dao.ftl");
        list.add("Dto.ftl");
        list.add("entity.ftl");
        list.add("Service.ftl");
        list.add("ServiceImpl.ftl");
        return list;
    }


    /**
     * 初始化配置
     */
    public void init() throws IOException {
        //实例化
        templateConfiguration = new Configuration(Configuration.getVersion());
        //设置模板所在的路径
        String path = this.getClass().getClassLoader().getResource("templates").getPath();
        templateConfiguration.setDirectoryForTemplateLoading(new File(path));
    }

    /**
     * 产生代码
     *
     * @throws IOException
     */
    public static void generateCode(Map param) throws IOException, TemplateException {
        //封装要填充的模拟数据
//         param = new HashMap<>();
        param.put("name","胡小雪");
        param.put("age","永远23");
        param.put("hehehe","hehehe");

        //process产生代码
        List<String> list = getTemplates();
        for (String tempName : list){
            //获取模板
            Template template = templateConfiguration.getTemplate(tempName);

            String savePath = getSavePath(tempName,"className");

            FileOutputStream stream = new FileOutputStream(savePath);
            OutputStreamWriter writer = new OutputStreamWriter(stream);

            //传参，生成数据
            template.process(param,writer);

        }
    }

    /**
     * 获取保存的路径
     * @param tempName
     * @param className
     * @return
     */
    private static String getSavePath(String tempName, String className) {

        String savePath = getResourcePath();

        if(tempName.contains("Controller.ftl")){
            return savePath + File.separator + "controller";
        }else if(tempName.contains("Dao.ftl")){
            return savePath + File.separator + "Dao";
        }else if(tempName.contains("Dto.ftl")){
            return savePath + File.separator + "dto";
        }else if(tempName.contains("entity.ftl")){
            return savePath + File.separator + "entity";
        }else if(tempName.contains("Service.ftl")){
            return savePath + File.separator + "service";
        }else if(tempName.contains("ServiceImpl.ftl")){
            return savePath + File.separator + "service" + File.separator + "impl";
        }
        return null;
    }

    /**
     * 项目基本路径
     * @return
     */
    public static String getProjectPath(){

        String path  = new File(GeneratorUtil.class.getClassLoader().getResource("").getFile()).getPath() + File.separator;
        StringBuilder sb = new StringBuilder();
        log.info("projectPath:  ============ "+path);
        sb.append(path.substring(0,path.indexOf("target"))).append("src").append(File.separator).append("main").append(File.separator);
        return sb.toString();
    }

    /**
     * 项目源路径下的java路径
     * @return
     */
    public static String getSourcePath(){
        StringBuilder sb  = new StringBuilder();
        sb.append(getProjectPath()).append("java").append(File.separator);
        return sb.toString();
    }

    /**
     * resources路径
     * @return
     */
    public static String getResourcePath(){
        StringBuilder sb = new StringBuilder();
        sb.append(getProjectPath()).append("resources").append(File.separator);
        return sb.toString();
    }
}
