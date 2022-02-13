package com.test.thread.result;

/**
 * @Package: com.test.thread.result
 * @ClassName: TestTask
 * @Author: 86150
 * @Description:
 * @Date: 2022/1/16 1:00
 */

import com.alibaba.fastjson.JSONObject;
import com.mongodb.util.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * 具体执行业务任务 需要 实现ITask接口  在execute中重写业务逻辑
 * TestTask<BR>
 * 创建人:wangbeidou <BR>
 * 时间：2018年8月8日-下午8:40:32 <BR>
 * @version 2.0
 *
 */
public class TestTask implements ITask<ResultBean<String>, Integer> {

    @Override
    public ResultBean execute(Integer e, Map<String, Object> params) {
        /**
         * 具体业务逻辑：将list中的元素加上辅助参数中的数据返回
         */
        int addNum = Integer.valueOf(String.valueOf(params.get("addNum")));
        e = e + addNum;
        ResultBean<String> resultBean = ResultBean.newInstance();
        resultBean.setData(e.toString());
        return resultBean;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        // 需要多线程处理的大量数据list
        List<Integer> data = new ArrayList<>(10000);
        for(int i = 0; i < 7; i ++){
            data.add(i + 1);
            /*for (int j=0;j<3000;j++){
                data.add(j + 1);
            }*/
        }

        // 创建多线程处理任务
        MultiThreadUtils<Integer> threadUtils = MultiThreadUtils.newInstance(5);
        ITask<ResultBean<String>, Integer> task = new TestTask();
        // 辅助参数  加数
        Map<String, Object> params = new HashMap<>();
        params.put("addNum", 4);
        // 执行多线程处理，并返回处理结果
        ResultBean<List<ResultBean<String>>> resultBean = threadUtils.execute(data, params, task);

        System.out.println("结果：" + JSONObject.toJSON(resultBean));
        long end = System.currentTimeMillis();

        System.out.println("耗时："+(end-start)+"ms");
    }


}