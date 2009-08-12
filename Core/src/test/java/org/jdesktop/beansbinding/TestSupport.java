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
 * $Id$
 *
 **********************************************************************************************************************/
package org.jdesktop.beansbinding;

import java.util.logging.Handler;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.io.File;
import java.io.InputStream;
import it.tidalwave.util.logging.SingleLineLogFormatter;
import org.junit.BeforeClass;

/**
 *
 * @author fritz
 */
public class TestSupport {

    @BeforeClass
    public static void setupLogging()
            throws Exception {
        try {
            new File("target/logs").mkdirs();
            final InputStream is = TestSupport.class.getResourceAsStream("log.properties");
            LogManager.getLogManager().readConfiguration(is);
            is.close();

            final SingleLineLogFormatter formatter = new SingleLineLogFormatter();
            Logger rootLogger = Logger.getLogger(TestSupport.class.getName());

            while (rootLogger.getParent() != null) {
                rootLogger = rootLogger.getParent();
            }

            for (final Handler handler : rootLogger.getHandlers()) {
                handler.setFormatter(formatter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

