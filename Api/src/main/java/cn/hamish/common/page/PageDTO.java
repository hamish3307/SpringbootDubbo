package cn.hamish.common.page;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @描述:
 * @Date: 2020-03-13 19:42
 * @Author: hha
 */
@Data
public class PageDTO<T> implements Serializable {
    private static final long serialVersionUID = 7055841985794278982L;

    // 当前页
    private int currentPage;

    // 总页数
    private int totalPage;

    // 总记录数
    private long totalRecords;

    // 列表数据
    private List<T> data;

}
