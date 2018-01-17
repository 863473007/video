<?php

$action = @$_GET['a'] ? addslashes(trim($_GET['a'])) : '';
$url = dirname($_SERVER['SERVER_NAME'] . $_SERVER['PHP_SELF']);

// 删除目录
function deltree($deldir) {
    $mydir = @dir($deldir);
    while ($file = $mydir->read()) {
        if ((is_dir("$deldir/$file")) AND ( $file != ".") AND ( $file != "..")) {
            @chmod("$deldir/$file", 0777);
            deltree("$deldir/$file");
        }
        if (is_file("$deldir/$file")) {
            @chmod("$deldir/$file", 0777);
            @unlink("$deldir/$file");
        }
    }
    $mydir->close();
    @chmod("$deldir", 0777);
    return (@rmdir($deldir)) ? 1 : 0;
}

switch ($action) {
    case 'del':
        if (addslashes(trim($_GET['do'])) != 'del') {
            header('HTTP/1.1 403 Forbidden');
            exit();
        }

        $dirname = 'idata/';

        deltree($dirname . 'chapters');
        deltree($dirname . 'details');
        @mkdir($dirname . 'chapters', 0777);
        @chmod($dirname . 'chapters', 0777);

        @mkdir($dirname . 'details', 0777);
        @chmod($dirname . 'details', 0777);

        break;
    case 'init':
        if (addslashes(trim($_GET['do'])) != 'init') {
            header('HTTP/1.1 403 Forbidden');
            exit();
        }
        // 1. 初始化
        $ch = curl_init();
        // 2. 设置选项，包括URL
        curl_setopt($ch, CURLOPT_URL, "http://" . $url . "/console.php?a=del&do=del");
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
        curl_setopt($ch, CURLOPT_HEADER, 0);
        curl_exec($ch);
        // 3. 释放curl句柄
        curl_close($ch);

        //课程总数
        $c_num = 3;

        //视频总数
        $d_num = 12;

        for ($i = 1; $i <= $c_num; $i++) {
            // 1. 初始化
            $ch = curl_init();
            // 2. 设置选项，包括URL
            curl_setopt($ch, CURLOPT_URL, "http://" . $url . "/chapters.php?id=" . $i);
            curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
            curl_setopt($ch, CURLOPT_HEADER, 0);
            curl_exec($ch);
            // 3. 释放curl句柄
            curl_close($ch);
        }


        for ($i = 1; $i <= $d_num; $i++) {
            // 1. 初始化
            $ch = curl_init();
            // 2. 设置选项，包括URL
            curl_setopt($ch, CURLOPT_URL, "http://" . $url . "/details.php?id=" . $i);
            curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
            curl_setopt($ch, CURLOPT_HEADER, 0);
            curl_exec($ch);
            // 3. 释放curl句柄
            curl_close($ch);
        }
        break;
    default:
        header('HTTP/1.1 403 Forbidden');
        exit();
        break;
}