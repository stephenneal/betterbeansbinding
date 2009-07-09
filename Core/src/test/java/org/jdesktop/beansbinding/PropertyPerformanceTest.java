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
 * $Id: PropertyPerformanceTest.java 117 2009-07-09 08:29:28Z fabriziogiudici $
 * 
 **********************************************************************************************************************/
package org.jdesktop.beansbinding;

import org.jdesktop.beansbinding.timing.StopWatch;
import org.jdesktop.beansbinding.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/***********************************************************************************************************************
 *
 * @author Kevin Day
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class PropertyPerformanceTest {

    private final static String CLASS = PropertyPerformanceTest.class.getName();
    private final static Logger logger = Logger.getLogger(CLASS);

    public static class TestBean {

        public String getValue() {
            return "value";
        }
    }

    @Test
    public void testPerformance() throws Exception {
        logger.info("testPerformance()");
        
        double limit = 10000.0; // nanoseconds per operation
        final int iterations = 50000;
        final long warmupTime = 20000;

        final TestBean bean = new TestBean();
        final Property<TestBean, String> valueProperty = BeanProperty.create("value");
        final StopWatch stopWatch = new StopWatch();

        long time = System.currentTimeMillis();

        logger.info(">>>> warming up...");
        while (System.currentTimeMillis() - time < warmupTime) {
            valueProperty.getValue(bean);
        }

        logger.info(">>>> testing...");
        stopWatch.start();
        stopWatch.pause();

        for (int i = 0; i < iterations; i++) {
            stopWatch.resume();
            valueProperty.getValue(bean);
            stopWatch.pause();
//
//            if (i % 1000 == 0) {
//                logger.info(">>>> completed %d iterations", i);
//            }
        }

        stopWatch.stop();
        logger.info(">>>> %s", stopWatch);

        final long cpuTime = stopWatch.getCurrentThreadCpuTime();
        final double cpuTimePerIteration = 1.0 * cpuTime / iterations;

        logger.info(">>>> totalCpuTime: %fms, cpuTimePerIteration: %f\u00b5s", cpuTime / 1E6, cpuTimePerIteration / 1E3);

        if (cpuTimePerIteration > limit) {
            fail("Time per iteration (" + cpuTimePerIteration + " is longer than allowed (" + limit + ")");
        }
    }
}
