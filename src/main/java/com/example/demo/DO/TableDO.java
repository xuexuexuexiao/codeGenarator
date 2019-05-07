package com.example.demo.DO;

import lombok.Data;

import java.util.List;

/**
 * @author Huxiaoxue
 * @version V1.0
 * @ClassName
 * @desc: 表数据
 * @create: 2019-05-07
 **/
@Data
public class TableDO {

    /**
     * 表名称
     */
    private String tableName;

    /**
     * 表备注
     */
    private String comment;

    /**
     * 表主键
     */
    private ColumnDO columnDO;

    /**
     * 表主键类型对应的java类型
     */
    private String priKeyAttrType;

    /**
     * 表列名：不包含主键
     */
    private List<ColumnDO> columnDOList;

    /**
     * 类名：第一个字母大写
     */
    private String className;

    /**
     * 类名：第一个字母小写
     */
    private String classname;

    /**
     * Dto
     */
    private String dtoName;

    @Override
    public String toString() {
        return "TableDO{" +
                "tableName='" + tableName + '\'' +
                ", comment='" + comment + '\'' +
                ", columnDO=" + columnDO +
                ", columnDOList=" + columnDOList +
                ", className='" + className + '\'' +
                ", classname='" + classname + '\'' +
                '}';
    }
}
