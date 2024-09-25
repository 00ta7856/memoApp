package beans;

import java.io.Serializable;
import java.util.Date;

public class MemoBeans implements Serializable {

	private int id;
	private String title, memo;
	private Date created_at, updated_at;

	//空コンストラクタ
	public MemoBeans() {
	}
	
	public MemoBeans(int id, String title, String memo, Date created_at, Date updated_at) {
		
		this.id = id;
		this.title = title;
		this.memo = memo;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getMemo() {
		return memo;
	}

	public Date getCreatet_at() {
		return created_at;
	}

	public Date getUpdate_at() {
		return updated_at;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public void setCreatet_at(Date createt_at) {
		this.created_at = createt_at;
	}

	public void setUpdate_at(Date update_at) {
		this.updated_at = update_at;
	}

}
