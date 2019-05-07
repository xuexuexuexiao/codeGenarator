package com.example.demo.util;

import com.example.demo.DO.ColumnDO;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;
import org.apache.commons.configuration.Configuration;

/**
 * Created by 20190301 on 2019/5/6.
 */
@Slf4j
public class CodeGeneratorUtilTest {


    @Test
    public void generatorTest() throws IOException, TemplateException {
        log.info("========================模板生成开始======================");
        try {
            CodeGeneratorUtil codeGeneratorUtil = new CodeGeneratorUtil();
            codeGeneratorUtil.init();
            codeGeneratorUtil.process("hello.ftl","D:\\hello.html");
            log.info("======================模板生成结束==========================");
        }catch (Exception e){
            e.printStackTrace();
            log.info("============================模板生成失败=============================");
        }
    }


    @Test
    public void generatorUtilTest(){
        Configuration configuration = getConfiguration();
        log.info("=================模板生成开始=====================");

        /**
         * 主键字段模拟数据
         */
        ColumnDO pk = new ColumnDO();
        pk.setAttrName("id");
        pk.setAttrType("String");
        pk.setColumnComment("id 主键");
        pk.setColumnName("id");
        pk.setColumnType("varchar");



        /**
         * 列字段模拟数据
         */
        List<ColumnDO> columnDOList = new ArrayList<ColumnDO>();
        //(String columnName, String columnType, String columnComment, String attrName, String attrname, String attrType)
        columnDOList.add(new ColumnDO("userName","varchar","用户名称",
                "UserName","userName","String"));

        columnDOList.add(new ColumnDO("age","int","年龄",
                "Age","age","Integer"));

        columnDOList.add(new ColumnDO("gender","varchar","性别",
                "Gender","gender","String"));

        columnDOList.add(new ColumnDO("status","varchar","状态",
                "Status","status","String"));

        columnDOList.add(new ColumnDO("grade","varchar","分数",
                "Grade","grade","String"));





        HashMap map = new HashMap<>(16);
        map.put("tableName", "t_user");
        map.put("comment", "测试表--代码生成");
        map.put("pk", "");
        map.put("className", "T_user");
        map.put("classname", "t_user");
        map.put("name","user");
        map.put("columnDOList", "");
        map.put("package", configuration.getString("package"));
        map.put("author", configuration.getString("author"));
        map.put("email", configuration.getString("email"));
        map.put("datetime", new Date());
        try{
            GeneratorUtil.generateCode(map);
            log.info("suceess to generate ^_^");
        }catch (Exception e){
            e.printStackTrace();
            log.info("模板生成失败 T_T");
        }
    }


    public Configuration getConfiguration(){
        try {
            return new PropertiesConfiguration("generate.properties");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}