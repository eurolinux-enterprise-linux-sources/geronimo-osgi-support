/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.geronimo.osgi.locator;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;

public class Activator implements BundleActivator {
    protected BundleContext bundleContext;

    public synchronized void start(BundleContext bundleContext) throws Exception {
        this.bundleContext = bundleContext;
        // initialize the locator
        ProviderLocator.init(bundleContext);
    }

    public synchronized void stop(BundleContext bundleContext) throws Exception {
        // shut down the locator service
        ProviderLocator.destroy();
        this.bundleContext = null;
    }

    public void bundleChanged(BundleEvent event) {
        // nothing to change here
    }
}
