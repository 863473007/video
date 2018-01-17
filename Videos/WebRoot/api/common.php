<?php

if (!defined('IN_SAESPOT'))
    exit('error: 403 Access Denied');

error_reporting(0);

//引入数据库操作类
include (dirname(__FILE__) . '/include/mysql.class.php');
// 初始化从数据类，若要写、删除数据则需要定义主数据类
$DBS = new DB_MySQL;
$dbhandle = $DBS->connect($servername, $dbport, $dbusername, $dbpassword, $dbname);


@set_magic_quotes_runtime(0);

//常用函数
//sql语句过滤
function stripsql($string) {
    if (!is_array($string)) {
        $pattern_arr = array("/ union /i", "/ select /i", "/ update /i", "/ outfile /i", "/ or /i");
        $replace_arr = array('&nbsp;union&nbsp;', '&nbsp;select&nbsp;', '&nbsp;update&nbsp;', '&nbsp;outfile&nbsp;', '&nbsp;or&nbsp;');
        $string = preg_replace($pattern_arr, $replace_arr, $string);
        return $string;
    } else {
        foreach ($string as $key => $val) {
            $string[$key] = stripsql($val);
        }
        return $string;
    }
}

?>