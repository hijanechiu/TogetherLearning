package tl.util;

import java.io.Serializable;

/*Json格式的數據進行響應*/
public class JsonResult<E> implements Serializable {

	private static final long serialVersionUID = 1L;
	/* 狀態碼 */
	private Integer state;
	/* 描述信息 */
	private String message;
	/* 數據 */
	private E data;
	
	public JsonResult() {
	}

	public JsonResult(Integer state) {
		this.state = state;
	}

	public JsonResult(Throwable e) {
		this.message = e.getMessage();
	}

	public JsonResult(Integer state, E data) {
		this.state = state;
		this.data = data;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

}
