package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页查询结果的封装类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    private Long total;//总记录数
    private List rows;//当前页数据列表
    //如果不确定rows中元素的类型，或者希望允许任意类型的元素，可以使用原始类型private List rows;
}
