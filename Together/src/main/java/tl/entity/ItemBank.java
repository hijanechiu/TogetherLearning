package tl.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="itembank")
@Component
public class ItemBank {
	
	@Id
	@Column(name="item_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer iid;
	
	@Column(name="item_title")
	private String itemTitle;
	
	@Column(name="author")
	private String author;
	
	@Column(name="pub_name")
	private String pubName;
	
	@Column(name="pub_date")
	private Date pubDate;

	public Integer getIid() {
		return iid;
	}

	public void setIid(Integer iid) {
		this.iid = iid;
	}

	public String getItemTitle() {
		return itemTitle;
	}

	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPubName() {
		return pubName;
	}

	public void setPubName(String pubName) {
		this.pubName = pubName;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	@Override
	public String toString() {
		return "ItemBank [iid=" + iid + ", ItemTitle=" + itemTitle + ", author=" + author + ", pubName=" + pubName
				+ ", pubDate=" + pubDate + "]";
	}
}
