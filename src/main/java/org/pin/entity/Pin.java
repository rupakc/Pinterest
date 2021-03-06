package org.pin.entity;

/** 
 * Defines a pin object corresponding to a pin fetched
 * @author Rupak Chakraborty
 * @since 25 October,2015
 */
public class Pin {
	
	private Long likeCount;
	private Long commentCount;
	private Long repinCount;
	private String creatorLastName;
	private String creatorFirstName;
	private String creatorUrl;
	private String creatorId;
	private String link;
	private String originalLink;
	private String boardId;
	private String boardUrl;
	private String boardName;
	private String url;
	private String note;
	private String mediaType;
	private String color;
	private String createdAt;
	private String imageUrl;
	private Long imageWidth;
	private Long imageHeight;
	private String Id;
	private Attribution attribution;
	private MetadataArticle metaArticle;
	private MetadataLink metaLink;
	private MetadataRecipe metaRecipe;
	
	/**
	 * @return the likeCount
	 */
	public Long getLikeCount() {
		return likeCount;
	}
	/**
	 * @param likeCount the likeCount to set
	 */
	public void setLikeCount(Long likeCount) {
		this.likeCount = likeCount;
	}
	/**
	 * @return the commentCount
	 */
	public Long getCommentCount() {
		return commentCount;
	}
	/**
	 * @param commentCount the commentCount to set
	 */
	public void setCommentCount(Long commentCount) {
		this.commentCount = commentCount;
	}
	/**
	 * @return the repinCount
	 */
	public Long getRepinCount() {
		return repinCount;
	}
	/**
	 * @param repinCount the repinCount to set
	 */
	public void setRepinCount(Long repinCount) {
		this.repinCount = repinCount;
	}
	/**
	 * @return the creatorLastName
	 */
	public String getCreatorLastName() {
		return creatorLastName;
	}
	/**
	 * @param creatorLastName the creatorLastName to set
	 */
	public void setCreatorLastName(String creatorLastName) {
		this.creatorLastName = creatorLastName;
	}
	/**
	 * @return the creatorFirstName
	 */
	public String getCreatorFirstName() {
		return creatorFirstName;
	}
	/**
	 * @param creatorFirstName the creatorFirstName to set
	 */
	public void setCreatorFirstName(String creatorFirstName) {
		this.creatorFirstName = creatorFirstName;
	}
	/**
	 * @return the creatorUrl
	 */
	public String getCreatorUrl() {
		return creatorUrl;
	}
	/**
	 * @param creatorUrl the creatorUrl to set
	 */
	public void setCreatorUrl(String creatorUrl) {
		this.creatorUrl = creatorUrl;
	}
	/**
	 * @return the creatorId
	 */
	public String getCreatorId() {
		return creatorId;
	}
	/**
	 * @param creatorId the creatorId to set
	 */
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}
	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}
	/**
	 * @return the originalLink
	 */
	public String getOriginalLink() {
		return originalLink;
	}
	/**
	 * @param originalLink the originalLink to set
	 */
	public void setOriginalLink(String originalLink) {
		this.originalLink = originalLink;
	}
	/**
	 * @return the boardId
	 */
	public String getBoardId() {
		return boardId;
	}
	/**
	 * @param boardId the boardId to set
	 */
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
	/**
	 * @return the boardUrl
	 */
	public String getBoardUrl() {
		return boardUrl;
	}
	/**
	 * @param boardUrl the boardUrl to set
	 */
	public void setBoardUrl(String boardUrl) {
		this.boardUrl = boardUrl;
	}
	/**
	 * @return the boardName
	 */
	public String getBoardName() {
		return boardName;
	}
	/**
	 * @param boardName the boardName to set
	 */
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}
	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}
	/**
	 * @return the mediaType
	 */
	public String getMediaType() {
		return mediaType;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pin [likeCount=" + likeCount + ", commentCount=" + commentCount
				+ ", repinCount=" + repinCount + ", creatorLastName="
				+ creatorLastName + ", creatorFirstName=" + creatorFirstName
				+ ", creatorUrl=" + creatorUrl + ", creatorId=" + creatorId
				+ ", link=" + link + ", originalLink=" + originalLink
				+ ", boardId=" + boardId + ", boardUrl=" + boardUrl
				+ ", boardName=" + boardName + ", url=" + url + ", note="
				+ note + ", mediaType=" + mediaType + ", color=" + color
				+ ", createdAt=" + createdAt + ", imageUrl=" + imageUrl
				+ ", imageWidth=" + imageWidth + ", imageHeight=" + imageHeight
				+ ", Id=" + Id + "]";
	}
	/**
	 * @param mediaType the mediaType to set
	 */
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * @return the createdAt
	 */
	public String getCreatedAt() {
		return createdAt;
	}
	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}
	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	/**
	 * @return the imageWidth
	 */
	public Long getImageWidth() {
		return imageWidth;
	}
	/**
	 * @param imageWidth the imageWidth to set
	 */
	public void setImageWidth(Long imageWidth) {
		this.imageWidth = imageWidth;
	}
	/**
	 * @return the imageHeight
	 */
	public Long getImageHeight() {
		return imageHeight;
	}
	/**
	 * @param imageHeight the imageHeight to set
	 */
	public void setImageHeight(Long imageHeight) {
		this.imageHeight = imageHeight;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		Id = id;
	}
	/**
	 * @return the attribution
	 */
	public Attribution getAttribution() {
		return attribution;
	}
	/**
	 * @param attribution the attribution to set
	 */
	public void setAttribution(Attribution attribution) {
		this.attribution = attribution;
	}
	/**
	 * @return the metaArticle
	 */
	public MetadataArticle getMetaArticle() {
		return metaArticle;
	}
	/**
	 * @param metaArticle the metaArticle to set
	 */
	public void setMetaArticle(MetadataArticle metaArticle) {
		this.metaArticle = metaArticle;
	}
	/**
	 * @return the metaLink
	 */
	public MetadataLink getMetaLink() {
		return metaLink;
	}
	/**
	 * @param metaLink the metaLink to set
	 */
	public void setMetaLink(MetadataLink metaLink) {
		this.metaLink = metaLink;
	}
	/**
	 * @return the metaRecipe
	 */
	public MetadataRecipe getMetaRecipe() {
		return metaRecipe;
	}
	/**
	 * @param metaRecipe the metaRecipe to set
	 */
	public void setMetaRecipe(MetadataRecipe metaRecipe) {
		this.metaRecipe = metaRecipe;
	}
}
