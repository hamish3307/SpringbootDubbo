package cn.hamish.common;

import cn.hamish.common.page.PageQueryDTO;
import lombok.Data;

import java.io.Serializable;

/**
 * @描述:
 * @Date: 2020-03-13 15:04
 * @Author: hha
 */
@Data
public class BaseQueryDTO<T> implements Serializable {

	private static final long serialVersionUID = -1101289275169091024L;

	private PageQueryDTO pageInfo;

	private T queryInfo;
	
}
