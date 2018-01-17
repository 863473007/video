<?php

define('IN_SAESPOT', 1);

include(dirname(__FILE__) . '/config.php');
include(dirname(__FILE__) . '/common.php');

if (!$_GET['id']) {
    header('HTTP/1.1 403 Forbidden');
    exit();
}
$se_id = intval($_GET['id']);

// 增加浏览数
$DBS->unbuffered_query("UPDATE v_section SET hits=hits+1 WHERE id='$se_id'");

$sql1 = "SELECT se.id,cl.name,ch_id FROM v_section se LEFT JOIN v_chapter ch ON ch.id = se.ch_id LEFT JOIN v_classes cl ON cl.id = ch.cl_id WHERE se.id = $se_id LIMIT 1";
$res = $DBS->fetch_one_array(stripsql($sql1));

$res['id'] = (int) $res['id'];

$sql2 = "SELECT ch.id chid,ch. NAME chname,ch.abstract chabstract,se.id id,se.image,se.title,hits,seconds,te. name teacher,te.avatar teacherAvatar,te.introduction teacherIntroduction,se.url,se.abstract abstract FROM v_section se LEFT JOIN v_chapter ch ON ch.id = se.ch_id LEFT JOIN v_classes cl ON cl.id = ch.cl_id LEFT JOIN v_teacher te ON te.id = se.te_id WHERE ch_id = " . $res['ch_id'] . " ORDER BY id";
$query = $DBS->query(stripsql($sql2));

//获取结果
$result = array();
while ($r = $DBS->fetch_array($query)) {
    $r['id'] = (int) $r['id'];
    $r['hits'] = (int) $r['hits'];
    $r['seconds'] = (int) $r['seconds'];
    $result[] = $r;
}

require (dirname(__FILE__) . '/include/tool.class.php');
$Tool = new Tool();
$Tool->trees($result);
unset($res['ch_id']);
$res['chapter'] = array_values($Tool->n_result);

$filename = 'idata/details/' . $se_id;
header('Access-Control-Allow-Origin:*');
if ($query && $DBS->link) {
    file_put_contents($filename, json_encode($res));
    echo json_encode($res);
} else {
    $current = file_get_contents($filename);
    echo $current;
}