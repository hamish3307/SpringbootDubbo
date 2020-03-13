package cn.hamish.common.page;

import lombok.Data;

import java.io.Serializable;

/**
 * @描述:
 * @Date: 2020-03-13 19:27
 * @Author: hha
 */
@Data
public class PageQueryDTO implements Serializable {
    private static final long serialVersionUID = 3944368714990200340L;

    // 默认页面大小
    public static final int DEFAULT_PAGESIZE = 10;

    //当前页
    private int currentPage;

    // 页面大小
    private int pageSize;

    /**
     * 计算sql start
     * 其中currentPage如果是第一页或者不传时就是为1
     *
     * @return
     */
    public int calStart() {
        if (currentPage == 0) {
            currentPage = 1;
        }
        return (currentPage - 1) * pageSize;
    }

}
