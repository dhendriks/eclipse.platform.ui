/*******************************************************************************
 * Copyright (c) 2000, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.core.filebuffers.tests;

import java.io.File;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import org.eclipse.core.filebuffers.FileBuffers;

/**
 * FileBuffersForNonExistingWorkspaceFiles
 */
public class FileBuffersForNonExistingWorkspaceFiles extends FileBufferFunctions {
	
	/*
	 * @see org.eclipse.core.filebuffers.tests.FileBufferFunctions#tearDown()
	 */
	protected void tearDown() throws Exception {
		File file= FileBuffers.getSystemFileAtLocation(getPath());
		FileTool.delete(file);
		super.tearDown();
	}
	
	/*
	 * @see org.eclipse.core.filebuffers.tests.FileBufferFunctions#createPath(org.eclipse.core.resources.IProject)
	 */
	protected IPath createPath(IProject project) throws Exception {
		IFolder folder= ResourceHelper.createFolder("project/folderA/folderB/");
		IPath path= folder.getFullPath().append("NonExistingWorkspaceFile");
		return new Path(path.toFile().getAbsolutePath());
	}
	
	/*
	 * @see org.eclipse.core.filebuffers.tests.FileBufferFunctions#markReadOnly()
	 */
	protected void markReadOnly() throws Exception {
		File file= FileBuffers.getSystemFileAtLocation(getPath());
		file.setReadOnly();
	}

	/*
	 * @see org.eclipse.core.filebuffers.tests.FileBufferFunctions#isStateValidationSupported()
	 */
	protected boolean isStateValidationSupported() {
		return false;
	}
}
