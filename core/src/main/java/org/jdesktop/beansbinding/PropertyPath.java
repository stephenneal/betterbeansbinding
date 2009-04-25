/***********************************************************************************************************************
 * 
 * BetterBeansBinding - keeping JavaBeans in sync
 * ==============================================
 * 
 * Copyright (C) 2009 by Tidalwave s.a.s. (http://www.tidalwave.it)
 * http://betterbeansbinding.kenai.com
 * 
 * This is derived work from BeansBinding: http://beansbinding.dev.java.net
 * BeansBinding is copyrighted (C) by Sun Microsystems, Inc.
 * 
 ***********************************************************************************************************************
 * 
 * This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General 
 * Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) 
 * any later version.
 * 
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied 
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more 
 * details.
 * 
 * You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to 
 * the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 * 
 ***********************************************************************************************************************
 * 
 * $Id: PropertyPath.java 33 2009-04-25 16:43:54Z fabriziogiudici $
 * 
 **********************************************************************************************************************/
package org.jdesktop.beansbinding;

import java.util.StringTokenizer;
import java.util.ArrayList;

/**
 * @author Shannon Hickey
 * @author Scott Violet
 */
abstract class PropertyPath {

    private PropertyPath() {}

    public abstract int length();

    // throws ArrayIndexOutBoundsException if not valid
    public abstract String get(int index);

    public String getLast() {
        return get(length() - 1);
    }

    public abstract String toString();

    public static PropertyPath createPropertyPath(String path) {
        if (path == null) {
            throw new IllegalArgumentException("path must be non-null");
        }

        StringTokenizer tokenizer = new StringTokenizer(path, ".");
        ArrayList<String> list = new ArrayList<String>();
        while (tokenizer.hasMoreTokens()) {
            list.add(tokenizer.nextToken());
        }

        int size = list.size();

        if (size == 0) {
            throw new IllegalArgumentException("path must be non-empty");
        } else if (list.size() == 1) {
            return new SinglePropertyPath(list.get(0));
        } else {
            String[] multi = new String[list.size()];
            return new MultiPropertyPath(list.toArray(multi));
        }
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o instanceof PropertyPath) {
            PropertyPath oPath = (PropertyPath)o;

            int length = length();

            if (length != oPath.length()) {
                return false;
            }

            for (int i = 0; i < length; i++) {
                if (!get(i).equals(oPath.get(i))) {
                    return false;
                }

                return true;
            }
        }

        return false;
    }
    
    public int hashCode() {
        int result = 17;
        int length = length();

        for (int i = 0; i < length; i++) {
            result = 37 * result + get(i).hashCode();
        }

        return result;
    }

    static final class MultiPropertyPath extends PropertyPath {
        private final String[] path;
        
        public MultiPropertyPath(String[] path) {
            this.path = path;

            for (int i = 0; i < path.length; i++) {
                path[i] = path[i].intern();
            }

            assert (path.length > 0);
        }

        public int length() {
            return path.length;
        }

        public String get(int index) {
            return path[index];
        }
        
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append(path[0]);
            for (int i = 1; i < path.length; i++) {
                builder.append('.');
                builder.append(path[i]);
            }
            return builder.toString();
        }
    }
    
    
    static final class SinglePropertyPath extends PropertyPath {
        private final String path;
        
        public SinglePropertyPath(String path) {
            this.path = path.intern();
        }

        public int length() {
            return 1;
        }

        public String get(int index) {
            if (index == 0) {
                return path;
            }

            throw new ArrayIndexOutOfBoundsException();
        }

        public String getLast() {
            return path;
        }

        public String toString() {
            return path;
        }
    }
}
