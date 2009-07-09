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
 * $Id: StopWatch.java 116 2009-07-09 08:21:46Z fabriziogiudici $
 *
 **********************************************************************************************************************/
package org.jdesktop.beansbinding.timing;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import static org.junit.Assert.*;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class StopWatch {

    private final ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
    private long threadCpuTimeBaseTime = 0;
    private long threadCpuTimeAccumulator = 0;
    
    public StopWatch() {
        assertTrue("isThreadCpuTimeEnabled == false", threadBean.isThreadCpuTimeEnabled());
        assertTrue("isThreadCpuTimeSupported == false", threadBean.isThreadCpuTimeSupported());
        assertTrue("isCurrentThreadCpuTimeSupported == false", threadBean.isCurrentThreadCpuTimeSupported());
    }

    public void start() {
        threadCpuTimeAccumulator = 0;
        resume();
    }

    public void stop() {
        pause();
    }

    public void pause() {
        threadCpuTimeAccumulator += threadBean.getCurrentThreadCpuTime() - threadCpuTimeBaseTime;
    }

    public void resume() {
        threadCpuTimeBaseTime = threadBean.getCurrentThreadCpuTime();
    }

    public long getCurrentThreadCpuTime() {
        return threadCpuTimeAccumulator;
    }

    @Override
    public String toString() {
        return String.format("StopWatch[threadCpuTime: %fms]", threadCpuTimeAccumulator / 1E6);
    }
}
