package com.weaver.codemaker.tools.baseTools;


import com.weaver.codemaker.tools.ConnectionEnum;
import com.weaver.codemaker.tools.GetUrlEnum;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * 基本工具类
 *
 * @Author : Jaylan Zhou
 *
 */

public class BaseTools {

    private BaseTools(){};

    /**
     * 首字母转大写
     * @param s
     * @return
     */

    public static String toUpperCaseFirstOne(String s){
        if(Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }

    /**
     * 首字母转小写
     * @param s
     * @return
     */

    public static String toLowerCaseFirstOne(String s){
        if(Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }

    /**
     *
     * 判断list是否为空
     *
     * @param list 检验的List
     * @return 不空为true，空为false
     */

    public static boolean notNullList(List list){

        boolean result = list != null && !list.isEmpty() && list.size() > 0;

        return result;

    }

    /**
     *
     * 判断String 字符串是否为空
     *
     * @param check 检验的String
     * @return 不空为true，空为false
     */
    public static boolean notNullString(String check){

        boolean result = check != null && !check.equals("");

        return result;

    }

    /**
     *
     * 创建CDK（18位字符串）
     *
     * @return
     */

    public static String creatCDK() {
        String chars = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String result = "";
        for (int i = 0; i < 18; i++) {
            result = result + chars.charAt((int) (36 * (Math.random())));
        }
        return result;//生成18位字符串
    }

    /**
     *
     * 生成id（生成规则：当前 年月日时分秒 加上6位随机数字）
     *
     * @return
     */

    public static String createId() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        String time = dateFormat.format(date);
        String num = "";
        for (int i = 0; i < 6; i++) {
            num = num + (int) (10 * (Math.random()));
        }
        return time + num;// 生成ID，由当前系统时间+随机数字，要16位，用于所有表生产唯一主键
    }

    public static boolean checkServerAndDriver(ConnectionEnum connectionEnum, GetUrlEnum getUrlEnum){

        boolean result = false;

        String getUrlEnumValue = getUrlEnum.toString();

        String connectionEunmValue = connectionEnum.toString();

        if(BaseTools.notNullString(getUrlEnumValue) && BaseTools.notNullString(connectionEunmValue)){

            if (getUrlEnumValue.equals(GetUrlEnum.SQLServer.toString())){

                if (connectionEunmValue.equals(ConnectionEnum.SQLServerDriver.toString())){

                    result = true;

                }

            } else if(getUrlEnumValue.equals(GetUrlEnum.MySQL.toString())){

                if (connectionEunmValue.equals(ConnectionEnum.MySqlDriver.toString()) || connectionEunmValue.equals(ConnectionEnum.MySqlDriver8.toString())){

                    result = true;

                }

            } else if (getUrlEnumValue.equals(GetUrlEnum.OracleService.toString())){

                if (connectionEunmValue.equals(ConnectionEnum.OracleDriver.toString())){

                    result = true;

                }

            } else if (getUrlEnumValue.equals(GetUrlEnum.OracleSID.toString())){

                if (connectionEunmValue.equals(ConnectionEnum.OracleDriver.toString())){

                    result = true;

                }

            }

            else if (getUrlEnumValue.equals(GetUrlEnum.OracleTNS.toString())){

                if (connectionEunmValue.equals(ConnectionEnum.OracleDriver.toString())){

                    result = true;

                }

            }

        }

        return result;

    }

}
