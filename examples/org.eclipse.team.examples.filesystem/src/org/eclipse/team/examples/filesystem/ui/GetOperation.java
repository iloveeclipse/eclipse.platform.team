/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.team.examples.filesystem.ui;

import org.eclipse.core.resources.mapping.ResourceTraversal;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.team.core.subscribers.SubscriberScopeManager;
import org.eclipse.team.examples.filesystem.FileSystemProvider;
import org.eclipse.team.examples.filesystem.Policy;
import org.eclipse.ui.IWorkbenchPart;

/**
 * Operation for getting the contents of the selected resources
 */
public class GetOperation extends FileSystemOperation {

	private boolean overwriteOutgoing;

	public GetOperation(IWorkbenchPart part, SubscriberScopeManager manager) {
		super(part, manager);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.team.examples.filesystem.ui.FileSystemOperation#execute(org.eclipse.team.examples.filesystem.FileSystemProvider, org.eclipse.core.resources.mapping.ResourceTraversal[], org.eclipse.core.runtime.SubProgressMonitor)
	 */
	protected void execute(FileSystemProvider provider,
			ResourceTraversal[] traversals, SubProgressMonitor monitor)
			throws CoreException {
		provider.getOperations().get(traversals, isOverwriteOutgoing(), monitor);

	}

	/**
	 * Indicate whether the operation should overwrite outgoing changes.
	 * By default, the get operation does not override local modifications.
	 * @return whether the operation should overwrite outgoing changes.
	 */
	protected boolean isOverwriteOutgoing() {
		return overwriteOutgoing;
	}

	/**
	 * Set whether the operation should overwrite outgoing changes.
	 * @param overwriteOutgoing whether the operation should overwrite outgoing changes
	 */
	public void setOverwriteOutgoing(boolean overwriteOutgoing) {
		this.overwriteOutgoing = overwriteOutgoing;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.team.examples.filesystem.ui.FileSystemOperation#getTaskName()
	 */
	protected String getTaskName() {
		return Policy.bind("GetAction.working"); //$NON-NLS-1$
	}

}
