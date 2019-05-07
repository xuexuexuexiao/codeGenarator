package com.example.demo.DO;

import lombok.Data;

/**
 * @author Huxiaoxue
 * @version V1.0
 * @ClassName
 * @desc: 列属性
 * @create: 2019-05-07
 **/
@Data
public class ColumnDO {
    /**
     * 字段名
     */
    private String columnName;

    /**
     * 字段类型
     */
    private String columnType;

    /**
     * 字段备注
     */
    private String columnComment;

    /**
     * 属性名称，第一个字母大写
     */
    private String attrName;

    /**
     * 属性名称，第一个字母小写
     */
    private String attrname;

    /**
     * 属性类型
     */
    private String attrType;

    public ColumnDO() {
    }

    public ColumnDO(String columnName, String columnType, String columnComment, String attrName, String attrname, String attrType) {
        this.columnName = columnName;
        this.columnType = columnType;
        this.columnComment = columnComment;
        this.attrName = attrName;
        this.attrname = attrname;
        this.attrType = attrType;
    }

    @Override
    public String toString() {
        return "ColumnDO{" +
                "columnName='" + columnName + '\'' +
                ", columnType='" + columnType + '\'' +
                ", columnComment='" + columnComment + '\'' +
                ", attrName='" + attrName + '\'' +
                ", attrname='" + attrname + '\'' +
                ", attrType='" + attrType + '\'' +
                '}';
    }


}
