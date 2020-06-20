/**
 * null
 */
package com.mobimore.model;

import java.io.Serializable;

/**
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/r0s1ru7oo9-2020-06-13T19:50:54Z/ActorInfo" target="_top">AWS API
 *      Documentation</a>
 */
public class ActorInfo implements Serializable, Cloneable {

    private String id;

    private String name;

    private java.util.List<String> urls;

    /**
     * @param id
     */

    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return
     */

    public String getId() {
        return this.id;
    }

    /**
     * @param id
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ActorInfo id(String id) {
        setId(id);
        return this;
    }

    /**
     * @param name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */

    public String getName() {
        return this.name;
    }

    /**
     * @param name
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ActorInfo name(String name) {
        setName(name);
        return this;
    }

    /**
     * @return
     */

    public java.util.List<String> getUrls() {
        return urls;
    }

    /**
     * @param urls
     */

    public void setUrls(java.util.Collection<String> urls) {
        if (urls == null) {
            this.urls = null;
            return;
        }

        this.urls = new java.util.ArrayList<String>(urls);
    }

    /**
     * <p>
     * <b>NOTE:</b> This method appends the values to the existing list (if any). Use
     * {@link #setUrls(java.util.Collection)} or {@link #withUrls(java.util.Collection)} if you want to override the
     * existing values.
     * </p>
     * 
     * @param urls
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ActorInfo urls(String... urls) {
        if (this.urls == null) {
            setUrls(new java.util.ArrayList<String>(urls.length));
        }
        for (String ele : urls) {
            this.urls.add(ele);
        }
        return this;
    }

    /**
     * @param urls
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ActorInfo urls(java.util.Collection<String> urls) {
        setUrls(urls);
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
        if (getId() != null)
            sb.append("Id: ").append(getId()).append(",");
        if (getName() != null)
            sb.append("Name: ").append(getName()).append(",");
        if (getUrls() != null)
            sb.append("Urls: ").append(getUrls());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof ActorInfo == false)
            return false;
        ActorInfo other = (ActorInfo) obj;
        if (other.getId() == null ^ this.getId() == null)
            return false;
        if (other.getId() != null && other.getId().equals(this.getId()) == false)
            return false;
        if (other.getName() == null ^ this.getName() == null)
            return false;
        if (other.getName() != null && other.getName().equals(this.getName()) == false)
            return false;
        if (other.getUrls() == null ^ this.getUrls() == null)
            return false;
        if (other.getUrls() != null && other.getUrls().equals(this.getUrls()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getId() == null) ? 0 : getId().hashCode());
        hashCode = prime * hashCode + ((getName() == null) ? 0 : getName().hashCode());
        hashCode = prime * hashCode + ((getUrls() == null) ? 0 : getUrls().hashCode());
        return hashCode;
    }

    @Override
    public ActorInfo clone() {
        try {
            return (ActorInfo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }
}
