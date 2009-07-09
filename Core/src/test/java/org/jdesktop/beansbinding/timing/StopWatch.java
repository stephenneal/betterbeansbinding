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
 * $Id: StopWatch.java 130 2009-07-09 14:04:35Z fabriziogiudici $
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

    private long elapsedTimeBaseTime = 0;
    private long elapsedTimeAccumulator = 0;

    private double calibrationFactor = 1;
    
    public StopWatch() {
        assertTrue("isThreadCpuTimeEnabled == false", threadBean.isThreadCpuTimeEnabled());
        assertTrue("isThreadCpuTimeSupported == false", threadBean.isThreadCpuTimeSupported());
        assertTrue("isCurrentThreadCpuTimeSupported == false", threadBean.isCurrentThreadCpuTimeSupported());

        calibrate();
    }

    public void start() {
        elapsedTimeAccumulator = 0;
        threadCpuTimeAccumulator = 0;
        resume();
    }

    public void stop() {
        pause();
    }

    public void pause() {
        elapsedTimeAccumulator += System.currentTimeMillis() - elapsedTimeBaseTime;
        threadCpuTimeAccumulator += threadBean.getCurrentThreadCpuTime() - threadCpuTimeBaseTime;
    }

    public void resume() {
        elapsedTimeBaseTime = System.currentTimeMillis();
        threadCpuTimeBaseTime = threadBean.getCurrentThreadCpuTime();
    }

    public long getElapsedTime() {
        return elapsedTimeAccumulator * 1000000;
    }

    public long getCurrentThreadCpuTime() {
        return threadCpuTimeAccumulator;
    }

    @Override
    public String toString() {
        return String.format("StopWatch[elapsedTime: %dms, threadCpuTime: %fms calibrationFactor: %f]",
                             elapsedTimeAccumulator,
                             threadCpuTimeAccumulator / 1E6,
                             calibrationFactor);
    }

    private void calibrate() {
        final long base = threadBean.getCurrentThreadCpuTime();
        int n = 0;

        for (int i = 0; i < 100000000; i++) {
            n += i; // just to make sure the compiler doesn't optimize it out - but it could be smart...
        }

        calibrationFactor = (threadBean.getCurrentThreadCpuTime() - base) / 23650000.0;
    }
}
