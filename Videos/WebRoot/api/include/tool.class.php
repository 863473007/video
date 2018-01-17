<?php

if (!defined('IN_SAESPOT'))
    exit('Access Denied');

class Tool {

    public $n_result = array();
    public $data = array();

    public function trees($array, $pid = 1) {
        $this->data = $array;
        foreach ($this->data as $key => $value) {
            if ($value['chid'] == $pid) {
                $this->n_result[($pid - 1)]['id'] = (int)$value['chid'];
                $this->n_result[($pid - 1)]['name'] = $value['chname'];
                $this->n_result[($pid - 1)]['abstract'] = $value['chabstract'];
                unset($value['chid'], $value['chname'], $value['chabstract']);
                $this->n_result[($pid - 1)]['sections'][] = $value;
                unset($this->data[$key]);
            } else {
                $this->trees($this->data, $pid + 1);
            }
        }
    }

}
