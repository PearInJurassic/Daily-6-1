/**   
* @Title: Tag.java 
* @Package com.daily.entity 
* @Description: TODO 
* @author Doris   
* @date 2020年4月30日 下午4:17:15 
* @version V1.0   
*/
package com.daily.entity;

/**
 * @ClassName: Tag
 * @Description: TODO
 * @author Doris
 * @date 2020年4月30日 下午4:17:15
 * 
 */
public class Tag {
    private Integer tagId;

    private String tagContent;

    private Integer postId;

    /**
     * @return the tagId
     */
    public Integer getTagId() {
        return tagId;
    }

    /**
     * @param tagId the tagId to set
     */
    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    /**
     * @return the tagContent
     */
    public String getTagContent() {
        return tagContent;
    }

    /**
     * @param tagContent the tagContent to set
     */
    public void setTagContent(String tagContent) {
        this.tagContent = tagContent;
    }

    /**
     * @return the postId
     */
    public Integer getPostId() {
        return postId;
    }

    /**
     * @param postId the postId to set
     */
    public void setPostId(Integer postId) {
        this.postId = postId;
    }

}
