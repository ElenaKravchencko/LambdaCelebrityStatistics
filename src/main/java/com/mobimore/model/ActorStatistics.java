/**
 * null
 */
package com.mobimore.model;

import java.io.Serializable;

/**
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/r0s1ru7oo9-2020-06-20T19:14:59Z/ActorStatistics"
 *      target="_top">AWS API Documentation</a>
 */
public class ActorStatistics implements Serializable, Cloneable {

    private java.util.List<ImageBase64> imageBase64;

    private Integer searchCount;

    /**
     * @return
     */

    public java.util.List<ImageBase64> getImageBase64() {
        return imageBase64;
    }

    /**
     * @param imageBase64
     */

    public void setImageBase64(java.util.Collection<ImageBase64> imageBase64) {
        if (imageBase64 == null) {
            this.imageBase64 = null;
            return;
        }

        this.imageBase64 = new java.util.ArrayList<ImageBase64>(imageBase64);
    }

    /**
     * <p>
     * <b>NOTE:</b> This method appends the values to the existing list (if any). Use
     * {@link #setImageBase64(java.util.Collection)} or {@link #withImageBase64(java.util.Collection)} if you want to
     * override the existing values.
     * </p>
     * 
     * @param imageBase64
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ActorStatistics imageBase64(ImageBase64... imageBase64) {
        if (this.imageBase64 == null) {
            setImageBase64(new java.util.ArrayList<ImageBase64>(imageBase64.length));
        }
        for (ImageBase64 ele : imageBase64) {
            this.imageBase64.add(ele);
        }
        return this;
    }

    /**
     * @param imageBase64
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ActorStatistics imageBase64(java.util.Collection<ImageBase64> imageBase64) {
        setImageBase64(imageBase64);
        return this;
    }

    /**
     * @param searchCount
     */

    public void setSearchCount(Integer searchCount) {
        this.searchCount = searchCount;
    }

    /**
     * @return
     */

    public Integer getSearchCount() {
        return this.searchCount;
    }

    /**
     * @param searchCount
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ActorStatistics searchCount(Integer searchCount) {
        setSearchCount(searchCount);
        return this;
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     *
     * @return A string representation of this object.
     *
     * @see Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getImageBase64() != null)
            sb.append("ImageBase64: ").append(getImageBase64()).append(",");
        if (getSearchCount() != null)
            sb.append("SearchCount: ").append(getSearchCount());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof ActorStatistics == false)
            return false;
        ActorStatistics other = (ActorStatistics) obj;
        if (other.getImageBase64() == null ^ this.getImageBase64() == null)
            return false;
        if (other.getImageBase64() != null && other.getImageBase64().equals(this.getImageBase64()) == false)
            return false;
        if (other.getSearchCount() == null ^ this.getSearchCount() == null)
            return false;
        if (other.getSearchCount() != null && other.getSearchCount().equals(this.getSearchCount()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getImageBase64() == null) ? 0 : getImageBase64().hashCode());
        hashCode = prime * hashCode + ((getSearchCount() == null) ? 0 : getSearchCount().hashCode());
        return hashCode;
    }

    @Override
    public ActorStatistics clone() {
        try {
            return (ActorStatistics) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }
}
