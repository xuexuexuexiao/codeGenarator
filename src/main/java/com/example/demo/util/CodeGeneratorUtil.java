package com.example.demo.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;

/**
 * @author Huxiaoxue
 * @version V1.0
 * @ClassName
 * @desc:
 * @create: 2019-05-06
 **/
public class CodeGeneratorUtil {

    private static Configuration configuration;

    /**
     * 初始化配置
     * @throws IOException
     */
    public void init() throws IOException {
        //实例化
        configuration = new Configuration(Configuration.getVersion());
        //设置模板所在的路径
        String path = this.getClass().getClassLoader().getResource("templates").getPath();
        configuration.setDirectoryForTemplateLoading(new File(path));
    }

    /**
     * process
     */
    public static void process(String tempName,String savePath) throws IOException, TemplateException {
        //获取模板
        Template template = configuration.getTemplate(tempName);
        //组装模拟数据
         HashMap param = new HashMap<>();
         param.put("name","胡小雪");
         param.put("age","永远23");
         param.put("hehehe","hehehe");

         //初始化保存路径
        FileOutputStream  stream = new FileOutputStream(savePath);
        OutputStreamWriter writer = new OutputStreamWriter(stream);

        //传参，生成数据
        template.process(param,writer);
    }



}
