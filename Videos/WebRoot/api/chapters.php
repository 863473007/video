<?php

define('IN_SAESPOT', 1);

include(dirname(__FILE__) . '/config.php');
include(dirname(__FILE__) . '/common.php');

if (!$_GET['id']) {
    header('HTTP/1.1 403 Forbidden');
    exit();
}

$cl_id = intval($_GET['id']);

$sql = "SELECT ch.id chid,ch. NAME chname,ch.abstract chabstract,se.id id,se.image,se.title,hits,seconds,te. name teacher,te.avatar teacherAvatar,se.url,se.abstract abstract FROM v_section se LEFT JOIN v_chapter ch ON ch.id = se.ch_id LEFT JOIN v_classes cl ON cl.id = ch.cl_id LEFT JOIN v_teacher te ON te.id = se.te_id WHERE cl.id = $cl_id ORDER BY chid,id";

$query = $DBS->query(stripsql($sql));

//获取结果
$result = array();
while ($res = $DBS->fetch_array($query)) {
    $res['id'] = (int) $res['id'];
    $res['hits'] = (int) $res['hits'];
    $res['seconds'] = (int) $res['seconds'];
    $result[] = $res;
}
require (dirname(__FILE__) . '/include/tool.class.php');
$Tool = new Tool();
$Tool->trees($result);
$c_chapters = array_values($Tool->n_result);
$c_res = $DBS->fetch_one_array(stripsql("SELECT * FROM v_classes WHERE id = {$cl_id} LIMIT 1"));

$filename = 'idata/chapters/' . $cl_id;
header('Access-Control-Allow-Origin:*');
if ($query && $DBS->link) {
    file_put_contents($filename, json_encode(array('id' => $c_res['id'], 'name' => $c_res['name'], 'chapters' => $c_chapters)));
    echo json_encode(array('id' => $c_res['id'], 'name' => $c_res['name'], 'chapters' => $c_chapters));
} else {
    $current = file_get_contents($filename);
    echo $current;
}