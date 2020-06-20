/**
 * null
 */
package com.mobimore.model;

import java.io.Serializable;

/**
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/r0s1ru7oo9-2020-06-20T18:36:17Z/Actor" target="_top">AWS API
 *      Documentation</a>
 */
public class Actor implements Serializable, Cloneable {

    private ImageBase64 imageBase64;

    private String name;

    /**
     * @param imageBase64
     */

    public void setImageBase64(ImageBase64 imageBase64) {
        this.imageBase64 = imageBase64;
    }

    /**
     * @return
     */

    public ImageBase64 getImageBase64() {
        return this.imageBase64;
    }

    /**
     * @param imageBase64
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public Actor imageBase64(ImageBase64 imageBase64) {
        setImageBase64(imageBase64);
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

    public Actor name(String name) {
        setName(name);
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
        if (getName() != null)
            sb.append("Name: ").append(getName());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof Actor == false)
            return false;
        Actor other = (Actor) obj;
        if (other.getImageBase64() == null ^ this.getImageBase64() == null)
            return false;
        if (other.getImageBase64() != null && other.getImageBase64().equals(this.getImageBase64()) == false)
            return false;
        if (other.getName() == null ^ this.getName() == null)
            return false;
        if (other.getName() != null && other.getName().equals(this.getName()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getImageBase64() == null) ? 0 : getImageBase64().hashCode());
        hashCode = prime * hashCode + ((getName() == null) ? 0 : getName().hashCode());
        return hashCode;
    }

    @Override
    public Actor clone() {
        try {
            return (Actor) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }
}
