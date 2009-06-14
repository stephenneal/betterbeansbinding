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
 * $Id: Validator.java 60 2009-04-26 20:47:20Z fabriziogiudici $
 *
 **********************************************************************************************************************/
package org.jdesktop.beansbinding;


/**
 * {@code Validator} is responsible for validating the value from the target of
 * a {@code Binding}.
 *
 * @param <T> the type of value that this validator can validate
 *
 * @author Shannon Hickey
 */
public abstract class Validator<T> {
    /**
     * Validates a value; returns {@code null} for a valid value, and a
     * {@code Result} object describing the problem for an invalid value.
     *
     * @param value the value to validate, may be {@code null}
     * @return {@code null} for a valid value or a {@code Result}
     *         describing the problem for an invalid value
     */
    public abstract Result validate(T value);

    /**
     * An instance of {@code Result} is returned from a {@code Validator's}
     * {@code validate} method to indicate an invalid value.
     * <p>
     * A {@code Result} can contain an error code and/or description.
     * These values are for your own reporting purposes and are not used
     * internally.
     */
    public class Result {
        private final Object errorCode;
        private final String description;

        /**
         * Creates a {@code Result} with the given error code and description.
         *
         * @param errorCode an error code for this {@code Result}, may be {@code null}
         * @param description a textual description of the {@code Result}, may be {@code null}
         */
        public Result(Object errorCode, String description) {
            this.description = description;
            this.errorCode = errorCode;
        }

        /**
         * Returns the error code for the result, which may be {@code null}.
         *
         * @return the error code
         */
        public Object getErrorCode() {
            return errorCode;
        }

        /**
         * Returns a description of the validation result, which may be {@code null}.
         *
         * @return the description
         */
        public String getDescription() {
            return description;
        }

        /**
         * Returns a string representation of the {@code Result}. This
         * method is intended to be used for debugging purposes only, and
         * the content and format of the returned string may vary between
         * implementations. The returned string may be empty but may not
         * be {@code null}.
         *
         * @return a string representation of this {@code Result}
         */
        public String toString() {
            return getClass().getName() + " [" + "errorCode=" + errorCode +
            ", description=" + description + "]";
        }
    }
}
