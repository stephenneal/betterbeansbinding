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
 * $Id: ELUtil.java 49 2009-04-25 22:31:22Z fabriziogiudici $
 * 
 **********************************************************************************************************************/
package org.jdesktop.el;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 *
 * <p>Utility methods for this portion of the EL implementation</p>
 *
 * <p>Methods on this class use a Map instance stored in ThreadLocal storage
 * to minimize the performance impact on operations that take place multiple
 * times on a single Thread.  The keys and values of the Map
 * are implementation private.</p>
 *
 * @author edburns
 */
class ELUtil {
    
    /**
     * <p>This class may not be constructed.</p>
     */
    
    private ELUtil() {
    }
    
    /**
     * <p>The <code>ThreadLocal</code> variable used to record the
     * {@link FacesContext} instance for each processing thread.</p>
     */
    private static ThreadLocal instance = new ThreadLocal() {
            protected Object initialValue() { return (null); }
        };
        
    /**
     * @return a Map stored in ThreadLocal storage.  This may
     * be used by methods of this class to minimize the performance
     * impact for operations that may take place multiple times on a given
     * Thread instance.
     */

    private static Map getCurrentInstance() {
        Map result = (Map) instance.get();
        if (null == result) {
            result = new HashMap();
            setCurrentInstance(result);
        }
        return result;

    }
    
    /**
     * <p>Replace the Map with the argument context.</p>
     *
     * @param context the Map to be stored in ThreadLocal storage.
     */

    private static void setCurrentInstance(Map context) {

        instance.set(context);

    }
    
    /*
     * <p>Convenience method, calls through to 
     * {@link #getExceptionMessageString(javax.el.ELContext,java.lang.String,Object []).
     * </p>
     *
     * @param context the ELContext from which the Locale for this message
     * is extracted.
     *
     * @param messageId the messageId String in the ResourceBundle
     *
     * @return a localized String for the argument messageId
     */
    
    public static String getExceptionMessageString(ELContext context, String messageId) {
        return getExceptionMessageString(context, messageId, null);
    }    
    
    /*
     * <p>Return a Localized message String suitable for use as an Exception message.
     * Examine the argument <code>context</code> for a <code>Locale</code>.  If
     * not present, use <code>Locale.getDefault()</code>.  Load the 
     * <code>ResourceBundle</code> "javax.el.Messages" using that locale.  Get
     * the message string for argument <code>messageId</code>.  If not found
     * return "Missing Resource in EL implementation ??? messageId ???" 
     * with messageId substituted with the runtime
     * value of argument <code>messageId</code>.  If found, and argument
     * <code>params</code> is non-null, format the message using the 
     * params.  If formatting fails, return a sensible message including 
     * the <code>messageId</code>.  If argument <code>params</code> is 
     * <code>null</code>, skip formatting and return the message directly, otherwise
     * return the formatted message.</p>
     *
     * @param context the ELContext from which the Locale for this message
     * is extracted.
     *
     * @param messageId the messageId String in the ResourceBundle
     *
     * @param params parameters to the message
     *
     * @return a localized String for the argument messageId
     */
    
    public static String getExceptionMessageString(ELContext context,
            String messageId, 
            Object [] params) {
        String result = "";
        Locale locale = null;
        
        if (null == context || null == messageId) {
            return result;
        }
        
        if (null == (locale = context.getLocale())) {
            locale = Locale.getDefault();
        }
        if (null != locale) {
            Map threadMap = getCurrentInstance();
            ResourceBundle rb = null;
            if (null == (rb = (ResourceBundle)
            threadMap.get(locale.toString()))) {
                rb = ResourceBundle.getBundle("org.jdesktop.el.PrivateMessages",
                                              locale);
                threadMap.put(locale.toString(), rb);
            }
            if (null != rb) {
                try {
                    result = rb.getString(messageId);
                    if (null != params) {
                        result = MessageFormat.format(result, params);
                    }
                } catch (IllegalArgumentException iae) {
                    result = "Can't get localized message: parameters to message appear to be incorrect.  Message to format: " + messageId;
                } catch (MissingResourceException mre) {
                    result = "Missing Resource in EL implementation: ???" + messageId + "???";
                } catch (Exception e) {
                    result = "Exception resolving message in EL implementation: ???" + messageId + "???";
                }
            }
        }
        
        return result;
    }
        
    
}
