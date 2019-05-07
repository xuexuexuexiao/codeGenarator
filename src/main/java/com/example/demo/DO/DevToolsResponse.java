package com.example.demo.DO;

import com.example.demo.enums.MessageEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Lero
 * @version V1.0
 * @ClassName:DevToolsResponse
 * @Description:
 * @date 2018/12/28
 */

@Data
public class DevToolsResponse implements Serializable {

    // 从 dev_error 程序获取以下信息
    private String code = MessageEnum.SUCCESS.getCode();   // success 表示 成功，否则为错误代号
    private String message = MessageEnum.SUCCESS.getMessage();  // 后端传递前端的信息
    private Boolean messageWindows; // y 表示 弹窗 ，n 表示 不弹窗，显示在程序的 指定栏


    // 保持与前端一致的 数据结构
    // 主程序 、子程序
    private Object Data;   // 前端页面数据 Data
    private Object UI; // 画面Json 可录/不可录 + 隐藏/显示 + 必录/非必录 + 焦点栏位否 + 栏位名称+数据类型 +控件类型
    private Object VueProgActionList; // 按钮清单 Json
    private Object VueMenu; // 目录Json

    private Object queryCondition;

    // 调用 另一个程序或者 子程序时使用
    private String openProg;  // null 指 无须开启窗口 ，not null 时，存放的是 前端要开启的程序
    private String openProgParms;  // openPrognot null 时，有值，存放的是 传入新程序的参数



    // 前端  全局变量

    private Object p_prog;  // 程序编号 / 程序名称
    private Object p_progAction;  // 当前动作 对应  dev_prog_action
}
