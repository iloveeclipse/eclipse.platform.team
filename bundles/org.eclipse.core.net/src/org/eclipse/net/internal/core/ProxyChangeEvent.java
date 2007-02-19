/*******************************************************************************
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.net.internal.core;

import org.eclipse.net.core.IProxyChangeEvent;
import org.eclipse.net.core.IProxyData;

public class ProxyChangeEvent implements IProxyChangeEvent {

	private final int type;
	private final String[] oldHosts;
	private final String[] nonProxiedHosts;
	private final IProxyData[] oldData;
	private final IProxyData[] changeData;

	public ProxyChangeEvent(int type, String[] oldHosts,
			String[] nonProxiedHosts, IProxyData[] oldData, IProxyData[] changedData) {
				this.type = type;
				this.oldHosts = oldHosts;
				this.nonProxiedHosts = nonProxiedHosts;
				this.oldData = oldData;
				this.changeData = changedData;
	}

	public int getChangeType() {
		return type;
	}

	public IProxyData[] getChangedProxyData() {
		return changeData;
	}

	public String[] getNonProxiedHosts() {
		return nonProxiedHosts;
	}

	public String[] getOldNonProxiedHosts() {
		return oldHosts;
	}

	public IProxyData[] getOldProxyData() {
		return oldData;
	}

}
