package com.example.demo.enums;

import lombok.Getter;

/**
 * @author Huxiaoxue
 * @version V1.0
 * @ClassName
 * @desc: 返回消息Enum
 * @create: 2019-03-28
 **/
@Getter
public enum MessageEnum {


    SUCCESS("0","成功"),

    PARAM_FAIL("1","参数不正确"),

    DELETE_SUCCESS("2","删除成功"),
    DELETE_FAIL("3","删除失败"),

    NOT_EXIST("3","不存在");

    private String code;
    private String message;

    MessageEnum(String code, String message){
        this.code = code;
        this.message = message;
    }

}
