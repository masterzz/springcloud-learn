package com.zhubr.product.utils;

import com.zhubr.product.VO.ResultVO;

public class ResultVOUtil {
    public static ResultVO success(Object oject) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(oject);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }
}
